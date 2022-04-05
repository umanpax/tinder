package com.tinder.fragments.swipe

import com.tinder.model.PhotoSummary
import com.tinder.model.ProfileSwipable
import com.tinder.utils.Workflow

class SwipePresenter(
    var view: SwipeFragment,
    var workflow: Workflow
) {

    fun getProfilesToSwipe() {
        val listProfiles = ArrayList<ProfileSwipable>()

        val photosP1 = ArrayList<PhotoSummary>()
        val hobbiesP1 = ArrayList<String>()
        hobbiesP1.add("Guitare")
        hobbiesP1.add("Piano")
        hobbiesP1.add("Piscine")
        photosP1.add(
            PhotoSummary(
                0,
                "",
                hobbiesP1,
                "Je recherche un homme grand, beau et fort !",
                "Master 2 compta",
                "Expert Comptable",
                "Gémeaux",
                false
            )
        )
        val p1 = ProfileSwipable()
        p1.id = 0
        p1.username = "Sandra"
        p1.age = 32
        p1.isAMatch = false
        p1.isCheckedProfile = true
        p1.photos = photosP1


        val photosP2 = ArrayList<PhotoSummary>()
        val hobbiesP2 = ArrayList<String>()
        hobbiesP2.add("Danse")
        hobbiesP2.add("Shopping")
        hobbiesP2.add("Cinéma")
        photosP2.add(
            PhotoSummary(
                0,
                "",
                hobbiesP2,
                "Je recherche un homme simple et gentil !",
                "License en informatique",
                "Data scientist",
                "Taureau",
                false
            )
        )
        val p2 = ProfileSwipable()
        p2.id = 1
        p2.username = "Charlotte"
        p2.age = 28
        p2.isAMatch = false
        p2.isCheckedProfile = true
        p2.photos = photosP2


        val photosP3 = ArrayList<PhotoSummary>()
        val hobbiesP3 = ArrayList<String>()
        hobbiesP3.add("Frisbi")
        hobbiesP3.add("Ponney")
        hobbiesP3.add("Chasse")
        photosP3.add(
            PhotoSummary(
                0,
                "",
                hobbiesP2,
                "Je sais pas trop ce que je veux !",
                "Indépendant",
                "Astronaute",
                "Capricorne",
                true
            )
        )
        val p3 = ProfileSwipable()
        p3.id = 2
        p3.username = "Lorène"
        p3.age = 35
        p3.isAMatch = false
        p3.isCheckedProfile = false
        p3.photos = photosP3

        listProfiles.add(p1)
        listProfiles.add(p2)
        listProfiles.add(p3)
        view.handleListProfiles(listProfiles)

    }

}