package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Text
import org.openqa.selenium.support.FindBy

class BoxAssemblyOrderStatus : AbstractContainer() {
    @FindBy(css="td:nth-child(1)")
    private var boxNumber: Text? = null
    @FindBy(css="td:nth-child(2)")
    private var fromOffice: Text? = null
    @FindBy(css="td:nth-child(3)")
    private var whereOffice: Text? = null
    @FindBy(css="td:nth-child(4)")
    private var toOffice: Text? = null
    @FindBy(css="td:nth-child(5)")
    private var user: Text? = null
    @FindBy(css="td:nth-child(5) span")
    private var notPaid: Text? = null
    @FindBy(css="td:nth-child(6)")
    private var count: Text? = null
    @FindBy(css="td:nth-child(7)")
    private var status: Text? = null
    @FindBy(css="td:nth-child(8)")
    private var assemblyBtn: Button? = null

    fun boxNumber(): String {
        return boxNumber!!.text()
    }

    fun fromOffice(): String {
        return fromOffice!!.text()
    }

    fun whereOffice(): String {
        return whereOffice!!.text()
    }

    fun toOffice(): String {
        return toOffice!!.text()
    }

    fun user(): String {
        return user!!.text()
    }

    fun notPaid(): String {
        return notPaid!!.text()
    }

    fun count(): String {
        return count!!.text()
    }

    fun status(): String {
        return status!!.text()
    }

    fun clickAssembly() {
        assemblyBtn!!.click()
    }

}
