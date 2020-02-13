package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.sp.ui.testdata.StockStatus
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
    var ordersCount: WebElement? = null
    var payBtn: WebElement? = null
    var status: StockStatus? = null
    var price: WebElement? = null
    var payed: WebElement? = null
    var calcBtn: WebElement? = null


    init {
        ordersCount = this.findElement(By.cssSelector(".cart-item-data-count"))
        price = this.findElement(By.cssSelector(".cart-item-pay-amount-total-large"))
        payed = this.findElement(By.cssSelector(".cart-item-pay-amount-payed"))
        calcBtn = this.findElement(By.cssSelector(".cart-item-total-calc"))

        status = convertStatus(statusBtn.text)
        if (status!!.isLess(StockStatus.STOP))
        {
            deleteAllOrdersBtn = this.findElement(By.cssSelector(".cart-item-delete-order-link"))
        }
    }

    fun getOrders() {
        val orders = this.findElements(By.cssSelector(".cart-item-content-data .cart-item-data"))
    }

    fun pay(){
        payBtn!!.click()

    }

    fun payByCard()
    {

    }

    private fun convertStatus(s: String): StockStatus{
        enumValues<StockStatus>().forEach {
            if (it.text == s)
            {
                return it
            }
        }
        return StockStatus.OPEN
    }
}
