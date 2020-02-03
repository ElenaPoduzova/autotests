package com.sp.frontend.elements

import com.tests.core.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class Image(element: WebElement) : AbstractContainer() {
    private var self: WebElement = element
    private var fakeImage: WebElement
    private var realImage: WebElement

    init {
        fakeImage = self.findElement(By.cssSelector(".sp-image-box__image"))
        realImage = self.findElement(By.cssSelector(".sp-image-box__image:nth-child(2)"))
    }
}
