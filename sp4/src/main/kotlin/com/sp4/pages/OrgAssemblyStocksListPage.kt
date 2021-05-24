package com.sp4.pages

import com.sp4.elements.BoxAssemblyOrder
import com.sp4.elements.BoxAssemblyOrderStatus
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy

class OrgAssemblyStocksListPage : BasePage() {

    companion object {
        fun clickElement(name: String) {
            Driver.getElementByXpath("//a[text() = '${name}']").click()
        }
    }

}