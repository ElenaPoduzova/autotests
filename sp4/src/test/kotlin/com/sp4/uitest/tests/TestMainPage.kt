package com.sp4.uitest.tests

import com.sp4.elements.Header
import com.sp4.pages.LoginPage
import com.sp4.pages.MainPage
import com.sp4.pages.UserProfilePage
import com.sp4.pages.WalletPage
import com.sp4.testdata.UsersList.USER
import com.sp4.uitest.testutils.TestInit
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestMainPage : TestInit() {
    private lateinit var mainPage: MainPage
    private lateinit var header: Header

    @Test(priority=1)
    fun loginTest() {
        mainPage = MainPage()
        header = Header()
        mainPage.open()
        header.openLoginForm()
        val loginPage = LoginPage()
        loginPage.commitLogin(USER)
        header.loginIs(USER!!)
    }

    @Test(priority=2)
    fun checkUserProfilePage() {
        val assert = SoftAssert()
        header.clickUserProfile()
        val profilePage = UserProfilePage()
        assert.assertEquals(profilePage.profileData!!.size, 3)
        assert.assertEquals(profilePage.profileMenu!!.size, 5)
        assert.assertAll()
    }

    @Test(priority=3)
    fun checkWalletPage() {
        val assert = SoftAssert()
        header.clickWalletBtn()
        val walletPage = WalletPage()
        val balance = walletPage.getBalance()
        walletPage.addMoney(100)
        assert.assertEquals(walletPage.getBalance(), balance + 100)
        assert.assertAll()
    }
}