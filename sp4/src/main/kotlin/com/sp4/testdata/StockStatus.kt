package com.sp4.testdata

enum class StockStatus(val text: String) {
    OPEN("Oткрыта (идёт набор заказов)"),
    STOP("стоп (сбор заказов завершён)"),
    CHECK("проверено наличие"),
    SEND("доставка от поставщика"),
    RECEIVE("идёт сортировка"),
    ORDERED("Заказана доставка в пункт выдачи"),
    OFFICE("В офисе хранения"),
    SENDTOOFFICE("Отправлено в пункт выдачи"),
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