package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class StockGoodTableParams: AbstractContainer() {
    private lateinit var values: MutableMap<String, String>

    override fun init(wrappedElement: WebElement) {
        super.init(wrappedElement)
        var paramsList = this.findElements(By.cssSelector("table tbody tr"))
        values = mutableMapOf<String, String>()
        for ((index, param) in paramsList!!.withIndex())
        {
            when (index) {
                0 -> values["Изображение:"] = param.findElement(By.cssSelector("a")).getAttribute("href")
                1 -> values["Название:"] = param.findElement(By.cssSelector("td")).text
                2 -> values["Описание:"] = param.text
                else -> {
                    values[param.findElement(By.cssSelector("td")).text] = param.findElement(By.cssSelector("td:nth-child(2)")).text
                }
            }
        }
    }

    fun getTitle(): String {
        return values["Название:"]!!
    }

    fun getDescription(): String {
        return values["Описание:"]!!
    }

    fun getCode(): String {
        return values["Артикул:"]!!
    }

    fun getPrice(): String {
        return values["Цена:"]!!
    }

    override fun toString(): String {
        return values["Название:"]!! + values["Описание:"]!! + values["Артикул:"]!! + values["Цена:"]!!
    }
}