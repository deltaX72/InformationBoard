package com.deltax72.informationboard.data.database.entities

import androidx.room.Entity

@Entity(
    tableName = User.tableName,
    primaryKeys = ["id", "username"]
)
data class User(
    val id: Long = -1,
    val username: String,
    val password: String,
    val salt: String,
    val dateCreated: String,
    val firstName: String,
    val lastName: String,
    val token: String
) {
    companion object {
        const val tableName = "UserTable"
    }
}