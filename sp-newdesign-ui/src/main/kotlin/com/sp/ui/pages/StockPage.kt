package com.sp.ui.pages

import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.pageobjects.BasePage
import com.sp.ui.elements.MonetaPayForm
import com.sp.ui.elements.WalletBalanceForm
import com.sp.ui.testdata.CardsList.CORRECTCARD
import com.sp.ui.elements.*
import com.sp.ui.elements.AddOrderDialog
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class StockPage: BasePage() {
    @FindBy(css=".item-plain .block p a")
    private val title: WebElement? = null

    @FindBy(css=".price-div")
    private val params: TableParams? = null

    @FindBy(css=".balloon-block a")
    private val status: WebElement? = null

    @FindBy(css=".balloon-block div")
    private val ordersCount: WebElement? = null

    @FindBy(css=".cart_info")
    private val cartInfo: StockCartInfo? = null

    @FindBy(css=".add-order div a")
    private val addOrderBtn: Button? = null

    @FindBy(css=".abuse-block a")
    private val abuseBtn: Button? = null

    @FindBy(css=".item-plain .block .image")
    private val fillRate: ProgressBar? = null

    @FindBy(xpath="//*[@class='stockrow-list']/div/div")
    private val goods: List<StockGood>? = null

    init {
        Wait.locationIs(".*\\/stock\\?id=\\d")
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun open() {
        Driver.openPage("/stock?id=1")
    }

    fun getTitle(): String {
        return title!!.text
    }

    fun getStockParams(): Map<String, String> {
        return params!!.getValues()
    }

    fun getFillRate(): Int {
        return fillRate!!.getValue()
    }

    fun makeOrder(goodNum: Int) {
        val result = goods!![goodNum].orderFirstAvailable()
        val addOrderDialog = AddOrderDialog()
        addOrderDialog.approve()
        goods[goodNum].isOrdered(result)
    }

}