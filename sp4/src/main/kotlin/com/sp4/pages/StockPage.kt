package com.sp4.pages

import com.sp4.elements.StockGood
import com.sp4.testdata.OrderData
import com.sp4.testdata.UserData
import com.uitestcore.driverutils.Driver
import com.uitestcore.elementobjects.*
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class StockPage : BasePage() {
    @FindBy(css=".sp-sale-page__title h1")
    private val stockTitle: Text? = null
    @FindBy(css=".sp-author__media.media")
    private val org: WebElement? = null
    @FindBy(css=".sp-author__message")
    private val authorMessage: WebElement? = null
    @FindBy(css=".sp-stock-status__value")
    private val status: WebElement? = null
    @FindBy(css=".sp-sale-page__stock-info-discount-value")
    private val discount: WebElement? = null
    @FindBy(css=".sp-sale-page__stock-info-goods-count")
    private val goodsCnt: Text? = null
    @FindBy(css=".sp-sale-page__stock-info-orders-count")
    private val ordersCnt: Text? = null
    @FindBy(css=".sp-sale-page__properties-description")
    private val aboutStock: WebElement? = null
    @FindBy(css=".sp-tabs.nav.nav-tabs li")
    private val navTabs: WebElement? = null
    @FindBy(css=".sp-sale-page__good-entity")
    private val goods: List<StockGood>? = null
    @FindBy(css=".sp-sale-page__good-entity")
    private val good: StockGood? = null

    companion object {
        fun open(id: String) {
            Driver.openPage("stock/${id}")
        }
    }

    fun clickNavTab(tabName: String) {
        Driver.findElement(By.xpath("//*[@class='sp-tabs nav nav-tabs']//a[contains(text(), '$tabName')]")).click()
    }

    fun addOrder(order: OrderData) {
        goods!!.forEach {
            if (it.getTitle() == order.goodName) {
                it.addOrder(order.size)
                return
            }
        }
    }

    fun isOrderAdded(order: OrderData, user: UserData): Boolean {
        goods!!.forEach {
            if (it.getTitle() == order.goodName) {
                return it.checkOrderAdded(order.sizeRow, user.name)
            }
        }
        return false
    }

    fun addOrderRow(order: OrderData) {
        goods!!.forEach {
            if (it.getTitle().toString() == order.goodName) {
                it.addOrderRow(order.sizeRow)
                return
            }
        }
    }

    fun getGoodsCount() : Int {
        val pattern1 = "(\\d*)\\w+".toRegex()
        if (pattern1.containsMatchIn(goodsCnt!!.text())) {
            var result = pattern1.find(goodsCnt.text())?.groups?.get(0)?.value
            return result!!.toInt()
        }
        else
            throw Exception("Wrong format")
    }

    fun getOrders() : Int{
        val pattern1 = "(\\d*)\\w+".toRegex()
        if (pattern1.containsMatchIn(ordersCnt!!.text())) {
            var result = pattern1.find(ordersCnt.text())?.groups?.get(0)?.value
            return result!!.toInt()
        }
        else
            throw Exception("Wrong format")
    }
}