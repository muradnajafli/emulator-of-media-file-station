package com.epam.static.delegation

class FileEditor(private val storage: FileStorage) : Editor {

    /**
     * This fun should create a new video that consist of videos from the [FileStorage] file list.
     * As a result it should display notification in the terminal "Edited file is [File]", where
     * [File] is a result of this fun. In case when storage list is empty it should throw
     * [IllegalMonitorStateException] with a message "Your storage is empty"
     */
    override fun edit() {
        //TODO()
    }
}