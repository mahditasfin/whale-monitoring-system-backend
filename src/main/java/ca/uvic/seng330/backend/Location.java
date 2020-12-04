package ca.uvic.seng330.backend;

/**
 * Location details and associated methods
 */
public class Location {
    private double latitude;
    private double longitude;

    /**
     * Default constructor
     */
    public Location(){
        latitude = 0;
        longitude = 0;
    }

    /**
     * Get Latitude of Location
     * @return double - Latitude of whale observation
     */
    public double getLatitude() {
        return latitude;
    }


    /**
     * Get Longitude of Location
     * @return double - Longitude of whale observation
     */
    public double getLongitude() {
        return longitude;
    }


    /**
     * Copy constructor. Copies field variables
     * @param other - Location object to be copied
     */
    public Location(Location other){
        if(other != null){
            this.latitude = other.latitude;
            this.longitude = other.longitude;
        }
    }

    public Location(double longitude, double latitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
