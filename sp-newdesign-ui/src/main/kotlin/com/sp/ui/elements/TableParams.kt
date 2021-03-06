package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class TableParams: AbstractContainer() {
    private lateinit var values: MutableMap<String, String>

    override fun init(wrappedElement: WebElement) {
        super.init(wrappedElement)
        val paramsList = this.findElements(By.cssSelector("table tbody tr"))
        values = mutableMapOf<String, String>()
        for (param in paramsList)
        {
            values[(param.findElement(By.cssSelector("th")) as WebElement).text] = (param.findElement(By.cssSelector("td strong")) as WebElement).text
        }
    }

    fun getValues(): MutableMap<String, String> {
        return values
    }

}