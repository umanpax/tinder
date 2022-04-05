package com.tinder.activities.splashscreen

import android.content.Intent
import androidx.core.app.ActivityCompat
import com.tinder.activities.base.BaseActivity
import com.tinder.model.PhotoSummary
import com.tinder.model.ProfileSwipable
import com.tinder.services.ws.DataManager
import com.tinder.utils.Workflow

class SplashScreenPresenter(var view: SplashScreenActivity, var workflow: Workflow) {

    private lateinit var dataManagerAccessor: DataManager

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
                "https://cdn.pixabay.com/photo/2019/10/09/01/29/girl-4536244_960_720.jpg",
                hobbiesP1,
                "Je recherche un homme grand, beau et fort !",
                "Master",
                "Comptable",
                "Gémeaux",
                false
            )
        )
        photosP1.add(
            PhotoSummary(
                0,
                "https://cdn.pixabay.com/photo/2019/10/09/01/29/girl-4536244_960_720.jpg",
                hobbiesP1,
                "Je recherche un homme grand, beau et fort !",
                "Master",
                "Comptable",
                "Gémeaux",
                false
            )
        )
        photosP1.add(
            PhotoSummary(
                0,
                "https://cdn.pixabay.com/photo/2019/10/09/01/29/girl-4536244_960_720.jpg",
                hobbiesP1,
                "Je recherche un homme grand, beau et fort !",
                "Master",
                "Comptable",
                "Gémeaux",
                false
            )
        )
        photosP1.add(
            PhotoSummary(
                0,
                "https://cdn.pixabay.com/photo/2019/10/09/01/29/girl-4536244_960_720.jpg",
                hobbiesP1,
                "Je recherche un homme grand, beau et fort !",
                "Master",
                "Comptable",
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
                "https://www.benouaiche.com/wp-content/uploads/2018/12/femme-cinquantaine-medecine-chirurgie-esthetique-dr-benouaiche-paris.jpg",
                hobbiesP2,
                "Je recherche un homme simple et gentil !",
                "License",
                "Vente",
                "Taureau",
                false
            )
        )
        photosP2.add(
            PhotoSummary(
                0,
                "https://www.benouaiche.com/wp-content/uploads/2018/12/femme-cinquantaine-medecine-chirurgie-esthetique-dr-benouaiche-paris.jpg",
                hobbiesP2,
                "Je recherche un homme simple et gentil !",
                "License",
                "Vente",
                "Taureau",
                false
            )
        )
        photosP2.add(
            PhotoSummary(
                0,
                "https://www.benouaiche.com/wp-content/uploads/2018/12/femme-cinquantaine-medecine-chirurgie-esthetique-dr-benouaiche-paris.jpg",
                hobbiesP2,
                "Je recherche un homme simple et gentil !",
                "License",
                "Vente",
                "Taureau",
                false
            )
        )
        photosP2.add(
            PhotoSummary(
                0,
                "https://www.benouaiche.com/wp-content/uploads/2018/12/femme-cinquantaine-medecine-chirurgie-esthetique-dr-benouaiche-paris.jpg",
                hobbiesP2,
                "Je recherche un homme simple et gentil !",
                "License",
                "Vente",
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
                "https://media.cyrillus.fr/Pictures/cyrillus/119593/debardeur-volante-en-lin-femme.jpg",
                hobbiesP2,
                "Je sais pas trop ce que je veux !",
                "HEC",
                "CEO",
                "Capricorne",
                true
            )
        )
        photosP3.add(
            PhotoSummary(
                0,
                "https://media.cyrillus.fr/Pictures/cyrillus/119593/debardeur-volante-en-lin-femme.jpg",
                hobbiesP2,
                "Je sais pas trop ce que je veux !",
                "HEC",
                "CEO",
                "Capricorne",
                true
            )
        )
        photosP3.add(
            PhotoSummary(
                0,
                "https://media.cyrillus.fr/Pictures/cyrillus/119593/debardeur-volante-en-lin-femme.jpg",
                hobbiesP2,
                "Je sais pas trop ce que je veux !",
                "HEC",
                "CEO",
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
        view.handleProfilesToSwipe(listProfiles)

    }


    fun toTinder() {
        ActivityCompat.finishAffinity(view)
        val intent = Intent(view, BaseActivity::class.java)
        view.startActivity(intent)
    }


}