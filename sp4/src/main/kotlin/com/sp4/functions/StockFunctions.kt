package com.sp4.functions

import com.sp4.pages.StockAdminEditPage
import com.sp4.pages.StockEditPage
import com.sp4.pages.StockGoodsCatalogPage
import com.sp4.pages.StockManagePage
import com.sp4.testdata.*

object StockFunctions {

    fun createStock(stock: StockData, goods: List<StockGoodData>) : Pair<Int, String> {
        var stockId: Int
        var fullStockId: String
        StockEditPage.open()
        val stockEditPage = StockEditPage()
        stockEditPage.fillWithJS(stock)
        StockManagePage.open()
        val stockManagePage = StockManagePage()
        if (stockManagePage.isStockPresent(StocksList.FullStock!!.title)) {
            stockId = stockManagePage.getStockIdByTitle(StocksList.FullStock!!.title)
            fullStockId = stockManagePage.getStockFullIdByTitle(StocksList.FullStock!!.title)
            goods.forEach {
                StockManagePage.open()
                stockManagePage.getStockByTitle(StocksList.FullStock!!.title).clickGoods().clickCatalogBtn().jsAddGood(it)
            }
        }
        else{
            throw Exception("Stock was not created!")
        }
        StockManagePage.open()
        stockManagePage.getStockByTitle(StocksList.FullStock!!.title).clickGoods().clickCatalogBtn()
        StockGoodsCatalogPage().addGoodToStock(goods.toTypedArray())
        return  Pair(stockId, fullStockId)
    }


    fun createStock(stock: StockData) : Pair<Int, String> {
        var stockId: Int
        var fullStockId: String
        StockEditPage.open()
        val stockEditPage = StockEditPage()
        stockEditPage.fillWithJS(stock)
        StockManagePage.open()
        val stockManagePage = StockManagePage()
        if (stockManagePage.isStockPresent(StocksList.FullStock!!.title)) {
            stockId = stockManagePage.getStockIdByTitle(StocksList.FullStock!!.title)
            fullStockId = stockManagePage.getStockFullIdByTitle(StocksList.FullStock!!.title)
        }
        else{
            throw Exception("Stock was not created!")
        }
        return  Pair(stockId, fullStockId)
    }

    fun openStock(id: Int) {
        StockAdminEditPage.open(id)
        var stockAdminEditPage = StockAdminEditPage()
        stockAdminEditPage.setStatus(StockStatus.OPEN)
        stockAdminEditPage.confirm()
    }

}