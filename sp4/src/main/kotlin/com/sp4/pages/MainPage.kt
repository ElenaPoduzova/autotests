package com.sp4.pages

import com.uitestcore.driverutils.Driver
import com.sp4.elements.StockCard
import com.uitestcore.pageobjects.BasePage
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
        val elementsList: List<WebElement> = Driver.findElements(By.cssSelector(".sp-stock__item"))
        val stockList: MutableList<StockCard> = mutableListOf<StockCard>()
        for(element in elementsList){
            stockList.add(StockCard(element))
        }
        return stockList
    }
}