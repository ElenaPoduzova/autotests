package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.RadioButton
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class PayDialog : AbstractContainer() {
    @FindBy(css = ".modal-header")
    private val header: TextField? = null
    @FindBy(css = "button.close")
    private val closeBtn: TextField? = null
    @FindBy(css = ".modal-body")
    private val info: WebElement? = null
    @FindBy(css = "#purse-pay")
    private val pursePay: RadioButton? = null
    @FindBy(css = "#purse-prepay")
    private val pursePrepay: RadioButton? = null

    @FindBy(css = "a.action-cart-pay-add")
    private val submitButton: Button? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    companion object Locators {
        fun waitToAppear() {
            Wait.elementPresence(By.cssSelector(".modal-content"))
        }
    }

    fun payAllFromPurse() {
        pursePay!!.click()
        submit()
    }

    fun prepayFromPurse() {
        pursePay!!.click()
        submit()
    }

    fun info() : String{
        return info!!.text
    }

    fun submit(){
        submitButton!!.click()
        Wait.elementVisibility(By.cssSelector(".modal-content"))
    }

}
