package com.example.harry.labassignment4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by harry on 2/15/2017.
 */


public class Speechtotext extends Activity {
    public TextView txtSpeechInput;
    public ImageButton btnSpeak;
    public final int REQ_CODE_SPEECH_INPUT = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speechtotext);
        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        // hide the action bar
        //getActionBar().hide();
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                promptSpeechInput();
            }
        });}
        /*btnSpeak.setOnClickListener(new View.OnClickListener()
        @Override
            public void onClick(View ) {
                promptSpeechInput();
                }
            });*/
    /**
          * Showing google speech input dialog
          * */
            private void promptSpeechInput(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
        getString(R.string.speech_prompt));
        try {
        startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
        Toast.makeText(getApplicationContext(),
        getString(R.string.speech_not_supported),
        Toast.LENGTH_SHORT).show();
        }
        }
    /**
          * Receiving speech input
          * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    switch (requestCode) {
    case REQ_CODE_SPEECH_INPUT: {
    if (resultCode == RESULT_OK && null != data) {

    ArrayList<String> result = data
    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
    txtSpeechInput.setText(result.get(0));
    }
    break;
    }
    }
    }

   /* @Override
  *//*  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }*/
}
