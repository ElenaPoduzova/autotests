package com.sp4.testdata

object OrderList {
    var TEST: OrderData? = OrderData()
        .setValues{ r: OrderData ->
        r.stockId = "219-avtomaticheski-sozdannaya-zakupka-2020-10-09"
        r.stockTitle = "Автоматически созданная закупка 2020-10-09"
        r.dataId = "446"
        r.goodName = "Женский кардиган"
        r.size = hashMapOf<String, String>("размер" to "40", "цвет" to "синий")
        r.sizeRow = "40, синий"
        r.orgPercent = "5%"
        r.discount = "1%"
    }
}
