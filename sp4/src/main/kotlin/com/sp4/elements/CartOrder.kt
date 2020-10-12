package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Text
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CartOrder : AbstractContainer() {
    @FindBy(css=".sp-cart__order-title")
    private val orderTitle: WebElement? = null
    @FindBy(css=".sp-cart__order-price")
    private val price: WebElement? = null
    @FindBy(css=".sp-cart__order-params")
    private val params: WebElement? = null
    @FindBy(css=".sp-cart__order-status")
    private val status: WebElement? = null
    @FindBy(css=".sp-cart__order-action-link.stretched-link.action-order-edit")
    private val edit: Button? = null
    @FindBy(css=".sp-cart__order-actions div")
    private val delete: Button? = null
    @FindBy(css=".sp-cart__order-image")
    private val image: WebElement? = null

    fun getTitle() : String {
        return orderTitle!!.text
    }

    fun getPrice() : Int {
        return price!!.text.toInt()
    }

    fun getParams() : String {
        return params!!.text
    }

    fun getStatus() : String {
        return status!!.text
    }

    fun deleteOrder() {
        delete!!.click()
        Wait.elementPresence(By.cssSelector(".modal.fade_.show"))
        InfoDialog().submit()
        Wait.elementAbsence(this.wrappedElement as WebElement)
    }
}
