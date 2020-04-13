package com.sp4.pages

import com.sp4.elements.CategorySelector
import com.sp4.elements.InfoDialog
import com.sp4.elements.StockOrgEntry
import com.sp4.elements.TextEditorFrame
import com.sp4.testdata.StockData
import com.uitestcore.driverutils.Common
import com.uitestcore.driverutils.Driver
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.CheckBox
import com.uitestcore.elementobjects.Select
import com.uitestcore.elementobjects.TextField
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.nio.file.Path
import java.nio.file.Paths


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
        }
    }

    fun getStockByTitle(title: String): StockOrgEntry {
        return Driver.findDecoratedElement(StockOrgEntry().javaClass, By.xpath(StockOrgEntry.getStockSelectorByTitle(title))) as StockOrgEntry
    }

    fun isStockPresent(title: String): Boolean {
        val stock = Driver.findDecoratedElements(StockOrgEntry().javaClass, By.xpath(StockOrgEntry.getStockSelectorByTitle(title))) as List<StockOrgEntry>
        return stock.isNotEmpty()
    }

    fun clickAddStock() {
        btnAddStock!!.click()
    }


}