package ca.uvic.seng330.backend.data;

import ca.uvic.seng330.backend.entity.StatusMessage;
import ca.uvic.seng330.backend.exceptions.HttpErrorException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class OpenWeatherMapsRestClient implements RestClient{

    private String BASE = "openweathermap.org";
    private final OkHttpClient client;
    private String API_KEY;

    public OpenWeatherMapsRestClient() throws Exception {
        client = new OkHttpClient();
        if (!testConnectivity())
            throw new Exception("Did not successfully connect to OpenWeatherMaps!");
    }

    public String get(String endpoint, Map<String, String> parameters) throws IOException, HttpErrorException {
        HttpUrl url = buildUrl(endpoint, parameters);

        Request getRequest = new Request.Builder().url(url).build();

        try(Response response = client.newCall(getRequest).execute()){

            if (!response.isSuccessful()){
                StatusMessage message = new ObjectMapper().readValue(response.body().string(), StatusMessage.class);
                throw new HttpErrorException(message);
            }


            if (response.body() != null)
                return response.body().string();
            else
                return "";
        }
    }
    @Override
    public void setAPIKey(String API_KEY){
        this.API_KEY=API_KEY;
    }

    @Override
    public String post(String body) throws Exception {
        return null;
    }

    @Override
    public String put(String body) throws Exception {
        return null;
    }

    @Override
    public String delete(String body) throws Exception {
        return null;
    }


    private boolean testConnectivity() {
        try {
            final URL url = new URL("https://" + BASE);
            final HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();
            if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public HttpUrl buildUrl(String endpoint, Map<String, String> parameters) {

        HttpUrl.Builder builder = new HttpUrl.Builder()
                .scheme("http")
                .host("api." + BASE)
                .addPathSegment("data")
                .addPathSegment("2.5")
                .addPathSegment(endpoint);

        for (String parameter : parameters.keySet()){
            builder.addQueryParameter(parameter, parameters.get(parameter));
        }

        builder.addQueryParameter("appid", API_KEY);

        System.out.println(builder.build().toString());

        return builder.build();
    }


}
