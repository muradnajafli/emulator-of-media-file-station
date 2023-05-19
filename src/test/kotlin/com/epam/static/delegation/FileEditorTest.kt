package com.epam.static.delegation

import com.epam.static.delegation.FileStorageTest.Companion.createStorageWithFiles
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class FileEditorTest {

    private lateinit var outputStream: ByteArrayOutputStream

    @Before
    fun setup() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @Test(expected = IllegalStateException::class)
    fun `when storage is empty edit action should throw an error`() {
        val storage = createStorageWithFiles(0)
        val editor = FileEditor(storage)
        editor.edit()
    }

    @Test
    fun `when storage not empty then appropriate message should be shown`() {
        val storage = createStorageWithFiles(3)
        val expected = "Edited file is"

        val editor = FileEditor(storage)
        editor.edit()
        val output = String(outputStream.toByteArray())
        TestCase.assertTrue(
                "Output message should starts from `$expected` but was `$output`",
                output.contains(expected))
    }
}