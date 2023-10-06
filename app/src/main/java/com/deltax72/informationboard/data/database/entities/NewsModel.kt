package com.deltax72.informationboard.data.database.entities

import androidx.room.Entity

@Entity(
    tableName = NewsModel.tableName,
    primaryKeys = ["id"]
)
data class NewsModel(
    val id: Int = -1,
    val image: ByteArray? = null,
    val username: String,
    val topic: String,
    val message: String,
    val dateCreated: Long = 0
) {
    companion object {
        const val tableName = "NewsModelTable"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NewsModel

        if (id != other.id) return false
        if (image != null) {
            if (other.image == null) return false
            if (!image.contentEquals(other.image)) return false
        } else if (other.image != null) return false
        if (username != other.username) return false
        if (topic != other.topic) return false
        if (message != other.message) return false
        if (dateCreated != other.dateCreated) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (image?.contentHashCode() ?: 0)
        result = 31 * result + username.hashCode()
        result = 31 * result + topic.hashCode()
        result = 31 * result + message.hashCode()
        result = 31 * result + dateCreated.hashCode()
        return result
    }

}