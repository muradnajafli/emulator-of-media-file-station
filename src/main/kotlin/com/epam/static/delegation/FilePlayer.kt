package com.epam.static.delegation

class FilePlayer(private val fileList: List<File>) : Player {

    override fun play() {
        fileList.forEach { file ->
            println("$file playing")
        }
    }
}