package de.thu.uselessmachine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Scoreboard extends AppCompatActivity {
    private int scoreOverall;
    private int scoreNormal;
    private int scoreXtreme;
    private ShareActionProvider shareActionProvider;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        scoreXtreme = prefs.getInt("scoreXtreme", 0);
        scoreNormal = prefs.getInt("scoreNormal", 0);
        scoreOverall = scoreNormal + scoreXtreme;
        TextView scoreOverallView = findViewById(R.id.overallScore);
        TextView scoreNormalView = findViewById(R.id.scoreNormal);
        TextView scoreXtremeView = findViewById(R.id.scoreXtreme);
        scoreOverallView.setText(String.format(getString(R.string.score_overall), scoreOverall));
        scoreNormalView.setText(String.format(getString(R.string.score_normal), scoreNormal));
        scoreXtremeView.setText(String.format(getString(R.string.score_xtreme), scoreXtreme));
        scoreOverallView.invalidate();
        scoreNormalView.invalidate();
        scoreXtremeView.invalidate();
        Toolbar toolbar = findViewById(R.id.toolbarScoreboard);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        Log.d("Scores", "Normal: " + prefs.getInt("scoreNormal",0) + " Xtreme: " + prefs.getInt("scoreXtreme",0) + " Overall: " + prefs.getInt("scoreOverall",0));
    }

    @Override
    protected void onPause() {
        super.onPause();
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
        scoreOverall = prefs.getInt("scoreOverall", 0);
        scoreNormal = prefs.getInt("scoreNormal", 0);
        scoreXtreme = prefs.getInt("scoreXtreme", 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.general_menu, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        setShareText("My current overall score for the useless machine is: " + scoreOverall + " clicks");
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
}