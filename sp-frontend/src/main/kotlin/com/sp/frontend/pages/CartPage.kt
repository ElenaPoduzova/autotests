package com.sp.frontend.pages

import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.Wait
import com.tests.core.elementobjects.TabElement
import com.tests.core.pageobjects.BasePage
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
    val elementsList: List<WebElement>? = null

    fun open() {
        Driver.openPage("/cart")
    }

    fun getCartItemsCount(): Int {
        return elementsList!!.size
    }

    fun getOrdersList(): MutableList<CartStock> {
        var ordersList: MutableList<CartStock> = mutableListOf<CartStock>()
        for(element in elementsList!!){
            if (element.text.startsWith("Закупка"))
            {
                ordersList.add(CartStock(element))
            }
        }
        return ordersList
    }

    fun getDiscountList(): MutableList<CartDiscount> {
        var ordersList: MutableList<CartDiscount> = mutableListOf<CartDiscount>()
        for(element in elementsList!!){
            if (element.text.startsWith("Скидка")) {
                ordersList.add(CartDiscount(element))
            }
        }
        return ordersList
    }

    fun clickTab(tabName: String) {
        val tabElement = Driver.get().findElement(By.cssSelector(".[data-tab='$tabName']"))
        Wait.until(ExpectedConditions.attributeContains(tabElement, "class", "nav-item nav-link d-inline-block active"))
    }

    fun openTab() {

    }

}