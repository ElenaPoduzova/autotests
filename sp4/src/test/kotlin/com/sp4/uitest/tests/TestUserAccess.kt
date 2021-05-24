package com.sp4.uitest.tests

import com.sp4.elements.Breadcrumbs
import com.sp4.elements.SpAlerts
import com.sp4.functions.UserFunctions
import com.sp4.testdata.UsersList
import com.sp4.uitest.testutils.TestInit
import com.uitestcore.driverutils.CookieProfileReader
import com.uitestcore.driverutils.Driver
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestUserAccess : TestInit() {

    private var userPages = arrayOf("user/view", "cart", "purse", "resell", "boast", "resell/user", "boast/user")
    private var orgPages = arrayOf("org", "stock/org", "supplier/org", "invoice/org", "purse/org", "parcel/org/view")
    private var adminPages = arrayOf("admin", "news/admin", "blog/admin", "boast/admin", "resell/admin", "stock/admin", "stock/admin/ready",
            "discount/admin", "page/admin", "poster/admin", "access/admin/permit", "assistant/admin", "office/admin/operator",
            "supplier/admin", "office/admin", "org/admin/company", "org/admin", "org/admin/medal", "tariff/admin",
            "invoice/admin", "forum/admin/moder", "user/admin", "city/admin/region", "city/admin/city", "purse/admin/org",
            "restrict/admin/pattern", "cron/admin/log", "system/admin/api/log", "task/admin", "cron/admin", "file/admin",
            "system/admin/daemon/status")


    @Test(priority=1)
    fun checkUserAccess() {
        Driver.openPage("/stock")
        UserFunctions.loginAsUser(UsersList.USER!!)
        val assert = SoftAssert()
        userPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertTrue(Driver.get().currentUrl.contains(it), "У пользователя должен быть доступ к пользовательской странице /${it}, но показана ${Driver.get().currentUrl}")
        }
        orgPages.forEach {
            Driver.openPage(it)
            //Breadcrumbs.waitForAppear()
            //assert.assertEquals(Breadcrumbs().getLastLink(), "Закупки", "У пользователя не должно быть доступа к орговской странице ${it}")
            SpAlerts.waitForNoAccessAlert()
            assert.assertTrue(SpAlerts.isNoAccessAlertDisplayed(), "Пользователь должен увидеть сообщение об отсутвии доступа к странице /${it}")
        }
        adminPages.forEach {
            Driver.openPage(it)
            SpAlerts.waitForNoAccessAlert()
            assert.assertTrue(SpAlerts.isNoAccessAlertDisplayed(), "Пользователь должен увидеть сообщение об отсутвии доступа к странице /${it}")
        }
        assert.assertAll()
    }

    @Test(priority=2)
    fun checkOrgAccess() {
        Driver.openPage("/stock")
        UserFunctions.loginAsUser(UsersList.ORG!!)
        Driver.reloadPage()
        val assert = SoftAssert()
        userPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertTrue(Driver.get().currentUrl.contains(it), "У орга должен быть доступ к пользовательской странице /${it}, но показана ${Driver.get().currentUrl}")
        }
        orgPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertTrue(Driver.get().currentUrl.contains(it), "У орга должен быть доступ к орговской странице /${it}, но показана ${Driver.get().currentUrl}")
        }
        adminPages.forEach {
            Driver.openPage(it)
            SpAlerts.waitForNoAccessAlert()
            assert.assertTrue(SpAlerts.isNoAccessAlertDisplayed(), "Орг должен увидеть сообщение об отсутвии доступа к странице /${it}")
        }
        assert.assertAll()
    }

    @Test(priority=3)
    fun checkAdminAccess() {
        Driver.openPage("/stock")
        UserFunctions.loginAsUser(UsersList.ADMIN!!)
        val assert = SoftAssert()
        userPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertTrue(Driver.get().currentUrl.contains(it), "У админа должен быть доступ к пользовательской странице /${it}")
        }
        orgPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertTrue(Driver.get().currentUrl.contains(it), "У админа должен быть доступ к орговской странице /${it}")
        }
        adminPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertTrue(Driver.get().currentUrl.contains(it), "У админа должен быть доступ к админской странице /${it}")
        }
        assert.assertAll()
    }
}