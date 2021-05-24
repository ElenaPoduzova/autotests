package com.sp4.pages

import com.sp4.elements.BoxAssemblyOrder
import com.sp4.elements.BoxAssemblyOrderStatus
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy

class OrgBoxesListPage : BasePage() {

    companion object {
        fun openOffice(id: Int) {
            Driver.openPage("/parcel/org/revision?office=${id}")
        }

        fun getBox(id: String): HashMap<String, String> {
            val row = Driver.getElementByXpath("//tr[td[text() = '${id}']]")
            val map = hashMapOf<String, String>()

            map["from"] = row.findElement(By.cssSelector("td:nth-child(2)")).text
            map["to"] = row.findElement(By.cssSelector("td:nth-child(3)")).text
            map["where"] = row.findElement(By.cssSelector("td:nth-child(4)")).text
            map["user"] = row.findElement(By.cssSelector("td:nth-child(5) a")).text
            map["number"] = row.findElement(By.cssSelector("td:nth-child(6)")).text
            map["boxNumber"] = row.findElement(By.cssSelector("td:nth-child(7)")).text
            map["status"] = row.findElement(By.cssSelector("td:nth-child(8)")).text

            return map
        }
    }

}