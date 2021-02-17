package com.epam.static.delegation

/**
 * Use delegation here instead of implementation of each interface methods
 */
class MediaFileProcessor(
    private val downloader: Downloader,
    private val player: Player,
    private val editor: FileEditor
) : Downloader, Player, Editor {

    override fun download() {
        TODO("Not yet implemented")
    }

    override fun edit() {
        TODO("Not yet implemented")
    }

    override fun play() {
        TODO("Not yet implemented")
    }

}
