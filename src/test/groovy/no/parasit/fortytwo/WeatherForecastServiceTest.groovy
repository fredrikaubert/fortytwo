package no.parasit.fortytwo

import org.junit.Test

class WeatherForecastServiceTest {

    WeatherForecastService weatherForecastService = new WeatherForecastService()


    @Test
    void testWeatherForecast() {
        def w = weatherForecastService.weatherForecast
        assert w.temp == 16



//        assert w.shouldTakeUmbrella == false
//        assert null != w



    }


}
