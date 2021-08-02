package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Text
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class StockGood : AbstractContainer() {
    @FindBy(css = "h5.sp-card__title.card-title")
    private val title: WebElement? = null
    @FindBy(css = ".sp-card__item-number")
    private val itemNumber: Text? = null
    @FindBy(css = ".sp-card__content span")
    private val info: WebElement? = null
    @FindBy(css = ".sp-card__image-wrapper")
    private val image: Sp4ImageGallery? = null
    @FindBy(css = ".sp-card__footer-price-block.sp-price__price-block.price-block")
    private val price: Text? = null
    @FindBy(css = ".sp-card__footer-clear-price-block.sp-price__clear-price-block.clear-price-block")
    private val priceWithoutDiscount: Text? = null
    @FindBy(css = ".sp-card__footer-rows.sp-show-rows-wrapper a span")
    private val showRowsBtn: WebElement? = null
    @FindBy(css = ".sp-good__variants.sp-card__footer-variants")
    private val orderParams: WebElement? = null
    @FindBy(css = "button.action-good-buy")
    private val buyBtn: Button? = null

    fun addOrderRow(size: String) {
        showRowsBtn!!.click()
        var goodRow = Sp4GoodRow(this.findElement(By.cssSelector(".sp-card__footer-good-row-list")))
        goodRow.addOrder(size)
    }

    fun expandRow() {
        showRowsBtn!!.click()
        Wait.elementVisibility(this.findElement(By.cssSelector(".sp-card__footer-good-row-list")))
    }

    fun addOrder(params: HashMap<String, String>) {
        params.forEach {
            var goodId = orderParams!!.findElement(By.cssSelector(".sp-good__variants-block.variants-block")).getAttribute("data-good-id")
            Driver.findElement(By.xpath("//div[@data-good-id='${goodId}']//*[@class='sp-good__feature-title sp-card__footer-title' and (contains(text(), '${it.key}'))]/following-sibling::button[contains(text(),'${it.value}')]")).click()
            Wait.elementVisibility(Driver.findElement(By.xpath("//div[@data-good-id='${goodId}']//*[@class='sp-good__feature-title sp-card__footer-title' and (contains(text(), '${it.key}'))]/following-sibling::button[contains(text(), '${it.value}') and contains(@class, 'selected-feature')]")))
        }
        buyBtn!!.click()
        SpAlerts.waitForOrderAdded()
    }

    fun checkOrderAdded(size: String, userName: String) : Boolean {
        showRowsBtn!!.click()
        Wait.elementPresence(By.cssSelector(".sp-card__footer-good-row-list"))
        var goodRow = Sp4GoodRow(this.findElement(By.cssSelector(".sp-card__footer-good-row-list")))
        return goodRow.checkOrderAdded(size, userName)
    }

    fun getTitle(): String {
        return title!!.text
    }

    fun getPrice(): Float {
        return price!!.text().toFloat()
    }

    fun getPriceWithoutDiscount(): Float {
        return priceWithoutDiscount!!.toString().toFloat()
    }
}
