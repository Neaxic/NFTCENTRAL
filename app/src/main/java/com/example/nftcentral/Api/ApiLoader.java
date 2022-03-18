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

    private String apikey = "14ccbb27-63c0-4f86-863e-a7312bf237cb";

    protected void onPreExecute() {
        super.onPreExecute();
        // display a progress dialog to show the user what is happening
        }

    @Override
    protected String doInBackground(String... params) {
        getAccountNFTs("0xb504439D29220A07fB5efd6D881df671934C3B51");

        return null;
    }

    private void getAccountNFTs(String addr){
        try {
            URL nftPortEndpoint = new URL("https://api.nftport.xyz/v0/accounts/"+addr+"?chain=ethereum");
            HttpsURLConnection myConnection = (HttpsURLConnection) nftPortEndpoint.openConnection();
            myConnection.setRequestProperty("Authorization", apikey);
            myConnection.setRequestProperty("Content-Type", "application/json");

            if (myConnection.getResponseCode() == 200) {
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                JsonReader jsonReader = new JsonReader(responseBodyReader);
                jsonReader.beginObject();

                while (jsonReader.hasNext()) { // Loop through all keys
                    String key = jsonReader.nextName(); // Fetch the next key
                    if (key.equals("response")) { // Check if desired key
                        String value = jsonReader.nextString();
                        if(value.equals("OK")){
                            System.out.println(value);
                            String keyInner = jsonReader.nextName();
                            System.out.println(keyInner);
                            jsonReader.beginArray();
                            while(jsonReader.hasNext()){
                                jsonReader.beginObject();
                                while(jsonReader.hasNext()){
                                    if(jsonReader.nextName().equals("contract_address")){
                                        String nftContract = jsonReader.nextString();
                                        System.out.println(nftContract);
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                            }
                            jsonReader.endArray();
                        }
                        break; // Break out of the loop
                    } else {
                        jsonReader.skipValue(); // Skip values of other keys
                    }
                }
                jsonReader.close();

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
    }


}
