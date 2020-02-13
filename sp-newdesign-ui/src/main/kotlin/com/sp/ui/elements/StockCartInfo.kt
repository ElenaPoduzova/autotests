package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class StockCartInfo() : AbstractContainer() {
    private lateinit var image: WebElement
    private lateinit var text: WebElement

    constructor(element: WebElement) : this() {
        super.wrappedElement = element
    }

    override fun init(wrappedElement: WebElement) {
        super.init(wrappedElement)
        image = this.findElement(By.cssSelector("img"))
        text = this.findElement(By.cssSelector("div"))
    }
}