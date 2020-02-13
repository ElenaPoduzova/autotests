package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.Button
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CartButton : AbstractContainer() {
    @FindBy(css = ".topbar-item.nav-btn:nth-child(2) a")
    private val btn: Button? = null

    @FindBy(css = "span.text")
    private val count: WebElement? = null

    fun click() {
        btn!!.click()
    }

    fun getValue(): Int {
        return count!!.text.toInt()
    }
}
