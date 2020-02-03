package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class OrderRow : AbstractContainer() {
    private var sizes: List<WebElement>? = null

    @FindBy(css=".items")
    private var items: List<WebElement>? = null

    @FindBy(css=".items li")
    private var places: List<WebElement>? = null

    override fun init(wrappedElement: WebElement) {
        super.init(wrappedElement)
    }

    fun add(): Int? {
        for ((index, place) in places!!.withIndex())
        {
            if (!place.getAttribute("class").contains("buy"))
            {
                place.click()
                return index
            }
        }
        return null
    }

    fun isOrdered(place: Int): Boolean {
        if (places!![place].getAttribute("class").contains("buy")) {
            return true
        }
        return false
    }

    fun addSize() {

    }
}
