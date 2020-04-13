package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Common
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.*
import org.openqa.selenium.support.FindBy

class StockOrgEntry : AbstractContainer() {
    @FindBy(css="td a")
    private val stockTitle: Link? = null
    @FindBy(css="td .sub-links a")
    private val subLinks: List<Link>? = null
    @FindBy(css=".badge.badge-secondary")
    private val status: Text? = null
    @FindBy(css=".small")
    private val creationDate: Text? = null
    @FindBy(css=".text-nowrap .fa.fa-pencil-square")
    private val editBtn: Button? = null
    @FindBy(css=".text-nowrap .fa.fa-minus-square")
    private val deleteBtn: Button? = null

    companion object {
        final val titleSelector = "//table/tbody/tr[1]/td[1]/a[text()='%s']/ancestor::tr"

        fun getStockSelectorByTitle(title: String): String {
            return String.format(titleSelector, title)
        }
    }

    fun clickEdit() {
        editBtn!!.click()
    }

    fun delete() {
        deleteBtn!!.click()
        Wait.elementPresence(InfoDialog.body())
        val infoDlg = InfoDialog()
        if (infoDlg.info() == "Вы подтверждаете удаление?") {
            infoDlg.submit()
        }
    }

    fun title(): String {
        return stockTitle!!.text()
    }

    fun status() {
        return status!!.text()
    }

    fun createdOn() {
        return creationDate!!.text()
    }

}
