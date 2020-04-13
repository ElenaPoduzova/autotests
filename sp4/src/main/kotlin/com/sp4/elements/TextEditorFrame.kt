package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.driverutils.Wait
import com.uitestcore.elementobjects.TextField
import com.sp4.testdata.CardData
import com.uitestcore.elementobjects.Button
import com.uitestcore.elementobjects.Select
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class TextEditorFrame : AbstractContainer() {
    @FindBy(css="iframe")
    private val frameElement: WebElement? = null
    @FindBy(css="body")
    private val textArea: TextField? = null

    @FindBy(css="[data-sceditor-command='bold']")
    private val boldBtn: Button? = null
    @FindBy(css="[data-sceditor-command='strike']")
    private val strikeBtn: Button? = null
    @FindBy(css="[data-sceditor-command='underline']")
    private val underlineBtn: Button? = null
    @FindBy(css="[data-sceditor-command='italic']")
    private val italicBtn: Button? = null
    @FindBy(css="[data-sceditor-command='color']")
    private val colorBtn: Button? = null
    @FindBy(css="[data-sceditor-command='link']")
    private val linkBtn: Button? = null
    @FindBy(css="[data-sceditor-command='unlink']")
    private val unlinkBtn: Button? = null
    @FindBy(css="[data-sceditor-command='quote']")
    private val quoteBtn: Button? = null
    @FindBy(css="[data-sceditor-command='image']")
    private val imageBtn: Button? = null
    @FindBy(css="[data-sceditor-command='emoticon']")
    private val emoteBtn: Button? = null
    @FindBy(css="[data-sceditor-command='removeformat']")
    private val clearFormatBtn: Button? = null
    @FindBy(css="[data-sceditor-command='maximize']")
    private val maximizeBtn: Button? = null
    @FindBy(css="[data-sceditor-command='source']")
    private val sourceBtn: Button? = null
    @FindBy(css="[data-sceditor-command='file']")
    private val fileBtn: Button? = null

    fun enterText(text: String) {
        Driver.get().switchTo().frame(frameElement)
        val field = Driver.findElement(By.cssSelector("body"))
        field.sendKeys(text)
        Driver.get().switchTo().defaultContent()
    }
}
