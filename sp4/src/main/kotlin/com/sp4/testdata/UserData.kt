package com.sp4.testdata

import com.uitestcore.data.DataClass

class UserData : DataClass<UserData> () {
    lateinit var login: String
    lateinit var password: String
    lateinit var name: String
    lateinit var role: UserRoles
}
