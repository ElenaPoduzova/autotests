package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.Button
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.sql.Driver

class WalletButton : AbstractContainer() {
    @FindBy(css = "a.nav-link")
    private val btn: Button? = null

    @FindBy(css = ".nav-link span span")
    private val count: WebElement? = null

    fun click() {
        btn!!.click()
    }

    fun getValue(): Float {
        return count!!.text.toFloat()
    }
}
