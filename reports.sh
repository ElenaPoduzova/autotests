#!/bin/bash

####################             ABOUT

# grubAllureResults - to send allure results
# deployAllureResults - to deploy allure reports

####################             VARS
BRANCH_ERROR_MESSAGE="IF YOU DON'T SEE THE PULL REQUEST BUILD, THEN BRANCH CANNOT BE MERGED, YOU SHOULD FIX IT FIRST"
URL_NOT_FOUND_ERROR_MESSAGE="NONE OF THE ALLURE REPORTS WERE FOUND"

####################             UTILS

function archive() {
    directory="$1"
    archiveName=$(echo ${directory}| awk -F"/" '{print $1}').tar.gz
    tar -czf ${archiveName} ${directory} > /dev/null
    echo ${archiveName} #return
}

function extractArchive() {
    file="$1"
    tar -xzf ${file}
}

function aboutTransfer() {
    url="$1"
    echo "[${TRAVIS_BUILD_NUMBER}] - ${url}" #return
}

function aboutNetlify() {
    url="$1"
    echo "[${TRAVIS_BUILD_NUMBER}] - Allure report on Netlify: ${url}" #return
}

function checkBranchIsOk() {
    if [[ "x${TRAVIS_PULL_REQUEST}" == "xfalse" ]] ; then
        echo "${BRANCH_ERROR_MESSAGE}"
        sleep 3
        exit 0
    fi
}

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

#########################               PART 1: send allure results into web to collect it later
function grubAllureResults() {
    echo "grubAllureResults"
    echo "Stage was: ${TRAVIS_BUILD_STAGE_NAME}"
    checkBranchIsOk #there is an exit inside

    if [[ "x${TRAVIS_BUILD_STAGE_NAME}" == "xTest" ]] ; then #don't remove x, it's useful
        for result in $(find jdi-dark*/target/allure-results -maxdepth 1 -type d)
        do
            echo RESULT: ${result}
            archiveFile=$(archive ${result})
            echo ARCHIVE: ${archiveFile}
            ls -lah *.tar.gz
            uploadedTo=$(uploadFile "${archiveFile}")
            echo UPLOAD TO: ${uploadedTo}
            sendComment "$(aboutTransfer "${uploadedTo}")"
        done
    fi
}

function uploadFile() {
    file="$1"
    url=$(curl --upload-file "${file}" https://transfer.sh/${file})
    echo ${url} #return
}

######################         PART 2: Deploy allure results as allure reports to netlify
function deployAllureResults() {
    checkBranchIsOk #there is an exit inside
    downloadAllureResults
    extractAllureResults
    generateAllureReports
    echo "LOG1"
    url=$(deployToNetlify "allure-report")
    echo "LOG2"
    sendComment "$(aboutNetlify ${url})"
}

function downloadAllureResults() {
    urlExistence=false
    for url in $(collectRelevantComments "${TRAVIS_BUILD_NUMBER}")
    do
        urlExistence=true
        echo "Found: ${url}"
        fileName="$(echo "${url}"| awk -F/ '{print $5}')"
        curl ${url} --output ${fileName}
    done
    if [[ "x${urlExistence}" == "xfalse" ]] ; then
        exitWithError
    fi
}

function extractAllureResults() {
    for archiveFile in $(ls -1 *.tar.gz)
    do
        extractArchive ${archiveFile}
    done
}

function generateAllureReports() {
    reportDirList="";
    allureDirExistence=false
    for report in $(ls -d1 jdi-dark*/)
    do
        allureDirExistence=true
        allureDir="${report}target/allure-results"
        if [[ -d "$allureDir" ]] ; then
            echo "Results found for ${report}"
            reportDirList="${reportDirList} ${allureDir}"
        else
            echo "RESULTS NOT FOUND FOR ${report}"
        fi
    done
    if [[ "x${allureDirExistence}" == "xfalse" ]] ; then
        exitWithError
    fi
    echo ${reportDirList}
    allure generate --clean ${reportDirList}
}

function exitWithError() {
    echo "${URL_NOT_FOUND_ERROR_MESSAGE}"
    sleep 3
    exit 1
}
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
