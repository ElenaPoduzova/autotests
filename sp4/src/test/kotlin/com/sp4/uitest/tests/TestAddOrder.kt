package com.sp4.uitest.tests

import com.sp4.pages.CartPage
import com.sp4.pages.StockPage
import com.sp4.testdata.OrderList.TEST
import com.sp4.testdata.UsersList.ORG
import com.sp4.uitest.testutils.TestInitWithLogin
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestAddOrder : TestInitWithLogin() {
    private lateinit var stockPage: StockPage

    @Test(priority=1)
    fun openStock() {
        val asert = SoftAssert()
        StockPage.open(TEST!!.stockId)
        stockPage = StockPage()
        //need lots of asserts like check elements present
        asert.assertAll()
    }

    @Test(priority=2)
    fun addOrder() {
        val asert = SoftAssert()
        stockPage.addOrder(TEST!!)
        asert.assertTrue(stockPage.isOrderAdded(TEST!!, ORG!!))
        asert.assertAll()
    }

    @Test(priority=3)
    fun checkOrderInCart() {
        val assert = SoftAssert()
        CartPage.open()
        val stock = CartPage().getStockById(TEST!!.dataId)
        val orders = stock.getOrders()
        assert.assertTrue(orders.isNotEmpty())
        assert.assertTrue(orders[0].getTitle() == TEST!!.goodName)
        assert.assertTrue(orders[0].getPrice() == 1000)
        assert.assertTrue(orders[0].getParams() == TEST!!.sizeRow)
        assert.assertTrue(orders[0].getStatus() == "заказан")
        orders[0].deleteOrder()
        assert.assertAll()
    }


}