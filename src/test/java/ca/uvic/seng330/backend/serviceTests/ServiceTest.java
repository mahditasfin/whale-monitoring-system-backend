package ca.uvic.seng330.backend.serviceTests;

import ca.uvic.seng330.backend.Location;
import ca.uvic.seng330.backend.data.BinderModule;
import ca.uvic.seng330.backend.data.WeatherData;
import ca.uvic.seng330.backend.entity.Weather;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ServiceTest {


    @Test
    public void testcall() throws Exception {
        Injector guice= Guice.createInjector(new BinderModule());
        WeatherData weatherData=guice.getInstance(WeatherData.class);



        //WeatherData d = new WeatherData("158eea8747b6c3582ef648615c4afc64");
        weatherData.setupRestClient("158eea8747b6c3582ef648615c4afc64");
        Location vancouver = new Location( 123, 49.2827);

        Optional<Weather> weatherOptional = weatherData.getWeather(vancouver);

        if (weatherOptional.isPresent()){
            Weather w = weatherOptional.get();

            System.out.println(w.getTemp() + " C");
            System.out.println(w.getPressure() + " kPA");
            System.out.println(w.getWeatherDescription());
            System.out.println(w.getWindDirection().toString());
            System.out.println(w.getWindSpeed() + " km/h");

        }

    }
}
