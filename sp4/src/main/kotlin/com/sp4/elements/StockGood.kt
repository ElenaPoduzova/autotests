package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
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
    @FindBy(css = ".sp-card__footer-row.row .price-block")
    private val price: Text? = null
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

    fun addOrder(params: HashMap<String, String>) {
        params.forEach {
            orderParams!!.findElement<WebElement>(By.xpath("//*[@class='sp-good__feature-title sp-card__footer-title' and (contains(text(), '${it.key}'))]/following-sibling::button[@data-feature-value = '${it.value}']")).click()
        }
        buyBtn!!.click()
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
}
