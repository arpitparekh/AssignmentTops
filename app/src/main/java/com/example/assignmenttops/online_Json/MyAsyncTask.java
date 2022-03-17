package com.example.assignmenttops.online_Json;

import android.os.AsyncTask;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyAsyncTask extends AsyncTask<String,Void,String> {

        ////////////////////
    private String requestUrl;
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
        ///////////////////

    ////////////////////////////////

    private onResponseListener listener ;
    public void setListener(onResponseListener listener) {
        this.listener = listener;
    }
    public interface onResponseListener {
        void onResponse(String response);
    }
    /////////////////////////////


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
//        String response=fetchDataFromUrl(requestUrl);
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(requestUrl)

                .build();
        try {
            Response response=client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        listener.onResponse(s);

    }

//    private String fetchDataFromUrl(String requestUrl) {
//
//        try {
//            URL theUrl=new URL(requestUrl);
//            HttpURLConnection conn= (HttpURLConnection) theUrl.openConnection();
//            conn.setReadTimeout(30000);
//            conn.setConnectTimeout(60000);
//
//            int responseCode=conn.getResponseCode();
//            String response="";
//
//            if(responseCode==HttpURLConnection.HTTP_OK){
//                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String line;
//                while((line=br.readLine()) != null){
//                    response+=line;
//                }
//            }
//            else if (responseCode==HttpURLConnection.HTTP_INTERNAL_ERROR) {
//                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String line;
//                while ((line = br.readLine()) != null) {
//                    response += line;
//                }
//            }
//
//            return response;  //return the response
//
//        } catch (Exception e) {
//            return e.toString();
//        }

//    }
}
