package com.example.giuliano.chords;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private MusicList store = new MusicList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSearch(View view){
        Spinner spinnerBand = (Spinner) findViewById(R.id.chooseBand);
        Spinner spinnerMusic = (Spinner) findViewById(R.id.chooseMusic);
        TextView resultArea = (TextView) findViewById(R.id.result);

        String band = String.valueOf(spinnerBand.getSelectedItem());
        String music = String.valueOf(spinnerMusic.getSelectedItem());

        Music result = store.searchMusic(new Specification(band, music));

        StringBuilder finalResult = new StringBuilder();

        if(result!=null){
            finalResult.append(result.getChords());
            resultArea.setText(finalResult);
        } else {
            resultArea.setText("Sorry...");
        }



    }


}
