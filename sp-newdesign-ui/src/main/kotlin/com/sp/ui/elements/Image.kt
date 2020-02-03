package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class Image(element: WebElement) : AbstractContainer() {
    private var self: WebElement = element
    private var fakeImage: WebElement? = null
    private var realImage: WebElement? = null

    override fun init(wrappedElement: WebElement) {
        super.init(wrappedElement)
        fakeImage = this.findElement(By.cssSelector(".sp-image-box__image"))
        realImage = this.findElement(By.cssSelector(".sp-image-box__image:nth-child(2)"))
    }
}
