package com.sp.testutils

import com.sp.ui.elements.LoginDialog
import com.sp.ui.elements.Header
import com.sp.ui.testdata.UserData


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