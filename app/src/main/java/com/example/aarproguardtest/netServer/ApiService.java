package com.example.aarproguardtest.netServer;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by fc on 2017/11/13.
 */

public class ApiService {
    private static OkHttpClient client = new OkHttpClient();

    public static void getList(String url, Callback callback) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback );
    }
}
