package com.alessiomanai.unicasino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button avvio, credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avvio = (Button) findViewById(R.id.avvio);
        credits = (Button) findViewById(R.id.about);

        avvio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent partita = new Intent(getBaseContext(), Game.class);
                //avvia la finestra corrispondente
                startActivity(partita);

            }
        });

        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent partita = new Intent(getBaseContext(), About.class);
                //avvia la finestra corrispondente
                startActivity(partita);

            }
        });

    }

}
