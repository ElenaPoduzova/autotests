package com.sp4.testdata

import com.sp4.testdata.UserData
import com.sp4.testdata.UserRoles

public object UsersList {
    public var USER: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "dante23101@yandex.ru"
        r.password = "123456"
        r.name = "dante"
        r.role = UserRoles.USER
    }
    public var ADMIN: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "dante23101@yandex.ru"
        r.password = "123456"
        r.name = "dante"
        r.role = UserRoles.ADMIN
    }
}
