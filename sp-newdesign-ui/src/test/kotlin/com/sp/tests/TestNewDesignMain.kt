package com.sp.tests

import com.uitestcore.driverutils.Driver
import com.sp.ui.elements.*
import com.sp.ui.pages.*
import com.sp.ui.testdata.UsersList.USER
import com.sp.testutils.TestInitDev
import org.testng.Assert
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestNewDesignMain : TestInitDev() {
    private lateinit var mainPage: MainPage
    private lateinit var header: Header
    private lateinit var cookiesAlert: CookiesAlert
    private lateinit var headerNavigate: HeaderNavigation

    @Test(priority=1)
    fun loginTest() {
        val assert = SoftAssert()
        mainPage = MainPage()
        mainPage.open()
        header = Header()
        val cityDropdown = CityDropdown()
        cityDropdown.confirm()
        headerNavigate = HeaderNavigation()
        assert.assertEquals(headerNavigate.navList!!.size, 7)
        cookiesAlert = CookiesAlert()
        cookiesAlert.dismiss()
        header.openLoginForm()
        val loginDialog = LoginDialog()
        loginDialog.waitToAppear()
        loginDialog.commitLogin(USER)
        assert.assertTrue(header.loginIs(USER))
        header.refresh()
        headerNavigate.refresh()
        assert.assertEquals(headerNavigate.navList!!.size, 9)
        //assert.assertEquals(header.getWalletCount().toString(), "199220.53")
        assert.assertAll()
    }

    //@Test(priority=2)
    fun checkPopularStocks() {
        val stockList = mainPage.getPopularStocks()
        Assert.assertEquals(stockList.size, 4)
    }

    //@Test(priority=3)
    fun checkUserProfilePage() {
        val asert = SoftAssert()
        header.clickUserProfile()
        val profilePage = UserProfilePage()
        asert.assertAll()
    }

    //@Test(priority=4)
    fun checkWalletPage() {
        val assert = SoftAssert()
        mainPage.open()
        header.clickWalletBtn()
        val walletPage = WalletPage()
        assert.assertEquals(walletPage.getBalance(), 100)
        walletPage.addMoney(100)
        val paymentCompletedMsg = PaymentCompletedMsg()
        assert.assertEquals(paymentCompletedMsg.getText(), "Заказ успешно оплачен.")
        assert.assertAll()
    }

    //@Test(priority = 5)
    fun openCartPageByButton() {
        val assert = SoftAssert()
        mainPage.open()
        header.clickCartBtn()
        val cartPage = CartPage()
        val ordersList = cartPage.stockList
        val itemsCount = cartPage.getCartItemsCount()

        assert.assertEquals(itemsCount, 40)
        assert.assertEquals(ordersList!![0].title.text, "NKU носки")
        assert.assertEquals(ordersList[0].statusBtn.text, "Готово к получению в пункте выдачи")
        assert.assertEquals(ordersList.size, 20)
        assert.assertNull(ordersList[0].payBtn)
        assert.assertNull(ordersList[0].deleteAllOrdersBtn)
        assert.assertEquals(ordersList[0].price!!.text, "93.54")
        assert.assertEquals(ordersList[0].payed!!.text, "Оплачено: 93.54")
        assert.assertAll()
    }

    @Test(priority = 6)
    fun stockListCheck() {
        val assert = SoftAssert()
        mainPage.open()
        headerNavigate.refresh()
        headerNavigate.clickTab("закупки")
        val stockListPage = StockListPage()
        stockListPage.openStockByTitle("NK3 ОТКРЫТО")
        val stockPage = StockPage()
        assert.assertEquals(stockPage.getTitle(), "NK3 ОТКРЫТО")
        assert.assertAll()
    }

    @Test(priority = 7)
    fun stockPageCheck() {
        val assert = SoftAssert()
        Driver.openPage(String.format("/stock?id=%d", 896))
        val stockPage = StockPage()
        assert.assertEquals(stockPage.getTitle(), "NK3 ОТКРЫТО")
        assert.assertEquals(stockPage.getFillRate(), "100")
        stockPage.makeOrder(0)
    }
}