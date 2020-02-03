package com.tests.core.impl

import com.tests.core.elementobjects.Button
import com.tests.core.elementobjects.CheckBox
import com.tests.core.elementobjects.RadioButton
import org.openqa.selenium.WebElement

internal class CheckBoxImpl protected constructor(wrappedElement: WebElement?) :
    AbstractElement(wrappedElement!!), CheckBox {
    override fun click() {
        wrappedElement.click()
    }

    override fun isSelected(): Boolean {
        return wrappedElement.isSelected
    }

    override fun select(state: Boolean) {
        if (wrappedElement.isSelected != state)
            wrappedElement.click()
    }
}