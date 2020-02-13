package com.sp.frontend.pages

import com.sp.frontend.elements.MonetaPayForm
import com.uitestcore.driverutils.Driver
import com.uitestcore.pageobjects.BasePage
import com.sp.frontend.elements.WalletBalanceForm
import com.sp.frontend.testdata.CardsList.CORRECTCARD
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class WalletPage : BasePage() {
    @FindBy(css="aside span")
    val balance: WebElement? = null

    @FindBy(css="aside > div > span:nth-child(3) > span")
    val number: WebElement? = null

    @FindBy(css="article")
    val balanceForm: WalletBalanceForm? = null

    fun open() {
        Driver.openPage("/purse")
    }

    fun getBalance(): Float {
        val pattern = "(\\d*\\.\\d\\d)".toRegex()
        val found = pattern.find(balance!!.text)
        return  found!!.value.toFloat()
    }

    fun getNumber(): Int {
        return  number!!.text.toInt()
    }

    fun addMoney(amount: Int) {
        balanceForm!!.enterCountAndAccept(amount)
        val cardForm = MonetaPayForm()
        cardForm.enterCardDataAndAccept(CORRECTCARD!!)
    }
}