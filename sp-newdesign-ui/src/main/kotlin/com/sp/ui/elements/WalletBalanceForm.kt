package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class WalletBalanceForm : AbstractContainer() {
    @FindBy(name="amount")
    private val countField: TextField? = null

    @FindBy(css="form > div.sp-form__submit > button.sp-button")
    private val btnAccept: WebElement? = null

    @FindBy(css="form > div.sp-form__submit > button.sp-button")
    private val btnDecline: WebElement? = null

    @FindBy(css="article > div > p")
    private val description1: WebElement? = null

    @FindBy(css="article > div > p:nth-child(3)")
    private val description2: WebElement? = null

    @FindBy(css="article > div > div")
    private val description3: WebElement? = null

    fun enterCountAndAccept(count: Int){
        countField!!.clearAndType(count.toString())
        btnAccept!!.click()
        Wait.elementPresence(By.cssSelector("section.b-pay"))
    }

    fun acceptIsEnabled(): Boolean {
        return btnAccept!!.isEnabled
    }
}
