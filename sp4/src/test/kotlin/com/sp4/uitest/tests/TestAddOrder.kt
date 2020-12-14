package com.sp4.uitest.tests

import com.sp4.elements.CartStock
import com.sp4.elements.Header
import com.sp4.pages.CartPage
import com.sp4.pages.StockPage
import com.sp4.testdata.OrderList.BOOTS
import com.sp4.testdata.StockViewList.AUTOCREATED
import com.sp4.testdata.UsersList
import com.sp4.testdata.UsersList.USER
import com.sp4.uitest.testutils.TestInitWithLogin
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestAddOrder : TestInitWithLogin(UsersList.USER) {
    private lateinit var stockPage: StockPage
    private lateinit var stockInCart: CartStock

    @Test(priority=1)
    fun openStock() {
        val assert = SoftAssert()
        StockPage.open(AUTOCREATED!!.stockId)
        stockPage = StockPage()
        //need lots of asserts like check elements present
        assert.assertEquals(stockPage.getGoodsCount(), 4)
        assert.assertEquals(stockPage.getOrders(), 1)
        assert.assertAll()
    }

    @Test(priority=2)
    fun addOrder() {
        val assert = SoftAssert()
        stockPage.addOrder(BOOTS!!)
        assert.assertTrue(stockPage.isOrderAdded(BOOTS!!, USER!!))
        assert.assertAll()
    }

    @Test(priority=3)
    fun checkOrderInCart() {
        val assert = SoftAssert()
        CartPage.open()
        stockInCart = CartPage().getStockByTitle(AUTOCREATED!!.stockTitle)
        val orders = stockInCart.getOrders()
        assert.assertTrue(orders.isNotEmpty())
        assert.assertTrue(orders[0].getTitle() == BOOTS!!.goodName)
        assert.assertTrue(orders[0].getPrice() == 1000)
        assert.assertTrue(orders[0].getParams() == BOOTS!!.sizeRow)
        assert.assertTrue(orders[0].getStatus() == "заказан")
        assert.assertTrue(stockInCart.getGoodsCount() == 1)
        assert.assertTrue(stockInCart.getNeedToPay().equals(1050))
        assert.assertTrue(stockInCart.getAllPay().equals(1050))
        assert.assertTrue(stockInCart.getOrgPay().equals(50))
        assert.assertTrue(stockInCart.getPaid().equals(0))
        assert.assertAll()
    }

    @Test(priority=4)
    fun payOrderInCart() {
        val assert = SoftAssert()
        val purseCurrent = Header().getWalletCount()
        stockInCart.pay()
        com.uitestcore.driverutils.Driver.pause(3)
        assert.assertEquals(Header().getWalletCount(), purseCurrent - 1050)
        assert.assertAll()
    }

    @Test(priority=5)
    fun deleteOrderInCart() {
        val assert = SoftAssert()
        CartPage.open()
        val stock = CartPage().getStockByTitle(AUTOCREATED!!.stockTitle)
        val purseCurrent = Header().getWalletCount()
        val orders = stock.getOrders()
        orders[0].deleteOrder()
        assert.assertEquals(Header().getWalletCount(), purseCurrent + 1050)
        assert.assertAll()
    }


}