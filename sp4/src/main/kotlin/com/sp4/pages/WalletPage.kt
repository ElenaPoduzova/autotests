package com.sp4.pages

import com.sp4.elements.MonetaPayForm
import com.uitestcore.driverutils.Driver
import com.uitestcore.pageobjects.BasePage
import com.sp4.testdata.CardsList.CORRECTCARD
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class WalletPage : BasePage() {
    @FindBy(css=".sp-purse__balance-amount")
    val balance: WebElement? = null

    @FindBy(css=".sp-purse__balance-ext-account-id")
    val number: WebElement? = null

    @FindBy(id="PurseRechargeForm_amount")
    val balanceField: TextField? = null

    @FindBy(id="PurseOutForm_amount")
    val withdrawField: TextField? = null

    @FindBy(css="#PurseRechargeForm button")
    val submit: Button? = null

    @FindBy(css=".sp-purse__payment-systems-items div[data-payment-system-unit-id='43674']")
    val selectVisa: Button? = null

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
        selectVisa!!.click()
        val cardForm = MonetaPayForm()
        cardForm.enterCardDataAndAccept(CORRECTCARD!!)
    }
}