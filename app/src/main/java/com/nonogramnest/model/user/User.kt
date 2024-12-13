package com.nonogramnest.model.user

import com.fasterxml.jackson.annotation.JsonProperty

data class User(
    @JsonProperty("user_id") val id: Int,
    @JsonProperty("email") val email: String,
    @JsonProperty("username") val username: String,
    @JsonProperty("role") val role: String
)