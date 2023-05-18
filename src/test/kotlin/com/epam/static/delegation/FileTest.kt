package com.epam.static.delegation

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class FileTest {

    @Test
    fun `when both file names are valid then final name should be created`() {
        val file1 = File(1200, "VideoFile1.mkv")
        val file2 = File(3110, "VideoFile2.mkv")
        val file = file1 + file2
        Assert.assertEquals("VideoFile1+2.mkv", file.name)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `when file name doesn't ends on a digit then error should be thrown`() {
        val file1 = File(1200, "VideoFile1.mkv")
        val file2 = File(3110, "VideoFiled2sada.mkv")
        file1 + file2
    }

    @Test
    fun `when two files ahs the same size and name they should be equal`() {
        val file1 = File(10, "FileName1.mkv")
        val file2 = File(10, "FileName1.mkv")
        TestCase.assertEquals(
                "hashcode() and equals() not implemented",
                file1,
                file2
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun `when file don't have mkv extension then error should be thrown`() {
        val file = File(10, "FileName1.mkv")
        val file2 = File(10, "FileName1.avi")
        file + file2
    }
}