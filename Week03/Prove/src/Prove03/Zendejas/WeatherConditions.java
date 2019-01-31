package Prove03.Zendejas;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

public class WeatherConditions {
    // Variables
    int id;
    String name;
    @SerializedName("main")
    HashMap<String, Float> measurements;
}
