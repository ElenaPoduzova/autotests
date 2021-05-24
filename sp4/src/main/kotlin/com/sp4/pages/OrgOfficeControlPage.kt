package com.sp4.pages

import com.uitestcore.driverutils.Driver
import com.uitestcore.pageobjects.BasePage

class OrgOfficeControlPage : BasePage() {
    companion object {
        fun openAssemblyOffice(id: Int) {
            Driver.openPage("/parcel/org/assembly?office=${id}")
        }
    }

    fun clickElement(name: String) {
        Driver.getElementByXpath("//a[text() = '${name}']").click()
    }

}