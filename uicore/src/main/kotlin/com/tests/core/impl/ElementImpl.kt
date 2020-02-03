package com.tests.core.impl

import com.tests.core.elementobjects.Element
import org.openqa.selenium.WebElement


class ElementImpl // ....
    (protected var webElement: WebElement, override val isDisplayed: Boolean, override val isExists: Boolean) : Element