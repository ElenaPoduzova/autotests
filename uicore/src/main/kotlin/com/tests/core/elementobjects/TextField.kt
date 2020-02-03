package com.tests.core.elementobjects

interface TextField : Element {
    fun type(text: String)

    fun clear()

    fun clearAndType(text: String)
}
