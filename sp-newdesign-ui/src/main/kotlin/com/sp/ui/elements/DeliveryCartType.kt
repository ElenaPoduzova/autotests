package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class DeliveryCartType(element: WebElement) : AbstractContainer() {
    private var self: WebElement = element
    private val deliveryPlace: WebElement
    private val deliveryPrice: WebElement
    private val deliveryCode: WebElement

    init {
        deliveryPlace = self.findElement(By.cssSelector(".cart-item-delivery-data-info"))
        deliveryPrice = self.findElement(By.cssSelector(".cart-item-delivery-data-title"))
        deliveryCode = self.findElement(By.cssSelector(".cart-item-alias"))
    }

    fun getPlace(): String? {
        return deliveryPlace.text
    }

    fun getCode(): String? {
        return deliveryPlace.text
    }

    fun getPrice(): Float? {
        val pattern = "[\\w*| ]- (\\d*)".toRegex()
        val found = pattern.find(deliveryPrice.text)
        return found!!.value.toFloat()
    }
}
