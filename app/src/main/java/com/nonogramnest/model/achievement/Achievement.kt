package com.nonogramnest.model.achievement

import com.fasterxml.jackson.annotation.JsonProperty

data class Achievement(
    @JsonProperty("achievement_id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("type") val solvedPuzzles: String,
    @JsonProperty("criteria") val criteria: Int
)
