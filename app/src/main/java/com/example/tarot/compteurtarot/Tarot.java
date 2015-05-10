package com.example.tarot.compteurtarot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jean_jean on 4/20/2015.
 */


public class Tarot {
    final int PETITE = 20;
    final int GARDE = 40;
    final int GARDE_SANS = 80;
    final int GARDE_CONTRE = 160;
    final int PETIT_CHLEM = 320;
    final int GRAND_CHLEM = 640;
    final int MISERE = 40;
    final int PETIT_BOUT = 40;
    final int POIGNEE = 40;
    final int DOUBLE_POIGNEE = 80;
    final int TRIPLE_POIGNEE = 160;
    final int RIEN = 80;

    String[] point = {"0","10","20","30","40","50","60"};

    private ArrayList<NomScore> arrayList = new ArrayList<NomScore>();
    private ArrayList<NomScore> copyarrayList = new ArrayList<NomScore>();
    ArrayList<String> sj = new ArrayList<String>();

    //TODO gerer les mort
    public void add_joueur(String name){
        if(arrayList.size() < 5) {
            NomScore joueur = new NomScore(name, 0, false);
            sj.add(name);
            arrayList.add(joueur);
        }else{
            NomScore joueur = new NomScore(name, 0, true);
            sj.add(name);
            arrayList.add(joueur);
        }
    }

    public ArrayList<NomScore> getArrayList() {
        return arrayList;
    }

    public void setcopyArrayList() {
        copy1();
    }

    public String[] getjoueurs(){
        Object[] ob = sj.toArray();
        String[] st = new String[ob.length];
        for(int j=0; j < ob.length; j++){
            st[j] = ob[j].toString();
        }
        return st;
    }

    public void calculscore(String name, String name1, int jeu, int scoreplus, boolean b){
        NomScore nomscore;
        ArrayList<Integer> mort = new ArrayList<Integer>();
        copy();
        if(name.equals(name1)){
            for (int i = 0; i < arrayList.size(); i++) {
                nomscore = arrayList.get(i);
                int score = nomscore.getScore();
                if(!nomscore.isMort()) {
                    if (b) {
                        if (name.equals(nomscore.getNom())) {
                            nomscore.setScore(score + (jeu + scoreplus) * 4);
                        } else {
                            nomscore.setScore(score - (jeu + scoreplus));
                        }
                    } else {
                        if (name.equals(nomscore.getNom())) {
                            nomscore.setScore(score - (jeu + scoreplus) * 4);
                        } else {
                            nomscore.setScore(score + (jeu + scoreplus));
                        }
                    }
                }else{
                    mort.add(i);
                }
        }
        }else {
            for (int i = 0; i < arrayList.size(); i++) {
                nomscore = arrayList.get(i);
                int score = nomscore.getScore();
                if (!nomscore.isMort()) {
                    if (b) {
                        if (name.equals(nomscore.getNom())) {
                            nomscore.setScore(score + (jeu + scoreplus) * 2);
                        } else if (name1.equals(nomscore.getNom())) {
                            nomscore.setScore(score + jeu + scoreplus);
                        } else {
                            nomscore.setScore(score - jeu - scoreplus);
                        }
                    } else {
                        if (name.equals(nomscore.getNom())) {
                            nomscore.setScore(score - (jeu + scoreplus) * 2);
                        } else if (name1.equals(nomscore.getNom())) {
                            nomscore.setScore(score - jeu - scoreplus);
                        } else if (jeu == RIEN && name.equals("")){
                            nomscore.setScore(score + jeu/4 + scoreplus);
                        }
                            else{
                                nomscore.setScore(score + jeu + scoreplus);
                            }
                        }
                }else{
                    mort.add(i);
                }
            }
        }
        int nb = 0;
        switch(arrayList.size()) {
            case 6:
                for (int i = 0; i < arrayList.size(); i++) {
                    nomscore = arrayList.get(i);
                    if (nomscore.isMort()) {
                        nb = i;
                        nomscore.setMort(false);
                    }
                }
                nb = nb + 1;
                if (nb >= arrayList.size()) {
                    nb = nb - arrayList.size();
                    nomscore = arrayList.get(nb);
                    nomscore.setMort(true);
                } else {
                    nomscore = arrayList.get(nb);
                    nomscore.setMort(true);
                }
                break;
            case 7:
                if(mort.contains(arrayList.size()-1)){
                    if( mort.get(mort.size()-2) == arrayList.size()-2){
                        nomscore = arrayList.get(arrayList.size()-2);
                        nomscore.setMort(false);
                        nomscore = arrayList.get(0);
                        nomscore.setMort(true);
                    }else{
                        nomscore = arrayList.get(arrayList.size()-1);
                        nomscore.setMort(false);
                        nomscore = arrayList.get(1);
                        nomscore.setMort(true);
                    }
                }else{
                    nb = mort.get(0);
                    nomscore = arrayList.get(nb);
                    nomscore.setMort(false);
                    nomscore = arrayList.get(nb+2);
                    nomscore.setMort(true);
                }
                break;
            case 8:
                if(mort.contains(arrayList.size()-1)){
                    if( mort.get(mort.size()-3) == arrayList.size()-3){
                        nomscore = arrayList.get(arrayList.size()-3);
                        nomscore.setMort(false);
                        nomscore = arrayList.get(0);
                        nomscore.setMort(true);
                    }else if(mort.get(mort.size()-2) == arrayList.size()-2){
                        nomscore = arrayList.get(arrayList.size()-2);
                        nomscore.setMort(false);
                        nomscore = arrayList.get(1);
                        nomscore.setMort(true);
                    }
                    else{
                        nomscore = arrayList.get(arrayList.size()-1);
                        nomscore.setMort(false);
                        nomscore = arrayList.get(2);
                        nomscore.setMort(true);
                    }
                }else{
                    nb = mort.get(0);
                    nomscore = arrayList.get(nb);
                    nomscore.setMort(false);
                    nomscore = arrayList.get(nb+3);
                    nomscore.setMort(true);

                }
                break;
            case 9:
                if(mort.contains(arrayList.size()-1)){
                    if( mort.get(mort.size()-4) == arrayList.size()-4){
                        nomscore = arrayList.get(arrayList.size()-4);
                        nomscore.setMort(false);
                        nomscore = arrayList.get(0);
                        nomscore.setMort(true);
                    }else if(mort.get(mort.size()-3) == arrayList.size()-3){
                        nomscore = arrayList.get(arrayList.size()-3);
                        nomscore.setMort(false);
                        nomscore = arrayList.get(1);
                        nomscore.setMort(true);
                    }else if(mort.get(mort.size()-2) == arrayList.size()-2){
                        nomscore = arrayList.get(arrayList.size()-2);
                        nomscore.setMort(false);
                        nomscore = arrayList.get(2);
                        nomscore.setMort(true);
                    }
                    else{
                        nomscore = arrayList.get(arrayList.size()-1);
                        nomscore.setMort(false);
                        nomscore = arrayList.get(3);
                        nomscore.setMort(true);
                    }
                }else{
                    nb = mort.get(0);
                    nomscore = arrayList.get(nb);
                    nomscore.setMort(false);
                    nomscore = arrayList.get(nb+4);
                    nomscore.setMort(true);

                }
                break;
            default:
                break;
        }
    }

    public void misere(String name, int point, boolean a){
        NomScore nomscore;
        copy();
        int pointp = point/4;
        for(int i=0; i<arrayList.size(); i++) {
            nomscore = arrayList.get(i);
            int score = nomscore.getScore();
            if(!nomscore.isMort()){
                if(a){
                if(name.equals(nomscore.getNom())){
                    nomscore.setScore(score + point);
                }else{
                    nomscore.setScore(score - pointp);
                }
            }else{
                    if(name.equals(nomscore.getNom())){
                        nomscore.setScore(score - point);
                    }else{
                        nomscore.setScore(score + pointp);
                    }
            }
        }
        }
    }

    public ArrayList<NomScore> getCopyarrayList() {
        return copyarrayList;
    }

    public String[] getPoint() {
        return point;
    }

    public void copy() {
        copyarrayList.clear();
        for(int i=0; i<arrayList.size(); i++){
            NomScore ns1 = new NomScore(arrayList.get(i).getNom(), arrayList.get(i).getScore(), arrayList.get(i).isMort());
            copyarrayList.add(ns1);
            Log.i("Tarot", Integer.toString(copyarrayList.get(i).getScore()));
        }
    }

    public void copy1() {
        arrayList.clear();
        for(int i=0; i<copyarrayList.size(); i++){
            NomScore ns1 = new NomScore(copyarrayList.get(i).getNom(), copyarrayList.get(i).getScore(), copyarrayList.get(i).isMort());
            arrayList.add(ns1);
            Log.i("Tarot", Integer.toString(arrayList.get(i).getScore()));
        }
    }
}
