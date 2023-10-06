package com.deltax72.informationboard.data.database.entities.auth

import androidx.room.Entity

@Entity(
    tableName = TokenResponse.tableName,
    primaryKeys = ["token"]
)
data class TokenResponse(
    val token: String
) {
    companion object {
        const val tableName = "token_response"
    }
}