package com.tests.core.elementobjects

interface CheckBox : Element {
    fun click()

    fun isSelected(): Boolean

    fun select(state: Boolean)
}
