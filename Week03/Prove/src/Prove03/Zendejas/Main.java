package Prove03.Zendejas;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // Get user input
//        System.out.println("Please enter the city: ");
//        Scanner reader = new Scanner(System.in);
//        String input = reader.nextLine();

        // Close the connection
//        reader.close();

        // For testing only TODO: Remove this before production
        String input = "Rexburg";

        // Create the weather object
        WeatherRequest w = new WeatherRequest(input);

        // Get the data
        new SendRequest(w);

        // Deserialize
        WeatherConditions wc;
        Deseralize ds = new Deseralize();
        wc = ds.deserializeWC(w.getData());

        // Output
        System.out.println("Current Weather Conditions:");
        System.out.println("City id: " + wc.id);
        System.out.println("City name: " + wc.name);
        System.out.println("Current Temp: " + wc.measurements.get("temp") +" F");

        // get Forcast
        WeatherRequest wf = new WeatherRequest(input);

        // get the data
        new SendRequest(wf);

        // Deserialize
        WeatherForecastItem wfi;
        Deseralize dwf = new Deseralize();
        wfi = dwf.deserializeWF(w.getData());

        // Forecast
        System.out.println(" ");
        System.out.println("5 - Day Forecast");
        System.out.println(); //TODO: Left here
    }
}
