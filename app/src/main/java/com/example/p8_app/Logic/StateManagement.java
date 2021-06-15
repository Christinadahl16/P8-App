package com.example.p8_app.Logic;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StateManagement {
    Map<String, JSONArray> state;

    StateManagement(){
        state = new HashMap<>();
    }

    public void SetState(String dataSource, JSONArray stateData){
        state.put(dataSource, stateData);
    }


    public void AddState(String dataSource, JSONObject stateData){

        JSONArray jsonArray = GetState(dataSource);
        if (jsonArray == null)
            return;

        jsonArray.put(stateData);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void DeleteState(String dataSource, String id){

        JSONArray jsonArray = GetState(dataSource);
        if (jsonArray == null)
            return;
        int jsonArrayLength = jsonArray.length();
        try {
            for (int i = 0; i < jsonArrayLength; i++){
                JSONObject jsonObject = null;

                jsonObject = jsonArray.getJSONObject(i);
                String jsonID = jsonObject.getString("id");

                if (jsonID.equals(id))
                {
                    jsonArray.remove(i);
                }
            }
        } catch (JSONException e) {
        }
    }


    public void UpdateState(String dataSource, JSONObject stateData){

        JSONArray jsonArray = GetState(dataSource);
        if (jsonArray == null)
            return;
        int jsonArrayLength = jsonArray.length();
        try {
            String id = stateData.getString("id");
            for (int i = 0; i < jsonArrayLength; i++){
                JSONObject jsonObject = null;

                jsonObject = jsonArray.getJSONObject(i);
                String jsonID = jsonObject.getString("id");

                if (jsonID.equals(id))
                {
                    jsonArray.put(i, stateData);
                }
            }
        } catch (JSONException e) {
        }

    }


    public JSONObject GetEntryByID(String dataSource, String id){
        JSONArray jsonArray = GetState(dataSource);
        if (jsonArray == null)
            return null;

        int jsonArrayLength = jsonArray.length();
        try {
            for (int i = 0; i < jsonArrayLength; i++){
                JSONObject jsonObject = null;

                    jsonObject = jsonArray.getJSONObject(i);
                    String jsonID = jsonObject.getString("id");

                    if (jsonID.equals(id))
                        return jsonObject;

            }

            return null;

        } catch (JSONException e) {
            return null;
        }

    }

    public JSONArray GetState(String dataSource){
        if (state.containsKey(dataSource)){
            JSONArray array = state.get(dataSource);
            if (array.length() == 0)
                return null;

            return array;
        }
        return null;
    }

}
