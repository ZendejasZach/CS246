package Zendejas.CS246;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Variables
    private static String FILE = "numbers.txt";
    private List<Integer> numberList;
    private ArrayAdapter<Integer> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the list and array adapter
        numberList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.my_list_item, numberList);

        // Connect adapter to listView
        ListView listView = findViewById(R.id.mainListView);
        listView.setAdapter(arrayAdapter);
    }

    public void onCreateClick(View view){
        // Set progress bar to 0
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(0);

        try (FileOutputStream outputStream = this.openFileOutput(FILE, Context.MODE_PRIVATE)){
            // Write
            for(int i = 1; i <= 10; i++){
                String line = String.format("%d%n", i);
                outputStream.write(line.getBytes());

                // Update progress
                progressBar.setProgress(i * 10);

                // Sleepy time
                Thread.sleep(250);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Toast loadToast = Toast.makeText(getApplicationContext().getApplicationContext(), "Create Finished", Toast.LENGTH_LONG);
        loadToast.show();
    }


    // Load button
    public void loadFile(View view){
        // Reset the progress bar
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(0);

        try (FileInputStream inputStream = this.openFileInput(FILE)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                // Read the file, line by line
                String line;
                while ((line = reader.readLine()) != null) {

                    // Get the number out of the file
                    int i = Integer.parseInt(line);

                    // Put the number in the adapter, which is connected to the ListView
                    arrayAdapter.add(i);

                    // See how many things are in the apdater, and update the ProgressBar
                    int adapterCount = arrayAdapter.getCount();
                    progressBar.setProgress(adapterCount * 10);

                    // Simulate a more difficult task by sleeping for 1/4 second
                    Thread.sleep(250);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Inform the user that the task is complete
        Toast.makeText(this, "Finished Loading", Toast.LENGTH_SHORT).show();
    }

    // Clear button
    public void clear(View view){
        // Reset bar
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(0);

        // clear array
        arrayAdapter.clear();

        // Toasty!
        Toast.makeText(this,"Cleared", Toast.LENGTH_SHORT).show();
    }
}
