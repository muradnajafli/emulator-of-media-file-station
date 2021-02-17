package com.epam.static.delegation

/**
 * Fill the filesToDownload list with a different [File] with your own
 * values
 */
fun main() {
    val storage = FileStorage.create(5, 9000)
    val filesToDownload = listOf()
    val downloader = FileDownloader(storage, filesToDownload)
    val fileList = storage.getAllFiles()
    val player = FilePlayer(fileList)
    val editor = FileEditor(storage)
    val mediaFileProcessor = MediaFileProcessor(downloader, player, editor)
    with(mediaFileProcessor) {
        download()
        play()
        edit()
    }
}