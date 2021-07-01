package com.inbetter.study.camp;

import okhttp3.*;

import java.io.IOException;

public class OKHttpClient {

    private static final String URL = "http://localhost:8801/";

    private final OkHttpClient httpClient = new OkHttpClient();

    public static void main(String[] args) throws Exception {

        OKHttpClient obj = new OKHttpClient();

        System.out.println("Testing 1 - Send Http GET request");
        obj.sendGet();

        System.out.println("Testing 2 - Send Http POST request");
        obj.sendPost();

    }

    private void sendGet() throws Exception {
        Request request = new Request.Builder()
                .url(URL)
                .addHeader("custom-key", "mkyong")
                .addHeader("User-Agent", "OkHttp Bot")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Get response body
            System.out.println(response.body().string());
        }

    }

    private void sendPost() throws Exception {
        // form parameters
        RequestBody formBody = new FormBody.Builder()
                .add("username", "abc")
                .add("password", "123")
                .add("custom", "secret")
                .build();

        Request request = new Request.Builder()
                .url(URL)
                .addHeader("User-Agent", "OkHttp Bot")
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Get response body
            System.out.println(response.body().string());
        }
    }

}
