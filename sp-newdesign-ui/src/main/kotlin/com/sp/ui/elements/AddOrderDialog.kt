package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.CheckBox
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class AddOrderDialog : AbstractContainer() {
    @FindBy(id = "placeroworderDialog")
    private val main: WebElement? = null

    @FindBy(id = "stockrowcolor")
    private val color: TextField? = null

    @FindBy(id = "stockrowtext")
    private val comment: TextField? = null

    @FindBy(id = "isAgreeOferta")
    private val offertaChekbox: CheckBox? = null

    @FindBy(id = "isAnonim")
    private val anonimChekbox: CheckBox? = null

    @FindBy(id = "submitstockordersubmit")
    private val submit: Button? = null

    init {
        Wait.elementVisibility(By.id("placeroworderDialog"))
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun addParams(colorText: String, commentText: String, isAnonim: Boolean) {
        color!!.clearAndType(colorText)
        comment!!.clearAndType(commentText)
        anonimChekbox!!.select(isAnonim)
    }

    fun approve() {
        if (offertaChekbox!!.isExists) {
            offertaChekbox.select(true)
        }
        submit!!.click()
        Wait.elementAbsence(main!!)
    }

}
