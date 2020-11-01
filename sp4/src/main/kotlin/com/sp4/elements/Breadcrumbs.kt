package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.Link
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class Breadcrumbs : AbstractContainer() {
    @FindBy(css = "nav.sp-breadcrumbs.breadcrumbs ul li")
    private val breadcrumbsLink: List<Link>? = null

    init {
        PageFactory.initElements(ExtendedFieldDecorator(Driver.get()), this)
    }

    companion object {
        fun waitForAppear() {
            Wait.elementPresence(By.cssSelector("nav.sp-breadcrumbs.breadcrumbs ul li"))
        }
    }

    fun getLinksNames() : MutableList<String> {
        var names = mutableListOf<String>()
        breadcrumbsLink!!.forEach {
            names.add(it.text())
        }
        return names
    }

    fun getLastLink() : String {
        return breadcrumbsLink!!.last().text()
    }
}
