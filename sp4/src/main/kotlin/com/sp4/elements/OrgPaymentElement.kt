package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Link
import com.uitestcore.elementobjects.Text
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class OrgPaymentElement : AbstractContainer() {
    @FindBy(css = "td:nth-child(1)")
    private val id: Text? = null
    @FindBy(css = ".role-user")
    private val user: Link? = null
    @FindBy(css = "td:nth-child(3)")
    private val type: Text? = null
    @FindBy(css = "td:nth-child(4)")
    private val amount: Text? = null
    @FindBy(css = "td:nth-child(5)")
    private val transaction: Text? = null
    @FindBy(css = "td:nth-child(6)")
    private val payer: Text? = null
    @FindBy(css = "td:nth-child(7)")
    private val status: Text? = null
    @FindBy(css = "td:nth-child(8)")
    private val date: Text? = null

    fun getPayer(): String {
        return payer!!.text()
    }

    fun amount(): Float {
        return amount!!.text().toFloat()
    }

    fun status(): String {
        return status!!.text()
    }

    fun type(): String {
        return type!!.text()
    }

}
