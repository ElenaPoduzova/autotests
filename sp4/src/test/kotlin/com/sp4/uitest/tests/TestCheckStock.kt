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
    private var boxesIds: MutableList<String> = mutableListOf()

    @BeforeClass
    fun before() {
        Driver.openPage("stock")
        UserFunctions.loginAsUser(UsersList.USER!!)
        UserFunctions.addMoneyToCount(5000)
        UserFunctions.loginAsUser(UsersList.USER2!!)
        UserFunctions.addMoneyToCount(5000)
        UserFunctions.loginAsUser(UsersList.USER3!!)
        UserFunctions.addMoneyToCount(5000)
    }

    @Test(priority=1, description = "Create a stock with prepay and discount and check it's page")
    fun createStockWithPrepayAndDiscount() {
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
        assert.assertEquals(stockPage.getDeliveryPrice(), 100.0f, "Доставка - 100")
        val goodsInStock = stockPage.getGoods()
        assert.assertEquals(goodsInStock[0].getPrice(), (goods[0].price.toFloat() * 0.9).toFloat(), "Цена должна отображаться со скидкой")
        assert.assertAll()
    }

    @Test(priority=2, description = "Add order to a stock with prepay and discount. Check it in a cart")
    fun addOrderAndCheckInCart() {
        UserFunctions.loginAsUser(UsersList.USER!!)

        StockPage.open(stockId!!.second)
        val stockPage = StockPage()
        stockPage.addOrder(OrderList.CARDIGAN!!)
        stockPage.addOrder(OrderList.BOOTS!!)
        val assert = SoftAssert()
        CartPage.open()
        Driver.reloadPage()
        val stockInCart = CartPage().getStockByTitle(StockWithPrepayAndDiscount!!.title)
        val orders = stockInCart.getOrders()
        assert.assertTrue(orders.isNotEmpty(), "Товары должны быть добавлены в корзину")
        assert.assertEquals(orders[0].getTitle(), OrderList.CARDIGAN!!.goodName, "Должно быть показано название товара - кардиган")
        assert.assertEquals(orders[0].getPrice().toString(), (OrderList.CARDIGAN!!.price.toFloat() * 0.9).toInt().toString(), "Цена 'Кардиган' должна соответствовать цене в закупке")
        assert.assertEquals(orders[0].getParams(), OrderList.CARDIGAN!!.sizeRow, "Параметры должны быть теми с которыми был добавлен товар")
        assert.assertEquals(orders[0].getStatus(), "заказан", "Статус товара - заказан")
        assert.assertEquals(orders[1].getTitle(), OrderList.BOOTS!!.goodName, "Должно быть показано название товара - кроссовки")
        assert.assertEquals(orders[1].getPrice().toString(), (OrderList.BOOTS!!.price.toFloat() * 0.9).toInt().toString(), "Цена 'Кроссовки' должна соответствовать цене в закупке")
        assert.assertEquals(orders[1].getParams(), OrderList.BOOTS!!.sizeRow, "Параметры должны быть теми с которыми был добавлен товар")
        assert.assertEquals(orders[1].getStatus(), "заказан")
        assert.assertEquals(stockInCart.getGoodsCount(), 2, "Всего товаров в заказе")
        assert.assertEquals(stockInCart.getNeedToPay(), 135.0f, "К оплате: ")
        assert.assertEquals(stockInCart.getAllPay(), 1417.5f, "Сумма заказа: ")
        assert.assertEquals(stockInCart.getOrgPay(), 67.5f, "Оргсбор: ")
        assert.assertEquals(stockInCart.getPaid(), 0.0f, "Оплачено: ")
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
        UserFunctions.loginIfUnauthorized(UsersList.USER2!!)

        StockPage.open(stockId!!.second)
        val stockPage = StockPage()
        stockPage.addOrder(OrderList.CARDIGAN!!)
        stockPage.addOrder(OrderList.SHIRT!!)
    }

    @Test(priority=5, description = "Add order for sptest3")
    fun addOrderForUser3() {
        UserFunctions.loginIfUnauthorized(UsersList.USER3!!)

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
        UserFunctions.loginIfUnauthorized(UsersList.ADMIN!!)

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

    @Test(priority = 7, description = "Login as org and check order's statuses")
    fun checkOrdersStatus() {
        val assert = SoftAssert()

        StockManagePage.open()
        val stockManagePage = StockManagePage()
        stockManagePage.getStockByTitle(StockWithPrepayAndDiscount!!.title).clickOrders()

        val ordersPage = StockOrgOrdersPage()
        val ordersForUser1 = ordersPage.getOrdersByUser("sptest1")
        val ordersForUser2 = ordersPage.getOrdersByUser("sptest2")
        val ordersForUser3 = ordersPage.getOrdersByUser("sptest3")

        assert.assertEquals(ordersForUser1[0].goodStatus(), "подтверждён", "Заказ sptest1, который подтвердили")
        assert.assertEquals(ordersForUser1[1].goodStatus(), "нет в наличии", "Заказ sptest1, который отменили")
        assert.assertEquals(ordersForUser2[0].goodStatus(), "подтверждён", "Заказ sptest2, который подтвердили")
        assert.assertEquals(ordersForUser2[1].goodStatus(), "подтверждён", "Заказ sptest2, который подтвердили")
        assert.assertEquals(ordersForUser3[0].goodStatus(), "нет в наличии", "Заказ sptest3, который отменили")
        assert.assertEquals(ordersForUser3[1].goodStatus(), "подтверждён", "Заказ sptest3, который подтвердили")

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
        val paymentsUser3 = paymentsPage.getOrdersByUser("sptest3")

        assert.assertEquals(paymentsUser1.size, 1, "Оплата от sptest1")
        assert.assertEquals(paymentsUser3.size, 1, "Оплата от sptest3")

        assert.assertAll()
    }

    @Test(priority=8, description = "Set stock status to stop and check in stock page and cart")
    fun stopStockAsOrg() {
        val assert = SoftAssert()

        StockFunctions.setStockStatus(stockId!!.first, StockStatus.STOP)
        StockPage.open(stockId!!.second)
        assert.assertTrue(StockPage().getStatus().contains(StockStatus.STOP.text), "На странице закупки статус стоп")

        UserFunctions.loginIfUnauthorized(UsersList.USER!!)
        CartPage.open()

        var stockInCart = CartPage().getStockByTitle(StockWithPrepayAndDiscount!!.title)
        val orders = stockInCart.getOrders()

        assert.assertTrue(stockInCart.getStatus().contains(StockStatus.STOP.text), "Закупка в стопе")
        assert.assertEquals(stockInCart.getAllPay(), 472.5f, "Осталось к оплате - 472.5")
        assert.assertEquals(orders[0].getStatus(), "подтверждён", "Кардиган подтвержден")
        assert.assertEquals(orders[1].getStatus(), "нет в наличии", "Кардиган подтвержден")
        assert.assertEquals(stockInCart.getGoodsCount(), 1, "Всего товаров в заказе")
        assert.assertEquals(stockInCart.getNeedToPay(), 0.0f, "К оплате: ")
        assert.assertEquals(stockInCart.getAllPay(), 472.50f, "Сумма заказа: ")
        assert.assertEquals(stockInCart.getOrgPay(), 22.50f, "Оргсбор: ")
        assert.assertEquals(stockInCart.getPaid(), 135.0f, "Оплачено: ")

        val purseCurrent = Header().getWalletCount()
        stockInCart.pay()
        Driver.pause(5)
        assert.assertEquals(Header().getWalletCount(), purseCurrent - 427.50f)

        assert.assertAll()
    }

    @Test(priority=9, description = "Login as org and set stock status to stop")
    fun setStockCheckedAsOrg() {
        val assert = SoftAssert()

        UserFunctions.loginIfUnauthorized(UsersList.ADMIN!!)
        StockFunctions.setStockStatus(stockId!!.first, StockStatus.STOP)
        StockPage.open(stockId!!.second)
        assert.assertTrue(StockPage().getStatus().contains(StockStatus.STOP.text))

        StockFunctions.setStockStatus(stockId!!.first, StockStatus.CHECK)
        StockPage.open(stockId!!.second)
        assert.assertEquals(StockPage().getStatus(), StockStatus.CHECK.text)

        StockFunctions.setStockStatus(stockId!!.first, StockStatus.SEND)
        StockPage.open(stockId!!.second)
        assert.assertEquals(StockPage().getStatus(), StockStatus.SEND.text)

        assert.assertAll()
    }

    @Test(priority=10, description = "Login as org and set stock status to receive")
    fun setStockInReceivedAsOrg() {
        val assert = SoftAssert()

        UserFunctions.loginIfUnauthorized(UsersList.ADMIN!!)
        StockFunctions.setStockStatus(stockId!!.first, StockStatus.RECEIVE)
        StockPage.open(stockId!!.second)
        assert.assertEquals(StockPage().getStatus(), StockStatus.RECEIVE.text)

        assert.assertAll()
    }

    @Test(priority=11, description = "Login as user and set office for delivery")
    fun setDeliveryAsUsers() {
        val assert = SoftAssert()

        UserFunctions.loginIfUnauthorized(UsersList.USER!!)
        CartPage.open()

        var stockInCart = CartPage().getStockByTitle(StockWithPrepayAndDiscount!!.title)
        stockInCart.selectPickupOffice("Зарубина, 44, г. Йошкар-Ола, ул. Зарубина, 44")
        stockInCart.reload()
        assert.assertEquals(stockInCart.getOffice().first, "Зарубина, 44 изменить отменить")
        assert.assertTrue(stockInCart.getOffice().second.contains( "г. Йошкар-Ола, ул. Зарубина, 44"))

        UserFunctions.loginIfUnauthorized(UsersList.USER2!!)
        CartPage.open()

        var stockInCart2 = CartPage().getStockByTitle(StockWithPrepayAndDiscount!!.title)
        stockInCart2.selectPickupOffice("Йошкар-Ола Строителей_1218_С, 424007, Йошкар-Ола г, Строителей ул, д.44")
        stockInCart2.reload()
        assert.assertEquals(stockInCart2.getOffice().first, "Йошкар-Ола Строителей_1218_С (boxberry) изменить отменить")
        assert.assertTrue(stockInCart2.getOffice().second.contains( "424007, Йошкар-Ола г, Строителей ул, д.44"))

        UserFunctions.loginIfUnauthorized(UsersList.USER3!!)
        CartPage.open()

        var stockInCart3 = CartPage().getStockByTitle(StockWithPrepayAndDiscount!!.title)
        stockInCart3.selectPickupOffice("Комсомольская, 110, г. Йошкар-Ола, ул. Комсомольская, 110")
        stockInCart3.reload()
        assert.assertEquals(stockInCart3.getOffice().first, "Комсомольская, 110 изменить отменить")
        assert.assertTrue(stockInCart3.getOffice().second.contains( "г. Йошкар-Ола, ул. Комсомольская, 110"))

        assert.assertAll()
    }

    @Test(priority=12, description = "Login as admin and run cron")
    fun runUpdateAssembly() {
        UserFunctions.loginIfUnauthorized(UsersList.ADMIN!!)

        AdminCronActionsPage.open()
        AdminCronActionsPage().clickRunCreateBoxes("Создание посылок по корзинам закупок", stockId!!.first)
    }

    @Test(priority=13, description = "Login as org and check boxes")
    fun checkBoxes() {
        val assert = SoftAssert()

        UserFunctions.loginIfUnauthorized(UsersList.ADMIN!!)

        OrgOfficeControlPage.openAssemblyOffice(18)

        OrgAssemblyStocksListPage.clickElement(StockWithPrepayAndDiscount!!.title)

        val assemblyPage = OrgBoxAssemblyPage()
        val orders = assemblyPage.getOrders()

        assert.assertEquals(orders.size, 3)

        assert.assertEquals(orders[0].first.status(), "новая")
        assert.assertEquals(orders[1].first.status(), "новая")
        assert.assertEquals(orders[2].first.status(), "новая")

        assert.assertEquals(orders[0].first.fromOffice(), "18", "Проверить начальный офис")
        assert.assertEquals(orders[1].first.fromOffice(), "18", "Проверить начальный офис")
        assert.assertEquals(orders[2].first.fromOffice(), "18", "Проверить начальный офис")

        assert.assertEquals(orders[0].first.whereOffice(), "18", "Проверить текущий офис")
        assert.assertEquals(orders[1].first.whereOffice(), "18", "Проверить текущий офис")
        assert.assertEquals(orders[2].first.whereOffice(), "18", "Проверить текущий офис")

        assert.assertEquals(orders[0].first.toOffice(), "", "Проверить конечный офис")
        assert.assertEquals(orders[1].first.toOffice(), "16872", "Проверить конечный офис")
        assert.assertEquals(orders[2].first.toOffice(), "", "Проверить конечный офис")

        assert.assertEquals(orders[1].first.notPaid(), "не оплачено: 661.50 р.")

        val orders1 = orders[0].second.getGoodsList()
        val orders2 = orders[1].second.getGoodsList()
        val orders3 = orders[2].second.getGoodsList()

        assert.assertEquals(orders1.size, 1)
        assert.assertEquals(orders2.size, 2)
        assert.assertEquals(orders3.size, 1)

        assert.assertEquals(orders1[0].getName(), "Женский кардиган")
        assert.assertEquals(orders2[0].getName(), "Женский кардиган")
        assert.assertEquals(orders2[1].getName(), "Рубашка женская белая")
        assert.assertEquals(orders3[0].getName(), "Рубашка женская белая")

        boxesIds.add(orders[0].first.boxNumber())
        boxesIds.add(orders[1].first.boxNumber())
        boxesIds.add(orders[0].first.boxNumber())

        assert.assertAll()
    }

    @Test(priority=14, description = "Login as org and assembly boxes. Check that boxes removed from page")
    fun assemblyBoxes() {
        val assert = SoftAssert()

        OrgBoxAssemblyPage().assemblyBox(0, 1.5f, Triple(1.5f, 50f, 12.5f))
        OrgBoxAssemblyPage().assemblyBox(0, 5.0f, Triple(50.2f, 70.2f, 15.5f))
        OrgBoxAssemblyPage().assemblyBox(0, 0.4f, Triple(10.0f, 15.3f, 6.1f))

        var orders = OrgBoxAssemblyPage().checkOrdersPresent()

        assert.assertEquals(1, orders)
        assert.assertAll()
    }

    @Test(priority=15, description = "Login as org check boxes in all boxes list")
    fun checkAssembledBoxesInList() {
        val assert = SoftAssert()

        OrgBoxesListPage.openOffice(18)
        val box1 = OrgBoxesListPage.getBox(boxesIds[0])
        val box2 = OrgBoxesListPage.getBox(boxesIds[1])
        val box3 = OrgBoxesListPage.getBox(boxesIds[2])

        assert.assertEquals(box1["number"], boxesIds[0])

        assert.assertAll()
    }
}