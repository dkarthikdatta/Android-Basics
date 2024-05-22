package com.example.myapplication;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class Interview {
    public static void main(String[] args) {
        // Assuming jsonObject is the JSON object received from the function

        String jsonString = "{\"key1\":\"value1\",\"key2\":123,\"key3\":45.67,\"key4\":true}";

        // Parse the JSON string into a JsonObject
        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

//        JSONObject jsonObject = getJsonObjectFromFunction();

        // Iterate through the keys of the JSON object
//        Iterator<String> keys = jsonObject.keys();
        for (String key : jsonObject.keySet()) {
            JsonElement value = jsonObject.get(key);
            if (value.isJsonPrimitive()) {
                if (value.getAsJsonPrimitive().isString()) {
                    // Value is a String
                    String stringValue = value.getAsString();
                    System.out.println(key + ": " + stringValue);
                } else if (value.getAsJsonPrimitive().isNumber()) {
                    // Value is a Number
                    double numberValue = value.getAsDouble();
                    System.out.println(key + ": " + numberValue);
                } else if (value.getAsJsonPrimitive().isBoolean()) {
                    // Value is a Boolean
                    boolean booleanValue = value.getAsBoolean();
                    System.out.println(key + ": " + booleanValue);
                }
            }
        }

    }

    // Dummy function to simulate getting a JSONObject
    private static JSONObject getJsonObjectFromFunction() {
        // Replace this with your actual method to get the JSON object
        // For demonstration purposes, I'm just creating a sample JSON object
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("key1", "value1");
            jsonObject.put("key2", 123);
            jsonObject.put("key3", 45.67);
            jsonObject.put("key4", true);
            JSONObject nestedJsonObject = new JSONObject();
            nestedJsonObject.put("nestedKey", "nestedValue");
            jsonObject.put("key5", nestedJsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}