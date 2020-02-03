package com.sp.frontend.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.elementobjects.Button
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class WalletButton : AbstractContainer() {
    @FindBy(css = ".sp-header__column--wallet i")
    private val btn: Button? = null

    @FindBy(css = ".sp-header__column--wallet .sp-icon-link__text")
    private val count: WebElement? = null

    fun click() {
        btn!!.click()
    }

    fun getValue(): Float {
        val pattern = "(\\d*\\.\\d\\d)".toRegex()
        val found = pattern.find(count!!.text)
        return found!!.value.toFloat()
    }
}
