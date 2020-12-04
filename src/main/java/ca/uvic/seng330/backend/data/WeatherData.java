package ca.uvic.seng330.backend.data;

import ca.uvic.seng330.backend.Location;
import ca.uvic.seng330.backend.entity.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class WeatherData implements WeatherDao<Location, Weather> {

    private ObjectMapper mapper;
    private RestClient client;
    private String API_KEY;

    public WeatherData(String API_KEY) throws Exception {
        this.API_KEY=API_KEY;
        setupMapper();
    }
    public WeatherData() throws Exception {
        setupMapper();
    }
    @Inject
    public void setClient(RestClient client){
        this.client=client;
    }

    private void setupMapper() {
        mapper = new ObjectMapper();
    }

    public void setupRestClient(String api_key) throws Exception {

        client.setAPIKey(api_key);
    }

    @Override
    public Optional<Weather> getWeather(Location location) throws Exception {
        Optional<Weather> weather = Optional.empty();
        Map<String, String> urlParams = new LinkedHashMap<>(); //keep order

        urlParams.put("lat", String.valueOf(location.getLatitude()));
        urlParams.put("lon", String.valueOf(location.getLongitude()));
        urlParams.put("units", "metric");

        String json = client.get("weather", urlParams);

        if (json != null || !json.isBlank())
            weather = Optional.of(mapper.readValue(json, Weather.class));

        return weather;
    }

}
