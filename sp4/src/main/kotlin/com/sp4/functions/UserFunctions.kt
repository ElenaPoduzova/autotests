package com.sp4.functions

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.sp4.elements.Header
import com.sp4.pages.LoginPage
import com.sp4.pages.WalletPage
import com.sp4.testdata.UserData
import java.sql.Driver

object UserFunctions {

    fun updateUsersCookies() {

        val profile = SharedFunctions.readJson("adminprofile")
        val (request1, response1, result1) = "https://dev.sp4.sitepokupok.ru/user/login".httpGet()
                .response()

        val pattern = "input type=\"hidden\" name=\"UserLoginForm.fhash.\" value=\"(.*)\"".toRegex()
        var fhash = pattern.find(String(response1.data))?.groups?.get(1)?.value
        val cookies =  response1.headers["Set-Cookie"]

        val (request, response, result) = "https://dev.sp4.sitepokupok.ru/user/login".httpPost()
                .header("Content-Type" to "application/x-www-form-urlencoded; application/json")
                .header("Set-Cookie" to response1.headers["Set-Cookie"])
                .body("{\"UserLoginForm[login]\":\"Sony\", \"UserLoginForm[password]\":\"12345\", \"UserLoginForm[fhash]\":\"$fhash\"")
                .response()

        val fuserValue = (response.headers.getValue("Set-Cookie") as ArrayList<String>)[1]
    }

    fun loginAsUser(profile: UserData) {
        val header = Header()
        header.logout()
        header.openLoginForm()
        val loginPage = LoginPage()
        loginPage.commitLogin(profile)
    }

    fun loginIfUnauthorized(profile: UserData) {
        val header = Header()
        if (header.isLoggedIn() && header.loginIs(profile)) {
            return
        } else {
            loginAsUser(profile)
        }
    }

    fun addMoney(count: Int) {
        com.uitestcore.driverutils.Driver.openPage("purse")
        val walletPage = WalletPage()
        walletPage.addMoney(count)
    }

    fun addMoneyToCount(balance: Int) {
        com.uitestcore.driverutils.Driver.openPage("purse")
        val walletPage = WalletPage()
        val count = balance - walletPage.getBalance()
        if (count >= 1) {
            walletPage.addMoney(count.toInt())
        }
    }

}