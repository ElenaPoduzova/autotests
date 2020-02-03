package com.sp.ui.testdata

public object UsersList {
    public var USER: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "user"
        r.password = "123"
        r.name = "user"
        r.role = UserRoles.USER
    }
    public var ADMIN: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "admin"
        r.password = "123"
        r.name = "admin"
        r.role = UserRoles.ADMIN
    }
}
