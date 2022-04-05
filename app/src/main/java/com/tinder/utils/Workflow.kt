package com.tinder.utils

import com.tinder.model.ProfileSwipable
import com.tinder.utils.Workflow.Singleton.INSTANCE
import java.io.Serializable

class Workflow : Serializable {

    var listProfiles: ArrayList<ProfileSwipable> = ArrayList()

    constructor()

    constructor(listProfiles: ArrayList<ProfileSwipable>) {
        this.listProfiles = listProfiles
    }

    /** Instance unique non préinitialisée  */
    object Singleton {
        var INSTANCE: Workflow? = null
    }


    /** Point d'accès pour l'instance unique du singleton  */
    fun getInstance(): Workflow {
        if (INSTANCE == null) {
            INSTANCE = Workflow()
        }
        return INSTANCE as Workflow
    }

    fun updateInstance(workflow: Workflow) {
        INSTANCE = workflow
    }

}