package Prove03.Zendejas;

import java.net.MalformedURLException;
import java.net.URL;

public class WeatherForcast {
    //Variables
    private WeatherForecastItem forcast;
    private URL forcastURL;
    private String city;
    private String api;
    private String data;

    public WeatherForcast(String c) throws MalformedURLException {
        this.forcastURL = new URL("https://api.openweathermap.org/data/2.5/forecast");
        //this.api =
        this.city = c;
        this.forcast = new WeatherForecastItem();
    }
}
