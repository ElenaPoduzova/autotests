package com.sp4.elements

import com.sp4.pages.StockGoodsListPage
import com.uitestcore.containers.AbstractContainer
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
    @FindBy(css=".sub-links a:nth-child(1)")
    private val goodsBtn: Button? = null
    @FindBy(css=".sub-links a:nth-child(2)")
    private val ordersBtn: Button? = null
    @FindBy(css=".sub-links a:nth-child(3)")
    private val paymentsBtn: Button? = null
    @FindBy(css=".sub-links a:nth-child(4)")
    private val mailingBtn: Button? = null

    companion object {
        private const val titleSelector = "//table/tbody/tr[1]/td[1]/a[text()='%s']/ancestor::tr"

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

    fun clickGoods() : StockGoodsListPage {
        goodsBtn!!.click()
        return StockGoodsListPage()
    }

    fun clickOrders() {
        ordersBtn!!.click()
    }

    fun clickPayments() {
        paymentsBtn!!.click()
    }

    fun clickMailing() {
        mailingBtn!!.click()
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
        if (pattern1.containsMatchIn(href)) {
            var result = pattern1.find(href)?.groups?.get(1)?.value
            return result.toString()
        }
        else
            throw Exception("Wrong url format")
    }

    fun createdOn() : String {
        return creationDate!!.text()
    }

}
