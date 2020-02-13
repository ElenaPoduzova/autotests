package com.sp.frontend.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class WalletBalanceForm : AbstractContainer() {
    @FindBy(name="amount")
    private val countField: TextField? = null

    @FindBy(css=".sp-form__submit button[type='submit']")
    private val btnAccept: WebElement? = null

    @FindBy(css=".form-div input")
    private val cardRadioBtn: WebElement? = null

    @FindBy(css="form > div.sp-form__submit > button.sp-button")
    private val btnDecline: WebElement? = null

    @FindBy(css="article > div > p")
    private val description1: WebElement? = null

    @FindBy(css="article > div > p:nth-child(3)")
    private val description2: WebElement? = null

    @FindBy(css="article > div > div")
    private val description3: WebElement? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun enterCountAndAccept(count: Int){
        countField!!.clearAndType(count.toString())
        btnAccept!!.click()
    }

    fun acceptIsEnabled(): Boolean {
        return btnAccept!!.isEnabled
    }
}
