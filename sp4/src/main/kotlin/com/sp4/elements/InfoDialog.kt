package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Common
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.TextField
import com.uitestcore.elementobjects.Text
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class InfoDialog : AbstractContainer() {
    @FindBy(css = ".modal-header")
    private val header: TextField? = null
    @FindBy(css = "button.close")
    private val closeBtn: TextField? = null
    @FindBy(css = ".modal-body")
    private val info: WebElement? = null

    @FindBy(css = "button[type='button'][data-dismiss='modal']")
    private val submitButton: Button? = null
    @FindBy(css = ".cancel")
    private val declineButton: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    companion object Locators {
        fun body() : By {
            return By.cssSelector(".modal-content")
        }
    }

    fun info() : String{
        return info!!.text
    }

    fun submit(){
        submitButton!!.click()
    }

}
