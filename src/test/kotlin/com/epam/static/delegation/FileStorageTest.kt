package com.epam.static.delegation

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
    fun `when creating storage with negative filesLimit it should throws IllegalArgumentException`() {
        FileStorage.create(-1, 10)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `when creating storage with zero filesLimit it should throws IllegalArgumentException`() {
        FileStorage.create(0, 10)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `when creating storage with negative sizeLimit it should throws IllegalArgumentException`() {
        FileStorage.create(10, -10)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `when creating storage with zero sizeLimit it should throws IllegalArgumentException`() {
        FileStorage.create(10, 0)
    }

    @Test
    fun `initial storage should be empty and size should be 0`() {
        val storage = FileStorage.create(1, 10)
        Assert.assertEquals(0, storage.getAllFiles().size)
    }

    @Test
    fun `when new file doesn't violate storage restrictions it should be added`() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "FileName1.mkv")
        storage += file
        Assert.assertEquals(1, storage.getAllFiles().size)
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun `when file with a negative size is adding to the storage then IllegalArgumentException should be thrown`() {
        val storage = FileStorage.create(1, 10)
        val file = File(-10, "FileName1.mkv")
        storage += file
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun `if new file will exceed filesLimit after add operation then IllegalArgumentException should be thrown`() {
        val storage = FileStorage.create(1, 50)
        val file1 = File(10, "FileName1.mkv")
        val file2 = File(10, "FileName2.mkv")
        storage += file1
        storage += file2
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun `if new file will exceed sizeLimit after adding then IllegalArgumentException should be thrown`() {
        val storage = FileStorage.create(5, 10)
        val file1 = File(10, "FileName1.mkv")
        val file2 = File(10, "FileName2.mkv")
        storage += file1
        storage += file2
    }

    @Test
    fun `when new file will not violate sizeLimit after adding it should be added to the storage`() {
        val storage = FileStorage.create(5, 10)
        val file1 = File(10, "FileName1.mkv")
        storage += file1
        Assert.assertEquals(1, storage.getAllFiles().size)
    }

    @Test
    fun `when new file will not violate filesLimit after adding it should be added to the storage`() {
        val storage = FileStorage.create(1, 20)
        val file1 = File(10, "FileName1.mkv")
        storage += file1
        Assert.assertEquals(1, storage.getAllFiles().size)
    }

    @Test
    fun `when deleting a file which present in the storage it should be deleted`() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "FileName1.mkv")
        storage += file
        storage -= file
        Assert.assertEquals(0, storage.getAllFiles().size)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `when remove file by invalid index then IllegalArgumentException should be thrown`() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "FileName1.mkv")
        storage += file
        storage -= 1
    }

    @Test(expected = IllegalArgumentException::class)
    fun `when remove file by negative index then IllegalArgumentException should be thrown`() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "FileName1.mkv")
        storage += file
        storage -= -1
    }

    @Test
    fun `when call invoke() on empty storage then appropriate message should be shown`() {
        val storage = FileStorage.create(1, 10)
        storage.invoke()
        val output = String(outputStream.toByteArray())
        val expected = "Your storage is empty\n"
        Assert.assertEquals(output, expected)
    }

    @Test
    fun `when call invoke() on a storage with a single file it should print appropriate message`() {
        val storage = FileStorage.create(1, 10)
        val file = File(10, "FileName1.mkv")
        storage += file
        storage.invoke()
        val output = String(outputStream.toByteArray())
        val expected = "${file.name} in your storage\n"
        Assert.assertEquals(output, expected)
    }

    @Test
    fun `when call invoke() on a storage with more then 1 file it should print appropriate message with coma separator`() {
        val storage = FileStorage.create(2, 100)
        val file1 = File(10, "FileName1.mkv")
        val file2 = File(10, "FileName2.mkv")
        storage += file1
        storage += file2
        storage.invoke()
        val output = String(outputStream.toByteArray())
        val expected = "${file1.name}, ${file2.name} in your storage\n"
        Assert.assertEquals(output, expected)
    }

    @Test
    fun `when call invoke(size) and all files meet requirements then all of them should be printed()`() {
        val storage = FileStorage.create(2, 100)
        val file1 = File(10, "FileName1.mkv")
        val file2 = File(10, "FileName2.mkv")
        storage += file1
        storage += file2
        storage.invoke(5)
        val output = String(outputStream.toByteArray())
        val expected = "${file1.name}\n${file2.name}\n"
        Assert.assertEquals(output, expected)
    }

    @Test
    fun `when call invoke(size) and no files meet requirements then nothing should be printed`() {
        val storage = FileStorage.create(2, 100)
        val file1 = File(10, "FileName1.mkv")
        val file2 = File(10, "FileName2.mkv")
        storage += file1
        storage += file2
        storage.invoke(50)
        val output = String(outputStream.toByteArray())
        Assert.assertEquals(output, "")
    }

    companion object {

        fun createStorageWithFiles(size: Int): FileStorage {
            val storage = FileStorage.create(100, Int.MAX_VALUE)
            List(size) { index -> File(1, "FileName$index.mkv") }
                    .forEach { storage += it }
            return storage
        }
    }
}