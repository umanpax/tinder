package com.tinder.components.photopager

import com.tinder.model.PhotoSummary
import java.io.Serializable

data class PhotoPagerItemsAttrs(
    var photo : PhotoSummary = PhotoSummary(),
) : Serializable
