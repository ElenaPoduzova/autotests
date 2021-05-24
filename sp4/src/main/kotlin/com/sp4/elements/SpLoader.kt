package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Link
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SpLoader : AbstractContainer() {
    companion object {
        fun waitAppear() {
            Wait.elementPresence(By.cssSelector("#f-loader[style='display: block;']"))
        }

        fun waitDisappear() {
            Wait.elementPresence(By.cssSelector("#f-loader[style='display: none;']"))
        }

        fun waitWorkedOut() {
            Wait.elementPresence(By.cssSelector("#f-loader[style='display: block;']"))
            Wait.elementPresence(By.cssSelector("#f-loader[style='display: none;']"))
        }
    }
}
