package com.example.nftcentral.Api;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.nftcentral.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ApiLoader extends AsyncTask<String, String, String> {

    /*
    onPreExecute(): This method runs on the UI thread, and is used for setting up your task (like showing a progress bar).
    doInBackground(): This is where you implement the code to execute the work that is to be performed on the separate thread.
    onProgressUpdate(): This is invoked on the UI thread and used for updating progress in the UI (such as filling up a progress bar).
    onPostExecute(): Again on the UI thread, this is used for updating the results to the UI once the AsyncTask has finished loading.
     */

    protected void onPreExecute() {
        super.onPreExecute();
        // display a progress dialog to show the user what is happening
        }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL nftPortEndpoint = new URL("https://api.nftport.xyz/v0/transactions/stats/0x4db1f25d3d98600140dfc18deb7515be5bd293af?chain=ethereum");
            HttpsURLConnection myConnection = (HttpsURLConnection) nftPortEndpoint.openConnection();
            myConnection.setRequestProperty("Authorization", "14ccbb27-63c0-4f86-863e-a7312bf237cb");

            if (myConnection.getResponseCode() == 200) {
                System.out.println("Success! "+myConnection.getResponseMessage());
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                JsonReader jsonReader = new JsonReader(responseBodyReader);
                System.out.println(jsonReader);

                // dismiss the progress dialog after receiving data from API

                jsonReader.beginObject(); // Start processing the JSON object
                while (jsonReader.hasNext()) { // Loop through all keys
                    String key = jsonReader.nextName(); // Fetch the next key
                    System.out.println(key);

                    /*
                    if (key.equals("organization_url")) { // Check if desired key
                        // Fetch the value as a String
                        String value = jsonReader.nextString();

                        // Do something with the value
                        // ...

                        break; // Break out of the loop
                    } else {
                        jsonReader.skipValue(); // Skip values of other keys
                    }*/
                }

                myConnection.disconnect();
            } else {
                System.out.println(myConnection.getResponseCode() + ", " + myConnection.getResponseMessage());
                myConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
