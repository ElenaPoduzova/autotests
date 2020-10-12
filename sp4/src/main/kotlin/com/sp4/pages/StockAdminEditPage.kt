package com.sp4.pages

import com.sp4.elements.TextEditorFrame
import com.sp4.testdata.StockStatus
import com.uitestcore.driverutils.Driver
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.CheckBox
import com.uitestcore.elementobjects.Select
import com.uitestcore.elementobjects.TextField
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class StockAdminEditPage : BasePage() {
    @FindBy(id="StockAdminForm_title")
    private val stockTitle: TextField? = null
    @FindBy(id="StockAdminForm_supplierId")
    private val supplierId: Select? = null
    @FindBy(id="StockAdminForm_ofertaId")
    private val offertaId: Select? = null
    @FindBy(id="StockAdminForm_description")
    private val annotation: TextField? = null
    @FindBy(id="StockAdminForm_info")
    private val userInfo: TextField? = null
    @FindBy(id="StockAdminForm_minAmount")
    private val minAmount: TextField? = null
    @FindBy(id="StockAdminForm_minAmount_label")
    private val minAmountLabel: WebElement? = null
    @FindBy(css="#StockAdminForm_catIds + div .selectize-input")
    private val category: Button? = null
    @FindBy(css="#StockOrgForm_cityRegionIds + div .selectize-input")
    private val cities: Button? = null
    @FindBy(id="StockAdminForm_orgPercent")
    private val orgPercent: TextField? = null
    @FindBy(id="StockAdminForm_currencyRate")
    private val currencyRate: TextField? = null
    @FindBy(id="StockAdminForm_discount")
    private val discount: TextField? = null
    @FindBy(id="StockAdminForm_prePayPercent")
    private val prapay: TextField? = null
    @FindBy(id="StockAdminForm_shipmentType")
    private val shipment: TextField? = null
    @FindBy(id="StockAdminForm_shipmentAmount")
    private val shipmentAmount: TextField? = null
    @FindBy(id="StockAdminForm_countOrderLimit")
    private val counrOrderLimit: TextField? = null
    @FindBy(id="StockAdminForm_dateStopExpect")
    private val stopDate: TextField? = null
    @FindBy(id="StockAdminForm_datePayExpire")
    private val payDate: TextField? = null
    @FindBy(id="StockAdminForm_shipmentText")
    private val shipmentPrice: TextField? = null
    @FindBy(id="StockAdminForm_tariff")
    private val stockTarif: Select? = null
    @FindBy(id="StockAdminForm_dateShipmentFrom")
    private val shipmentFrom: TextField? = null
    @FindBy(id="StockAdminForm_dateShipmentTo")
    private val shipmentTo: TextField? = null
    @FindBy(id="StockAdminForm_level")
    private val accessLevel: Select? = null
    @FindBy(id="StockAdminForm_status")
    private val status: Select? = null
    @FindBy(id="StockAdminForm_dateOpen")
    private val openDate: TextField? = null
    @FindBy(id="StockAdminForm_flags-isShipmentOrder")
    private val canOrderToOffice: CheckBox? = null
    @FindBy(id="StockAdminForm_flags-isCustomOrder")
    private val canOrderCustom: CheckBox? = null
    @FindBy(id="StockAdminForm_flags-isOrderRow")
    private val isOrderRow: CheckBox? = null
    @FindBy(id="StockAdminForm_flags-isColorGuaranty")
    private val isColorGuaranty: CheckBox? = null
    @FindBy(css="button.btn.btn-primary")
    private val confirmBtn: Button? = null
    @FindBy(css="a.btn.btn-outline-secondary")
    private val declineBtn: Button? = null

    @FindBy(css="#StockAdminForm_text_label ~ div")
    private val description: TextEditorFrame? = null
    @FindBy(css="#StockAdminForm_sizeText_label ~ div")
    private val sizes: TextEditorFrame? = null

    companion object {
        fun open(id: Int) {
            Driver.openPage("/stock/admin/edit?id=${id}")
        }
    }

    fun setStatus(statusValue: StockStatus) {
        status!!.selectByValue(statusValue.toString().toLowerCase())
    }

    fun confirm() {
        confirmBtn!!.scrollTo()
        confirmBtn.click()
    }

}