package Zendejas.CS246;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileTask extends AsyncTask<String, Integer, Void> {
    private Context context;
    private ProgressBar progressBar;

    public CreateFileTask(Context context, ProgressBar progressBar){
        this.context = context;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute(){
        progressBar.setProgress(0);

        Toast.makeText(context, "Creating file", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(String... file){
        String filename = file[0];
        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            for (int i = 0; i <= 10; i++){
                String line = String.format("%d%n", i);
                fos.write(line.getBytes());

                // Update progress
                publishProgress(i * 10);

                // Sleepy
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... data){
        progressBar.setProgress(data[0]);
    }

    @Override
    protected void onPostExecute(Void result){
        Toast.makeText(context, "Finished Saving", Toast.LENGTH_SHORT).show();
    }
}
