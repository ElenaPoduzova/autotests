package com.sp.frontend.elements

import com.tests.core.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class User(element: WebElement) : AbstractContainer() {
    private var self = element
    private var avatar: WebElement
    private var name: WebElement

    init {
        avatar = self.findElement(By.cssSelector(".sp-stock__item-author-image"))
        name = self.findElement(By.cssSelector(".sp-stock__item-author-name"))
    }
}
