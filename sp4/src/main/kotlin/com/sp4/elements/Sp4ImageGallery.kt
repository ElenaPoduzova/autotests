package com.sp4.elements

import com.uitestcore.containers.AbstractContainer
import com.uitestcore.driverutils.Driver
import com.uitestcore.driverutils.ExtendedFieldDecorator
import com.uitestcore.elementobjects.Text
import com.uitestcore.elementobjects.TextField
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class Sp4ImageGallery : AbstractContainer() {
    @FindBy(css = "h5.sp-card__title.card-title")
    private val title: Text? = null
    @FindBy(css = ".sp-card__item-number")
    private val itemNumber: Text? = null
    @FindBy(css = ".sp-card__content span")
    private val info: WebElement? = null
    @FindBy(css = ".sp-card__image-wrapper")
    private val image: WebElement? = null
}
