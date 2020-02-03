package com.sp.frontend.uitest.testutils

import com.sp.frontend.elements.LoginDialog
import com.sp.frontend.elements.Header
import com.sp.frontend.testdata.UserData


object Functions {

    fun logIn(userData: UserData) {
        var header = Header()
        header.openLoginForm()
        var loginDialog = LoginDialog();
        loginDialog.waitToAppear()
        loginDialog.commitLogin(userData)
    }

    fun logOut(){

    }

    fun isLoggedIn(){

    }
}