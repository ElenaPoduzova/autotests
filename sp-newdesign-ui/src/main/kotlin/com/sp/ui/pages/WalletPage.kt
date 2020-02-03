package com.sp.ui.pages

import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.Wait
import com.tests.core.elementobjects.Button
import com.tests.core.pageobjects.BasePage
import com.sp.ui.elements.MonetaPayForm
import com.sp.ui.elements.WalletBalanceForm
import com.sp.ui.testdata.CardsList.CORRECTCARD
import com.sp.ui.elements.BankPayForm
import com.sp.ui.elements.PaymentCompletedMsg
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class WalletPage : BasePage() {
    @FindBy(id="purse-amount-decimal")
    val balance: WebElement? = null

    @FindBy(css=".accid")
    val number: WebElement? = null

    @FindBy(css=".prsin a")
     val walletFormBtn: Button? = null

    @FindBy(id="pawwidget")
     val monetaIFrame: WebElement? = null

    fun open() {
        Driver.openPage("/purse")
    }

    fun getBalance(): Float {
        val pattern = "(\\d*\\.\\d\\d)".toRegex()
        val found = pattern.find(balance!!.text)
        return found!!.value.toFloat()
    }

    fun getNumber(): Int {
        val pattern = "[\\w| |:](\\d*)".toRegex()
        val found = pattern.find(number!!.text)
        return found!!.value.toInt()
    }

    fun addMoney(amount: Int) {
        walletFormBtn!!.click()
        Wait.elementPresence(By.cssSelector("form"))
        val balanceForm = WalletBalanceForm()
        balanceForm.enterCountAndAccept(amount)
        val monetaPayForm = MonetaPayForm(monetaIFrame!!)
        monetaPayForm.enterCardDataAndAccept(CORRECTCARD!!)
        val bankPayForm = BankPayForm()
        bankPayForm.enterPasswordAndAccept(CORRECTCARD!!)
    }
}