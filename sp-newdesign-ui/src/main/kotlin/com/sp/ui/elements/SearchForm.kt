package com.sp.ui.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.elementobjects.Button
import com.tests.core.elementobjects.TextField
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
