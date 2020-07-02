package com.mojtabahd.divar.entitiy;
import com.google.gson.annotations.SerializedName

data class Post_list (

	@SerializedName("widget_type") val widget_type : String,
	@SerializedName("data") val data : Data
)