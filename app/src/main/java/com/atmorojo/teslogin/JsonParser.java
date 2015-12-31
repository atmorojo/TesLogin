package com.atmorojo.teslogin;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;

/**
 * Created by atmorojo on 12/31/15.
 */
public class JsonParser {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
//        Request response = client.newCall(request).execute();
        Request response = client.newCall(request).execute();
        return response.body().toString();
    }

    public static void main(String[] args) throws IOException {
        JsonParser example = new JsonParser();
        String json = "atmorojo";
        String response = example.post("http://www.roundsapp.com/post", json);
        System.out.println(response);
    }
}
