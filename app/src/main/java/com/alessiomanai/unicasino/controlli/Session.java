package com.alessiomanai.unicasino.controlli;


import java.util.ArrayList;
import java.util.Random;

public class Session {

    private Random random = new Random();
    private int casella1, casella2, casella3;
    private final int INTMAX = 7;

    public Session(){

    }

    public void start(){

        casella1 = random1();
        casella2 = random2();
        casella3 = random3();
    }

    private int random1(){

        int k;

        return k = random.nextInt(INTMAX) + 1;

    }

    private int random2(){

        int k;

        return k = random.nextInt(INTMAX) + 1;

    }

    private int random3(){

        int k;

        return k = random.nextInt(INTMAX) + 1;

    }

    public ArrayList<Integer> getCaselle(){

        ArrayList<Integer> caselle = new ArrayList<>();

        caselle.add(casella1);
        caselle.add(casella2);
        caselle.add(casella3);

        return caselle;
    }

}
