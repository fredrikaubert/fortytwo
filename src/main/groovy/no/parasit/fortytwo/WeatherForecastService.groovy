package no.parasit.fortytwo

class WeatherForecastService {
    def url = "http://www.yr.no/sted/Norge/Oslo/Oslo/Oslo/varsel.xml"



    WeatherForecast getWeatherForecast() {
        Date now = new Date()
        def slurper = new XmlSlurper().parse(url)
        def temp = slurper.forecast.tabular.time[0].temperature.@value.text()  as Integer
        def symbol = slurper.forecast.tabular.time[0].symbol.@number.text()
        WeatherForecast weatherForecast = new WeatherForecast(temp: temp, shouldTakeUmbrella: true, weatherSymbolUrl:symbolUrl(symbol) )

    }



    String symbolUrl(String symbol) {
        "http://api.yr.no/weatherapi/weathericon/1.0/?symbol=${symbol};content_type=image/png"
    }

}
