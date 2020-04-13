package com.sp4.uitest.tests

import com.sp4.pages.*
import com.sp4.testdata.StocksList.FullStock
import com.sp4.uitest.testutils.TestInitWithLogin
import org.junit.Assert
import org.testng.annotations.Test

class TestCreateStock : TestInitWithLogin() {
    private lateinit var stockEditPage: StockEditPage

    @Test(priority=1)
    fun createStock() {
        StockEditPage.open()
        stockEditPage = StockEditPage()
        stockEditPage.fillStockDataAndConfirm(FullStock!!)
        val stockManagePage = StockManagePage()
        Assert.assertTrue(stockManagePage.isStockPresent(FullStock!!.title))
        val stockOrgEntry = stockManagePage.getStockByTitle(FullStock!!.title)
        stockOrgEntry.delete()
        Assert.assertTrue(stockManagePage.isStockPresent(FullStock!!.title))
    }
}