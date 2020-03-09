package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.support.FindBy

class SearchForm : AbstractContainer() {
    @FindBy(id = "text")
    private val searchField: TextField? = null

    @FindBy(css = "input[type=\"submit\"]")
    private val searchButton: Button? = null

    fun search(query: String) {
        searchField!!.clearAndType(query)
        searchButton!!.click()
    }
}
