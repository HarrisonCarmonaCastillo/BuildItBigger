package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lelouchharryu.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.harrison.jokeandroidlib.JokeDisplayActivity;

import java.io.IOException;

/**
 * Created by LelouchHarryu on 30/01/2016.
 */
public class JokeAsynctask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static JokeApi myApiService = null;
    private Context context;
    private ProgressBar mProgressBar;
    private LinearLayout ll_container;

    public JokeAsynctask(Context context, ProgressBar progressBar , LinearLayout ll_container) {
        this.context = context;
        this.mProgressBar = progressBar;
        this.ll_container = ll_container;
    }

    @Override
    protected void onPreExecute() {
        ll_container.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }


    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        ll_container.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_EXTRA_KEY, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
