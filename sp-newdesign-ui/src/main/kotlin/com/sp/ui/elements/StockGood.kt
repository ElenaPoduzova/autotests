package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class StockGood: AbstractContainer() {
    @FindBy(css=".table-info")
    private var info: StockGoodTableParams? = null

    @FindBy(css=".row table.table-sizes")
    private var rows: List<OrderRow>? = null

    fun orderSize(size:String) {
    }

    fun getInfo() {

    }

    override fun toString(): String {
        return info!!.toString() + ", rows count = " + rows!!.size
    }

    fun orderFirstAvailable(): Pair<Int, Int> {
        for ((index, row) in rows!!.withIndex())
        {
            val place = row.add()
            if (place != null) {
                return Pair(index, place)
            }
        }
        throw Exception("ERROR: No available orders")
    }

    fun isOrdered(position: Pair<Int, Int>): Boolean {
        return rows!![position.first].isOrdered(position.second)
    }
}
