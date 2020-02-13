package com.sp.frontend.pages

import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.TabElement
import com.uitestcore.pageobjects.BasePage
import com.sp.frontend.elements.CartDiscount
import com.sp.frontend.elements.CartStock
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
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
    val ordersList: List<CartStock>? = null

    fun open() {
        Driver.openPage("/cart")
    }

    fun clickTab(tabName: String) {
        val tabElement: WebElement = Driver.get().findElement(By.cssSelector(".[data-tab='$tabName']"))
        Wait.until(ExpectedConditions.attributeContains(tabElement, "class", "nav-item nav-link d-inline-block active"))
    }

    fun openTab() {

    }

}