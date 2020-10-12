package com.sp4.testdata

import com.uitestcore.data.DataClass

class StockGoodData : DataClass<StockGoodData> () {
    lateinit var title: String
    lateinit var description: String
    lateinit var id: String
    lateinit var price: String
    lateinit var category: String
    lateinit var categoryName: String
    lateinit var status: GoodStatus
    lateinit var image: String
    lateinit var color: Array<String>
    lateinit var size: Array<String>
}
