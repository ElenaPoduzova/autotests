package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.elementobjects.Button
import com.tests.core.elementobjects.TextField
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class UserDataTable : AbstractContainer() {
    @FindBy(name="table.userData tr")
    private val registered: WebElement? = null

    @FindBy(name="table.userData tr:nth-child(2)")
    private val lastVisit: WebElement? = null

    @FindBy(name="table.userData tr:nth-child(3)")
    private val name: WebElement? = null

    @FindBy(name="table.userData tr:nth-child(4)")
    private val city: WebElement? = null

    @FindBy(name="table.userData tr:nth-child(5)")
    private val email: WebElement? = null

    @FindBy(name="table.userData tr:nth-child(6)")
    private val phone: WebElement? = null

    @FindBy(name="table.userData tr:nth-child(7)")
    private val address: WebElement? = null

    @FindBy(name=".action-promo-show")
    private val promoBtn: Button? = null

    fun enterPromo(promoCode: String) {
        promoBtn!!.click()
    }

    fun info() {
    }
}
