package com.example.p8_app.Logic;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Comm {

    private static String url = "http://192.168.1.111:8000/api/";

    public static URL GetUrl(String subLink) throws MalformedURLException {
        return new URL(url + subLink);
    }


    public static  String MapToParametersToLaravel(Map<String, String> parametersMap){
        StringBuilder parametersString = new StringBuilder();

        for (Map.Entry<String, String> entry : parametersMap.entrySet()) {

            if (parametersString.length() > 0)
                parametersString.append("&");

            parametersString.append("/" + entry.getValue());
        }

        return parametersString.toString();
    }


    public static  String MapToParameters(Map<String, String> parametersMap){
        StringBuilder parametersString = new StringBuilder();

        for (Map.Entry<String, String> entry : parametersMap.entrySet()) {

            if (parametersString.length() > 0)
                parametersString.append("&");

            parametersString.append(entry.getKey() + "=" + entry.getValue());
        }

        return parametersString.toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String sendSecurePost(String address, Map<String, String> parameters) throws Exception {

        String urlParameters = MapToParameters(parameters);
        byte[] postData  = urlParameters.getBytes( StandardCharsets.UTF_8 );
        int    postDataLength = postData.length;

        URL url = GetUrl(address);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Bearer "+Session.getAuth());
        conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        conn.setUseCaches( false );
        conn.setDoOutput(true);
        conn.getOutputStream().write(postData);


        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;

        StringBuilder sb = new StringBuilder();

        while ((output = br.readLine()) != null) {
            sb.append(output);
        }
        conn.disconnect();

        return sb.toString();

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String sendSecureGet(String address, Map<String, String> parameters) throws Exception {

            return sendSecureSend("GET", address, parameters);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String sendSecureDelete(String address, Map<String, String> parameters) throws Exception {

        return sendSecureSend("DELETE", address, parameters);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String sendSecureSend(String Method, String address, Map<String, String> parameters) throws Exception {

        String urlParameters = MapToParametersToLaravel(parameters);
        URL url;

        if (urlParameters.isEmpty())
            url = GetUrl(address);
        else
            url = GetUrl(address + urlParameters);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", "Bearer "+Session.getAuth());
        conn.setRequestMethod(Method);
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;

        StringBuilder sb = new StringBuilder();

        while ((output = br.readLine()) != null) {
            sb.append(output);
        }
        conn.disconnect();

        return sb.toString();

    }




    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String sendPost(String address, Map<String, String> parameters) throws Exception {

            String urlParameters = MapToParameters(parameters);
            byte[] postData  = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int    postDataLength = postData.length;

            URL url = GetUrl(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
            conn.setUseCaches( false );
            conn.setDoOutput(true);
            conn.getOutputStream().write(postData);


            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            StringBuilder sb = new StringBuilder();

            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();

            return sb.toString();

    }

    public String sendGet(String address, Map<String, String> parameters) throws Exception {

        String urlParameters = MapToParameters(parameters);

        URL url = new URL(address + "?" + urlParameters);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setUseCaches( false );
        conn.setDoOutput(true);

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;

        StringBuilder sb = new StringBuilder();

        while ((output = br.readLine()) != null) {
            sb.append(output);
        }
        conn.disconnect();

        return sb.toString();

    }
}
