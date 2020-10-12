package com.sp4.testdata

import com.uitestcore.data.DataClass

class StockData : DataClass<StockData> () {
    lateinit var title: String
    lateinit var supplierId: String
    lateinit var offertaId: String
    lateinit var annotation: String
    lateinit var description: String
    lateinit var userInfo: String
    lateinit var category: String
    lateinit var categoryName: String
    lateinit var cityName: String
    lateinit var minAmount: String
    lateinit var orgPercent: String
    lateinit var currencyRate: String
    lateinit var discount: String
    lateinit var prepay: String
    lateinit var sizes: String
    lateinit var stopDate: String
    lateinit var payDate: String
    lateinit var shipment: String
    lateinit var shipmentFrom: String
    lateinit var shipmentTo: String
    lateinit var accessLevel: String
    lateinit var status: StockStatus
    var canOrderToOffice: Boolean = false
    var canOrderCustom: Boolean = false
    var isOrderRow: Boolean = false
    var isColorGuaranty: Boolean = false
    lateinit var image: String
    lateinit var sliza: String
}
