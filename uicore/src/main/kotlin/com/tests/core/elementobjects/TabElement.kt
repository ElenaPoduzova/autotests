package com.tests.core.elementobjects

interface TabElement : Element {
    fun click()

    fun isActive(): Boolean

    fun getText(): String
}
