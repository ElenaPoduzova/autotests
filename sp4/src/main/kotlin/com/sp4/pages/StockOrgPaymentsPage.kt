package com.sp4.pages

import com.sp4.elements.OrgPaymentElement
import com.uitestcore.driverutils.Driver
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy


class StockOrgPaymentsPage : BasePage() {
    @FindBy(css="tbody tr")
    private val payments: List<OrgPaymentElement>? = null

    fun getOrders(title: String): List<OrgPaymentElement> {
        return payments!!
    }

    fun getOrdersByUser(user: String): List<OrgPaymentElement> {
        return Driver.findDecoratedElements(OrgPaymentElement::class, By.xpath("//a[contains(text(), '$user')]/ancestor::tr"))
    }

}