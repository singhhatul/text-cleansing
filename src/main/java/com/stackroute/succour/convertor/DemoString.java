package com.stackroute.succour.convertor;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DemoString {
    public static void main(String[] args) throws JSONException {
        String s="{'profiles': [{'name':'john', 'age': 44}, {'name':'Alex','age':11}]}";
        JSONObject myjson = new JSONObject(s);
        JSONArray the_json_array = myjson.getJSONArray("profiles");

        int size = the_json_array.length();
        ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
        for (int i = 0; i < size; i++) {
            JSONObject another_json_object = the_json_array.getJSONObject(i);
            //Blah blah blah...
            arrays.add(another_json_object);
        }

//Finally
        JSONObject[] jsons = new JSONObject[arrays.size()];
        arrays.toArray(jsons);

//The end...
        // Displaying the list
        System.out.println("The list is: \n");

        // Create an iterator for the list
        // using iterator() method
        Iterator<JSONObject> iter
                = arrays.iterator();

        // Displaying the values after iterating
        // through the list
        System.out.println("\nThe iterator values"
                + " of list are: ");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
            System.out.println("\n");
        }
    }
}
