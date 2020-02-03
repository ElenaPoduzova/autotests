package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.ExtendedFieldDecorator
import com.tests.core.elementobjects.Button
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CookiesAlert : AbstractContainer() {
    @FindBy(css = ".cookiealert.show")
    private val main: WebElement? = null

    @FindBy(css = ".cookiealert.show button")
    private val btn: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun dismiss() {
        btn!!.click()
    }
}
