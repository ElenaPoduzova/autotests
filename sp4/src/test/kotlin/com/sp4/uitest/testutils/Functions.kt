package com.sp4.uitest.testutils

import com.sp4.elements.CookiesAlert
import com.sp4.elements.LoginDialog
import com.sp4.elements.Header
import com.sp4.pages.MainPage
import com.sp4.testdata.UserData


object Functions {

    fun logIn(userData: UserData) {
        val mainPage = MainPage()
        val header = Header()
        mainPage.open()
        val cookiesAlert = CookiesAlert()
        cookiesAlert.dismiss()
        header.openLoginForm()
        val loginDialog = LoginDialog()
        loginDialog.waitToAppear()
        loginDialog.commitLogin(userData)
    }

    fun closeCookies() {
        val cookiesAlert = CookiesAlert()
        try {
            cookiesAlert.dismiss()
        }
        catch (ex: Exception)
        {

        }
    }

    fun logOut(){

    }

    fun isLoggedIn(){

    }
}