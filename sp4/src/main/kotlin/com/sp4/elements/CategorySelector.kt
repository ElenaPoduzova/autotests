package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.Button
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.sql.Driver

class CategorySelector(element: WebElement) : AbstractContainer() {

    init {
        wrappedElement = element
    }

    fun selectCategory(categoryType: String, categoryName: String) {
        val categoryGroup = wrappedElement!!.findElement<WebElement>(By.cssSelector("[class='optgroup'][data-group='$categoryType'] div[data-value='$categoryName']"))
        categoryGroup.click()
    }
}
