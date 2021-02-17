package com.epam.static.delegation

class FileDownloader(
    private val storage: FileStorage,
    private val filesList: List<File>
) : Downloader {

    /**
     * After downloading file it should be added to the storage using operator
     */
    override fun download() {
        filesList.forEach { file ->
            println("$file downloaded")
        }
    }

}