package com.epam.static.delegation

/**
 * Represents a file which our [MediaFileProcessor] is operating with
 *
 * Requirements:
 * - file should have only `mkv` extension
 * - [name] should have the next structure: "VideoFileN.mkv",
 *   where "N" is a number of the file (from 0 to 9)
 * - [size] should be >= 0
 * Tips:
 * - in ensure correct behaviour in collections don't forget about
 *   equals() and hashCode()
 */
class File(val size: Int, val name: String) {

    companion object {
        private const val DOT = "."
    }

    /**
     * Emulates editing process of the video files. Creating a new file
     * with extended [name] and added up [size]
     *
     * Requirements:
     * - result file size should be a sum of the first and second files sizes
     * - result file name should have next structure: "VideoFileN+R.mkv",
     *   where "N" is a number of the first file, "R" is a number of the second file
     * - when any of files has invalid name then [IllegalArgumentException]
     *   should be thrown
     * Tips:
     * - constant [DOT] could be useful to divide file name and it extension
     * - in order to simplify this function maybe initial checks for the file name
     *   and size will be suitable to put into `init` block
     *
     * @param file which will be added to the current one
     * @return new file with a total size and extended name
     */
    operator fun plus(file: File): File {
        val firstNumberSubstring = name.substringAfter("VideoFile").substringBefore(DOT)
        val secondNumberSubstring = file.name.substringAfter("VideoFile").substringBefore(DOT)

        try {
            val firstFileNumber = firstNumberSubstring.toInt()
            val secondFileNumber = secondNumberSubstring.toInt()
            val newSize = size + file.size
            val newFileName = "VideoFile$firstFileNumber+$secondFileNumber$DOT${file.name.substringAfter(DOT)}"
            return File(newSize, newFileName)

        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }


    override fun hashCode(): Int {
        return 31 * size.hashCode() + name.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is File) return false

        return size == other.size && name == other.name
    }
}