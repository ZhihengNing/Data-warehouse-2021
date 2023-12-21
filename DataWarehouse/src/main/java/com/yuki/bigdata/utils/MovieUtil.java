package com.yuki.bigdata.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class MovieUtil {
    private static RestTemplate restTemplate = new RestTemplate();

    private static final String jsonPath = "src/main/resources/information.json";

    private static final String writePath = "src/main/resources/result.txt";

    private static final String errorPath = "src/main/resources/error.txt";

    private static final String url = "https://www.omdbapi.com/?apikey=143fd460&s=";

    private static final Set<String> set = new HashSet<>();

    static {
        //set.add("B00023P4JW");
        //set.add("B01CQOVH4U");
    }

    @Test
    public static void readMovieJson() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(jsonPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(writePath));
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(errorPath));
        String temp;
        while ((temp = reader.readLine()) != null) {
            JSONObject json = JSONObject.parseObject(temp);
            String asin = json.getString("asin");
            if (!set.contains(asin)) {
                String title = json.getString("title");
                String endTitle = transfer(title);
                JSONObject forObject = restTemplate
                        .getForObject(url + endTitle, JSONObject.class);
                Boolean response = forObject.getBoolean("Response");
                if (response) {
                    String type = forObject.getJSONArray("Search").getJSONObject(0).getString("Type");
                    writer.write(asin + "|" + endTitle + "|" + type + "\n");
                } else {
                    writer1.write(asin + "|" + endTitle + "\n");
                }
                writer.flush();
                writer1.flush();
            }
        }
        reader.close();
        //Woody Allen Four Movie Comedy Collection (Anything Else / The Curse Of The Jade Scorpion / Hollywood Ending / Small Time Crooks)
    }

    public static void main(String[] args) throws IOException {
        //readMovieJson();
        //getAsin("src/main/resources/bannedUrl.txt","src/main/resources/needUrl.txt");
        //getDirectorAndActor();
        hashset();
        // System.out.println(transfer("The Hobbit: The Motion Picture Trilogy (Extended Edition) (Blu-ray)"));

    }

    public static void getJson(String s) {
        JSONObject forObject = restTemplate.getForObject(url + s, JSONObject.class);
        System.out.println(forObject);

    }

    public static String transfer(String s) {
        String regex = "\\[.*?]|\\(.*?\\)";
        return s.replaceAll(regex, "").trim();
    }

    public static void getAsin(String s, String s1) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(s));
        BufferedWriter writer = new BufferedWriter(new FileWriter(s1));
        String temp;
        while ((temp = reader.readLine()) != null) {
            writer.write(temp.replace("https://www.amazon.com/dp/", "") + "\n");
        }
        writer.close();
        reader.close();
    }

    public static void hashset() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/mapper/information.json"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/mapper/info.json"));
        String temp;
        Set<JSONObject> set = new HashSet<>();
        while ((temp = reader.readLine()) != null) {
            JSONObject jsonObject = JSON.parseObject(temp);
            set.add(jsonObject);
        }

        System.out.println(set.size());
    }

    public static void getDirectorAndActor() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/information.json"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/director.txt"));
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("src/main/resources/actor.txt"));
        Set<String> directors = new HashSet<>();
        Set<String> actors = new HashSet<>();
        String temp;
        while ((temp = reader.readLine()) != null) {
            JSONObject j = JSONObject.parseObject(temp);
            JSONObject json = j.getJSONObject("production_detail");
            if (json.getString("Director") != null) {
                for (String director : json.getString("Director").split(",")) {
                    directors.add(director.trim());
                    writer.write(director.trim());
                    writer.newLine();
                }
            }
            if (json.getString("Actors") != null) {
                for (String actor : json.getString("Actors").split(",")) {
                    actors.add(actor.trim());
                    writer1.write(actor.trim());
                    writer1.newLine();
                }
            }
            writer.flush();
            writer1.flush();
        }
        BufferedWriter newWriter = new BufferedWriter(new FileWriter("src/main/resources/new_director.txt"));
        BufferedWriter newWriter1 = new BufferedWriter(new FileWriter("src/main/resources/new_actor.txt"));
        directors.forEach((s) -> {
            try {
                newWriter.write(s);
                newWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        actors.forEach((s) -> {
            try {
                newWriter1.write(s);
                newWriter1.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        directors.retainAll(actors);
        System.out.println(directors.size());
    }



}
