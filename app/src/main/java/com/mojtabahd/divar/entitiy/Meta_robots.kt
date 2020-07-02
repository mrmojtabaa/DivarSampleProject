package com.mojtabahd.divar.entitiy;
import com.google.gson.annotations.SerializedName

data class Meta_robots (

	@SerializedName("index") val index : Boolean,
	@SerializedName("follow") val follow : Boolean
)