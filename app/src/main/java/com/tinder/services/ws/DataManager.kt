package com.tinder.services.ws

import com.tinder.services.ServiceGenerator


/**
 * Created by pierre-alexandrevezinet on 24/03/2022.
 *
 */
class DataManager {

    var baseUrl: String = ""
    var serviceGenerator: ServiceGenerator

    /**
     * @param baseUrl
     */
    constructor(baseUrl: String) {
        this.baseUrl = baseUrl
        serviceGenerator = ServiceGenerator(baseUrl)
    }

}



