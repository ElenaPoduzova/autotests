package com.sp4.uitest.tests

import com.sp4.elements.Breadcrumbs
import com.sp4.elements.SpAlerts
import com.sp4.uitest.testutils.TestInit
import com.uitestcore.driverutils.CookieProfileReader
import com.uitestcore.driverutils.Driver
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert

class TestUserAccess : TestInit() {

    private var userPages = arrayOf("user/view", "cart", "purse", "resell", "boast", "resell/user", "boast/user")
    private var orgPages = arrayOf("org", "org/admin", "stock/org", "supplier/org", "invoice/org", "purse/org", "parcel/org/view")
    private var adminPages = arrayOf("admin", "news/admin", "blog/admin", "boast/admin", "resell/admin", "stock/admin", "stock/admin/ready",
            "discount/admin", "page/admin", "poster/admin", "access/admin/permit", "assistant/admin", "office/admin/operator",
            "supplier/admin", "office/admin", "org/admin/company", "org/admin", "org/admin/medal", "tariff/admin",
            "invoice/admin", "forum/admin/moder", "user/admin", "city/admin/region", "city/admin/city", "purse/admin/org",
            "restrict/admin/pattern", "cron/admin/log", "system/admin/api/log", "task/admin", "cron/admin", "file/admin",
            "system/admin/daemon/status")


    @Test(priority=1)
    fun checkUserAccess() {
        Driver.openPage("/stock")
        Driver.setCookies(CookieProfileReader.readProfile("userprofile"))
        Driver.reloadPage()
        val assert = SoftAssert()
        userPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertTrue(Driver.get().currentUrl.contains(it), "У пользователя должен быть доступ к пользовательской странице /${it}")
        }
        orgPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertEquals(Breadcrumbs().getLastLink(), "Закупки", "У пользователя не должно быть доступа к орговской странице ${it}")
            assert.assertTrue(SpAlerts.isNoAccessAlertDisplayed(), "Пользователь должен увидеть сообщение об отсутвии доступа к странице /${it}")
        }
        adminPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertEquals(Breadcrumbs().getLastLink(), "Закупки", "У пользователя не должно быть доступа к админской странице ${it}")
            assert.assertTrue(SpAlerts.isNoAccessAlertDisplayed(), "Пользователь должен увидеть сообщение об отсутвии доступа к странице /${it}")
        }
        assert.assertAll()
        Driver.deleteCookies()
    }

    @Test(priority=2)
    fun checkOrgAccess() {
        Driver.openPage("/stock")
        Driver.deleteCookies()
        Driver.setCookies(CookieProfileReader.readProfile("orgprofile"))
        Driver.reloadPage()
        val assert = SoftAssert()
        userPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertTrue(Driver.get().currentUrl.contains(it), "У орга должен быть доступ к пользовательской странице /${it}")
        }
        orgPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertTrue(Driver.get().currentUrl.contains(it), "У орга должен быть доступ к орговской странице /${it}")
        }
        adminPages.forEach {
            Driver.openPage(it)
            Breadcrumbs.waitForAppear()
            assert.assertEquals(Breadcrumbs().getLastLink(), "Закупки", "У орга не должно быть доступа к админской странице /${it}")
            assert.assertTrue(SpAlerts.isNoAccessAlertDisplayed(), "Орг должен увидеть сообщение об отсутвии доступа к странице /${it}")
        }
        assert.assertAll()
        Driver.deleteCookies()
    }

    @Test(priority=3)
    fun checkAdminAccess() {
        Driver.openPage("/stock")
        Driver.deleteCookies()
        Driver.setCookies(CookieProfileReader.readProfile("adminprofile"))
        Driver.reloadPage()
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
        Driver.deleteCookies()
    }
}