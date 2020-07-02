package com.mojtabahd.divar.entitiy;
import com.google.gson.annotations.SerializedName

data class Web_image (

	@SerializedName("src") val src : String,
	@SerializedName("type") val type : String
)