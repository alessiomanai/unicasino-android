package com.alessiomanai.unicasino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    TextView monete;
    ImageView[] casella = new ImageView[3];
    ImageView insert;
    Button leva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        monete = (TextView) findViewById(R.id.displayCoins);
        casella[0] = (ImageView) findViewById(R.id.casella1);
        casella[1] = (ImageView) findViewById(R.id.casella2);
        casella[2] = (ImageView) findViewById(R.id.casella3);
        insert = (ImageView) findViewById(R.id.insert);
        leva = (Button) findViewById(R.id.leva);



    }
}
