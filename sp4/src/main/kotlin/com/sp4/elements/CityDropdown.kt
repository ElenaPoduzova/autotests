package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.elementobjects.Button
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CityDropdown : AbstractContainer() {
    @FindBy(css = ".popover .show .bs-popover-auto")
    private val main: WebElement? = null

    @FindBy(css = ".popover .sp-button")
    private val btnYes: Button? = null

    @FindBy(css = ".popover .sp-button:nth-child(2)")
    private val btnSelect: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun confirm() {
        btnYes!!.click()
    }
}
