package io.github.kimmking.netty.server;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OKhttpTest {
    public static void main(String[] args) throws Exception{
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()//直接复制方法体中的内容
                        .addHeader("Content-Type","text/html")
                        .addHeader("charset","utf-8")
                        .url("http://localhost:8801/")//同上
                        .build();
                try (Response response = client.newCall(request).execute()) {
                    System.out.println(response.body().string());//同上
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


}
