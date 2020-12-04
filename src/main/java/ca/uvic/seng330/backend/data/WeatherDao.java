package ca.uvic.seng330.backend.data;

import java.util.Optional;

public interface WeatherDao<ID, T> {

    Optional<T> getWeather(ID id) throws Exception;
}
