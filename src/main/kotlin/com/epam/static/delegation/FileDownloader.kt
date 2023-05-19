package com.epam.static.delegation

class FileDownloader(
        private val storage: FileStorage,
        private val filesList: Collection<File>
) : Downloader {

    /**
     * Persists all files to the storage and prints their names.
     *
     * Requirements:
     * - implement a mechanism which will save files to the storage
     */
    override fun download() {
        filesList.forEach { file ->
            println("$file downloaded")
            TODO()
        }
    }
}