package com.tinder.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProfileSwipable(
    @SerializedName("id")
    @Expose var id: Int? = null,

    @SerializedName("username")
    @Expose var username: String? = null,

    @SerializedName("age")
    @Expose var age: Int? = null,

    @SerializedName("age")
    @Expose var photos: ArrayList<PhotoSummary>? = null,

    @SerializedName("is_a_match")
    @Expose var isAMatch : Boolean? = null,

    @SerializedName("is_checked_profile")
    @Expose var isCheckedProfile : Boolean? = null,


    ) : Serializable
