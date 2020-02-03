package com.sp.frontend.testdata

import com.tests.core.data.DataClass

class UserInfo : DataClass<UserInfo> () {
    lateinit var login: String
    lateinit var city: String
    lateinit var email: String
    lateinit var phone: String
}
