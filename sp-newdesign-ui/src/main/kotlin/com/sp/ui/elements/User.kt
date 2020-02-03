package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class User() : AbstractContainer() {
    private lateinit var self: WebElement
    private lateinit var avatar: WebElement
    private lateinit var name: WebElement

    constructor(element: WebElement) : this() {
        super.wrappedElement = element
    }

    override fun init(wrappedElement: WebElement) {
        super.init(wrappedElement)
        avatar = this.findElement(By.cssSelector("img"))
        name = this.findElement(By.cssSelector("span"))
    }
}