package com.example.maintenanceapp.data

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.junit.Assert.assertThat

class DateTest() {

    @Test
    fun date() {
        var currenttime = LocalDateTime.now()
        var timeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd") // HH:mm:ss.SSS")
        var testtime = currenttime.format(timeformat).toString()
        assertThat(testtime,equalTo("45"))
    }
}
