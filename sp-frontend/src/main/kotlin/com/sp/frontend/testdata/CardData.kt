package com.sp.frontend.testdata

import com.tests.core.data.DataClass

class CardData : DataClass<CardData> () {
    lateinit var number: String
    lateinit var cvv: String
    lateinit var expireMonth: String
    lateinit var expireYear: String
    lateinit var password: String
}
