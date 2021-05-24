package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.*
import org.openqa.selenium.support.FindBy

class BoxAssemblyOrderGoods : AbstractContainer() {
    @FindBy(css=".media-body  div:nth-child(2)")
    private val goodName: Text? = null
    @FindBy(css=".media-body  div:nth-child(3)")
    private val goodSize: Text? = null
    @FindBy(css=".media-body  div:nth-child(4) a")
    private val editCodeButton: Button? = null
    @FindBy(css=".col")
    private val price: Text? = null

    fun getPrice(): String {
        return price!!.text()
    }

    fun getName(): String {
        return goodName!!.text()
    }

    fun getSize(): String {
        return goodSize!!.text()
    }

    fun clickEdit() {
        editCodeButton!!.click()
    }
}
