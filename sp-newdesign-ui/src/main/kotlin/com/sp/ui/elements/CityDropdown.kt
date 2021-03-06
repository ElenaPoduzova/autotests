package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.elementobjects.Button
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CityDropdown : AbstractContainer() {
    @FindBy(id = "dropdown_cityselect")
    private val main: WebElement? = null

    @FindBy(css = "#dropdown_cityselect .btn.btn-yes")
    private val btnYes: Button? = null

    @FindBy(css = "#dropdown_cityselect .btn.btn-sel")
    private val btnSelect: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun confirm() {
        btnYes!!.click()
    }
}
