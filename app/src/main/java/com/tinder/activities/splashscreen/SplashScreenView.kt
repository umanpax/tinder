package com.tinder.activities.splashscreen

import com.tinder.model.ProfileSwipable


interface SplashScreenView{
    fun handleProfilesToSwipe(response : ArrayList<ProfileSwipable>)
    fun toggleError(response : String)
}