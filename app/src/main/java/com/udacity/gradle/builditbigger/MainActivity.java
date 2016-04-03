package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view){
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        LinearLayout ll_container = (LinearLayout) findViewById(R.id.ll_container);
        new JokeAsynctask(this, progressBar, ll_container).execute();
    }


}
