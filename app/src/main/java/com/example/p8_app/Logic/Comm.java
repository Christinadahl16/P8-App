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

    private static String url = "http://192.168.0.88/api/";

    private static URL GetUrl(String subLink) throws MalformedURLException {
        return new URL(url + subLink);
    }

    private String MapToParameters(Map<String, String> parametersMap){
        StringBuilder parametersString = new StringBuilder();

        for (Map.Entry<String, String> entry : parametersMap.entrySet()) {

            if (parametersString.length() > 0)
                parametersString.append("&");

            parametersString.append(entry.getKey() + "=" + entry.getValue());
        }

        return parametersString.toString();
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
