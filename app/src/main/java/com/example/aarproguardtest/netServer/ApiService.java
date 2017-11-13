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

    public static void getList(int page, int size, Callback callback) throws IOException {
        String url = "https://api.m.jd.com/client.action?functionId=searchWare&body={\"pageIdx\":" + page
                + ",\"pageSize\": " + size + ",\"searchType\":\"3\",\"shopId\":\"1000080061\",\"sort\":\"0\",\"source\":\"app-paipai\"}&client=paipai&clientVersion=6.5.0";
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback );
    }
}
