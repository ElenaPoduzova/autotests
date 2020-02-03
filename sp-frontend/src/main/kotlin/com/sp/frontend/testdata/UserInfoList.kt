package com.sp.frontend.testdata

import com.sp.frontend.testdata.UserInfo

public object UserInfoList {
    public var USERINFO1: UserInfo? = UserInfo()
        .setValues{ r: UserInfo ->
        r.login = "dante"
        r.city = "123456"
        r.email = "test1@sp.ru"
        r.phone = "+79877777777"
    }
    public var USERINFO2: UserInfo? = UserInfo()
        .setValues{ r: UserInfo ->
        r.login = "user"
        r.city = "123456"
        r.email = "test2@sp.ru"
        r.phone = "+79875555555"
    }
}
