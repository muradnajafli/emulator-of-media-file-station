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

    /**
     * Returns list of the file, which are currently persisted
     * in the storage
     */
    fun getAllFiles(): Collection<File> = TODO()

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
        TODO()
    }

    /**
     * Removes file from the storage, if it presents
     */
    operator fun minusAssign(file: File) {
        TODO()
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
        TODO()
    }

    /**
     * Prints all files names, which satisfy a condition: [File.size] > [size]
     */
    operator fun invoke(size: Int) {
        TODO()
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
        TODO()
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
            TODO()
        }
    }
}