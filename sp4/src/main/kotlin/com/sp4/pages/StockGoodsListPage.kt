package com.sp4.pages

import com.sp4.elements.GoodOrgEntry
import com.sp4.elements.StockOrgEntry
import com.uitestcore.driverutils.Driver
import com.uitestcore.elementobjects.Button
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy

class  StockGoodsListPage : BasePage() {
    @FindBy(css=".good-page .float-right a:nth-child(2)")
    private val catalogBtn: Button? = null

    @FindBy(css=".good-page .float-right a")
    private val slizaBtn: Button? = null

    companion object {
        fun open(stockId: String) {
            Driver.openPage("/stock/org/good?stock=$stockId")
        }
    }

    fun clickCatalogBtn() : StockGoodsCatalogPage {
        catalogBtn!!.click()
        return StockGoodsCatalogPage()
    }

    fun addSliza(file: String) {
        slizaBtn!!.click()
        SlizaPage().addSliza(file)
    }
}