package com.tests.core.impl

import com.tests.core.elementobjects.Text
import com.tests.core.impl.AbstractElement
import org.openqa.selenium.WebElement

internal class TextImpl protected constructor(wrappedElement: WebElement?) :
    AbstractElement(wrappedElement!!), Text {
    override fun type(text: String) {
        wrappedElement.sendKeys(text)
    }
}