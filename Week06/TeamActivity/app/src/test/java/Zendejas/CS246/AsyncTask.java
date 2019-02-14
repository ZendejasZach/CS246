package Zendejas.CS246;


import java.io.IOException;


    public void doInBackground(Integer i) throws InterruptedException, IOException {
        // write the thing
        outputStream.write(Integer.parseInt(i + "\n"));

        // update the progress
        onProgressUpdate(i);
        Thread.sleep(250);
    }

    public void onProgressUpdate(Integer i) throws IOException {
        // update progress
        progressStatus++;
        progressBar.setProgress(progressStatus);

        // if progress is complete, close file stream
        if (progressStatus == 9){
            onPostExecute();
        }
    }

    public void onPostExecute() throws IOException {
        outputStream.close();
    }
}