package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SelectDeliveryOfficeDialog : AbstractContainer() {
    @FindBy(css = ".modal-header")
    private val header: WebElement? = null
    @FindBy(css = ".sp-btn-close")
    private val closeBtn: Button? = null
    @FindBy(css = ".selectize-dropdown.single.form-control")
    private val cityList: WebElement? = null
    @FindBy(css = ".selectize-input")
    private val selectCityBtn: WebElement? = null
    @FindBy(xpath = "//div[div[contains(text(), 'Самовывоз из пункта выдачи')]]")
    private val pickup: Button? = null
    @FindBy(xpath = "//div[div[contains(text(), 'Самовывоз из пункта выдачи')]]")
    private val courier: Button? = null

    private val pickupOfficeLocator: String = "//div[contains(@class, 'sp-cart-delivery-form__delivery-item') and div[contains(text(), '%s')]]/a"

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    companion object Locators {
        fun waitToAppear() {
            Wait.elementPresence(By.cssSelector(".modal-content"))
        }
    }

    fun selectPickup(pickupName: String) {
        pickup!!.click()
        Wait.elementPresence(By.xpath(String.format(pickupOfficeLocator, pickupName)))
        val script = "document.evaluate(\"${String.format(pickupOfficeLocator, pickupName)}\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();"
        Driver.executeJS(script)
        Wait.elementPresence(By.cssSelector(".action-cart-office-update"))
        Driver.findElement(By.cssSelector(".action-cart-office-update")).click()
        Wait.elementInvisibility(By.cssSelector(".action-cart-office-update"))
    }

}
