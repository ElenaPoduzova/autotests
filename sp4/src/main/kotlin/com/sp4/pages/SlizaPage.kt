package com.sp4.pages

import com.uitestcore.driverutils.Driver
import com.uitestcore.elementobjects.Button
import com.uitestcore.pageobjects.BasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.nio.file.Path
import java.nio.file.Paths

class  SlizaPage : BasePage() {
    @FindBy(css= "GoodGoodSlizaUploadForm_sliza")
    private val slizaBtn: WebElement? = null

    companion object {
        fun open(id: String) {
            Driver.openPage("/stock/org/good?stock=$id")
        }
    }

    fun addSliza(filePath: String) {
        val resourceDirectory: Path = Paths.get("src", "test", "resources")
        val absolutePath: String = resourceDirectory.toFile().absolutePath
        slizaBtn!!.sendKeys(absolutePath + filePath)
    }

}