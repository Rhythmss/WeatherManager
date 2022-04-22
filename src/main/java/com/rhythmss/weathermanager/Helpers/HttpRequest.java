package com.rhythmss.weathermanager.Helpers;

import com.rhythmss.weathermanager.Managers.WeatherManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    private HttpURLConnection httpURLConnection;
    private String errorResponse;
    private String successResponse;

    public void sendRequest(String endpoint, String requestMethod) throws IOException {
        httpURLConnection = (HttpURLConnection) new URL(endpoint).openConnection();
        httpURLConnection.setRequestMethod(requestMethod);
        httpURLConnection.connect();
    }

    public String getResponse() throws IOException {
        String streamRow;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;
        String response;
        boolean errorFlag = false;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        } catch (IOException e) {
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            errorFlag = true;
        }
        while((streamRow = bufferedReader.readLine()) != null){
            stringBuilder.append(streamRow);
        }
        response = stringBuilder.toString();
        if(errorFlag){
            errorResponse = response;
        }
        else{
            successResponse = response;
        }
        return response;
    }

    public String getErrorResponse() {
        if(errorResponse != null)
            return errorResponse;
        return "Not request error";
    }

    public String getSuccessResponse(){
        if(successResponse != null)
            return successResponse;
        return "Not request success response";
    }

    public int getStatusCode(){
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            return -1;
        }
    }

}
