package com.alessiomanai.unicasino.controlli;

public class Giocatore {

    private String nome;
    private double recordMonete;

    public Giocatore(){

    }

    public Giocatore(String nome){

        this.setNome(nome);
    }

    public Giocatore(String nome, double recordMonete){

        this.setNome(nome);
        this.setRecordMonete(recordMonete);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRecordMonete() {
        return recordMonete;
    }

    public void setRecordMonete(double recordMonete) {
        this.recordMonete = recordMonete;
    }
}
