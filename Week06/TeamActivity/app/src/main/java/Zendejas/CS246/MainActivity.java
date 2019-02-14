package Zendejas.CS246;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

public class MainActivity extends AppCompatActivity{

    // variables
    // TODO: Ask if adding variables here is considered best practice
    String filename = "numbers.txt";
    String sCurrentLine;
    FileOutputStream outputStream;
    ProgressBar progressBar = findViewById(R.id.progressBar);
    Integer progressStatus = 0;
    ArrayAdapter<String> numberAdapter = new ArrayAdapter<>(this, R.layout.activity_main, R.id.View_list, Collections.singletonList(sCurrentLine));
    ListView listView = findViewById(R.id.View_list);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Creates text file with 1-10 on each line
    public void createFile(View view){
        // Link to the Create button
        Button button = findViewById(R.id.button_Create);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // set progress to 0
                progressStatus = 0;

                try{
                    // open fileStream
                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);

                    // loop to add 1-10 and sleep on each line
                    //TODO: Test this to make sure the format is correct
                    for (Integer i = 1; i == 10; i++){
                        new numbers().execute(i);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // Loads above mentioned file
    //TODO: Test this ish too
    public void loadFile(View view){
        // prep
        Button button = findViewById(R.id.button_Load);
        progressStatus = 0;


        // load the data
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Get file and directory
                File directory = getApplicationContext().getFilesDir();
                File file = new File(directory, filename);

                // read the file line by line
                StringBuilder contentBuilder = new StringBuilder();
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    while((sCurrentLine = br.readLine()) != null){
                        // read the line
                        contentBuilder.append(sCurrentLine).append("\n");

                        // update the progress bar
                        progressStatus++;
                        progressBar.setProgress(progressStatus);

                        // add to list
                        listView.setAdapter(numberAdapter);

                        // sleepy time
                        Thread.sleep(250);
                    }
                } catch(IOException e){
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Clears the adapter
    public void clear(View view){
        Button button = findViewById(R.id.button_Clear);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // clear the adapter
                numberAdapter.clear();
            }
        });
    }

    // Async Task
    private class numbers extends AsyncTask<Integer>{

        @Override
        protected Object doInBackground(Integer...params) {
            // write
            outputStream.write(Integer.parseInt(i + "\n"));

            // update the progress

        }
    }
}

