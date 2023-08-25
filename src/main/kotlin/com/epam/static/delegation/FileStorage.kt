package com.epam.static.delegation

/**
 * Keeps all our files, which will be downloaded.
 * Has a specific restrictions for total files size and they amounts
 *
 * Requirements:
 * - you have to add any collection you want in order to
 *   be able to add/remove/iterate files to the storage
 *
 * @param filesLimit how many files could be persisted
 * @param sizeLimit total size of persisted files
 */
class FileStorage private constructor(
        private val filesLimit: Int,
        private val sizeLimit: Int
) {

    private val files: MutableList<File> = mutableListOf()


    /**
     * Returns list of the file, which are currently persisted
     * in the storage
     */
    fun getAllFiles(): Collection<File> {
        return files
    }

    /**
     * Adds file to the storage, if it possible
     *
     * Requirements:
     * - [filesLimit] should not be violated
     * - [sizeLimit] should be enough to persist new file
     * - if any of restrictions is violated, then [IllegalArgumentException]
     *   should be thrown with message "Cannot add file due to restriction violations"
     *
     * @param file to persist in the storage
     * @throws [IllegalArgumentException] when restrictions is violated
     */
    operator fun plusAssign(file: File) {
        if (files.size >= filesLimit) {
            throw IllegalArgumentException("Cannot add file due to restriction violations")
        }
        // files.size -> number of files in storage
        // file.size -> size of one file
        // [2, 3, 4, 5]
        // count() -> 4
        // what we what it to return:
        if (files.sumOf { it.size } + file.size > sizeLimit) {
            throw IllegalArgumentException("Cannot add file due to restriction violations")
        }
        if (file.size < 0) {
            throw IllegalArgumentException("Cannot add file due to restriction violations")
        }
        files.add(file)

    }

    /**
     * Removes file from the storage, if it presents
     */
    operator fun minusAssign(file: File) {
        if (file in files) {
            files.remove(file)
        }

    }

    /**
     *
     * Removes file from the storage by its index, if such index exists.
     *
     * Requirements:
     * - when index is invalid then [IllegalArgumentException] should
     *   be thrown with the message: "Wrong file index $index"
     *
     * @param index of file with should be deleted
     * @throws [IllegalArgumentException] when index is invalid
     */
    operator fun minusAssign(index: Int) {
        val filesList = files.toList()
        if (index < 0 || index >= filesList.size) {
            throw IllegalArgumentException("Wrong file index $index")
        }
        files.remove(filesList[index])
    }

    /**
     * Prints all files names, which satisfy a condition: [File.size] > [size]
     */
    operator fun invoke(size: Int) {
        for (file in files) {
            if (file.size > size) {
                print(file.name)
                print("\n")
            }
        }

    }

    /**
     * Prints all files names which are currently stored
     * to the terminal
     *
     * Requirements:
     * - all names should be printed in one line with `coma` separator.
     *   For example, if storage consists of 2 files then function should print:
     *   "VideoFile1.mkv, VideoFile2.mkv in your storage"
     * - if storage is empty then a next notification should be shown:
     *   "Your storage is empty"
     */
    operator fun invoke() {
        if (files.isEmpty()) {
            print("Your storage is empty\n")
        } else {
            val names = files.joinToString(", ") { it.name }
            print("$names in your storage\n")
        }

    }

    companion object {
        /**
         * Create a new instance of [FileStorage] with given restrictions
         *
         * Requirements:
         * - [filesLimit] should be greater than 0
         * - [sizeLimit]  should be greater than 0
         * - if requirements is violated then [IllegalArgumentException]
         *   should be thrown
         */
        fun create(filesLimit: Int, sizeLimit: Int): FileStorage {
            if (filesLimit > 0 && sizeLimit > 0) {
                return FileStorage(filesLimit, sizeLimit)

            }
            throw IllegalArgumentException()
        }
    }
}