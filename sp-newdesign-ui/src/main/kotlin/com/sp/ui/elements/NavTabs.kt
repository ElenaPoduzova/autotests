package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.elementobjects.TabElement
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class NavTabs : AbstractContainer() {
    private lateinit var navList: List<WebElement>

    override fun init(wrappedElement: WebElement) {
        super.wrappedElement = wrappedElement
        navList = this.findElements(By.cssSelector(".nav-item"))
    }

    fun clickTab(name: String){
        for(element in navList!!){
            if (element.text == name) {
                element.click()
                break
            }
        }
    }

    fun activeTab(): WebElement? {
        for(element in navList!!){
            if (element.getCssValue("class").endsWith("active")) {
                return element
            }
        }
        return  null
    }

}
