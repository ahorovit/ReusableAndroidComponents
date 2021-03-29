package <PROJECT>.data

// structure after relevant JSON object (or add converters)
data class TmdbReview(
    val id: Int,
    val author: String,
    val content: String,
    val url: String
)

// Structure after overall JSON response to link to relevant object
data class TmdbReviewResponse(
        val result: TmdbReview
)