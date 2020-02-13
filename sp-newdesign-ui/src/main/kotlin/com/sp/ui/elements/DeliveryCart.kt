package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class DeliveryCart(element: WebElement) : AbstractContainer() {
    private var self: WebElement = element
    private val deliveryTime: WebElement
    private val deliveryPrice: WebElement
    private val deliveryType: DeliveryCartType

    init {
        deliveryTime = self.findElement(By.cssSelector(".supplier-org-delivery-info"))
        deliveryPrice = self.findElement(By.cssSelector(".supplier-org-delivery-title"))
        deliveryType = DeliveryCartType(self.findElement(By.cssSelector(".cart-item-delivery-data")))
    }

    fun getDeliveryTime(): String? {
        return deliveryTime.text
    }

    fun getDeliveryPrice(): Float? {
        val pattern = "[\\w*| ]- (\\d*)".toRegex()
        val found = pattern.find(deliveryPrice.text)
        return found!!.value.toFloat()
    }
}
