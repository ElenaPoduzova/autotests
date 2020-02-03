package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class CartGood(element: WebElement) : AbstractContainer() {
    private var self = element
    private var org: User? = null
    private var title: WebElement? = null
    private var statusBtn: WebElement? = null
    private var prepay: WebElement? = null
    private var discount: WebElement? = null
    private var description: WebElement? = null


    override fun init(wrappedElement: WebElement) {
        super.init(wrappedElement)
        title = this.findElement(By.cssSelector(".cart-item-header a span.cart-item-title-value"))
        org = User(this.findElement(By.cssSelector(".cart-params-list .cart-item-org-login-block")))
        statusBtn = this.findElement(By.cssSelector(".cart-param-status"))
        prepay = this.findElement(By.cssSelector(".cart-params-list div:nth-child(2)"))
        discount = this.findElement(By.cssSelector(".cart-params-list div:nth-child(3)"))
        description = this.findElement(By.cssSelector(".cart-item-header .row"))
    }

    fun getOrders() {
        var orders = this.findElements(By.cssSelector(".cart-item-content-data .cart-item-data"))
    }
}
