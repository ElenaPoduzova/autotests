package com.sp.ui.testdata

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
