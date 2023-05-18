package com.epam.static.delegation

import com.epam.static.delegation.FileStorageTest.Companion.createStorageWithFiles
import org.junit.Test
import kotlin.test.assertEquals

class FileDownloaderTest {

    @Test
    fun `when file list is downloaded all then it should be persisted in the storage`() {
        val storage = createStorageWithFiles(0)
        val fileList = listOf(
                File(150, "VideoFile1.mkv"),
                File(1500, "VideoFile2.mkv")
        )

        val downloader = FileDownloader(storage, fileList)
        downloader.download()
        assertEquals(
                fileList.size,
                storage.getAllFiles().size
        )
    }
}