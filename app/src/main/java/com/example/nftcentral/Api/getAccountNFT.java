package com.example.nftcentral.Api;

import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.nftcentral.Modles.NFT;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class getAccountNFT extends AsyncTask<String, Void, ArrayList<NFT>> {

    private String apikey = "14ccbb27-63c0-4f86-863e-a7312bf237cb";

    protected void onPreExecute() {
    }

    @Override
    protected ArrayList<NFT> doInBackground(String... addr) {
        ArrayList<NFT> nfts = new ArrayList();

        try {
            URL nftPortEndpoint = new URL("https://api.nftport.xyz/v0/accounts/"+addr[0]+"?chain=ethereum");
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
                            String keyInner = jsonReader.nextName();
                            jsonReader.beginArray();
                            while(jsonReader.hasNext()){
                                jsonReader.beginObject();
                                while(jsonReader.hasNext()){
                                    NFT nft = new NFT();
                                    if(jsonReader.nextName().equals("contract_address")){
                                        nft.setContract(jsonReader.nextString());
                                        nft.setOwner(addr[0]);
                                        nft.setOwner(true);
                                        if(jsonReader.nextName().equals("token_id")){
                                            nft.setToken(jsonReader.nextString());
                                        }

                                        nfts.add(nft);
                                    }
                                    else {
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
        return nfts;
    }

    @Override
    protected void onPostExecute(ArrayList<NFT> s) {
        super.onPostExecute(s);
    }
}
