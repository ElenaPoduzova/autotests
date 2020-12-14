package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Text
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.sql.Driver

class CategoryGroup(element: WebElement) : AbstractContainer() {
    val self = element

    @FindBy(css = ".optgroup-header")
    private val header: Text? = null

    fun selectCategory(categoryName: String) {
        self.findElement(By.cssSelector("div[class='option'][data-value='$categoryName']"))
    }
}
