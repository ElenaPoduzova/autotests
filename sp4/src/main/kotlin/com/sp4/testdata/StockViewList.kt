package com.sp4.testdata

object StockViewList {
    var AUTOCREATED: StockViewData? = StockViewData()
        .setValues{ r: StockViewData ->
            r.stockId = "250-avtomaticheski-sozdannaya-zakupka-2020-10-30"
            r.stockTitle = "Автоматически созданная закупка 2020-10-30"
            r.orgPercent = "5"
            r.discount = "0"
            r.prepay = "0"
        }
}
