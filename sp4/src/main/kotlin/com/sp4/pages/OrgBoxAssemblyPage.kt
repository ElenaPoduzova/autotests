package com.sp4.pages

import com.sp4.elements.BoxAssemblyOrder
import com.sp4.elements.BoxAssemblyOrderStatus
import com.sp4.elements.BoxOptionsPanel
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.Wait
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy

class OrgBoxAssemblyPage : BasePage() {
    @FindBy(xpath= "//tbody/tr[position() mod 2 = 1]")
    private var ordersStatuses: List<BoxAssemblyOrderStatus>? = null
    @FindBy(xpath= "//tbody/tr[position() mod 2 = 0]")
    private var ordersGoods: List<BoxAssemblyOrder>? = null

    companion object {
        fun openAssemblyOffice(id: Int) {
            Driver.openPage("/parcel/org/assembly?office=${id}")
        }
    }

    fun checkOrdersPresent(): Int {
        return ordersStatuses!!.size
    }

    fun getOrders(): List<Pair<BoxAssemblyOrderStatus, BoxAssemblyOrder>> {
        var list = mutableListOf<Pair<BoxAssemblyOrderStatus, BoxAssemblyOrder>>()
        for (i in ordersStatuses!!.indices) {
            list.add(Pair(ordersStatuses!![i], ordersGoods!![i]))
        }
        return list
    }

    fun assemblyBox(index: Int, weight: Float, size: Triple<Float, Float, Float>) {
        ordersStatuses!![index].clickAssembly()
        Wait.elementPresence(By.cssSelector(".my-4.p-3"))
        var boxOptionsPanel = Driver.findDecoratedElement(BoxOptionsPanel::class, By.cssSelector(".my-4.p-3"))
        boxOptionsPanel.setAndSaveParameters(weight, size)
    }

}