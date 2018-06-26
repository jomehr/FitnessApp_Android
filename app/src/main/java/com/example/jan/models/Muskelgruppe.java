package com.example.jan.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Muskelgruppe implements Serializable{

    //Attribute
    private String muskelgruppenname;
    private ArrayList<String> muskelgruppe = new ArrayList<> ();

    public Muskelgruppe(String muskelgruppenname, ArrayList<String> muskelgruppe) {
        this.setMuskelgruppenname(muskelgruppenname);
        this.setMuskelgruppe(muskelgruppe);
    }

    boolean enthaelt (String muskel) {
        return this.getMuskelgruppe().contains(muskel);
    }

    //getter
    public ArrayList<String> getMuskelgruppe() {
        return muskelgruppe;
    }

    public String getMuskelgruppenname() {
        return muskelgruppenname;
    }

    //setter
    public void setMuskelgruppe(ArrayList<String> muskelgruppe) {
        this.muskelgruppe = muskelgruppe;
    }

    public void setMuskelgruppenname(String muskelgruppenname) {
        this.muskelgruppenname = muskelgruppenname;
    }
}
