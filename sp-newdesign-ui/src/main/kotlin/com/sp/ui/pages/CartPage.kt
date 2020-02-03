package com.sp.ui.pages

import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.Wait
import com.tests.core.elementobjects.TabElement
import com.tests.core.pageobjects.BasePage
import com.sp.ui.elements.CartDiscount
import com.sp.ui.elements.CartGood
import com.sp.ui.elements.CartStock
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class CartPage : BasePage() {
    @FindBy(css=".[data-tab='default']")
    val mainTab: TabElement? = null

    @FindBy(css=".[data-tab='needpay']")
    val needpayTab: TabElement? = null

    @FindBy(css=".[data-tab='ready']")
    val readyTab: TabElement? = null

    @FindBy(css=".[data-tab='archive']")
    val archiveTab: TabElement? = null

    @FindBy(css=".cart-item-cart")
    val stockList: List<CartStock>? = null

    @FindBy(css=".cart-item-discount")
    val discountList: List<CartDiscount>? = null

    @FindBy(css=".cart-item-good")
    val goodList: List<CartGood>? = null

    fun open() {
        Driver.openPage("/cart")
    }

    fun getCartItemsCount(): Int {
        return (if (stockList != null) stockList!!.size else 0
                + if (discountList != null) discountList!!.size else 0
                + if (goodList != null) goodList!!.size else 0)
    }

    fun clickTab(tabName: String) {
        val tabElement = Driver.get().findElement(By.cssSelector(".[data-tab='$tabName']"))
        Wait.until(ExpectedConditions.attributeContains(tabElement, "class", "nav-item nav-link d-inline-block active"))
    }

    fun openTab() {

    }

}