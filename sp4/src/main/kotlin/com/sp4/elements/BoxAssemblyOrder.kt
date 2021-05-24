package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.*
import org.openqa.selenium.support.FindBy

class BoxAssemblyOrder : AbstractContainer() {
    @FindBy(css="div[id*='order-item']")
    private val goods: List<BoxAssemblyOrderGoods>? = null
    @FindBy(css="div.row div.col")
    private val stockHeader: Text? = null

    fun getGoodsList(): List<BoxAssemblyOrderGoods> {
        return goods!!
    }

    fun getHeader(): String {
        return stockHeader!!.text()
    }
}
