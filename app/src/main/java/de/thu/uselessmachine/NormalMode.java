package de.thu.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class NormalMode extends AppCompatActivity {
    private boolean isOn = false;

    int scoreNormal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode);
        TextView score = findViewById(R.id.displayScoreNormal);
        score.setText("Score: " + scoreNormal + " clicks");
        score.invalidate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("scoreNormal", scoreNormal);
        editor.apply();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        scoreNormal= prefs.getInt("scoreNormal", 0);
    }

    public void onMainSwitchNormalClicked(View view) {
        ImageButton switchButton = findViewById(R.id.switchButtonNormal);
        if (!isOn) {
            isOn = true;
            TextView quote = findViewById(R.id.quoteNormal);
            switchButton.setImageResource(R.drawable.switch_on);
            final long waitTime = (long)(1500*Math.random());
            switchButton.postDelayed(() -> {
                switchButton.setImageResource(R.drawable.switch_off);
                //quote.setText(waitTime + "ms");
                quote.setText(QuoteDatabase.getRandomQuoteNormal());
            }, waitTime);
            isOn = false;
            scoreNormal++;
            TextView score = findViewById(R.id.displayScoreNormal);
            score.setText("Score: " + scoreNormal + " clicks");
        }
    }

}