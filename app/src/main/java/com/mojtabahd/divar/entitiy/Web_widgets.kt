package com.mojtabahd.divar.entitiy;
import com.google.gson.annotations.SerializedName

data class Web_widgets (

	@SerializedName("post_list") val post_list : List<Post_list>,
	@SerializedName("toolbox") val toolbox : List<String>
)