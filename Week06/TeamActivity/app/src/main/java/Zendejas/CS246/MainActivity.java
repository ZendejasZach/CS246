package Zendejas.CS246;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
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
        ProgressBar progressBar = findViewById(R.id.progressBar2);

        CreateFileTask  task = new CreateFileTask(this.getApplicationContext(), progressBar);
        task.execute(FILE);

    }

    // Load button
    public void loadFile(View view){
        ProgressBar progressBar = findViewById(R.id.progressBar2);

        LoadFileTask task = new LoadFileTask(this.getApplicationContext(), progressBar, arrayAdapter);
        task.execute(FILE);
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
