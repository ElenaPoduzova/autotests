package com.sp4.testdata

enum class GoodStatus(val text: String) {
    ACTIVE("open"),
    INACTIVE("close");

    fun isLess(status: GoodStatus): Boolean {
        if (this.ordinal < status.ordinal)
        {
            return true
        }
        return false
    }
}