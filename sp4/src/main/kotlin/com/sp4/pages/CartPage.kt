package com.sp4.pages

import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.TabElement
import com.uitestcore.pageobjects.BasePage
import com.sp4.elements.CartStock
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

    companion object {
        fun open() {
            Driver.openPage("/cart")
            Wait.elementPresence(By.xpath("//h1[text() = 'Мои заказы']"))
        }
    }

    fun clickTab(tabName: String) {
        val tabElement: WebElement = Driver.get().findElement(By.cssSelector(".[data-tab='$tabName']"))
        Wait.until(ExpectedConditions.attributeContains(tabElement, "class", "nav-item nav-link d-inline-block active"))
    }

    fun openTab() {

    }

    fun getStockByTitle(stockTitle: String) : CartStock {
        return Driver.findDecoratedElement(CartStock::class, By.xpath("//div[@class='sp-cart__title']/a[contains(text(), '${stockTitle}')]/ancestor::div[contains(@class, 'sp-cart__item')]"))
    }

    fun getStockById(id: String) : CartStock {
        return Driver.findDecoratedElement(CartStock::class, By.cssSelector("div[data-id='${id}']"))
    }

}