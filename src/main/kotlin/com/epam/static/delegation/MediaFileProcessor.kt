package com.epam.static.delegation

/**
 * Composition of all possible actions, which should be applied to
 * or invoked with [File].
 *
 * Requirements:
 *  - you should use delegation here instead of implementation
 *    of each interface methods
 */
class MediaFileProcessor(
    private val downloader: Downloader,
    private val player: Player,
    private val editor: Editor
) : Downloader by downloader, Player by player, Editor by editor {

    override fun download() {
        downloader.download()
    }

    override fun edit() {
        editor.edit()
    }

    override fun play() {
        player.play()
    }
}
