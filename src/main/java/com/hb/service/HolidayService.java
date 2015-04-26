package com.hb.service;

import android.content.Context;
import android.util.Log;

import com.hb.model.Holiday;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HolidayService {

    public static final String TAG = "HolidayService";
    public static final String HOLIDAY_JSON = "jsons/holiday.json";
    public static final String WEATHER = "weather";
    public static final String DAYS_TO_GO = "daysToGo";
    public static final String CARDS = "cards";
    public static final String CARD = "card";

    public Holiday getHolidayDetails(final Context context) {

        return parseJson(loadJSONFromAsset(context));

    }

    private String loadJSONFromAsset(final Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(HOLIDAY_JSON);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.e(TAG, "Exception in loading json");

        }
        return json;
    }

    private Holiday parseJson(final String holidayJson) {

        try {
            JSONObject jsonObject = new JSONObject(holidayJson);

            Integer weather = (Integer) jsonObject.get(WEATHER);
            Integer daysToGo = (Integer) jsonObject.get(DAYS_TO_GO);

            JSONArray jsonArray = (JSONArray) jsonObject.get(CARDS);

            List<String> cards = new ArrayList<String>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject cardJson = (JSONObject) jsonArray.get(i);
                cards.add((String) cardJson.get(CARD));
            }

            return new Holiday(weather, daysToGo, cards);
        } catch (JSONException e) {
            Log.e(TAG, "Exception in parsing json");
        }
        return null;
    }

}
