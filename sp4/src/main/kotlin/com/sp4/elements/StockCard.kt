package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.sp4.elements.User
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class StockCard(element: WebElement) : AbstractContainer() {
    private var self: WebElement = element
    private var image: Image
    private var title: WebElement
    private var author: User
    private var description: WebElement
    private var footer: WebElement

    init {
        image = Image(self.findElement(By.cssSelector(".sp-stock__item-image")))
        title = self.findElement(By.cssSelector(".sp-stock__item-title"))
        author = User(self.findElement(By.cssSelector(".sp-stock__item-author")))
        description = self.findElement(By.cssSelector(".sp-stock__item-description"))
        footer = self.findElement(By.cssSelector(".sp-stock__item-footer"))
    }

    fun getTitle(): String? {
        return title.text
    }
}
