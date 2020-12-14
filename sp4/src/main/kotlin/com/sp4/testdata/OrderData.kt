package com.sp4.testdata

import com.uitestcore.data.DataClass

class OrderData : DataClass<OrderData> () {
    lateinit var goodName: String
    lateinit var size: HashMap<String, String>
    lateinit var sizeRow: String
    lateinit var price: String
}