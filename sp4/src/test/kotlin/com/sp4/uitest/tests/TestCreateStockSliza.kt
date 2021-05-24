package com.sp4.uitest.tests

import com.sp4.functions.StockFunctions
import com.sp4.functions.UserFunctions
import com.sp4.pages.*
import com.sp4.testdata.*
import com.sp4.testdata.StocksList.FullStock
import com.sp4.uitest.testutils.TestInitWithLogin
import org.junit.Assert
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestCreateStockSliza : TestInitWithLogin(UsersList.ORG) {
    private var stockId: Pair<Int, String>? = null

    @Test(priority=1)
    fun createStock() {
        val assert = SoftAssert()
        UserFunctions.loginAsUser(UsersList.ADMIN!!)
        var goods = arrayListOf<StockGoodData>()
        goods.add(StocksGoodList.BOOTS!!)
        goods.add(StocksGoodList.CARDIGAN!!)
        goods.add(StocksGoodList.TOP!!)
        goods.add(StocksGoodList.SHIRT!!)
        stockId = StockFunctions.createStock(StocksList.StockWithPrepayAndDiscount!!, goods)
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

}