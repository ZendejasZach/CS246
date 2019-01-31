package Prove03.Zendejas;

import com.google.gson.Gson;

public class Deseralize {
    /**
     * Parses the data from the response to the WeatherConditions object
     * @param data
     * @return
     */
    public WeatherConditions deserializeWC(String data){
        // Variables
        Gson gson = new Gson();

        // Deserialize
        WeatherConditions weather = gson.fromJson(data, WeatherConditions.class);

        return weather;
    }

    /**
     * Parses the data from the response to the WeatherForecastItem object
     * @param data
     * @return
     */
    public WeatherForecastItem deserializeWF(String data){
       // Variables
       Gson gson = new Gson();

       // Deserialize
       WeatherForecastItem weather = gson.fromJson(data, WeatherForecastItem.class);

       return weather;
    }
}
