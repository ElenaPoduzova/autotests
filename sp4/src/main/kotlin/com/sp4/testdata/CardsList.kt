package com.sp4.testdata

import com.sp4.testdata.CardData

public object CardsList {
    public var CORRECTCARD: CardData? = CardData()
        .setValues{ r: CardData ->
        r.number = "4000000000000002"
        r.cvv = "987"
        r.expireMonth = "12"
        r.expireYear = "2030"
        r.password = "123456"
    }
}
