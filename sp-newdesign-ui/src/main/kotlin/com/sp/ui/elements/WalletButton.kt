package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.elementobjects.Button
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class WalletButton : AbstractContainer() {
    @FindBy(css = ".topbar-item.nav-btn:nth-child(3) a")
    private val btn: Button? = null

    @FindBy(css = "span.text.sum")
    private val count: WebElement? = null

    fun click() {
        btn!!.click()
    }

    fun getValue(): Float {
        val pattern = "([\\d| ]*,\\d\\d)".toRegex()
        val found = pattern.find(count!!.text)
        val count = found!!.value.replace(",", ".").replace(" ", "")
        return count.toFloat()
    }
}
