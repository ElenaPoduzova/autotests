package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.containers.DefaultContainerFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class OrderCart(element: WebElement) : AbstractContainer() {
    private var self: WebElement = element
    private var image: WebElement
    private var title: WebElement
    private var author: User
    private var description: WebElement
    private var footer: WebElement

    init {
        image = self.findElement(By.cssSelector(".card-preview"))
        title = self.findElement(By.cssSelector(".cards-card-title"))
        author = User(self.findElement(By.cssSelector(".cards-card-user")))
        description = self.findElement(By.cssSelector(".cards-card-body .cards-card-details"))
        footer = self.findElement(By.cssSelector(".cards-card-footer"))
    }

    fun getTitle(): String? {
        return title.text
    }
}
