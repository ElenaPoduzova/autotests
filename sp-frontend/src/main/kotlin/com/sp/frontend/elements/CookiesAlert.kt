package com.sp.frontend.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import java.lang.Exception

class CookiesAlert : AbstractContainer() {
    @FindBy(css = ".sp-cookie-alert")
    private val main: WebElement? = null

    @FindBy(css = "div.sp-cookie-alert-wrapper.sp-cookie-alert-wrapper.container button")
    private val btn: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun dismiss() {
        try {
            btn!!.click()
        }
        catch (ex: Exception)
        {

        }
    }
}
