package com.sp4.pages

import com.sp4.elements.OrgOrderElement
import com.sp4.elements.StockOrgEntry
import com.sp4.testdata.StockGoodData
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Select
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy


class StockOrgOrdersPage : BasePage() {
    @FindBy(css=".order-item")
    private val orders: List<OrgOrderElement>? = null

    fun getOrders(title: String): List<OrgOrderElement> {
        return orders!!
    }

    fun getOrdersByUser(user: String): List<OrgOrderElement> {
        return Driver.findDecoratedElements(OrgOrderElement::class, By.xpath("//a[contains(text(), '$user')]/ancestor::tr[contains(@class, 'order-item')]"))
    }

}