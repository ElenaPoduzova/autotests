package com.sp4.testdata

import com.uitestcore.data.DataClass

class StockViewData : DataClass<StockViewData> () {
    lateinit var stockId: String
    lateinit var stockTitle: String
    lateinit var orgPercent: String
    lateinit var discount: String
    lateinit var prepay: String
}
