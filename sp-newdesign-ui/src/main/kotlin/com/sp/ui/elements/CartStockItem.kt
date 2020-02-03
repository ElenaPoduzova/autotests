package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class CartStockItem(element: WebElement) : AbstractContainer() {
    private var self = element
    public var name: WebElement
    public var image: Image
    public var params: WebElement
    public var status: WebElement
    public var price: WebElement


    init {
        name = self.findElement(By.cssSelector(".cart-item-name"))
        image = Image(self.findElement(By.cssSelector("img")))
        params = self.findElement(By.cssSelector(".cart-item-data-params"))
        status = self.findElement(By.cssSelector(".cart-item-data-status"))
        price = self.findElement(By.cssSelector(".cart-item-price"))
    }

    fun getOrders() {
        var orders = self.findElements(By.cssSelector(".cart-item-content-data .cart-item-data"))
    }
}
