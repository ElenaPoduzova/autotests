package com.sp.ui.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.support.FindBy

class UserPasswordForm : AbstractContainer() {
    @FindBy(name="oldpassword")
    private val oldpasswordField: TextField? = null

    @FindBy(name="newpassword")
    private val newpasswordField: TextField? = null

    @FindBy(name="newpasswordrepeat")
    private val newpasswordrepeatField: TextField? = null
}
