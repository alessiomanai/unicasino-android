package com.alessiomanai.unicasino.controlli;


public class Leva {

    boolean stato;

    public Leva(){

        this.stato = false;

    }

    public boolean getStato(){
        return this.stato;
    }

    public void attiva(){
        this.stato = true;
    }

    public void disattiva(){
        this.stato = false;
    }

}
