package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Link
import com.uitestcore.elementobjects.Text
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CartStock : AbstractContainer() {
    @FindBy(css="a.sp-cart__org-link.sp-link.sp-link--dotted")
    private val org: Link? = null
    @FindBy(css="a.sp-cart__title-link sp-link")
    private val title: WebElement? = null
    @FindBy(css=".sp-stock-status__value")
    private val statusBtn: WebElement? = null
    @FindBy(css=".sp-cart__footer div div")
    private val goodsCount : Text? = null
    @FindBy(css=".cart-params-list div:nth-child(2)")
    private val prepay: Text? = null
    @FindBy(css=".sp-cart__footer .sp-cart__org-percent-value.sp-cart__footer-item")
    private val orgPay: Text? = null
    @FindBy(css=".cart-params-list div:nth-child(3)")
    private val discount: Text? = null
    @FindBy(css=".sp-cart__footer .sp-cart__delivery-key.sp-cart__footer-item")
    private val deliveryOffice: Text? = null
    @FindBy(css=".sp-cart__delivery-address.sp-cart__footer-item")
    private val deliveryOfficeFull: Text? = null
    @FindBy(css=".sp-cart__footer .sp-cart__delivery-alias.sp-cart__footer-item")
    private val receiveCode: Text? = null
    @FindBy(css=".sp-cart__footer .sp-cart__total-amount-value.sp-cart__pay-info-value.sp-cart__footer-item")
    private val finalAmount: Text? = null
    @FindBy(css=".sp-cart__pay-amount-value.sp-cart__pay-info-value.sp-cart__footer-item")
    private val paidAmount: Text? = null
    @FindBy(css=".sp-cart__needpay-amount-value.sp-cart__pay-info-value.sp-cart__footer-item")
    private val toPay: Text? = null
    @FindBy(css=".sp-cart__action-btn.sp-cart__footer-item")
    private val payBtn: Button? = null
    @FindBy(css=".sp-cart__pay-history.sp-cart__footer-item a")
    private val historyLink: Link? = null
    @FindBy(css=".sp-cart__org-message-text")
    private val description: Text? = null
    @FindBy(css="div[class*='sp-cart__order sp-cart__order--']")
    private val ordersList: List<CartOrder>? = null
    @FindBy(css=".sp-cart__toggle")
    private val toggleBtn: Button? = null
    @FindBy(css=".sp-cart__stop-time.sp-cart__footer-item")
    private val payBefore: Text? = null
    @FindBy(css="a.action-cart-office-select")
    private val changeDelivery: Button? = null

    fun reload() {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun getOrders() : List<CartOrder> {
        return this.ordersList!!
    }

    fun pay(){
        payBtn!!.click()
        PayDialog.waitToAppear()
        PayDialog().payAllFromPurse()
    }

    fun prePay(){
        payBtn!!.click()
        PayDialog.waitToAppear()
        PayDialog().prepayFromPurse()
    }

    fun selectPickupOffice(office: String) {
        changeDelivery!!.click()
        SelectDeliveryOfficeDialog.waitToAppear()
        SelectDeliveryOfficeDialog().selectPickup(office)
    }

    fun payByCard()
    {
    }

    fun getGoodsCount() : Int {
        val pattern1 = "(\\d*)\\w+".toRegex()
        if (pattern1.containsMatchIn(goodsCount!!.text())) {
            var result = pattern1.find(goodsCount.text())?.groups?.get(0)?.value
            return result!!.toInt()
        }
        else
            throw Exception("Wrong format")
    }

    fun getOrgPay() : Float {
        return orgPay!!.text().toFloat()
    }

    fun getAllPay() : Float {
        return finalAmount!!.text().toFloat()
    }

    fun getPaid() : Float {
        return paidAmount!!.text().toFloat()
    }

    fun getNeedToPay() : Float {
        return toPay!!.text().toFloat()
    }

    fun getStatus(): String {
        return statusBtn!!.text
    }

    fun getOffice(): Pair<String, String> {
        return Pair(deliveryOffice!!.text(), deliveryOfficeFull!!.text())
    }
}
