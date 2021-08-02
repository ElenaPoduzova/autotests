package com.sp4.testdata

import com.uitestcore.data.DataClass

class CardData : DataClass<CardData> () {
    lateinit var number: String
    lateinit var cvv: String
    lateinit var expireDate: String
    lateinit var password: String
}
