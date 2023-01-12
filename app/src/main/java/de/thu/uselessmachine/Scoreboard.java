package de.thu.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class Scoreboard extends AppCompatActivity {
    private int scoreOverall;
    private int scoreNormal;
    private int scoreXtreme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        scoreOverall = scoreNormal + scoreXtreme;
        TextView scoreOverallView = findViewById(R.id.overallScore);
        TextView scoreNormalView = findViewById(R.id.scoreNormal);
        TextView scoreXtremeView = findViewById(R.id.scoreXtreme);
        scoreOverallView.setText("Score overall: " + scoreOverall + " clicks");
        scoreNormalView.setText("Score in Normal mode: " + scoreNormal + " clicks");
        scoreXtremeView.setText("Score in Xtreme mode: " + scoreXtreme + " clicks");



    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        scoreOverall = scoreNormal + scoreXtreme;
        editor.putInt("scoreOverall", scoreOverall);
        editor.putInt("scoreNormal", scoreNormal);
        editor.putInt("scoreXtreme", scoreXtreme);
        editor.apply();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        scoreOverall = prefs.getInt("scoreOverall", 0);
        scoreNormal = prefs.getInt("scoreNormal", 0);
        scoreXtreme = prefs.getInt("scoreXtreme", 0);
    }
}