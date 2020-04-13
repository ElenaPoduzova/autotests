package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.TextField
import com.sp4.testdata.CardData
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Select
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class MonetaPayForm : AbstractContainer() {
    @FindBy(id="additionalParameters_cardNumber")
    private val frontNumber: TextField? = null

    @FindBy(id="additionalParameters_cardCVV2")
    private val cvvNumber: TextField? = null

    @FindBy(id="cardExpirationMonth")
    private val expireMonth: Select? = null

    @FindBy(id="cardExpirationYear")
    private val expireYear: Select? = null

    @FindBy(css="form .form_row.form_row_total")
    private val totalCountText: WebElement? = null

    @FindBy(name="_do_next")
    private val payBtn: Button? = null

    init {
        Wait.elementPresence(By.cssSelector(".purse-frame"))
        Driver.get().switchTo().frame(Driver.getElementByCss(".purse-frame"))
        Wait.elementPresence(By.cssSelector(".tab-ps"))
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun enterCardDataAndAccept(card: CardData){
        frontNumber!!.clearAndType(card.number)
        cvvNumber!!.clearAndType(card.cvv)
        expireMonth!!.selectByValue(card.expireMonth)
        expireYear!!.selectByValue(card.expireYear)
        Driver.scrollToElement(Driver.getElementByName("_do_next"))
        payBtn!!.click()
    }

    fun checkTotalAmount(amount: Int): Boolean {
        return totalCountText!!.text.equals(String.format("Сумма к оплате: %d", amount))
    }
}
