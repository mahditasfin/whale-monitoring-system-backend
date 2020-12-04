package ca.uvic.seng330.backend.data;

import com.google.inject.AbstractModule;

public class BinderModule extends AbstractModule {
    protected void configure(){
        bind(RestClient.class).to(OpenWeatherMapsRestClient.class); }
}

