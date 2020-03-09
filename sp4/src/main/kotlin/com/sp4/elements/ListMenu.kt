package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ListMenu: AbstractContainer() {
    @FindBy(css="li.sp-side-menu__item")
    private var itemsList: List<WebElement>? = null

    fun clickItem(num: Int) {
        itemsList!![num].click()
    }

    fun isActive(num: Int): Boolean {
        return itemsList!![num].getCssValue("class").equals("sp-side-menu__item sp-side-menu__item--active")
    }

    fun itemText(num: Int): String {
        return itemsList!![num].text
    }

    fun clickMenuItem(num: Int) {
        itemsList!![num].click()
    }

    fun itemCount(): Int {
        return  itemsList!!.size
    }
}
