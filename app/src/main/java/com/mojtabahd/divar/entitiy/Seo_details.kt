package com.mojtabahd.divar.entitiy;
import com.google.gson.annotations.SerializedName

data class Seo_details (

	@SerializedName("title") val title : String,
	@SerializedName("description") val description : String,
	@SerializedName("headline") val headline : String,
	@SerializedName("canonical") val canonical : String,
	@SerializedName("meta_robots") val meta_robots : Meta_robots,
	@SerializedName("bread_crumbs") val bread_crumbs : List<Bread_crumbs>,
	@SerializedName("next") val next : String,
	@SerializedName("web_url") val web_url : String,
	@SerializedName("android_url") val android_url : String,
	@SerializedName("prev") val prev : String
)