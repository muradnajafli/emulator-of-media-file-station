package com.epam.static.delegation

class FilePlayer(private val storage: FileStorage) : Player {

    override fun play() {
        storage.getAllFiles().forEach { file ->
            println("$file playing")
        }
    }
}