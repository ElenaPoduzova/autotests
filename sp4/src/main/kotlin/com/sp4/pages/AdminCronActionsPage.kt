package com.sp4.pages

import com.sp4.elements.SpAlerts
import com.sp4.elements.TextEditorFrame
import com.sp4.testdata.StockStatus
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.CheckBox
import com.uitestcore.elementobjects.Select
import com.uitestcore.elementobjects.TextField
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class AdminCronActionsPage : BasePage() {
    private val elementPath = "//td/a[contains(text(), '%s')]"

    companion object {
        fun open() {
            Driver.openPage("/cron/admin")
        }
    }

    fun clickRunCreateBoxes(name: String, stockId: Int) {
        Driver.getElementByXpath(String.format(elementPath, name)).click()
        SpAlerts.waitForText("Создание посылок по корзинам закупок")
        SpAlerts.waitForText(stockId.toString())
    }

}