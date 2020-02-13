package com.sp.ui.pages

import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.pageobjects.BasePage
import com.sp.ui.elements.NavTabs
import com.sp.ui.elements.StockCard
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class StockListPage : BasePage() {
    @FindBy(css="a.cards-card")
    var elementsList: List<WebElement>? = null

    fun open() {
        Driver.openPage()
    }

    fun reload() {
        Driver.reloadPage()
    }

    fun openStockByTitle(title: String) {
        for(element in elementsList!!){
            if (element.text.contains(title)) {
                element.click()
                return
            }
        }
    }

    fun getAllStocks(): List<WebElement>? {
        return elementsList
    }
}