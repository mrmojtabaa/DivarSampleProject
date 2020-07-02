package com.mojtabahd.divar.entitiy;

import com.google.gson.annotations.SerializedName

data class Data (

	@SerializedName("title") val title : String,
	@SerializedName("image") val image : String,
	@SerializedName("web_image") val web_image : List<Web_image>,
	@SerializedName("description") val description : String,
	@SerializedName("has_chat") val has_chat : Boolean,
	@SerializedName("red_text") val red_text : String,
	@SerializedName("normal_text") val normal_text : String,
	@SerializedName("token") val token : String,
	@SerializedName("image_overlay_tag") val image_overlay_tag : String,
	@SerializedName("index") val index : Int,
	@SerializedName("city") val city : String,
	@SerializedName("district") val district : String,
	@SerializedName("category") val category : String
)