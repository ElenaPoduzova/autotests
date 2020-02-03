package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.ExtendedFieldDecorator
import com.tests.core.driverutils.Wait
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions

class PaymentCompletedMsg : AbstractContainer() {
    @FindBy(css=".moon")
    val mainElement: WebElement? = null

    @FindBy(css="center p")
    val textElement: WebElement? = null

    init {
        Wait.titleIs("Сайт Покупок - Afterpay Stockpay")
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun getText(): String {
        return textElement!!.text
    }
}