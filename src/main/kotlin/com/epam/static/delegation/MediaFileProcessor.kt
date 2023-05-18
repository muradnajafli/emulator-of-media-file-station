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
) : Downloader, Player, Editor {

    override fun download() {
        TODO()
    }

    override fun edit() {
        TODO()
    }

    override fun play() {
        TODO()
    }
}
