package com.epam.static.delegation

import org.junit.Assert
import org.junit.Test

class FileTest {

    @Test
    fun some_file_plus_another_file() {
        val file1 = File(1200, "VideoFile1.mkv")
        val file2 = File(3110, "VideoFile2.mkv")
        val file = file1 + file2
        Assert.assertEquals("VideoFile1 + 2.mkv", file.name)
    }

    @Test(expected = IllegalArgumentException::class)
    fun some_file_plus_another_file_with_incorrect_name() {
        val file1 = File(1200, "VideoFile1.mkv")
        val file2 = File(3110, "VideoFiledsada.mkv")
        file1 + file2
    }
}