package ca.uvic.seng330.backend.data;


public interface RestClientFactory {
   RestClient create(String api_key);
}
