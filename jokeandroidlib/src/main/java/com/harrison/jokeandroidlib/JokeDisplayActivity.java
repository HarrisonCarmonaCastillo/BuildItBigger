package com.harrison.jokeandroidlib;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends Activity {

    public static final String JOKE_EXTRA_KEY = "JOKE_INTENT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitvity_joke_display);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            TextView tv_joke = (TextView) findViewById(R.id.tv_joke);
            tv_joke.setText(extras.getString(JOKE_EXTRA_KEY));
        }

    }
}
