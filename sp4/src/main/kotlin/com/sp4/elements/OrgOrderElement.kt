package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Link
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class OrgOrderElement : AbstractContainer() {
    @FindBy(css = ".fa-plus-square-o.action-order-update")
    private val btnConfirmOrder: Button? = null
    @FindBy(css = ".fa-minus-square-o.action-order-update")
    private val btnDeclineOrder: Button? = null
    @FindBy(css = ".role-user")
    private val user: Link? = null
    @FindBy(css = "td:nth-child(3)")
    private val goodName: WebElement? = null
    @FindBy(css = "td:nth-child(4)")
    private val goodPrice: WebElement? = null
    @FindBy(css = "td:nth-child(5)")
    private val goodCount: WebElement? = null
    @FindBy(css = "td:nth-child(6)")
    private val goodShipping: WebElement? = null
    @FindBy(css = "td:nth-child(7)")
    private val goodAddBill: WebElement? = null
    @FindBy(css = "td:nth-child(8)")
    private val goodOrgPrice: WebElement? = null
    @FindBy(css = "td:nth-child(9)")
    private val goodPaid: WebElement? = null
    @FindBy(css = "td:nth-child(10)")
    private val goodPaidStatus: WebElement? = null
    @FindBy(css = "td:nth-child(11)")
    private val goodStatus: WebElement? = null
    @FindBy(css = "td:nth-child(12)")
    private val goodAddDate: WebElement? = null
    @FindBy(css = "td:nth-child(13)")
    private val goodCreateAddBillBtn: WebElement? = null

    fun confirmOrder() {
        btnConfirmOrder!!.scrollTo()
        btnConfirmOrder.click()
    }

    fun declineOrder() {
        btnDeclineOrder!!.click()
    }

    fun goodName(): String {
        return goodName!!.text
    }

    fun goodPrice(): Float {
        return goodPrice!!.text.toFloat()
    }

    fun goodCount(): Int {
        return goodCount!!.text.toInt()
    }

    fun orgPrice(): Float {
        return goodOrgPrice!!.text.toFloat()
    }

    fun paid(): Float {
        return goodPaid!!.text.toFloat()
    }

    fun paidStatus(): String {
        return goodPaidStatus!!.text
    }

    fun goodStatus(): String {
        return goodStatus!!.text
    }

    fun creationDate(): String {
        return goodAddDate!!.text
    }

}
