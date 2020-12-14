package com.sp4.functions

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.uitestcore.driverutils.Driver
import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import java.io.IOException
import java.io.InputStream

object SharedFunctions {
    private var propertiesPath: String? = null

    @Volatile
    private var inputStream: InputStream? = null
    private val path: String?
        get() = if (StringUtils.isBlank(propertiesPath)) {
            ""
        } else {
            if (propertiesPath!![0] != '/') {
                propertiesPath = "/$propertiesPath"
            }
            propertiesPath
        }


    fun getFloatFromString(string: String) : Float {
        val pattern1 = "(\\d+)".toRegex()
        if (pattern1.containsMatchIn(string)) {
            var result = pattern1.find(string)?.groups?.get(0)?.value
            return result!!.toFloat()
        }
        else
            throw Exception("Wrong format")
    }

    fun readJson(fileName: String): JsonObject {
        var jsonObject = JsonObject()
        propertiesPath = "$fileName.json"
        try {
            inputStream = SharedFunctions::class.java.getResourceAsStream(path!!)
            if (inputStream != null) {
                jsonObject =  JsonParser.parseString(IOUtils.toString(inputStream, "UTF-8")).asJsonObject
            }
        } catch (var3: Exception) {
            try {
                if (inputStream != null) {
                    inputStream!!.close()
                }
            } catch (var2: IOException) {
                throw RuntimeException(var2.message)
            }
        }
        return jsonObject
    }

    fun isElementExists(by: By): Boolean {
        return try {
            Driver.get().findElement(by)
            true
        }
        catch (ex: Exception) {
            false
        }
    }

}