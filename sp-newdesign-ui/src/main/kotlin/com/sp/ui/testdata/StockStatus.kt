package com.sp.ui.testdata

import java.lang.reflect.Type

enum class StockStatus(val text: String) {
    OPEN("Открыта (идёт сбор заказов)"),
    STOP("Стоп (сбор заказов завершён)"),
    CHECKED("Проверено наличие"),
    DELIVERY("Доставка от поставщика"),
    SORTING("Идёт сортировка"),
    ORDERED("Заказана доставка в пункт выдачи"),
    OFFICE("В офисе хранения"),
    SEND("Отправлено в пункт выдачи"),
    READY("Готово к получению в пункте выдачи"),
    USER("Получено пользователем"),
    ARCHIVE("В архиве");

    fun isLess(status: StockStatus): Boolean {
        if (this.ordinal < status.ordinal)
        {
            return true
        }
        return false
    }
}