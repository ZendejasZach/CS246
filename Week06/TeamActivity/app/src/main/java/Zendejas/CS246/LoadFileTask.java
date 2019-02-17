package Zendejas.CS246;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;

public class LoadFileTask extends AsyncTask<String, Integer, Void> {
    private WeakReference<Context> contextRef;
    private WeakReference<ProgressBar> pbRef;
    private WeakReference<ArrayAdapter<Integer>> aaRef;

    public LoadFileTask(Context c, ProgressBar pb, ArrayAdapter<Integer> aa){
        this.contextRef = new WeakReference<>(c);
        this.pbRef = new WeakReference<>(pb);
        this.aaRef = new WeakReference<>(aa);
    }

    @Override
    protected void onPreExecute(){
        ProgressBar pb = pbRef.get();

        if (pb != null){
            pb.setProgress(0);
        }

        Context c = contextRef.get();

        if (c != null){
            Toast.makeText(c, "Loading file", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected Void doInBackground(String... file) {
        String filename = file[0];

        Context c = contextRef.get();

        if (c != null) {
            try (FileInputStream fis = c.openFileInput(filename)) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        int i = Integer.parseInt(line);

                        publishProgress(i);

                        Thread.sleep(250);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... data){
        ArrayAdapter<Integer> arrayAdapter = aaRef.get();
        ProgressBar progressBar = pbRef.get();

        if (arrayAdapter != null && progressBar != null){
            Integer i = data[0];

            arrayAdapter.add(i);

            int adapterCount = arrayAdapter.getCount();
            progressBar.setProgress(adapterCount * 10);
        }
    }
}
