package com.epam.static.delegation

/**
 * name of file should have the next structure "VideoFileN.mkv" where N is
 * a number of file (order number or number that related to your decision)
 */
data class File(val size: Int, val name: String) {

    companion object {
        private const val DOT = "."
    }

    /**
     * This operator should emulate editing video files. After editing it should
     * be created a new video file that contains both. It means that size of new video will consist
     * of the size of the first video and the size of the second one. Also, if name of first video
     * is "VideoFile1.mkv" and name of the second file is "VideoFile2.mkv" the name of final video
     * should be "VideoFile1 + 2.mkv". This rule is applicable for any number of files.
     * @param file which will add to another file
     * @return result file which contains these 2 files
     * @throws IllegalArgumentException in case when name doesn't contain any digit
     */
    operator fun plus(file: File): File {
        //TODO()
    }
}