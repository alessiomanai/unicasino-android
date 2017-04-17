package com.alessiomanai.unicasino;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alessiomanai.unicasino.controlli.Coin;
import com.alessiomanai.unicasino.controlli.Leva;
import com.alessiomanai.unicasino.controlli.Session;
import com.bumptech.glide.Glide;

public class Game extends AppCompatActivity {

    TextView monete;
    ImageView[] casella = new ImageView[3];
    ImageView insert;
    Button leva;
    Coin coins;
    Leva levaS;
    Session sessione;

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

        coins = new Coin();

        if (savedInstanceState != null) {
            coins.caricaBundle(savedInstanceState.getLong("Monete"));
        }

        levaS = new Leva();
        sessione = new Session();

        aggiornaMonete();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (coins.getMonete() > 0 && coins.inserimento()) {
                    coins.off();
                    coins.monetaInserita();
                    aggiornaMonete();
                    levaS.attiva();
                    leva.setBackgroundColor(getResources().getColor(R.color.bottoneLeva));
                    attivaCaselle();

                } else if (!coins.inserimento()) {

                    Toast.makeText(Game.this, "Non puoi inserire altre monete", Toast.LENGTH_SHORT);

                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                    builder.setTitle("Poveraccio");
                    builder.setMessage("Non hai monete per giocare\nIl gioco è vietato ai minori e può causare dipendenza patologica");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Rigioca", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            coins.start();
                            aggiornaMonete();
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton("Chiudi", new DialogInterface.OnClickListener() {
                        @Override

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    builder.show();
                }

            }
        });

        leva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (levaS.getStato()) {

                    levaS.disattiva();
                    coins.on();
                    sessione.start();
                    leva.setBackgroundColor(getResources().getColor(R.color.levadisattivata));

                    switch (sessione.getCaselle().get(0)) {

                        case 1:
                            casella[0].setImageDrawable(getResources().getDrawable(R.drawable.gianni));
                            break;
                        case 2:
                            casella[0].setImageDrawable(getResources().getDrawable(R.drawable.maurizio));
                            break;
                        case 3:
                            casella[0].setImageDrawable(getResources().getDrawable(R.drawable.riccardone));
                            break;
                        case 4:
                            casella[0].setImageDrawable(getResources().getDrawable(R.drawable.massimo));
                            break;
                        case 5:
                            casella[0].setImageDrawable(getResources().getDrawable(R.drawable.salvatore));
                            break;
                        case 6:
                            casella[0].setImageDrawable(getResources().getDrawable(R.drawable.daggr));
                            break;
                        case 7:
                            casella[0].setImageDrawable(getResources().getDrawable(R.drawable.pinna));
                            break;


                    }

                    switch (sessione.getCaselle().get(1)) {

                        case 1:
                            casella[1].setImageDrawable(getResources().getDrawable(R.drawable.gianni));
                            break;
                        case 2:
                            casella[1].setImageDrawable(getResources().getDrawable(R.drawable.maurizio));
                            break;
                        case 3:
                            casella[1].setImageDrawable(getResources().getDrawable(R.drawable.riccardone));
                            break;
                        case 4:
                            casella[1].setImageDrawable(getResources().getDrawable(R.drawable.massimo));
                            break;
                        case 5:
                            casella[1].setImageDrawable(getResources().getDrawable(R.drawable.salvatore));
                            break;
                        case 6:
                            casella[1].setImageDrawable(getResources().getDrawable(R.drawable.daggr));
                            break;
                        case 7:
                            casella[1].setImageDrawable(getResources().getDrawable(R.drawable.pinna));
                            break;


                    }

                    switch (sessione.getCaselle().get(2)) {

                        case 1:
                            casella[2].setImageDrawable(getResources().getDrawable(R.drawable.gianni));
                            break;
                        case 2:
                            casella[2].setImageDrawable(getResources().getDrawable(R.drawable.maurizio));
                            break;
                        case 3:
                            casella[2].setImageDrawable(getResources().getDrawable(R.drawable.riccardone));
                            break;
                        case 4:
                            casella[2].setImageDrawable(getResources().getDrawable(R.drawable.massimo));
                            break;
                        case 5:
                            casella[2].setImageDrawable(getResources().getDrawable(R.drawable.salvatore));
                            break;
                        case 6:
                            casella[2].setImageDrawable(getResources().getDrawable(R.drawable.daggr));
                            break;
                        case 7:
                            casella[2].setImageDrawable(getResources().getDrawable(R.drawable.pinna));
                            break;

                    }

                    if (sessione.getCaselle().get(0) == sessione.getCaselle().get(1) &&
                            sessione.getCaselle().get(1) == sessione.getCaselle().get(2)) {

                        assegnaMonete(sessione.getCaselle().get(0));
                    }

                }

            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("Monete", coins.getMonete());
        super.onSaveInstanceState(savedInstanceState);
    }

    void attivaCaselle() {

        Glide.with(getApplicationContext())
                .load(R.drawable.random)
                .asGif()
                .into(casella[0]);

        Glide.with(getApplicationContext())
                .load(R.drawable.random)
                .asGif()
                .into(casella[1]);

        Glide.with(getApplicationContext())
                .load(R.drawable.random)
                .asGif()
                .into(casella[2]);

    }

    void aggiornaMonete() {

        String money = "Coins: " + coins.toString();

        monete.setText(money);
    }

    void assegnaMonete(int numero) {

        AlertDialog.Builder builder;

        switch (numero) {

            case 1:
                builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("UniCAsinò");
                builder.setMessage("Fenu gives you 15 coins!");
                builder.setCancelable(false);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

                coins.fenu();
                aggiornaMonete();
                break;

            case 2:
                builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("UniCAsinò");
                builder.setMessage("Atzori gives you 5 coins!");
                builder.setCancelable(false);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                coins.atzori();
                aggiornaMonete();
                break;

            case 3:
                builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("UniCAsinò");
                builder.setMessage("Scateni gives you 10 coins!");
                builder.setCancelable(false);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

                coins.scateni();
                aggiornaMonete();
                break;

            case 4:
                builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("UniCAsinò");
                builder.setMessage("OMG Bartoletti just hacked the system and gives you 200 coins!");
                builder.setCancelable(false);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

                coins.bartoletti();
                aggiornaMonete();
                break;

            case 5:
                builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("UniCAsinò");
                builder.setMessage("Welcome to Csorovo! 5 coins for you!");
                builder.setCancelable(false);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

                coins.salvatore();
                aggiornaMonete();
                break;

            case 6:
                builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("UniCAsinò");
                builder.setMessage("Say DAGGR correctly and you gain 25 coins!");
                builder.setCancelable(false);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

                coins.daggr();
                aggiornaMonete();
                break;

            case 7:
                builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("UniCAsinò");
                builder.setMessage("Pinna gives you 20 coins!");
                builder.setCancelable(false);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

                coins.pinna();
                aggiornaMonete();
                break;

        }

    }

}
