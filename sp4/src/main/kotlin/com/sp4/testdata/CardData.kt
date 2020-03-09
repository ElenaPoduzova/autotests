package com.sp4.testdata

import com.uitestcore.data.DataClass

class CardData : DataClass<CardData> () {
    lateinit var number: String
    lateinit var cvv: String
    lateinit var expireMonth: String
    lateinit var expireYear: String
    lateinit var password: String
}
