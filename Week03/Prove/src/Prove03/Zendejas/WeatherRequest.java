package Prove03.Zendejas;

import com.google.gson.Gson;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class WeatherRequest {
    // Variables
    private WeatherConditions weather;
    private String city;
    private String api;
    private URL url;
    private String data;
    private String apiFilename;

    /**
     * Constructor
     * @param c
     */
    public WeatherRequest(String c) throws IOException {
        // Variables
        this.apiFilename = "api.txt";
        this.city = c;
        this.url = new URL("https://api.openweathermap.org/data/2.5/weather");
        this.weather = new WeatherConditions();

        // read API file
        api = Files.readAllLines(Paths.get(apiFilename)).get(0);
    }

    /**
     * Getters
     */
    public WeatherConditions getWeather(){
        return this.weather;
    }

    public String getCity() {
        return this.city;
    }

    public String getApi() {
        return this.api;
    }

    public URL getUrl() {
        return this.url;
    }

    public String getData(){
        return this.data;
    }

    /**
     * Setters
     */
    public void setData(String d) {
        this.data = d;
    }
}

