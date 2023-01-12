package de.thu.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onNormalModeButtonClicked(View view) {
        Intent intent = new Intent(this, NormalMode.class);
        startActivity(intent);
    }

    public void onXtremeModeButtonClicked(View view) {
        Intent intent = new Intent(this, XtremeMode.class);
        startActivity(intent);
    }

    public void onScoreboardButtonClicked(View view) {
        Intent intent = new Intent(this, Scoreboard.class);
        startActivity(intent);
    }

    public void onCreditsButtonClicked(View view) {
        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
    }
}