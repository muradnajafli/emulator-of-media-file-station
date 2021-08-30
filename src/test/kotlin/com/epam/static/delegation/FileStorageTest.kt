package com.epam.static.delegation

import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class FileStorageTest {

    private lateinit var outputStream: ByteArrayOutputStream

    @Before
    fun setup() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @Test(expected = IllegalArgumentException::class)
    fun create_storage_negative_files_limit() {
        FileStorage.create(-1, 10)
    }

    @Test(expected = IllegalArgumentException::class)
    fun create_storage_zero_files_limit() {
        FileStorage.create(0, 10)
    }

    @Test(expected = IllegalArgumentException::class)
    fun create_storage_negative_size_limit() {
        FileStorage.create(10, -10)
    }

    @Test(expected = IllegalArgumentException::class)
    fun create_storage_zero_size_limit() {
        FileStorage.create(10, 0)
    }

    @Test
    fun check_storage_size_no_actions() {
        val storage = FileStorage.create(1, 10)
        Assert.assertEquals(0, storage.getAllFiles().size)
    }

    @Test
    fun add_file_to_storage_check_size() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "some name")
        storage += file
        Assert.assertEquals(1, storage.getAllFiles().size)
    }

    @Test
    fun add_file_to_storage_check_storage_content() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "some name")
        storage += file
        assertEquals(
            "Hashcode and equals not implemented",
            File(10, "some name"),
            storage.getAllFiles().firstOrNull()
        )
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun add_file_to_storage_negative_size() {
        val storage = FileStorage.create(1, 10)
        val file = File(-10, "some name")
        storage += file
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun add_file_to_storage_files_limit_exceed() {
        val storage = FileStorage.create(1, 50)
        val file1 = File(10, "some name")
        val file2 = File(10, "some name2")
        storage += file1
        storage += file2
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun add_file_to_storage_size_limit_exceed() {
        val storage = FileStorage.create(5, 10)
        val file1 = File(10, "some name")
        val file2 = File(10, "some name")
        storage += file1
        storage += file2
    }

    @Test
    fun add_file_to_storage_size_equal_to_limit() {
        val storage = FileStorage.create(5, 10)
        val file1 = File(10, "some name")
        storage += file1
        Assert.assertEquals(1, storage.getAllFiles().size)
    }

    @Test
    fun add_file_to_storage_files_count_equal_to_limit() {
        val storage = FileStorage.create(1, 20)
        val file1 = File(10, "some name")
        storage += file1
        Assert.assertEquals(1, storage.getAllFiles().size)
    }

    @Test
    fun remove_file_from_storage() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "some name")
        storage += file
        storage -= file
        Assert.assertEquals(0, storage.getAllFiles().size)
    }

    @Test
    fun double_add_file_from_storage() {
        val storage = FileStorage.create(5, 100)
        val file1 = File(10, "some name")
        val file2 = File(20, "some name2")
        storage += file1
        storage += file2
        Assert.assertEquals(2, storage.getAllFiles().size)
    }

    @Test
    fun double_remove_file_from_storage() {
        val storage = FileStorage.create(2, 100)
        val file1 = File(10, "some name")
        val file2 = File(20, "some name2")
        storage += file1
        storage += file2

        storage -= file1
        Assert.assertEquals(1, storage.getAllFiles().size)
    }

    @Test(expected = IllegalArgumentException::class)
    fun remove_from_storage_by_index() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "some name")
        storage += file
        storage -= 1
    }

    @Test(expected = IllegalArgumentException::class)
    fun remove_from_storage_by_negative_index() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "some name")
        storage += file
        storage -= -1
    }

    @Test
    fun invoke_storage_no_results() {
        val storage = FileStorage.create(1, 10)
        storage.invoke()
        val output = String(outputStream.toByteArray())
        val expected = "Your storage is empty\n"
        Assert.assertEquals(output, expected)
    }

    @Test
    fun invoke_storage_single_results() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "some name")
        storage += file
        storage.invoke()
        val output = String(outputStream.toByteArray())
        val expected = "${file.name} in your storage\n"
        Assert.assertEquals(output, expected)
    }

    @Test
    fun invoke_storage_double_results() {
        val storage = FileStorage.create(2, 100)
        val file1 = File(10, "some name1")
        val file2 = File(10, "some name2")
        storage += file1
        storage += file2
        storage.invoke()
        val output = String(outputStream.toByteArray())
        val expected = "${file1.name}, ${file2.name} in your storage\n"
        Assert.assertEquals(output, expected)
    }

    @Test
    fun invoke_storage_check_by_size() {
        val storage = FileStorage.create(2, 100)
        val file1 = File(10, "some name1")
        val file2 = File(20, "some name2")
        storage += file1
        storage += file2
        storage.invoke(5)
        val output = String(outputStream.toByteArray())
        val expected = "${file1.name}\n${file2.name}\n"
        Assert.assertEquals(output, expected)
    }

    @Test
    fun invoke_storage_check_by_size_no_results() {
        val storage = FileStorage.create(2, 100)
        val file1 = File(10, "some name1")
        val file2 = File(20, "some name2")
        storage += file1
        storage += file2
        storage.invoke(50)
        val output = String(outputStream.toByteArray())
        Assert.assertEquals(output, "")
    }
}