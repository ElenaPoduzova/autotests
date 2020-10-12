package com.sp4.testdata

import com.uitestcore.driverutils.Common.imagePathByOs

object StocksGoodList {
    var FisrtGood: StockGoodData? = StockGoodData()
        .setValues{ r: StockGoodData ->
            r.title = "Кроссовки"
            r.description = "Удобные женские кроссовки"
            r.id = "АРТ 0001"
            r.price = "200"
            r.category = "Для женщин"
            r.categoryName = "8"
            r.status = GoodStatus.ACTIVE
            r.image = imagePathByOs("women_boots.jpg")
            r.size = arrayOf("35", "36", "37", "38")
            r.color = arrayOf("белый")
    }
    var SecondGood: StockGoodData? = StockGoodData()
        .setValues{ r: StockGoodData ->
            r.title = "Женский кардиган"
            r.description = "Теплый шерстяной кардиган"
            r.id = "АРТ 0002"
            r.price = "1000"
            r.category = "Для женщин"
            r.categoryName = "8"
            r.status = GoodStatus.ACTIVE
            r.image = imagePathByOs("women_cardigan.jpg")
            r.size = arrayOf("40", "42", "44")
            r.color = arrayOf("синий", "белый")
    }
    var ThirdGood: StockGoodData? = StockGoodData()
        .setValues{ r: StockGoodData ->
            r.title = "Короткий топ"
            r.description = "Женский модный топ"
            r.id = "АРТ 0003"
            r.price = "150"
            r.category = "Для женщин"
            r.categoryName = "8"
            r.status = GoodStatus.ACTIVE
            r.image = imagePathByOs("women_top.jpg")
            r.size = arrayOf("40", "42", "44")
            r.color = arrayOf("красный", "черный")
    }
    var FourthGood: StockGoodData? = StockGoodData()
        .setValues{ r: StockGoodData ->
            r.title = "Рубашка женская белая"
            r.description = "Белая жеская рубашка для офиса"
            r.id = "АРТ 0004"
            r.price = "100"
            r.category = "Для женщин"
            r.categoryName = "8"
            r.status = GoodStatus.ACTIVE
            r.image = imagePathByOs("women_shirt.jpg")
            r.size = arrayOf("40", "42", "44")
            r.color = arrayOf("синий", "черный", "белый")
    }
}
