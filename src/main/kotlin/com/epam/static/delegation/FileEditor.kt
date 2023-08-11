package com.epam.static.delegation

class FileEditor(private val storage: FileStorage) : Editor {

    /**
     * Creates a new one long video by putting all the videos
     * from the [storage] together.
     *
     * Requirements:
     * - result output should have a structure: "Edited file is $file"
     *   where `file` is a result of this function
     * - if storage is empty ,then [IllegalStateException] should be thrown
     *   with a message: "Your storage is empty"
     */
    override fun edit() {
        val files = storage.getAllFiles()

        if (files.isEmpty()) {
            throw IllegalStateException("Your storage is empty")
        }

        files.forEach { file ->
            println("Edited file is $file")
        }

    }
}