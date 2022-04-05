package com.tinder.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PhotoSummary(
    @SerializedName("id")
    @Expose var id: Int? = null,

    @SerializedName("url")
    @Expose var url: String ? = null,

    @SerializedName("listHobbies")
    @Expose var listHobbies: ArrayList<String>? = null,

    @SerializedName("path")
    @Expose var description : String? = null,

    @SerializedName("studies")
    @Expose var studies : String? = null,

    @SerializedName("job")
    @Expose var job : String? = null,

    @SerializedName("astro")
    @Expose var astro : String? = null,

    @SerializedName("smoke")
    @Expose var smoke : Boolean? = null,


) : Serializable
