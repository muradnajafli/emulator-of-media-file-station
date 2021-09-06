package com.epam.static.delegation

class FileStorage private constructor(
    private val filesLimit: Int,
    private val sizeLimit: Int
) {

    private val fileList = ArrayList<File>()

    fun getAllFiles(): List<File> = fileList

    /**
     * This operator should add your [File] to the storage file list. Also, it should check
     * if it is possible regarding files limit and size limit to add your file to this list. If it's
     * not possible due to size and files limitations, it should @throws [IllegalArgumentException]
     * with a message "Cannot add file due to restriction violations".
     */
    operator fun plusAssign(file: File) {
        //TODO()
    }

    operator fun minusAssign(file: File) {
        fileList.remove(file)
    }

    /**
     * This operator should make the same changes as a previous one,
     * but using as a @param index instead of [File]
     * In case when index doesn't have a correct value for current
     * file list, it should @throws [IllegalArgumentException] with a message
     * "Wrong file index 'value'", where instead of 'value' part you should add
     * the value of @param index
     */
    operator fun minusAssign(index: Int) {
        //TODO()
    }

    /**
     * For files from file list which size is more than @param this 'invoke' function should
     * print names of these files in terminal.
     */
    operator fun invoke(size: Int) {
        //TODO()
    }

    /**
     * As a result it should print string in the terminal, which contains names of files
     * from the file list using comma as a separator. For example, if the file list contains
     * two files: "VideoFile1.mkv" and "VideoFile2.mkv", the result will be
     * "VideoFile1.mkv, VideoFile2.mkv in your storage". So the result of this function is
     * displaying a notification in the terminal in the following structure "'result string' in your
     * storage" where 'result string' is the string of files names, divided with comma.
     * In case of an empty file list, the message in the terminal will be "Your storage is empty".
     */
    operator fun invoke() {
        //TODO()
    }

    /**
     * Create instance of [FileStorage] here
     * if filesLimit or sizeLimit has a negative or zero value, then @throws [IllegalArgumentException]
     */
    companion object {
        fun create(filesLimit: Int, sizeLimit: Int): FileStorage {
            //TODO()
        }
    }
}