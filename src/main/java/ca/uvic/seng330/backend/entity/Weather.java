package ca.uvic.seng330.backend.entity;

import ca.uvic.seng330.backend.deserializer.HistoricalWeatherDeserializer;
import ca.uvic.seng330.backend.Direction;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = HistoricalWeatherDeserializer.class)
public class Weather {

    private double temp;
    private double pressure;
    private String weatherDescription;
    private Direction windDirection;
    private int windSpeed;


    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp() {
        return temp;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getPressure() {
        return pressure;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWindDirection(double windDirection) {

        if ((windDirection >= 350) || (windDirection <= 15))
            this.windDirection = Direction.NORTH;
        else if ((windDirection > 15) || (windDirection < 85))
            this.windDirection = Direction.NORTHEAST;
        else if ((windDirection >= 85) || (windDirection <= 105))
            this.windDirection = Direction.EAST;
        else if ((windDirection > 105) || (windDirection < 165))
            this.windDirection = Direction.SOUTHEAST;
        else if ((windDirection >= 165) || (windDirection <= 195))
            this.windDirection = Direction.SOUTH;
        else if ((windDirection > 195) || (windDirection < 255))
            this.windDirection = Direction.SOUTHWEST;
        else if ((windDirection >= 255) || (windDirection <= 285))
            this.windDirection = Direction.WEST;
        else if ((windDirection > 285) || (windDirection < 350))
            this.windDirection = Direction.NORTHWEST;
    }


    public Direction getWindDirection() {
        return windDirection;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = (int) windSpeed;
    }

    public int getWindSpeed() {
        return windSpeed;
    }
}
