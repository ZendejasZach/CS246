package Prove03.Zendejas;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

public class WeatherForecastItem {
    //variables
    int id;
    String name;
    @SerializedName("main")
    HashMap<String, Float> measurements;
    String time;
    int temp;
    @SerializedName("weather")
    HashMap<String, String> conditions;
    @SerializedName("wind")
    HashMap<String, Float> wind;
}
