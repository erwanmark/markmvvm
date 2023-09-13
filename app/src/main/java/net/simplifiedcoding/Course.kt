package net.simplifiedcoding

import java.time.Duration

// on below line creating a data class for course,
data class Course(
    // on below line creating variables.
    var doctorsName: String? = "",
    var doctorsLocation: String? = "",
    var doctorsSpecialisation: String? = "",
    val doctorsContacts: String = "",
    var consoltationCharges: String? = "",
)
