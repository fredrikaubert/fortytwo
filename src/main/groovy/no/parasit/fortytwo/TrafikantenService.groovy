package no.parasit.fortytwo

import groovy.time.TimeCategory
import wslite.soap.SOAPClient

class TrafikantenService {

    def client = new SOAPClient("http://reis.trafikanten.no/topp2009/topp2009ws.asmx")

    int minTimeToDeparture = 5
    String dateFormat = "yyyy-MM-dd'T'HH:mm:ss"
    int departureStopId = 3012430  //Hovseter
    int destinationStopId = 3010011 //Jernbanetorget

    DeparturesInfo getDeparturesInfo() {
        Date after
        use(TimeCategory) {
            after = new Date() + 5.minutes
        }

        def response = client.send(SOAPAction:'http://www.trafikanten.no/GetTravelsAfter') {
            body {
                GetTravelsAfter('xmlns':'http://www.trafikanten.no/') {
                    from(departureStopId)
                    to(destinationStopId)
                    departureTime(after.format(dateFormat))
                }
            }
        }
    println response.text
    return parseResponse(response.body)
    }

    DeparturesInfo parseResponse(body) {
        def departureTimes = body.GetTravelsAfterResponse.GetTravelsAfterResult.TravelProposal.findAll {
            it.TravelStages.TravelStage.size() == 1 &&
            it.TravelStages.TravelStage[0].DepartureStop.ID.toInteger() == departureStopId &&
            it.TravelStages.TravelStage[0].ArrivalStop.ID.toInteger() == destinationStopId &&
            it.TravelStages.TravelStage[0].Transportation.text().equalsIgnoreCase("Metro")


        }.collect {
            println "The date string:" + it.DepartureTime.text()
            Date.parse(dateFormat, it.DepartureTime.text())
        }
        println "DepartureTimes from service:" + departureTimes

       new DeparturesInfo(departures: departureTimes)

    }






}
