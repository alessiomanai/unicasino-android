package com.alessiomanai.unicasino.controlli;

public class Giocatore {

    private String nome;
    private long recordMonete;

    public Giocatore(){

    }

    public Giocatore(String nome){

        this.setNome(nome);
    }

    public Giocatore(String nome, long recordMonete){

        this.setNome(nome);
        this.setRecordMonete(recordMonete);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getRecordMonete() {
        return recordMonete;
    }

    public void setRecordMonete(long recordMonete) {
        this.recordMonete = recordMonete;
    }
}
