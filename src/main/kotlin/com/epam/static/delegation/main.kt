package com.epam.static.delegation

/**
 * Here is an example code which could be useful to check your implementation
 * manually. There are any requirements for it, this code will not be tested
 * and it just for demonstration purposes.
 * Feel free to use it!
 */
fun main() {
    // fill this list with your files to make this code work!
    val filesToDownload = listOf<File>()

    val storage = FileStorage.create(filesToDownload.size, 9000)

    val downloader = FileDownloader(storage, filesToDownload)
    val player = FilePlayer(storage)
    val editor = FileEditor(storage)

    val mediaFileProcessor = MediaFileProcessor(downloader, player, editor)
    with(mediaFileProcessor) {
        download()
        play()
        edit()
    }
}