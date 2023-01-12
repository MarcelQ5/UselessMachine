package de.thu.uselessmachine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class NormalMode extends AppCompatActivity {
    private boolean isOn = false;
    private ShareActionProvider shareActionProvider;
    int scoreNormal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarNormal);
        setSupportActionBar(toolbar);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.general_menu, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        setShareText("My current Normal score for the useless machine is: " + scoreNormal + " clicks");
        return true;
    }

    private void setShareText(String text) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        if (text != null) {
            shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        }
        shareActionProvider.setShareIntent(shareIntent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backToMainMenu:
                Intent backToMain = new Intent(this, MainActivity.class);
                startActivity(backToMain);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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