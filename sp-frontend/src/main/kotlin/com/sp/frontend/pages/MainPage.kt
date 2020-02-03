package com.sp.frontend.pages

import com.tests.core.driverutils.Driver
import com.sp.frontend.elements.StockCard
import com.tests.core.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class MainPage : BasePage() {
    fun open() {
        Driver.openPage()
    }

    fun reload() {
        Driver.reloadPage()
    }

    fun getPopularStocks(): MutableList<StockCard>{
        var elementsList: List<WebElement> = Driver.findElements(By.cssSelector(".sp-stock__item"))
        var stockList: MutableList<StockCard> = mutableListOf<StockCard>()
        for(element in elementsList){
            stockList.add(StockCard(element))
        }
        return stockList
    }
}