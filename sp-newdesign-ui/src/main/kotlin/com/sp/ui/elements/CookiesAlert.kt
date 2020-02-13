package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.elementobjects.Button
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
