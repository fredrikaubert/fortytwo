package no.parasit.fortytwo

import groovy.json.JsonSlurper
import groovy.time.TimeCategory
import wslite.rest.RESTClient

class TrafikantenRestService {
    int minTimeToDeparture = 5
    String dateFormat = "ddMMyyyyHHmm"
    int departureStopId = 3012430  //Hovseter
    int destinationStopId = 3010011 //Jernbanetorget

    RESTClient client = new RESTClient("http://api.trafikanten.no/reisrest")

    DeparturesInfo getDeparturesInfo() {
        Date after
        use(TimeCategory) {
            after = new Date() + 5.minutes
        }
        def response = client.get(
                path:"Travel/GetTravelsByPlaces",
                connectTimeout: 10000,
                readTimeout: 60000,
                query:[
                        time:after.format(dateFormat),
                        toplace: destinationStopId,
                        fromplace: departureStopId,
                        changeMargin: 200,
                        changePunish: 100,
                        walkingFactor: 100,
                        walkingDistance: 100,
                        isAfter: "True",
                        proposals: 10,
                        transporttypes:"Metro"

                        ],
        )
        println response.text
        return parseResponse(response.text)
    }

    DeparturesInfo parseResponse(body) {

        def json = new JsonSlurper().parseText(body)

        def departureTimes = json.GetTravelsByPlacesResult.TravelProposals.findAll {
            it.TravelStages.size() == 1 &&
                    it.TravelStages[0].DepartureStop.ID == departureStopId &&
                    it.TravelStages[0].ArrivalStop.ID == destinationStopId &&
                    it.TravelStages[0].Transportation == 8 //Metro


        }.collect {
            def ( secs, timezone) = it.DepartureTime.toString()[6..-3].split('\\+').collect{it as Long}
            return new Date(secs)
        }
        println "DepartureTimes from service:" + departureTimes

        new DeparturesInfo(departures: departureTimes)

    }






}
