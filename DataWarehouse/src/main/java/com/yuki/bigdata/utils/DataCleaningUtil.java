package com.yuki.bigdata.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.*;

public class DataCleaningUtil {

    private static final RestTemplate restTemplate = new RestTemplate();

    private static final String URL = "https://www.omdbapi.com/?apikey=73b1f0ea&s=";

    private static final String MYURL="https://api.themoviedb.org/3/search/movie?api_key=fa1261f224854b1b8368a7cb455bd31a&query=";

    private static final String errorAsin = "src/main/resources/errorAsin.txt";

    public static void CleanBefore(String original, String later) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(original));
        BufferedWriter writer = new BufferedWriter(new FileWriter(later));
        String temp;
        while ((temp = reader.readLine()) != null) {
            JSONObject json = JSON.parseObject(temp);

            writer.write(json.toJSONString());
            writer.newLine();
        }
    }

    public static void CleanOne(String original, String later) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(original));
        BufferedWriter writer = new BufferedWriter(new FileWriter(later));
        BufferedWriter error = new BufferedWriter(new FileWriter(errorAsin));
        String temp;
        while ((temp = reader.readLine()) != null) {
            JSONObject json = JSON.parseObject(temp);
            String title = json.getString("title");
            try {
                JSONObject forObject = restTemplate.getForObject(URL + title.trim(), JSONObject.class);
                assert forObject != null;
                if (forObject.getBooleanValue("Response")) {
                    String type = forObject.getJSONArray("Search")
                            .getJSONObject(0)
                            .getString("Type");
                    if (type.equals("movie")) {
                        writer.write(json.toJSONString());
                        writer.newLine();
                    }
                }
            } catch (Exception e) {
                error.write(json.getString("asin"));
                error.newLine();
                error.flush();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restTemplate.getForObject(MYURL + "Prank", JSONObject.class));
    }
}
