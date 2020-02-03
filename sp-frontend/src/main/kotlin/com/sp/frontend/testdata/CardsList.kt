package com.sp.frontend.testdata

import com.sp.frontend.testdata.CardData

public object CardsList {
    public var CORRECTCARD: CardData? = CardData()
        .setValues{ r: CardData ->
        r.number = "4000000000000002"
        r.cvv = "987"
        r.expireMonth = "12"
        r.expireYear = "30"
        r.password = "123456"
    }
}
