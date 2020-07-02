package com.mojtabahd.divar.entitiy;
import com.google.gson.annotations.SerializedName

data class SearchResponse (

	@SerializedName("suggestion_list") val suggestion_list : List<Suggestion_list>,
	@SerializedName("input_suggestion") val input_suggestion : Input_suggestion,
	@SerializedName("title") val title : String,
	@SerializedName("subtitle") val subtitle : String,
	@SerializedName("seo_details") val seo_details : Seo_details,
	@SerializedName("last_post_date") val last_post_date : Long,
	@SerializedName("first_post_date") val first_post_date : Long,
	@SerializedName("web_widgets") val web_widgets : Web_widgets,
	@SerializedName("widget_list") val widget_list : List<Widget_list>

)