package com.mojtabahd.divar.entitiy;
import com.google.gson.annotations.SerializedName

data class Suggestion_list (

	@SerializedName("displayed_text") val displayed_text : String,
	@SerializedName("value") val value : Value
)