package com.tests.core.containers

import org.openqa.selenium.WebElement
import com.tests.core.elementobjects.Element

interface Container : Element {
    fun init(wrappedElement: WebElement)
}
