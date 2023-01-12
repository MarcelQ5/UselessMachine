package de.thu.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class XtremeMode extends AppCompatActivity {
    private boolean isOn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xtreme_mode);
    }

    public void onMainSwitchXtremeClicked(View view) {
        Context context = this;
        ImageButton switchButton = findViewById(R.id.switchButtonXtreme);
        ImageView image = findViewById(R.id.memeImage);
        if (!isOn) {
            isOn = true;
            TextView quote = findViewById(R.id.quoteXtreme);
            switchButton.setImageResource(R.drawable.switch_on);
            XtremeObject randomXtreme = QuoteDatabase.getRandomXtreme();
            quote.setText(randomXtreme.getQuote());
            int imageID = context.getResources().getIdentifier(randomXtreme.getImageName(),"drawable", context.getPackageName());
            image.setImageResource(imageID);
            image.setVisibility(View.VISIBLE);
            final long waitTimeImage = (long)(1500);
            final long waitTimeSwitch = (long)(waitTimeImage+(800*Math.random()));
            image.postDelayed(() -> {
                image.setVisibility(View.INVISIBLE);
            }, waitTimeImage);
            switchButton.postDelayed(() -> {
                switchButton.setImageResource(R.drawable.switch_off);
            }, waitTimeSwitch);
            isOn = false;
        }
    }
}