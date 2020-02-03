package com.sp.ui.pages

import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.ExtendedFieldDecorator
import com.tests.core.pageobjects.BasePage
import com.sp.ui.elements.StockCard
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class MainPage : BasePage() {
    fun open() {
        Driver.openPage()
    }

    fun reload() {
        Driver.reloadPage()
    }

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun getPopularStocks(): MutableList<StockCard>{
        var elementsList: List<WebElement> = Driver.findElements(By.cssSelector(".stock.row.mb-3 a.cards-card"))
        var stockList: MutableList<StockCard> = mutableListOf<StockCard>()
        for(element in elementsList){
            stockList.add(StockCard(element))
        }
        return stockList
    }
}