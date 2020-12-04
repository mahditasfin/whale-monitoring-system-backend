package ca.uvic.seng330.backend.data;

public enum WeatherAPI {

    CURRENT_WEATHER,
    HISTORICAL_WEATHER;

    public static String getSubDomain(WeatherAPI endpoint){
        switch (endpoint){
            case CURRENT_WEATHER:
                return "api";
            case HISTORICAL_WEATHER:
                return "history";

            default:
                return "";
        }
    }

    public static String getPath(WeatherAPI endpoint){
        switch (endpoint){
            case CURRENT_WEATHER:
                return "weather";
            case HISTORICAL_WEATHER:
                return "history/city";
            default:
                return "";
        }

    }


}
