package com.sp.frontend.elements

import com.tests.core.containers.AbstractContainer
import com.tests.core.elementobjects.TextField
import org.openqa.selenium.support.FindBy

class UserDataForm : AbstractContainer() {
    @FindBy(name="login")
    private val loginField: TextField? = null

    @FindBy(name="city")
    private val cityField: TextField? = null

    @FindBy(name="email")
    private val emailField: TextField? = null

    @FindBy(name="phone")
    private val phoneField: TextField? = null

    fun fillForm(){

    }
}
