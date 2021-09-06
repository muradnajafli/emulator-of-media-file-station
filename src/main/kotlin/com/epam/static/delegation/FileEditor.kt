package com.epam.static.delegation

class FileEditor(private val storage: FileStorage) : Editor {

    /**
     * This function should create a new video that consists of videos from the [FileStorage] file list.
     * As a result it should display the notification in the terminal "Edited file is [File]", where
     * [File] is the result of this function. In case when storage list is empty it should throw
     * [IllegalMonitorStateException] with a message "Your storage is empty".
     */
    override fun edit() {
        //TODO()
    }
}