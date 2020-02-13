package com.sp.frontend.uitest.testutils

import com.sp.frontend.elements.CookiesAlert
import com.sp.frontend.elements.LoginDialog
import com.sp.frontend.elements.Header
import com.sp.frontend.pages.MainPage
import com.sp.frontend.testdata.UserData


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