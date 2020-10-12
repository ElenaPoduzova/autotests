package com.sp4.testdata

object UsersList {
    var USER: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "sptest1 "
        r.password = "12345"
        r.name = "sptest1"
        r.role = UserRoles.USER
    }
    var ADMIN: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "dante23101@yandex.ru"
        r.password = "123456"
        r.name = "dante"
        r.role = UserRoles.ADMIN
    }
    var ORG: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "Sony"
        r.password = "12345"
        r.name = "Sony"
        r.role = UserRoles.ORG
    }
}
