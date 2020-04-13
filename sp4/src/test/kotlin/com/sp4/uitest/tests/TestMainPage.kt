package com.sp4.uitest.tests

import com.sp4.elements.CookiesAlert
import com.sp4.elements.Header
import com.sp4.elements.LoginDialog
import com.sp4.elements.StockCard
import com.sp4.pages.LoginPage
import com.sp4.pages.MainPage
import com.sp4.pages.UserProfilePage
import com.sp4.pages.WalletPage
import com.sp4.testdata.UsersList.USER
import com.sp4.uitest.testutils.TestInit
import org.testng.Assert
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
        header.loginIs(USER)
        header.refresh()
        //Assert.assertEquals(header.getWalletCount().toString(), "100.0")
    }

    @Test(priority=2)
    fun checkUserProfilePage() {
        val asert = SoftAssert()
        header.clickUserProfile()
        val profilePage = UserProfilePage()
        //asert.assertEquals(profilePage.profileMenu!!.itemCount(), 3)
        asert.assertEquals(profilePage.navs!!.size, 4)
        asert.assertAll()
    }

    @Test(priority=3)
    fun checkWalletPage() {
        val asert = SoftAssert()
        header.clickWalletBtn()
        val walletPage = WalletPage()
        val balance = walletPage.getBalance()
        walletPage.addMoney(100)
        asert.assertEquals(walletPage.getBalance(), balance + 100)
        asert.assertAll()
    }
}