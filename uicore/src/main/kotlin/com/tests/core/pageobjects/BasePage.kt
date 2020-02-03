package com.tests.core.pageobjects

import com.tests.core.driverutils.Driver
import com.tests.core.driverutils.ExtendedFieldDecorator
import org.openqa.selenium.support.PageFactory

open class BasePage {
    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }
}