package com.sp4.uitest.tests

import com.sp4.elements.Header
import com.sp4.functions.StockFunctions
import com.sp4.functions.UserFunctions
import com.sp4.pages.*
import com.sp4.testdata.*
import com.sp4.testdata.StocksList.StockWithPrepayAndDiscount
import com.sp4.uitest.testutils.TestInit
import com.uitestcore.driverutils.Driver
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestCheckStock : TestInit() {
    private var stockId: Pair<Int, String>? = null

    @BeforeClass
    fun before() {
        Driver.openPage("stock")
    }

    @Test(priority=1, description = "Create a stock with prepay and discount and check it's page")
    fun checkStockWithPrepayAndDiscount() {
        val assert = SoftAssert()
        UserFunctions.loginAsUser(UsersList.ADMIN!!)
        var goods = arrayListOf<StockGoodData>()
        goods.add(StocksGoodList.BOOTS!!)
        goods.add(StocksGoodList.CARDIGAN!!)
        goods.add(StocksGoodList.TOP!!)
        goods.add(StocksGoodList.SHIRT!!)
        stockId = StockFunctions.createStock(StockWithPrepayAndDiscount!!, goods)
        StockFunctions.openStock(stockId!!.first)
        StockPage.open(stockId!!.second)
        val stockPage = StockPage()
        assert.assertEquals(stockPage.getGoodsCount(), 4, "Должно быть 4 товара")
        assert.assertEquals(stockPage.getOrgPercent(), 5, "Оргсбор - 5%")
        assert.assertEquals(stockPage.getPrepay(), 10, "Предоплата - 10%")
        assert.assertEquals(stockPage.getDiscount(), 10, "Скидка - 10%")
        assert.assertEquals(stockPage.getDiscountLabel(), "10%", "Должен быть значок скидки в 10%")
        assert.assertEquals(stockPage.getDeliveryPrice(), 100.0.toFloat(), "Доставка - 100")
        val goodsInStock = stockPage.getGoods()
        assert.assertEquals(goodsInStock[0].getPrice(), (goods[0].price.toFloat() * 0.9), "Цена должна отображаться со скидкой")
        assert.assertAll()
    }

    @Test(priority=2, description = "Add order from a stock with prepay and discount. Check it in a cart")
    fun addOrderAndCheckInCartAndCheck() {
        UserFunctions.loginAsUser(UsersList.USER!!)

        StockPage.open(stockId!!.second)
        val stockPage = StockPage()
        stockPage.addOrder(OrderList.CARDIGAN!!)
        stockPage.addOrder(OrderList.BOOTS!!)
        val assert = SoftAssert()
        CartPage.open()
        val stockInCart = CartPage().getStockByTitle(StockWithPrepayAndDiscount!!.title)
        val orders = stockInCart.getOrders()
        assert.assertTrue(orders.isNotEmpty(), "Товары должны быть добавлены в корзину")
        assert.assertEquals(orders[0].getTitle(), OrderList.CARDIGAN!!.goodName, "Должно быть показано название товара - кардиган")
        assert.assertEquals(orders[0].getPrice().toString(), (OrderList.CARDIGAN!!.price.toFloat() * 0.9).toString(), "Цена 'Кардиган' должна соответствовать цене в закупке")
        assert.assertEquals(orders[0].getParams(), OrderList.CARDIGAN!!.sizeRow, "Параметры должны быть теми с которыми был добавлен товар")
        assert.assertEquals(orders[0].getStatus(), "заказан", "Статус товара - заказан")
        assert.assertEquals(orders[1].getTitle(), OrderList.BOOTS!!.goodName, "Должно быть показано название товара - кроссовки")
        assert.assertEquals(orders[1].getPrice().toString(), (OrderList.BOOTS!!.price.toFloat() * 0.9).toString(), "Цена 'Кроссовки' должна соответствовать цене в закупке")
        assert.assertEquals(orders[1].getParams(), OrderList.BOOTS!!.sizeRow, "Параметры должны быть теми с которыми был добавлен товар")
        assert.assertEquals(orders[1].getStatus(), "заказан")
        assert.assertEquals(stockInCart.getGoodsCount(), 2, "Всего товаров в заказе")
        assert.assertEquals(stockInCart.getNeedToPay(), 1417.50, "К оплате: ")
        assert.assertEquals(stockInCart.getAllPay(), 1417.50, "Сумма заказа: ")
        assert.assertEquals(stockInCart.getOrgPay(), 67.5, "Оргсбор: ")
        assert.assertEquals(stockInCart.getPaid(), 0, "Оплачено: ")
        assert.assertAll()
    }

    @Test(priority=3, description = "Pay for order for sptest1")
    fun payOrder() {
        val assert = SoftAssert()
        val stockInCart = CartPage().getStockByTitle(StockWithPrepayAndDiscount!!.title)
        val purseCurrent = Header().getWalletCount()
        stockInCart.prePay()
        Driver.pause(5)
        assert.assertEquals(Header().getWalletCount(), purseCurrent - 135)
        assert.assertAll()
    }

    @Test(priority=4, description = "Add order for sptest2")
    fun addOrderForUser2() {
        UserFunctions.loginAsUser(UsersList.USER2!!)

        StockPage.open(stockId!!.second)
        val stockPage = StockPage()
        stockPage.addOrder(OrderList.CARDIGAN!!)
        stockPage.addOrder(OrderList.SHIRT!!)
    }

    @Test(priority=5, description = "Add order for sptest3")
    fun addOrderForUser3() {
        UserFunctions.loginAsUser(UsersList.USER3!!)

        StockPage.open(stockId!!.second)
        val stockPage = StockPage()
        stockPage.addOrder(OrderList.BOOTS!!)
        stockPage.addOrder(OrderList.SHIRT!!)

        CartPage.open()
        val stockInCart = CartPage().getStockByTitle(StockWithPrepayAndDiscount!!.title)
        stockInCart.pay()
    }

    @Test(priority=6, description = "Login as org and check orders")
    fun checkOrdersAsOrg() {
        val assert = SoftAssert()
        UserFunctions.loginAsUser(UsersList.ADMIN!!)

        val stockManagePage = StockManagePage()
        StockManagePage.open()
        stockManagePage.getStockByTitle(StockWithPrepayAndDiscount!!.title).clickOrders()

        val ordersPage = StockOrgOrdersPage()
        val ordersForUser1 = ordersPage.getOrdersByUser("sptest1")
        val ordersForUser2 = ordersPage.getOrdersByUser("sptest2")
        val ordersForUser3 = ordersPage.getOrdersByUser("sptest3")

        assert.assertEquals(ordersForUser1.size, 2)
        assert.assertEquals(ordersForUser2.size, 2)
        assert.assertEquals(ordersForUser3.size, 2)

        ordersForUser1[0].confirmOrder()
        ordersForUser1[1].declineOrder()

        ordersForUser2[0].confirmOrder()
        ordersForUser2[1].confirmOrder()

        ordersForUser3[0].declineOrder()
        ordersForUser3[1].confirmOrder()

        assert.assertAll()
    }

    @Test(priority = 7, description = "")
    fun checkOrdersStatus() {
        val assert = SoftAssert()

        val stockManagePage = StockManagePage()
        StockManagePage.open()
        stockManagePage.getStockByTitle(StockWithPrepayAndDiscount!!.title).clickOrders()

        val ordersPage = StockOrgOrdersPage()
        val ordersForUser1 = ordersPage.getOrdersByUser("sptest1")
        val ordersForUser2 = ordersPage.getOrdersByUser("sptest2")
        val ordersForUser3 = ordersPage.getOrdersByUser("sptest3")

        assert.assertEquals(ordersForUser1.size, 2)
        assert.assertEquals(ordersForUser2.size, 2)
        assert.assertEquals(ordersForUser3.size, 2)

        assert.assertAll()
    }

    @Test(priority=8, description = "Login as org and check orders")
    fun checkPaymentsAsOrg() {
        val assert = SoftAssert()

        StockManagePage.open()
        val stockManagePage = StockManagePage()
        stockManagePage.getStockByTitle(StockWithPrepayAndDiscount!!.title).clickPayments()

        val paymentsPage = StockOrgPaymentsPage()
        val paymentsUser1 = paymentsPage.getOrdersByUser("sptest1")
        val paymentsUser2 = paymentsPage.getOrdersByUser("sptest2")

        assert.assertEquals(paymentsUser1.size, 1)
        assert.assertEquals(paymentsUser2.size, 1)

        assert.assertAll()
    }
}