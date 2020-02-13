package com.sp.frontend.elements

import com.uitestcore.containers.AbstractContainer
import com.sp.frontend.testdata.StockStatus
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class CartStock() : AbstractContainer() {
    var org: User = User(this.findElement(By.cssSelector(".cart-params-list .cart-item-org-login-block")))
    var title: WebElement = this.findElement(By.cssSelector(".cart-item-header a span.cart-item-title-value"))
    var statusBtn: WebElement = this.findElement(By.cssSelector(".status-link.status-link-popover"))
    var prepay: WebElement = this.findElement(By.cssSelector(".cart-params-list div:nth-child(2)"))
    var discount: WebElement = this.findElement(By.cssSelector(".cart-params-list div:nth-child(3)"))
    var description: WebElement = this.findElement(By.cssSelector(".cart-item-header .row"))
    var statusList: WebElement = this.findElement(By.cssSelector(".sp-status-list"))
    var deleteAllOrdersBtn: WebElement? = null
    var ordersCount: WebElement? = this.findElement(By.cssSelector(".cart-item-data-count"))
    var payBtn: WebElement? = null
    var status: StockStatus? = null
    var price: WebElement? = this.findElement(By.cssSelector(".cart-item-pay-amount-total-large"))
    var payed: WebElement? = this.findElement(By.cssSelector(".cart-item-pay-amount-payed"))
    var calcBtn: WebElement? = this.findElement(By.cssSelector(".cart-item-total-calc"))


    init {
        status = convertStatus(statusBtn.text)
        if (status!!.isLess(StockStatus.STOP))
        {
            deleteAllOrdersBtn = this.findElement(By.cssSelector(".cart-item-delete-order-link"))
        }
    }

    fun getOrders() {
        var orders: List<WebElement> = this.findElements(By.cssSelector(".cart-item-content-data .cart-item-data"))
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
