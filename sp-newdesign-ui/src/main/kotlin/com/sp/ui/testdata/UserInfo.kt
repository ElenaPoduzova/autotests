package com.sp.ui.testdata

import com.uitestcore.data.DataClass

class UserInfo : DataClass<UserInfo> () {
    lateinit var login: String
    lateinit var city: String
    lateinit var email: String
    lateinit var phone: String
}
