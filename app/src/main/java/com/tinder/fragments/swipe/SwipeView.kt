package com.tinder.fragments.swipe

import com.tinder.model.ProfileSwipable

interface SwipeView {
    fun handleListProfiles(response : ArrayList<ProfileSwipable>)
}