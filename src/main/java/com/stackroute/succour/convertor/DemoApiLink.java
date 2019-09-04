package com.stackroute.succour.convertor;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DemoApiLink {
    public static void main(String[] args) {
        //inline will store the JSON data streamed in string format
        String inline = "";

        try {
            URL url = new URL("https://newsapi.org/v2/top-headlines?" +
                    "country=us&" +
                    "apiKey=018ac7c4b5be4c1f934c29a1d8e51bca");
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();

            //Scanner functionality will read the JSON data from the stream
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext()) {
                inline += sc.nextLine();
            }
            System.out.println("\nJSON Response in String format");
            System.out.println(inline);
//                    //Close the stream when reading the data has been finished
//                    sc.close();


            JSONObject myjson = new JSONObject(inline);
            JSONArray the_json_array = myjson.getJSONArray("articles");

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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

