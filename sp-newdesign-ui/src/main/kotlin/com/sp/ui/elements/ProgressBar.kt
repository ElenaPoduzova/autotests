package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Text
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ProgressBar : AbstractContainer() {
    private var main: WebElement? = null
    private var img: WebElement? = null
    private var text: WebElement? = null
    private var value: Int = 0

    override fun init(wrappedElement: WebElement) {
        super.init(wrappedElement)
        main = this.findElement(By.cssSelector(".rate"))
        img = this.findElement(By.cssSelector("i"))
        text = this.findElement(By.cssSelector("span"))
        val pattern = "(\\d+)".toRegex()
        val found = pattern.find(main!!.getAttribute("title").toString())
        value = found!!.value.toInt()
    }

    fun getValue(): Int {
        return value
    }
}
