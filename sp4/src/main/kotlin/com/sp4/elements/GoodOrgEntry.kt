package com.sp4.elements

import com.sp4.pages.StockGoodsListPage
import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Common
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.*
import org.openqa.selenium.support.FindBy

class GoodOrgEntry : AbstractContainer() {
    @FindBy(css="td a")
    private val stockTitle: Link? = null
    @FindBy(css="//td[3]")
    private val addedInStocksCnt: Text? = null
    @FindBy(css="td span.badge")
    private val status: Text? = null
    @FindBy(css="td.small")
    private val creationDate: Text? = null
    @FindBy(css=".text-nowrap .fa.fa-plus-square")
    private val addToStockBtn: Button? = null
    @FindBy(css=".text-nowrap .fa.fa-pencil-square")
    private val editBtn: Button? = null
    @FindBy(css=".text-nowrap .fa.fa-trash.action-item-confirm-delete")
    private val deleteBtn: Button? = null

    companion object {
        private const val titleSelector = "//td[contains(text(), '%s')]/ancestor::tr"

        fun getGoodSelectorByTitle(title: String): String {
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

    fun clickAdd()  {
        addToStockBtn!!.click()
    }

    fun title(): String {
        return stockTitle!!.text()
    }

    fun status() : String {
        return status!!.text()
    }

    fun id(): String {
        val href = stockTitle!!.href()
        val pattern1 = ".*stock\\/(\\d*)-.*".toRegex()
        if (pattern1.containsMatchIn(href))
            return pattern1.find(href)!!.value
        else
            throw Exception("Wrong url format")
    }

    fun createdOn() : String {
        return creationDate!!.text()
    }

}
