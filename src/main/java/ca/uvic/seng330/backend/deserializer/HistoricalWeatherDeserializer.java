package ca.uvic.seng330.backend.deserializer;

import ca.uvic.seng330.backend.entity.Weather;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class HistoricalWeatherDeserializer extends StdDeserializer<Weather> {

    public HistoricalWeatherDeserializer(){
        this(null);
    }

    public HistoricalWeatherDeserializer(Class<?> vc){
        super(vc);
    }

    @Override
    public Weather deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Weather weather = new Weather();

        JsonNode weatherNode = p.getCodec().readTree(p);
            weather.setTemp(weatherNode.get("main").get("temp").asDouble(0));
            weather.setPressure(weatherNode.get("main").get("pressure").asDouble());
            weather.setWeatherDescription(weatherNode.get("weather").get(0).get("description").asText());
            weather.setWindDirection(weatherNode.get("wind").get("deg").asDouble());
            weather.setWindSpeed(weatherNode.get("wind").get("speed").asDouble());

        return weather;
    }
}

