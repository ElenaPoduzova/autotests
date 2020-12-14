package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Link
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SpAlerts : AbstractContainer() {
    @FindBy(css = ".sp-alert__body")
    private val alert: WebElement? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    companion object {
        fun waitForNoAccessAlert() {
            Wait.elementPresence(By.xpath("//div[@class='sp-alert__content' and contains(text(),  'У вас нет прав для данного действия')]"))
        }

        fun isNoAccessAlertDisplayed() : Boolean {
            return (Driver.get().findElements(By.xpath("//div[@class='sp-alert__content' and contains(text(),  'У вас нет прав для данного действия')]")).size > 0)
        }

        fun waitForOrderAdded() {
            Wait.elementPresence(By.xpath("//div[@class='sp-alert__content' and contains(text(),  'Товар заказан')]"))
        }
    }
}
