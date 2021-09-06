package com.epam.static.delegation

/**
 * Name of the file should have the following structure:
 * "VideoFileN.mkv" where N is a number of the file (it can be an order number or
 * number that is related to your decision).
 * Size can have any Int value.
 */
data class File(val size: Int, val name: String) {

    companion object {
        private const val DOT = "."
    }

    /**
    * This operator should emulate editing video files. After editing
    * a new video file should be created. It should contain both files. It means that size of the new video will consist
    * of the size of the first video and the size of the second one. Also, if the name of the first video
    * is "VideoFile1.mkv" and the name of the second file is "VideoFile2.mkv" the name of the final video
    * should be "VideoFile1 + 2.mkv". This rule is applicable to any number of files.
    * @param file which will be added to another file
    * @return result file which contains two initial files
    * @throws [IllegalArgumentException] in case of both files names don’t contain any digits
    */
    operator fun plus(file: File): File {
        //TODO()
    }
}