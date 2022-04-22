package com.rhythmss.weathermanager.Managers;

import com.rhythmss.weathermanager.Constants.EndpointsList;
import com.rhythmss.weathermanager.Helpers.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;

import static com.rhythmss.weathermanager.Constants.EndpointsList.*;

public class WeatherManager {

    public static final String BASE_ENDPOINT = "https://api.openweathermap.org/data/2.5";
    private HttpRequest httpRequest;
    private final String apiKey;

    public WeatherManager(String apiKey) {
        httpRequest = new HttpRequest();
        this.apiKey = apiKey;
    }

    public String getCurrentWeatherData(double lat, double lon) throws IOException {
        return getStringResponse(CURRENT_WEATHER_ENDPOINT + "?lon=" + lon + "&lat=" + lat, "GET");
    }

    public JSONObject getJSONCurrentWeatherData(double lat, double lon) throws IOException {
        return new JSONObject(getCurrentWeatherData(lat, lon));
    }
    private String getStringResponse(String endpoint, String method) throws IOException {
        httpRequest.sendRequest(BASE_ENDPOINT + endpoint + "&appid=" + apiKey, method);
        return httpRequest.getResponse();
    }

    public String getApiKey() {
        return apiKey;
    }


}
