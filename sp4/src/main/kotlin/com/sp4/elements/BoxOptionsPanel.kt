package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy
import java.sql.Driver

class BoxOptionsPanel : AbstractContainer() {
    @FindBy(id= "ParcelDimensionForm_weight")
    private var weight: TextField? = null
    @FindBy(id= "ParcelDimensionForm_length")
    private var length: TextField? = null
    @FindBy(id= "ParcelDimensionForm_width")
    private var width: TextField? = null
    @FindBy(id= "ParcelDimensionForm_height")
    private var height: TextField? = null
    @FindBy(css= "button")
    private var saveBtn: Button? = null

    fun getBoxId(): String {
        val string = this.wrappedElement!!.text
        val pattern1 = "Посылка: ([A-W|a-w|0-9]+)".toRegex()
        if (pattern1.containsMatchIn(string)) {
            var result = pattern1.find(string)?.groups?.get(0)?.value
            return result!!
        }
        else
            throw Exception("Wrong format")
    }

    fun getOffice(): String {
        val string = this.wrappedElement!!.text
        val pattern1 = "Пункт назначения: (\\d+)".toRegex()
        if (pattern1.containsMatchIn(string)) {
            var result = pattern1.find(string)?.groups?.get(0)?.value
            return result!!
        }
        else
            throw Exception("Wrong format")
    }

    fun setAndSaveParameters(weightVal: Float, size: Triple<Float, Float, Float>) {
        weight!!.clearAndType(weightVal.toString())
        length!!.clearAndType(size.first.toString())
        width!!.clearAndType(size.second.toString())
        height!!.clearAndType(size.third.toString())
        saveBtn!!.click()
        Wait.elementPresence(By.xpath("//div[@class='alert alert-success' and contains(text(),  'Данные посылки успешно сохранены')]"))
        Wait.elementPresence(By.xpath("//span[@class='color-green' and text() ='Принята в офис']"))
    }

}