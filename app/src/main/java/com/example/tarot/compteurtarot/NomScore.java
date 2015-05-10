package com.example.tarot.compteurtarot;

/**
 * Created by Jean_jean on 4/26/2015.
 */
public class NomScore {
    String nom;
    int score;
    String mort;

    public NomScore(String n, int s, String m){
        nom = n;
        score = s;
        mort = m;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String isMort() {
        return mort;
    }

    public void setMort(String mort) {
        this.mort = mort;
    }
}
