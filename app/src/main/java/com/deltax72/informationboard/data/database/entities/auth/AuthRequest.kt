package com.deltax72.informationboard.data.database.entities.auth

import androidx.room.Entity

@Entity(
    tableName = AuthRequest.tableName,
    primaryKeys = ["username"]
)
data class AuthRequest(
    var username: String = "",
    var password: String = ""
) {
    companion object {
        const val tableName = "auth_request"
    }
}