package ca.uvic.seng330.backend.data;

import java.util.Map;

public interface  RestClient {
    String get(String endpoint, Map<String,String> params) throws Exception;
    String post(String body) throws Exception;
    String put(String body) throws Exception;
    String delete(String body) throws Exception;
    void setAPIKey(String API);
}
