package com.sp.frontend.elements

import com.tests.core.containers.AbstractContainer
import com.sp.frontend.testdata.StockStatus
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class CartStock(element: WebElement) : AbstractContainer() {
    private var self = element
    public var org: User
    public var title: WebElement
    public var statusBtn: WebElement
    public var prepay: WebElement
    public var discount: WebElement
    public var description: WebElement
    public var statusList: WebElement
    public var deleteAllOrdersBtn: WebElement? = null
    public var ordersCount: WebElement? = null
    public var payBtn: WebElement? = null
    public var status: StockStatus? = null
    public var price: WebElement? = null
    public var payed: WebElement? = null
    public var calcBtn: WebElement? = null


    init {
        title = self.findElement(By.cssSelector(".cart-item-header a span.cart-item-title-value"))
        org = User(self.findElement(By.cssSelector(".cart-params-list .cart-item-org-login-block")))
        statusBtn = self.findElement(By.cssSelector(".status-link.status-link-popover"))
        prepay = self.findElement(By.cssSelector(".cart-params-list div:nth-child(2)"))
        discount = self.findElement(By.cssSelector(".cart-params-list div:nth-child(3)"))
        description = self.findElement(By.cssSelector(".cart-item-header .row"))
        statusList = self.findElement(By.cssSelector(".sp-status-list"))
        ordersCount = self.findElement(By.cssSelector(".cart-item-data-count"))
        price = self.findElement(By.cssSelector(".cart-item-pay-amount-total-large"))
        payed = self.findElement(By.cssSelector(".cart-item-pay-amount-payed"))
        calcBtn = self.findElement(By.cssSelector(".cart-item-total-calc"))

        status = convertStatus(statusBtn.text)
        if (status!!.isLess(StockStatus.STOP))
        {
            deleteAllOrdersBtn = self.findElement(By.cssSelector(".cart-item-delete-order-link"))
        }
    }

    fun getOrders() {
        var orders = self.findElements(By.cssSelector(".cart-item-content-data .cart-item-data"))
    }

    fun pay(){
        payBtn!!.click()

    }

    fun payByCard()
    {

    }

    private fun convertStatus(s: String): StockStatus {
        enumValues<StockStatus>().forEach {
            if (it.text == s)
            {
                return it
            }
        }
        return StockStatus.OPEN
    }
}
