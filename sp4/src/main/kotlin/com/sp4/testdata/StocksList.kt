package com.sp4.testdata

import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.random.Random

object StocksList {
    var FullStock: StockData? = StockData()
        .setValues{ r: StockData ->
            r.title = "Автоматическая закупка " + LocalDate.now() + " " + LocalDateTime.now().hour + " " + LocalDateTime.now().minute
            r.supplierId = "35"
            r.offertaId = "1"
            r.annotation = "Краткое описание закупки."
            r.description = "Подробное описание закупки с картинками, ссылками и т.д."
            r.userInfo = "Инфо для пользователей - отображается в корзине."
            r.category = "Для женщин"
            r.categoryName = "8"
            r.cityName = "Все города"
            r.minAmount = "10000"
            r.orgPercent = "5"
            r.currencyRate = "1"
            r.discount = "0"
            r.prepay = "0"
            r.sizes = "40, 42, 44, 46, 48, 50"
            r.stopDate = LocalDate.now().plusDays(2).toString() + " 00:00:00"
            r.payDate = LocalDate.now().plusDays(5).toString() + " 00:00:00"
            r.shipment = "100"
            r.shipmentFrom = LocalDate.now().plusDays(10).toString() + " 00:00:00"
            r.shipmentTo = LocalDate.now().plusDays(20).toString() + " 00:00:00"
            r.shipmentType = StockDeliveryType.AMOUNT
            r.accessLevel = "1"
            r.status = StockStatus.READY
            r.canOrderToOffice = true
            r.canOrderCustom = true
            r.isOrderRow = false
            r.isColorGuaranty = true
            r.image = ( if (System.getProperty("os.name").toString() == "Windows") {"\\coverImage.jpg"} else {"/coverImage.jpg"} ).toString()
            r.sliza = ( if (System.getProperty("os.name").toString() == "Windows") {"\\test.xls"} else {"/test.xls"} ).toString()
        }

    var coverImageNumber = Random.nextInt(1, 4)

    var StockWithPrepayAndDiscount: StockData? = StockData()
        .setValues{ r: StockData ->
            r.title = "Автоматическая закупка " + LocalDate.now() + " " + LocalDateTime.now().hour + " " + LocalDateTime.now().minute
            //r.title = "Автоматическая закупка " + LocalDate.now() + " " + 21 + " " + 37
            r.supplierId = "35"
            r.offertaId = "1"
            r.annotation = "Краткое описание закупки."
            r.description = "Подробное описание закупки с картинками, ссылками и т.д."
            r.userInfo = "Инфо для пользователей - отображается в корзине. Закупка с 10% предоплатой и 10% скидкой"
            r.category = "Для женщин"
            r.categoryName = "8"
            r.cityName = "Все города"
            r.minAmount = "10000"
            r.orgPercent = "5"
            r.currencyRate = "1"
            r.discount = "10"
            r.prepay = "10"
            r.sizes = "40, 42, 44, 46, 48, 50"
            r.stopDate = LocalDate.now().plusDays(2).toString() + " 00:00:00"
            r.payDate = LocalDate.now().plusDays(5).toString() + " 00:00:00"
            r.shipment = "100"
            r.shipmentFrom = LocalDate.now().plusDays(10).toString() + " 00:00:00"
            r.shipmentTo = LocalDate.now().plusDays(20).toString() + " 00:00:00"
            r.shipmentType = StockDeliveryType.AMOUNT
            r.accessLevel = "1"
            r.status = StockStatus.READY
            r.canOrderToOffice = true
            r.canOrderCustom = true
            r.isOrderRow = false
            r.isColorGuaranty = true
            r.image = ( if (System.getProperty("os.name").toString() == "Windows") {"\\coverImage${coverImageNumber}.jpg"} else {"/coverImage${coverImageNumber}.jpg"} ).toString()
            r.sliza = ( if (System.getProperty("os.name").toString() == "Windows") {"\\test.xls"} else {"/test.xls"} ).toString()
        }
}
