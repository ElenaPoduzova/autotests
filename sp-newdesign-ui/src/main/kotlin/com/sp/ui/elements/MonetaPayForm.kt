package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.elementobjects.TextField
import com.sp.ui.testdata.CardData
import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.ExtendedFieldDecorator
import com.tests.core.driverutils.Wait
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class MonetaPayForm(formFrame: WebElement) : AbstractContainer() {
    @FindBy(css="dl.field-cardNumber")
    private val frontNumber: TextField? = null

    @FindBy(css="dl.field-cardCVV2")
    private val cvvNumber: TextField? = null

    @FindBy(id="dcardExpirationMonth")
    private val expireMonth: TextField? = null

    @FindBy(id="cardExpirationYear")
    private val expireYear: TextField? = null

    @FindBy(css="form .form_row.form_row_total")
    private val totalCountText: WebElement? = null

    @FindBy(id="payCardButton")
    private val payBtn: WebElement? = null

    init {
        Driver.get().switchTo().frame(formFrame);
        Wait.elementPresence(By.cssSelector("section.b-pay"))
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun enterCardDataAndAccept(card: CardData){
        frontNumber!!.clearAndType(card.number)
        cvvNumber!!.clearAndType(card.cvv)
        expireMonth!!.clearAndType(card.expireMonth)
        expireYear!!.clearAndType(card.expireYear)
        payBtn!!.click()
    }

    fun checkTotalAmmount(amount: Int): Boolean {
        return totalCountText!!.text.equals(String.format("Сумма к оплате: %d", amount))
    }
}
