package de.thu.uselessmachine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;


public class NormalMode extends AppCompatActivity {
    private boolean isOn = false;
    private ShareActionProvider shareActionProvider;
    TextView scoretext;
    SharedPreferences prefs;
    int scoreNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Toolbar toolbar = findViewById(R.id.toolbarNormal);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        scoreNormal = prefs.getInt("scoreNormal", 0);
        scoretext = findViewById(R.id.displayScoreNormal);
        scoretext.setText(String.format(getString(R.string.score), scoreNormal));
        scoretext.invalidate();
        findViewById(R.id.switchButtonNormal).setOnClickListener(l -> {
            ImageButton switchButton = findViewById(R.id.switchButtonNormal);
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (!isOn) {
                isOn = true;
                TextView quote = findViewById(R.id.quoteNormal);
                switchButton.setImageResource(R.drawable.switch_on);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                    Log.d("Vibrate", "Vibration!");
                } else {
                    v.vibrate(500);
                    Log.d("Vibrate", "Vibration!");
                }
                final long waitTime = (long) (1500 * Math.random());
                switchButton.postDelayed(() -> {

                    switchButton.setImageResource(R.drawable.switch_off);
                    quote.setText(getRandomQuote());
                }, waitTime);
                isOn = false;
                scoreNormal++;
                scoretext.setText(String.format(getString(R.string.score), scoreNormal));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("scoreNormal", scoreNormal);
        editor.apply();
    }
    @Override
    protected void onResume() {
        super.onResume();
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
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private String getRandomQuote() {
        int rand = (int) (Math.random() * 29);
        switch (rand) {
            case 0:
                return getString(R.string.Q0);
            case 1:
                return getString(R.string.Q1);
            case 2:
                return getString(R.string.Q2);
            case 3:
                return getString(R.string.Q3);
            case 4:
                return getString(R.string.Q4);
            case 5:
                return getString(R.string.Q5);
            case 6:
                return getString(R.string.Q6);
            case 7:
                return getString(R.string.Q7);
            case 8:
                return getString(R.string.Q8);
            case 9:
                return getString(R.string.Q9);
            case 10:
                return getString(R.string.Q10);
            case 11:
                return getString(R.string.Q11);
            case 12:
                return getString(R.string.Q12);
            case 13:
                return getString(R.string.Q13);
            case 14:
                return getString(R.string.Q14);
            case 15:
                return getString(R.string.Q15);
            case 16:
                return getString(R.string.Q16);
            case 17:
                return getString(R.string.Q17);
            case 18:
                return getString(R.string.Q18);
            case 19:
                return getString(R.string.Q19);
            case 20:
                return getString(R.string.Q20);
            case 21:
                return getString(R.string.Q21);
            case 22:
                return getString(R.string.Q22);
            case 23:
                return getString(R.string.Q23);
            case 24:
                return getString(R.string.Q24);
            case 25:
                return getString(R.string.Q25);
            case 26:
                return getString(R.string.Q26);
            case 27:
                return getString(R.string.Q27);
            case 28:
                return getString(R.string.Q28);
            case 29:
                return getString(R.string.Q29);
            default:
                return getString(R.string.QError);
        }
    }
}