package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.ExtendedFieldDecorator
import com.tests.core.driverutils.Wait
import com.tests.core.elementobjects.Button
import com.tests.core.elementobjects.RadioButton
import com.tests.core.elementobjects.TextField
import com.sp.ui.elements.MonetaPayForm
import com.sp.ui.testdata.CardData
import com.sp.ui.testdata.CardsList
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class OrderPayForm : AbstractContainer() {
    private val rootElementPath = ".modal modal-cart-pay"

    @FindBy(css="input[data-type='pay-purse']")
    private val payPurse: RadioButton? = null

    @FindBy(css="input[data-type='pay-card-recurrent']")
    private val payRecurrent: RadioButton? = null

    @FindBy(css="input[data-type='pay-card']")
    private val payCard: RadioButton? = null

    @FindBy(css="#payform-send")
    private val payBtn: Button? = null

    @FindBy(css="#payform-cancel")
    private val declineBtn: RadioButton? = null

    @FindBy(id="pawwidget")
    val monetaIFrame: WebElement? = null

    init {
        Wait.elementPresence(By.ByCssSelector(rootElementPath))
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun payPurse(){
        payPurse!!.click()
        payBtn!!.click()
    }

    fun payRecurrent(){
        payRecurrent!!.click()
        val monetaPayForm = MonetaPayForm(monetaIFrame!!)
        monetaPayForm.enterCardDataAndAccept(CardsList.CORRECTCARD!!)
        val bankPayForm = BankPayForm()
        bankPayForm.enterPasswordAndAccept(CardsList.CORRECTCARD!!)
    }
}
