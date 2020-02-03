package com.sp.frontend.uitests.tests

import com.sp.frontend.elements.CookiesAlert
import com.sp.frontend.elements.Header
import com.sp.frontend.elements.LoginDialog
import com.sp.frontend.elements.StockCard
import com.sp.frontend.pages.MainPage
import com.sp.frontend.pages.UserProfilePage
import com.sp.frontend.pages.WalletPage
import com.sp.frontend.testdata.UsersList.USER
import com.sp.frontend.uitest.testutils.TestInit
import org.testng.Assert
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestMainPage : TestInit() {
    private lateinit var mainPage: MainPage
    private lateinit var header: Header
    private lateinit var cookiesAlert: CookiesAlert

    @Test(priority=1)
    fun loginTest() {
        mainPage = MainPage()
        header = Header()
        mainPage.open()
        cookiesAlert = CookiesAlert()
        cookiesAlert.dismiss()
        header.openLoginForm()
        var loginDialog = LoginDialog();
        loginDialog.waitToAppear()
        loginDialog.commitLogin(USER);
        header.loginIs(USER)
        Thread.sleep(5000)
        Assert.assertEquals(header.getWalletCount().toString(), "100.0")
    }

    @Test(priority=2)
    fun checkPopularStocks() {
        var stockList: MutableList<StockCard> = mainPage.getPopularStocks()
        Assert.assertEquals(stockList.size, 4)
    }

    @Test(priority=3)
    fun checkUserProfilePage() {
        val asert = SoftAssert()
        header.clickUserProfile()
        val profilePage: UserProfilePage =
                UserProfilePage()
        //asert.assertEquals(profilePage.profileMenu!!.itemCount(), 3)
        asert.assertEquals(profilePage.navs!!.size, 3)
        asert.assertAll();
    }

    @Test(priority=4)
    fun checkWalletPage() {
        val asert = SoftAssert()
        header.clickWalletBtn()
        val walletPage: WalletPage =
                WalletPage()
        asert.assertEquals(walletPage.getBalance(), 100)
        walletPage.addMoney(100)
        asert.assertAll();
    }
}