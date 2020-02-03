package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.ExtendedFieldDecorator
import com.tests.core.driverutils.Wait
import com.tests.core.elementobjects.TextField
import com.sp.ui.testdata.CardData
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class BankPayForm() : AbstractContainer() {
    @FindBy(id="psw_id")
    private val password: TextField? = null

    @FindBy(css="#pa_amount b")
    private val totalCountText: WebElement? = null

    @FindBy(id="btnSubmit")
    private val payBtn: WebElement? = null

    init {
        Wait.elementPresence(By.name("frm"))
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun enterPasswordAndAccept(card: CardData){
        password!!.clearAndType(card.password)
        payBtn!!.click()
    }

    fun checkTotalAmount(amount: Int): Boolean {
        return totalCountText!!.text.equals(String.format("RUB ", amount))
    }
}
