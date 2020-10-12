package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class Sp4GoodRow(element: WebElement) : AbstractContainer() {
    private var self: WebElement = element
    @FindBy(css = ".sp-good__row.good-entity-row")
    private val rows: List<WebElement>? = null

    fun addOrder(size: String) {
        self.findElement<WebElement>(By.xpath("//*[@class='sp-good__variant-title sp-good__variant-title-1 ' and  contains(text(), '$size')]/following-sibling::div[@class='sp-good__items']/div[@class='sp-good__item']")).click()
    }

    fun checkOrderAdded(size: String, userName: String) : Boolean {
        var order = self.findElement<WebElement>(By.xpath("//*[@class='sp-good__variant-title sp-good__variant-title-1 ' and  contains(text(), '$size')]/following-sibling::div[@class='sp-good__items']/div[@class='sp-good__item sp-good__item--ordered']/a"))
        if (order != null) {
            return (order.text == userName)
        }
        return false;
    }
}
