package com.sp4.pages

import com.sp4.elements.Sp4Selector
import com.sp4.elements.InfoDialog
import com.sp4.elements.TextEditorFrame
import com.sp4.testdata.StockGoodData
import com.uitestcore.driverutils.Common
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Select
import com.uitestcore.elementobjects.TextField
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.nio.file.Path
import java.nio.file.Paths


class StockAddGoodPage : BasePage() {
    @FindBy(id="GoodOrgForm_title")
    private val stockTitle: TextField? = null
    @FindBy(id="GoodOrgForm_code")
    private val id: TextField? = null
    @FindBy(css="#GoodOrgForm_price")
    private val price: TextField? = null
    @FindBy(css="#GoodOrgForm_catIds_label + div .selectize-input")
    private val category: Button? = null
    @FindBy(css="#GoodOrgForm_status")
    private val status: Select? = null
    @FindBy(css=".image-item-add a")
    private val addItemLink: WebElement? = null
    @FindBy(css="#GoodOrgForm_price_label")
    private val priceLabel: WebElement? = null
    @FindBy(css="button.btn.btn-primary")
    private val confirmBtn: Button? = null

    @FindBy(css="#GoodOrgForm_text_label ~ div")
    private val description: TextEditorFrame? = null

    private final var generateBtnSelector = "//a[text() = \"Генерация вариантов\"]"
    private final var generatePageRoot = ".sp-body.sp-body-good-variant.sp-body-good-variant-generate"

    companion object {
        fun open(id: String) {
            Driver.openPage("/good/org/add?stock=$id")
        }

        fun isOpened() : Boolean {
            val urlRegex = "https:\\/\\/[\\w.]+\\/good\\/org\\/add\\?stock=\\d+".toRegex()
            if (urlRegex.matches(Driver.get().currentUrl)) {
                return true
            }
            return false;
        }
    }

    private fun addGood(data: StockGoodData) {
        stockTitle!!.clearAndType(data.title)
        description!!.enterText(data.description)
        id!!.clearAndType(data.id)
        price!!.clearAndType(data.price)
        fillCategory(data.category, data.categoryName)
        status!!.selectByValue(data.status.text)
        if (addItemLink!!.isEnabled) {
            uploadFile(data.image)
        }
    }

    private fun addOptions(data: StockGoodData) {
        Driver.findElement(By.xpath(generateBtnSelector)).click()
        Wait.elementPresence(By.cssSelector(generatePageRoot))
        StockAddGoodOptionsPage().addOptions(data)

    }

    private fun uploadFile(filePath: String) {
        val resourceDirectory: Path = Paths.get("src", "test", "resources")
        val absolutePath: String = resourceDirectory.toFile().absolutePath

        var jsExecutor = Driver.get() as JavascriptExecutor
        jsExecutor.executeScript("document.getElementById(\"form-image\").className = \"\"")
        jsExecutor.executeScript("document.getElementById(\"form-image\").setAttribute(\"data-type\", \"photo\")")
        jsExecutor.executeScript("document.getElementById(\"form-image\").setAttribute(\"action\", \"https://dev.sp4.sitepokupok.ru/good/image/add?type=photo\")")
        val imageInput = Driver.findElement(By.cssSelector("#image-add"))
        imageInput.sendKeys(absolutePath + filePath)
    }

    private fun fillCategory(categoryType: String, categoryName: String) {
        category!!.click()
        val selector = Sp4Selector(Driver.findElement(By.cssSelector(".selectize-dropdown-content")))
        selector.selectCategory(categoryType, categoryName)
        priceLabel!!.click()
    }

    fun fillGoodDataAndConfirm(data: StockGoodData) {
        addGood(data)
        confirmBtn!!.scrollTo()
        if (Common.isElementBecomeVisible(InfoDialog.body())) {
            val infoDlg = InfoDialog()
            if (infoDlg.info() == "Загружено максимальное число изображений этого типа") {
                infoDlg.submit()
            }
        }
        confirmBtn.click()
        Wait.elementPresence(By.xpath(generateBtnSelector))
        addOptions(data)
    }

}