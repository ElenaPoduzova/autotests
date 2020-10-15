package com.sp4.testdata

import com.uitestcore.data.DataClass

class OrderData : DataClass<OrderData> () {
    lateinit var stockId: String
    lateinit var stockTitle: String
    lateinit var dataId: String
    lateinit var goodName: String
    lateinit var size: HashMap<String, String>
    lateinit var sizeRow: String
    lateinit var orgPercent: String
    lateinit var discount: String
}
