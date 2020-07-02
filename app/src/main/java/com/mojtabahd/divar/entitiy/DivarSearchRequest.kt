package com.mojtabahd.divar.entitiy;

import com.google.gson.annotations.SerializedName

data class DivarSearchRequest(
    @SerializedName("json_schema") val jsonSchema: Json_schema,
    @SerializedName("last-post-date") val lastPostDate: Long
)