package com.sp4.uitest.tests

import com.sp4.pages.*
import com.sp4.testdata.StockStatus
import com.sp4.testdata.StocksList.FullStock
import com.sp4.testdata.StocksGoodList
import com.sp4.testdata.UsersList
import com.sp4.uitest.testutils.TestInitWithLogin
import org.junit.Assert
import org.testng.annotations.Test

class TestCreateStock : TestInitWithLogin(UsersList.ORG) {
    private lateinit var stockManagePage: StockManagePage
    private var stockId: Int? = null

    @Test(priority=1)
    fun createStock() {
        StockManagePage.open()
        stockManagePage = StockManagePage()
        stockManagePage.clickAddStock()
        StockEditPage().fillStockDataAndConfirm(FullStock!!)
        Assert.assertTrue(stockManagePage.isStockPresent(FullStock!!.title))
        stockId = stockManagePage.getStockIdByTitle(FullStock!!.title)
        Assert.assertTrue(stockManagePage.isStockPresent(FullStock!!.title))
    }

    @Test(priority=2)
    fun createNewGoods() {
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn().addGood(StocksGoodList.BOOTS!!)
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn().addGood(StocksGoodList.CARDIGAN!!)
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn().addGood(StocksGoodList.TOP!!)
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn().addGood(StocksGoodList.SHIRT!!)
    }

    @Test(priority=3)
    fun addGoodsToStock() {
        stockManagePage = StockManagePage()
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn()
        StockGoodsCatalogPage().addGoodToStock(arrayOf(StocksGoodList.BOOTS, StocksGoodList.CARDIGAN, StocksGoodList.TOP, StocksGoodList.SHIRT))
    }

    @Test(priority=4)
    fun setStockToOpen() {
        StockAdminEditPage.open(stockId!!)
        var stockEditPage = StockAdminEditPage()
        stockEditPage.setStatus(StockStatus.OPEN)
        stockEditPage.confirm()
    }
}