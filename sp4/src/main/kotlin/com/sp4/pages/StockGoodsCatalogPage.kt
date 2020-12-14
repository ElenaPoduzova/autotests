package com.sp4.pages

import com.sp4.elements.GoodOrgEntry
import com.sp4.testdata.StockGoodData
import com.uitestcore.driverutils.Driver
import com.uitestcore.elementobjects.Button
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy

class  StockGoodsCatalogPage : BasePage() {
    @FindBy(css=".good-page div a")
    private val addGoodBtn: Button? = null

    companion object {
        fun open(stockId: String) {
            Driver.openPage("/stock/org/good/catalog?stock=$stockId")
        }
    }

    fun clickAddGood() {
        addGoodBtn!!.click()
    }

    fun addGood(data: StockGoodData) {
        clickAddGood()
        StockAddGoodPage().fillGoodDataAndConfirm(data)
    }

    fun jsAddGood(data: StockGoodData) {
        clickAddGood()
        StockAddGoodPage().jsFillGoodDataAndConfirm(data)
    }

    fun getGoodByName(title: String): GoodOrgEntry {
        return Driver.findDecoratedElement(GoodOrgEntry::class, By.xpath(GoodOrgEntry.getGoodSelectorByTitle(title))) as GoodOrgEntry
    }

    fun addGoodToStock(data: Array<StockGoodData?>) {
        data.forEach {
            getGoodByName(it!!.title).clickAdd()
        }
    }

}