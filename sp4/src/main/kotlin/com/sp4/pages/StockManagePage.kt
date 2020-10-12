package com.sp4.pages

import com.sp4.elements.StockOrgEntry
import com.sp4.testdata.StockGoodData
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Select
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy


class StockManagePage : BasePage() {
    @FindBy(css="a:contains('Добавление закупки')")
    private val btnAddStock: Button? = null
    @FindBy(css="table.table.table-custom tbody tr")
    private val supplierId: List<StockOrgEntry>? = null
    @FindBy(id="StockOrgForm_ofertaId")
    private val offertaId: Select? = null

    companion object {
        fun open() {
            Driver.openPage("/stock/org")
            Wait.elementPresence(By.xpath("//h1[text() = 'Управление закупками']"))
        }
    }

    fun getStockByTitle(title: String): StockOrgEntry {
        return Driver.findDecoratedElement(StockOrgEntry::class, By.xpath(StockOrgEntry.getStockSelectorByTitle(title)))
    }

    fun isStockPresent(title: String): Boolean {
        val stock = Driver.findDecoratedElements(StockOrgEntry::class, By.xpath(StockOrgEntry.getStockSelectorByTitle(title)))
        return stock.isNotEmpty()
    }

    fun clickAddStock() {
        btnAddStock!!.click()
    }

    fun getStockIdByTitle(title: String): Int {
        try {
            var stock = Driver.findDecoratedElement(StockOrgEntry::class, By.xpath(StockOrgEntry.getStockSelectorByTitle(title)))
            return stock.id().toInt()
        }
        catch (e: Exception) {
            throw Exception("Stock is not found")
        }
    }

    fun addGoodToStock(id: Int, data: StockGoodData) {
        Driver.openPage("/stock/org/good?stock=${id}")
        StockGoodsListPage().clickCatalogBtn().clickAddGood()
        StockAddGoodPage().fillGoodDataAndConfirm(data)
    }
}