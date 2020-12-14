package com.sp4.testdata

object OrderList {
    var BOOTS: OrderData? = OrderData()
        .setValues{ r: OrderData ->
            r.goodName = "Кроссовки"
            r.size = hashMapOf<String, String>("размер" to "37", "цвет" to "белый")
            r.sizeRow = "37, белый"
            r.price = "1000"
        }

    var CARDIGAN: OrderData? = OrderData()
        .setValues{ r: OrderData ->
            r.goodName = "Женский кардиган"
            r.size = hashMapOf<String, String>("размер" to "40", "цвет" to "синий")
            r.sizeRow = "40, синий"
            r.price = "500"
        }
    var TOP: OrderData? = OrderData()
        .setValues{ r: OrderData ->
            r.goodName = "Короткий топ"
            r.size = hashMapOf<String, String>("размер" to "42", "цвет" to "черный")
            r.sizeRow = "42, черный"
            r.price = "100"
        }

    var SHIRT: OrderData? = OrderData()
        .setValues{ r: OrderData ->
            r.goodName = "Рубашка женская белая"
            r.size = hashMapOf<String, String>("размер" to "40", "цвет" to "черный")
            r.sizeRow = "40, черный"
            r.price = "200"
        }
}
