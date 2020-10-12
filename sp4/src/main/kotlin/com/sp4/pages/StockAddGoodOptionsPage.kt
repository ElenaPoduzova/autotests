package com.sp4.pages

import com.sp4.testdata.StockGoodData
import com.uitestcore.driverutils.Driver
import com.uitestcore.elementobjects.Button
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy


class StockAddGoodOptionsPage : BasePage() {
    @FindBy(css=".sp-body.sp-body-good-variant.sp-body-good-variant-generate")
    private val title: WebElement? = null
    @FindBy(css="label#GenerateVariantForm_feature-1_label + div span")
    private val sizeAddBtn: Button? = null
    @FindBy(css="label#GenerateVariantForm_feature-2_label + div span")
    private val colorAddBtn: Button? = null
    @FindBy(css="label#GenerateVariantForm_feature-3_label + div span")
    private val weightAddBtn: Button? = null
    @FindBy(css="label#GenerateVariantForm_feature-3_label + div span")
    private val volumeAddBtn: Button? = null
    @FindBy(css="button.btn.btn-primary")
    private val confirmBtn: Button? = null
    @FindBy(css="a.btn.btn-outline-secondary")
    private val cancelBtn: Button? = null

    fun addOptions(data: StockGoodData) {
        data.size.forEach {
            sizeAddBtn!!.click()
        }
        //get all added input fields
        var sizeInputs = Driver.findElements(By.cssSelector("label#GenerateVariantForm_feature-1_label + div input"))
        for (i in data.size.indices) {
            sizeInputs[i].sendKeys(data.size[i])
        }
        data.color.forEach {
            colorAddBtn!!.click()
        }
        var colorInputs = Driver.findElements(By.cssSelector("label#GenerateVariantForm_feature-2_label + div input"))
        for (i in data.color.indices) {
            colorInputs[i].sendKeys(data.color[i])
        }
        confirmBtn!!.click()
    }

}