package com.tests.core.impl

import com.tests.core.elementobjects.TabElement
import org.openqa.selenium.WebElement

internal class TabElementImpl protected constructor(wrappedElement: WebElement?) :
    AbstractElement(wrappedElement!!), TabElement {
    override fun click() {
        wrappedElement.click()
    }

    override fun isActive(): Boolean {
        return wrappedElement.getCssValue("class").endsWith("active")
    }

    override fun getText(): String {
        return wrappedElement.text
    }
}