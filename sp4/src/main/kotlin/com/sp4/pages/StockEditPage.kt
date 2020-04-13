package com.sp4.pages

import com.sp4.elements.CategorySelector
import com.sp4.elements.InfoDialog
import com.sp4.elements.TextEditorFrame
import com.sp4.testdata.StockData
import com.uitestcore.driverutils.Common
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.CheckBox
import com.uitestcore.elementobjects.Select
import com.uitestcore.elementobjects.TextField
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.nio.file.Path
import java.nio.file.Paths


class StockEditPage : BasePage() {
    @FindBy(id="StockOrgForm_title")
    private val stockTitle: TextField? = null
    @FindBy(id="StockOrgForm_supplierId")
    private val supplierId: Select? = null
    @FindBy(id="StockOrgForm_ofertaId")
    private val offertaId: Select? = null
    @FindBy(id="StockOrgForm_description")
    private val annotation: TextField? = null
    @FindBy(id="StockOrgForm_info")
    private val userInfo: TextField? = null
    @FindBy(id="StockOrgForm_minAmount")
    private val minAmount: TextField? = null
    @FindBy(css=".selectize-input")
    private val category: Button? = null
    @FindBy(id="StockOrgForm_orgPercent")
    private val orgPercent: TextField? = null
    @FindBy(id="StockOrgForm_currencyRate")
    private val currencyRate: TextField? = null
    @FindBy(id="StockOrgForm_discount")
    private val discount: TextField? = null
    @FindBy(id="StockOrgForm_prePayPercent")
    private val prapay: TextField? = null
    @FindBy(id="StockOrgForm_dateStopExpect")
    private val stopDate: TextField? = null
    @FindBy(id="StockOrgForm_datePayExpire")
    private val payDate: TextField? = null
    @FindBy(id="StockOrgForm_shipmentText")
    private val shipment: TextField? = null
    @FindBy(id="StockOrgForm_dateShipmentFrom")
    private val shipmentFrom: TextField? = null
    @FindBy(id="StockOrgForm_dateShipmentTo")
    private val shipmentTo: TextField? = null
    @FindBy(id="StockOrgForm_level")
    private val accessLevel: Select? = null
    @FindBy(id="StockOrgForm_status")
    private val status: Select? = null
    @FindBy(id="StockOrgForm_flags-isShipmentOrder")
    private val canOrderToOffice: CheckBox? = null
    @FindBy(id="StockOrgForm_flags-isCustomOrder")
    private val canOrderCustom: CheckBox? = null
    @FindBy(id="StockOrgForm_flags-isOrderRow")
    private val isOrderRow: CheckBox? = null
    @FindBy(id="StockOrgForm_flags-isColorGuaranty")
    private val isColorGuaranty: CheckBox? = null
    @FindBy(css=".image-item-add a")
    private val addItemLink: WebElement? = null
    @FindBy(css="button.btn.btn-primary")
    private val confirmBtn: Button? = null
    @FindBy(css="a.btn.btn-outline-secondary")
    private val declineBtn: Button? = null

    @FindBy(css="#StockOrgForm_text_label ~ div")
    private val description: TextEditorFrame? = null
    @FindBy(css="#StockOrgForm_sizeText_label ~ div")
    private val sizes: TextEditorFrame? = null

    companion object {
        fun open() {
            Driver.openPage("stock/org/add")
        }
    }

    private fun createNewStock(data: StockData) {
        stockTitle!!.clearAndType(data.title)
        supplierId!!.selectByValue(data.supplierId)
        offertaId!!.selectByValue(data.offertaId)
        annotation!!.clearAndType(data.annotation)
        description!!.enterText(data.description)
        userInfo!!.clearAndType(data.userInfo)
        fillCategory(data.category, data.categoryName)
        minAmount!!.clearAndType(data.minAmount)
        orgPercent!!.clearAndType(data.orgPercent)
        currencyRate!!.clearAndType(data.currencyRate)
        discount!!.clearAndType(data.discount)
        prapay!!.clearAndType(data.prepay)
        sizes!!.enterText(data.sizes)
        stopDate!!.clearAndType(data.stopDate)
        payDate!!.clearAndType(data.payDate)
        shipment!!.clearAndType(data.shipment)
        shipmentFrom!!.clearAndType(data.shipmentFrom)
        shipmentTo!!.clearAndType(data.shipmentTo)
        accessLevel!!.selectByValue(data.accessLevel)
        canOrderToOffice!!.select(data.canOrderToOffice)
        canOrderCustom!!.select(data.canOrderCustom)
        isOrderRow!!.select(data.isOrderRow)
        isColorGuaranty!!.select(data.isColorGuaranty)
        if (addItemLink!!.isEnabled) {
            uploadFile(data.image)
        }
    }

    private fun uploadFile(filePath: String) {
        val resourceDirectory: Path = Paths.get("src", "test", "resources")
        val absolutePath: String = resourceDirectory.toFile().absolutePath

        var jsExecutor = Driver.get() as JavascriptExecutor
        jsExecutor.executeScript("document.getElementById(\"form-image\").className = \"\"")
        jsExecutor.executeScript("document.getElementById(\"form-image\").setAttribute(\"data-type\", \"logo\")")
        jsExecutor.executeScript("document.getElementById(\"form-image\").setAttribute(\"action\", \"https://dev.sp4.sitepokupok.ru/stock/image/add?type=logo\")")
        val imageInput = Driver.findElement(By.cssSelector("#image-add"))
        imageInput.sendKeys(absolutePath + filePath)
    }

    private fun fillCategory(categoryType: String, categoryName: String) {
        category!!.click()
        val selector = CategorySelector(Driver.findElement(By.cssSelector(".selectize-dropdown-content")))
        selector.selectCategory(categoryType, categoryName)
    }

    fun fillStockDataAndConfirm(data: StockData) {
        createNewStock(data)
        confirmBtn!!.scrollTo()
        if (Common.isElementBecomeVisible(InfoDialog.body())) {
            val infoDlg = InfoDialog()
            if (infoDlg.info() == "Загружено максимальное число изображений этого типа") {
                infoDlg.submit()
            }
        }
        confirmBtn.click()
    }

}