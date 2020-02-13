package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class CartDiscount(element: WebElement) : AbstractContainer() {
    private var self = element
    private var org: User
    private var title: WebElement
    private var statusBtn: WebElement
    private var prepay: WebElement
    private var discount: WebElement
    private var description: WebElement


    init {
        title = self.findElement(By.cssSelector(".cart-item-header-content a span.cart-item-title-value"))
        org = User(self.findElement(By.cssSelector(".cart-params-list .cart-item-org-login-block")))
        statusBtn = self.findElement(By.cssSelector(".cart-param-status .text-truncate"))
        prepay = self.findElement(By.cssSelector(".cart-params-list div:nth-child(2)"))
        discount = self.findElement(By.cssSelector(".cart-params-list div:nth-child(3)"))
        description = self.findElement(By.cssSelector(".cart-item-header .row"))
    }

    fun getOrders() {
        val orders = self.findElements(By.cssSelector(".cart-item-content-data .cart-item-data"))
    }
}
