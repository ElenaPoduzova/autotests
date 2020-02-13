package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.TabElement
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import java.lang.RuntimeException

class HeaderNavigation : AbstractContainer() {
    @FindBy(css = ".header-navbar li a")
    val navList: List<TabElement>? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun refresh() {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    fun clickTab(name: String){
        name.toLowerCase()
        for(element in navList!!){
            if (element.getText().toLowerCase() == name) {
                element.click()
                return
            }
        }
        throw RuntimeException("No tab found")
    }

    fun activeTab(): TabElement? {
        for(element in navList!!){
            if (element.isActive()) {
                return element
            }
        }
        return  null
    }
}
