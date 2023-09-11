package net.simplifiedcoding

import android.content.Context

data class Courses(
    // on below line creating variables.
    var courseName: String? = "",
    var courseDuration: String? = "",
    var courseDescription: String? = "",
    val courseAuthor: Context = "",
    var courseId: String? = "",
) {

}