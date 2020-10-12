package com.sp4.uitest.tests

import com.sp4.pages.*
import com.sp4.testdata.StockStatus
import com.sp4.testdata.StocksList.FullStock
import com.sp4.testdata.StocksGoodList
import com.sp4.uitest.testutils.TestInitWithLogin
import org.junit.Assert
import org.testng.annotations.Test

class TestCreateStock : TestInitWithLogin() {
    private lateinit var stockManagePage: StockManagePage
    private var stockId: Int? = null

    @Test(priority=1)
    fun createStock() {
        StockEditPage.open()
        StockEditPage().fillStockDataAndConfirm(FullStock!!)
        stockManagePage = StockManagePage()
        Assert.assertTrue(stockManagePage.isStockPresent(FullStock!!.title))
        stockId = stockManagePage.getStockIdByTitle(FullStock!!.title)
        Assert.assertTrue(stockManagePage.isStockPresent(FullStock!!.title))
    }

    @Test(priority=2)
    fun createNewGoods() {
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn().addGood(StocksGoodList.FisrtGood!!)
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn().addGood(StocksGoodList.SecondGood!!)
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn().addGood(StocksGoodList.ThirdGood!!)
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn().addGood(StocksGoodList.FourthGood!!)
    }

    @Test(priority=3)
    fun addGoodsToStock() {
        stockManagePage = StockManagePage()
        StockManagePage.open()
        stockManagePage.getStockByTitle(FullStock!!.title).clickGoods().clickCatalogBtn()
        StockGoodsCatalogPage().addGoodToStock(arrayOf(StocksGoodList.FisrtGood, StocksGoodList.SecondGood, StocksGoodList.ThirdGood, StocksGoodList.FourthGood))
    }

    @Test(priority=4)
    fun setStockToOpen() {
        StockAdminEditPage.open(stockId!!)
        var stockEditPage = StockAdminEditPage()
        stockEditPage.setStatus(StockStatus.OPEN)
        stockEditPage.confirm()
    }
}