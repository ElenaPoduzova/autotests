package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class StockCard() : AbstractContainer() {
    private lateinit var image: WebElement
    private lateinit var title: WebElement
    private lateinit var author: User
    private lateinit var description: WebElement
    private lateinit var footer: WebElement

    constructor(element: WebElement) : this() {
        super.wrappedElement = element
    }

    override fun init(wrappedElement: WebElement) {
        super.init(wrappedElement)
        image = this.findElement(By.cssSelector(".card-preview"))
        title = this.findElement(By.cssSelector(".cards-card-title"))
        author =
            User(this.findElement(By.cssSelector(".cards-card-user")))
        description = this.findElement(By.cssSelector(".cards-card-body .cards-card-details"))
        footer = this.findElement(By.cssSelector(".cards-card-footer"))
    }

    fun getTitle(): String? {
        return title.text
    }

    fun clickLink() {
        title.click()
    }
}
