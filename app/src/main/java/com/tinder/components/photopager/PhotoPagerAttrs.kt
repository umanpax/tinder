package com.tinder.components.photopager

import java.io.Serializable

data class PhotoPagerAttrs(
    var mPhotoPagerItemsAttrs : ArrayList<PhotoPagerItemsAttrs> = ArrayList()
) : Serializable