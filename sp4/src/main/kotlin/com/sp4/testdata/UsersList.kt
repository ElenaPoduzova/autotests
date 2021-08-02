package com.sp4.testdata

object UsersList {
    var USER: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "sptest1"
        r.password = "12345"
        r.name = "sptest1"
        r.role = UserRoles.USER
    }
    var USER2: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "sptest2"
        r.password = "12345"
        r.name = "sptest2"
        r.role = UserRoles.USER
    }
    var USER3: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "sptest3"
        r.password = "12345"
        r.name = "sptest3"
        r.role = UserRoles.USER
    }
    var USER4: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "sptest4"
        r.password = "12345"
        r.name = "sptest4"
        r.role = UserRoles.USER
    }
    var ADMIN: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "Sony"
        r.password = "12345"
        r.name = "dante"
        r.role = UserRoles.ADMIN
    }
    var ORG: UserData? = UserData()
        .setValues{ r: UserData ->
        r.login = "org"
        r.password = "12345"
        r.name = "Sony"
        r.role = UserRoles.ORG
    }
}
