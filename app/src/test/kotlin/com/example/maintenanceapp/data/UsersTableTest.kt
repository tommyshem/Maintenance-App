package com.example.maintenanceapp.data

import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.google.common.truth.Truth.assertThat

class DateTest {

    @Test
    fun date() {
        val currenttime = LocalDateTime.now()
        val timeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd") // HH:mm:ss.SSS")
        val testtime = currenttime.format(timeformat).toString()
        assertThat(testtime).isEqualTo("45")
    }
}
