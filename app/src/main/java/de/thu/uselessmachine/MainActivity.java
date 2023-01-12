package de.thu.uselessmachine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.normalModeButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NormalMode.class);
            startActivity(intent);
        });
        findViewById(R.id.xtremeModeButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, XtremeMode.class);
            startActivity(intent);
        });
        findViewById(R.id.scoreboardButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Scoreboard.class);
            startActivity(intent);
        });

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
    }


    //public void onNormalModeButtonClicked(View view) {
    //    Intent intent = new Intent(this, NormalMode.class);
    //    startActivity(intent);
    //}

    //public void onXtremeModeButtonClicked(View view) {
    //    Intent intent = new Intent(this, XtremeMode.class);
    //    startActivity(intent);
    //}

    //public void onScoreboardButtonClicked(View view) {
    //    Intent intent = new Intent(this, Scoreboard.class);
    //    startActivity(intent);
    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.credits) {
            Intent intent = new Intent(this, Credits.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}