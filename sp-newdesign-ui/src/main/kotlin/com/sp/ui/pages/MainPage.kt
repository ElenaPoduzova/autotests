package com.sp.ui.pages

import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.pageobjects.BasePage
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
        val elementsList: List<WebElement> = Driver.findElements(By.cssSelector(".stock.row.mb-3 a.cards-card"))
        val stockList: MutableList<StockCard> = mutableListOf<StockCard>()
        for(element in elementsList){
            stockList.add(StockCard(element))
        }
        return stockList
    }
}