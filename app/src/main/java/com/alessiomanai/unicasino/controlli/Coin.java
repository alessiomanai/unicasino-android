package com.alessiomanai.unicasino.controlli;


public class Coin {

    private long monete;
    private boolean stato = true;

    public Coin() {

        this.start();

    }

    public boolean inserimento() {

        return this.stato;
    }

    public void on() {

        this.stato = true;

    }

    public void off() {

        this.stato = false;
    }

    public String toString() {

        return Long.toString(this.monete);
    }

    public long getMonete() {

        return this.monete;
    }

    public void start() {

        this.monete = 10;
        this.stato = true;
    }

    public void fenu() {

        this.monete += 15;
    }

    public void atzori() {

        this.monete += 5;
    }

    public void bartoletti() {

        this.monete += 200;
    }

    public void scateni() {

        this.monete += 10;
    }

    public void daggr() {

        this.monete += 25;
    }

    public void salvatore() {

        this.monete += 5;
    }

    public void pinna() {

        this.monete += 20;
    }

    public void monetaInserita() {

        this.monete--;
    }

    public void caricaBundle(long monete){

        this.monete = monete;
    }

}
