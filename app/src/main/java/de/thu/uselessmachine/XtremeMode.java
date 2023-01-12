package de.thu.uselessmachine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


public class XtremeMode extends AppCompatActivity {
    private boolean isOn = false;
    private ShareActionProvider shareActionProvider;
    int scoreXtreme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xtreme_mode);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarXtreme);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        TextView score = findViewById(R.id.displayScoreXtreme);
        score.setText(String.format(getString(R.string.score), scoreXtreme));
        score.invalidate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("scoreXtreme", scoreXtreme);
        editor.apply();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        scoreXtreme= prefs.getInt("scoreXtreme", 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.general_menu, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        setShareText("My current Xtreme score for the useless machine is: " + scoreXtreme + " clicks");
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

    @SuppressLint("DiscouragedApi")
    public void onMainSwitchXtremeClicked(View view) {
        Context context = this;
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        ImageButton switchButton = findViewById(R.id.switchButtonXtreme);
        ImageView image = findViewById(R.id.memeImage);
        if (!isOn) {
            isOn = true;
            TextView quote = findViewById(R.id.quoteXtreme);
            switchButton.setImageResource(R.drawable.switch_on);
            XtremeObject randomXtreme = QuoteDatabase.getRandomXtreme();
            quote.setText(randomXtreme.getQuote());
            int imageID = context.getResources().getIdentifier(randomXtreme.getImageName(), "drawable", context.getPackageName());
            image.setImageResource(imageID);
            image.setVisibility(View.VISIBLE);
            final long waitTimeImage = (long) (1500);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                Log.d("Vibrate", "Vibration!");
            } else {
                v.vibrate(500);
                Log.d("Vibrate", "Vibration!");
            }
            final long waitTimeSwitch = (long) (waitTimeImage + (800 * Math.random()));
            image.postDelayed(() -> image.setVisibility(View.INVISIBLE), waitTimeImage);
            switchButton.postDelayed(() -> switchButton.setImageResource(R.drawable.switch_off), waitTimeSwitch);
            isOn = false;
            scoreXtreme++;
            TextView score = findViewById(R.id.displayScoreXtreme);
            score.setText(String.format(getString(R.string.score), scoreXtreme));
        }
    }
}