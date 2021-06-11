package com.example.p8_app.Logic;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PostJob {

    Map<String, String> parameters = new HashMap<String, String>();
    Map<String, String> imageParameters = new HashMap<String, String>();

    String _type = "POST";
    String _id = "";

    String address;
    PostJob(String address) {
        this.address = address;
    }

    void setID(String id){
        _type = "PUT";
        _id = id;
    }

    public void AddText (String name, String value){

        parameters.put(name, value);
    }

    public void SetImage(String name, String value){
        imageParameters = new HashMap<String, String>();
        imageParameters.put(name, value);
    }

    private static URL GetUrl(String subLink) throws MalformedURLException {
        return Comm.GetUrl(subLink);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String sendSecurePost() throws Exception {

        try {
            String fileName = "";
            String imageFieldName = "";

            for (Map.Entry<String, String> entry : imageParameters.entrySet()) {

                imageFieldName = entry.getKey();
                fileName = entry.getValue();
            }

            FileInputStream fileInputStream = null;

            if (fileName.isEmpty()) {
                return new Comm().sendSecurePost(address, parameters);
            }

            fileInputStream = new FileInputStream(new File(fileName));


            String lineEnd = "\r\n";
            String twoHyphens = "--";
            String boundary = "*****";

            DataOutputStream dos = null;
            DataInputStream inStream = null;

            int bytesRead, bytesAvailable, bufferSize;

            byte[] buffer;

            int maxBufferSize = 1 * 1024 * 1024 * 1024;

            if (_type.equals("PUT")) {
                address += "/" + _id;
            }

            URL url = GetUrl(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + Session.getAuth());
            conn.setRequestProperty("User-Agent", "Android Multipart HTTP Client 1.0");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

            conn.setDoInput(true);
            // Allow Outputs
            conn.setDoOutput(true);
            // Don't use a cached copy.
            conn.setUseCaches(false);


            dos = new DataOutputStream(conn.getOutputStream());

            dos.writeBytes(twoHyphens + boundary + lineEnd);
            dos.writeBytes("Content-Disposition: form-data; name=\"" + imageFieldName + "\";filename=\"" + fileName + "\"" + lineEnd);
            dos.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
            dos.writeBytes(lineEnd);

            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {
                dos.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            dos.writeBytes(lineEnd);

            for (Map.Entry<String, String> entry : parameters.entrySet()) {

                String key = entry.getKey();
                String value = entry.getValue();

                dos.writeBytes(twoHyphens + boundary + lineEnd);
                dos.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"" + lineEnd);
                dos.writeBytes("Content-Type: text/plain" + lineEnd);
                dos.writeBytes(lineEnd);
                dos.writeBytes(value);
                dos.writeBytes(lineEnd);
            }

            if (_type.equals("PUT")) {
                dos.writeBytes(twoHyphens + boundary + lineEnd);
                dos.writeBytes("Content-Disposition: form-data; name=\"_method\"" + lineEnd);
                dos.writeBytes("Content-Type: text/plain" + lineEnd);
                dos.writeBytes(lineEnd);
                dos.writeBytes("PUT");
                dos.writeBytes(lineEnd);
            }


            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

            fileInputStream.close();
            dos.flush();
            dos.close();


            if (conn.getResponseCode() != 200) {
                String err = "";
                InputStream error = conn.getErrorStream();
                for (int i = 0; i < error.available(); i++) {
                    err += (char) error.read();
                }
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
        catch (Exception ex){
            throw new Exception(ex);
        }
        finally {
            ImageFilePath.Cleanup();
        }
    }

}
