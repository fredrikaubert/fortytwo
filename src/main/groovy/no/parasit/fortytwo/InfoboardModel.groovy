package no.parasit.fortytwo

import groovyx.javafx.beans.FXBindable
import javafx.scene.paint.Color


@FXBindable
class InfoboardModel {
    String pictureUrl = "https://www.google.no/images/srpr/logo4w.png"
    Integer temperature = 15
    String weatherIcon = "https://www.google.no/images/srpr/logo4w.png"
    ObservableList departures = [new Date(), new Date(), new Date(), new Date(), new Date()]
    @FXBindable Date currentTime = new Date()
    Color slot1Color = Color.RED
    Color slot2Color = Color.IVORY
    Color slot3Color = Color.IVORY
    Color slot4Color = Color.IVORY
    Color slot5Color = Color.IVORY
}
