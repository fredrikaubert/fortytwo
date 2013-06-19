package no.parasit.fortytwo

import groovy.time.TimeCategory
import javafx.scene.control.ScrollPane
import javafx.scene.image.Image
import javafx.scene.paint.Color

import static groovyx.javafx.GroovyFX.start


final tickerFont = '42pt sanserif'
final Integer goodTime = 13
final Integer badTime =  10
final Integer impossibleTime = 9
final int width = 640
final int height = 363

start {
    def model = new InfoboardModel()
    TrafikantenRestService trafikantenService = new TrafikantenRestService()
    RSSPictureFeed pictureFeed = new RSSPictureFeed()
    WeatherForecastService weatherForecastService = new WeatherForecastService()
    def forecas = weatherForecastService.weatherForecast

    model.pictureUrl = pictureFeed.getNextPicture()
    model.weatherIcon = forecas.weatherSymbolUrl
    model.temperature = forecas.temp
    model.departures = trafikantenService.departuresInfo.departures
    def departureTexts = []

    String dateFormat = "HH:mm"
    stage(title: 'GroovyFX Hello World', visible: true) {
        scene(fill: BLACK, width: width, height: height) {


            stackPane {
                imageView(fitWidth:width, smooth:true, cache:true, preserveRatio:true, image: bind(model.pictureUrl()).using({new Image(it)}) )

                borderPane(prefWidth: width, prefHeight: height) { //clock
                   left(align: LEFT, margin: [0, 10, 0, 1]) {
                       stackPane( alignment: "top_right") {
                       text(text:bind(model.currentTime()).using({it.format(dateFormat)}), font:tickerFont) {
//                           constraint(row:0, column:0, halignment: "left")
                           fill Color.IVORY
                           effect dropShadow(color: WHITE, radius: 25, spread: 0.25)
                       }
                       }
                   }


                   right(align: CENTER, margin: [0, 10, 0, 1]) {
                        stackPane( alignment: "top_right", width:100, height:160) { //weather
                            rectangle( width: 100, height:160, opacity:0.5, alignment:"top_center"  ) {
                                fill GRAY
                                effect dropShadow()
                            }
                            vbox(padding: 10, spacing:15, width:100, height:160,alignment: "top_center" ) {
                                imageView( image: bind(model.weatherIcon()).using({new Image(it, 70, 0, true, true)})  )
                                text( text: bind(model.temperature()).using({it.toString()}), font: tickerFont) {
                                    fill Color.IVORY
                                    effect dropShadow(color: WHITE, radius: 25, spread: 0.25)
                                }
                            }
                        }
                   }
                   bottom(align: BOTTOM_LEFT, margin: [0, 0, 10, 0]) {

                       stackPane() {  //trafikanten
                           rectangle(x:0, y:0, width: width, height:50, opacity:0.5,  ) {
                               fill GRAY
                               effect dropShadow()
                           }

                           scrollPane(margin: [0, 0, 0, 0],height:50, pannable:false, hbarPolicy: ScrollPane.ScrollBarPolicy.NEVER, vbarPolicy: ScrollPane.ScrollBarPolicy.NEVER, prefViewportHeight:55,style: "-fx-background-color: transparent;" ) {
                               //
                               hbox(padding:[0,0,0,5], spacing: 15, width:800, height:50) {

                                   departureTexts << text( text: bind(model.departures()).using({it.size > 0 ? it[0].format(dateFormat) : ""}), font: tickerFont) {
                                        fill Color.IVORY
                                        effect dropShadow(color: WHITE, radius: 25, spread: 0.25)
                                    }
                                   departureTexts << text( text: bind(model.departures()).using({it.size > 1 ? it[1].format(dateFormat) : ""}), font: tickerFont) {
                                        fill  Color.IVORY
                                        effect dropShadow(color: Color.WHITE, radius: 25, spread: 0.25)

                                        //  stroke: bind(model.currentTime()).using({BLUE})
                                    }
                                   departureTexts << text( text: bind(model.departures()).using({it.size > 2 ? it[2].format(dateFormat) : ""}), font: tickerFont)  {
                                       fill Color.IVORY
                                       effect dropShadow(color: Color.WHITE, radius: 25, spread: 0.25)

                                   }
                                   departureTexts << text( text: bind(model.departures()).using({it.size > 3 ? it[3].format(dateFormat) : ""}), font: tickerFont){
                                       fill Color.IVORY
                                       effect dropShadow(color: Color.WHITE, radius: 25, spread: 0.25)
                                   }

                                   departureTexts << text( text: bind(model.departures()).using({it.size > 4 ? it[4].format(dateFormat) : ""}), font: tickerFont){
                                       fill Color.IVORY
                                       effect dropShadow(color: Color.WHITE, radius: 25, spread: 0.25)
                                   }
                               }
                           }
                       }


                   }

                }
            }

//            hbox(padding:0, width:100, height: 500) {
//                text(text:"15", font:'20pt sanserif') {
//
//                }
//
//                imageView(viewport: [0,0, 400, 400], "http://api.met.no/weatherapi/weathericon/1.0/?symbol=5;content_type=image/png", )
//
//
//                imageView "file://Users/fredrik/Downloads/meteocons-icons/SVG/1.svg"
//
//            }
        }
    }


    sequentialTransition(cycleCount: INDEFINITE) {
        pauseTransition(1.s) {
            onFinished {
                model.currentTime = new Date()
                use(TimeCategory) {
                       model.departures.eachWithIndex { date, idx ->
                           if(departureTexts.size > idx) {
                               if(model.currentTime + impossibleTime.minutes > date ){
                                    departureTexts[idx].fill = RED
                               } else if(model.currentTime + badTime.minutes > date ) {
                                   departureTexts[idx].fill = YELLOW
                               } else if(model.currentTime + goodTime.minutes > date ) {
                                   departureTexts[idx].fill = LIGHTGREEN
                               } else {
                                   departureTexts[idx].fill = IVORY
                               }
                           }
                       }

                }
            }
        }
    }.playFromStart()


    sequentialTransition(cycleCount: INDEFINITE) {
        pauseTransition(60.s) {
            onFinished {
                model.pictureUrl = pictureFeed.nextPicture
            }
        }
    }.playFromStart()


    sequentialTransition(cycleCount: INDEFINITE) {
        pauseTransition(1800.s) {
            onFinished {
                def forecast = weatherForecastService.weatherForecast
                model.temperature = forecast.temp
                model.weatherIcon = forecast.weatherSymbolUrl
            }
        }
    }.playFromStart()



    sequentialTransition(cycleCount: INDEFINITE) {
        pauseTransition(120.s) {
            onFinished {
                model.departures = trafikantenService.departuresInfo.departures
            }
        }
    }.playFromStart()
}
