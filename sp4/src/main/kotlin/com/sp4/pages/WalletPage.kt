package com.sp4.pages

import com.sp4.elements.MonetaPayForm
import com.uitestcore.driverutils.Driver
import com.uitestcore.pageobjects.BasePage
import com.sp4.elements.WalletBalanceForm
import com.sp4.testdata.CardsList.CORRECTCARD
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Text
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class WalletPage : BasePage() {
    @FindBy(css=".card-body strong")
    val balance: WebElement? = null

    @FindBy(css=".card-body strong:nth-child(3)")
    val number: WebElement? = null

    @FindBy(id="PurseRechargeForm_amount")
    val balanceField: TextField? = null

    @FindBy(id="PurseOutForm_amount")
    val withdrawField: TextField? = null

    @FindBy(css="#PurseRechargeForm button")
    val submit: Button? = null

    fun open() {
        Driver.openPage("/purse")
    }

    fun getBalance(): Float {
        return  balance!!.text.toFloat()
    }

    fun getNumber(): Int {
        return  number!!.text.toInt()
    }

    fun addMoney(amount: Int) {
        balanceField!!.clearAndType(amount.toString())
        submit!!.click()
        val cardForm = MonetaPayForm()
        cardForm.enterCardDataAndAccept(CORRECTCARD!!)
    }
}