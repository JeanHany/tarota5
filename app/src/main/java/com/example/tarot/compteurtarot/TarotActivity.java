package com.example.tarot.compteurtarot;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jean_jean on 4/26/2015.
 */
public class TarotActivity extends Activity {
    Tarot tarot = new Tarot();
    private Custom_View custom_view;
    ListView listView;
    EditText editText;
    private NomScore nomscore;
    ArrayList<NomScore> nomScores;
    String TAG = "Tarot Activity";
    int scoreplus;
    String name;
    int quel;
    String[] st4 = {"Gagner", "Perdu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarot);
        Button button = (Button) findViewById(R.id.ok);
        editText = (EditText) findViewById(R.id.namejoueur);
        listView = (ListView) findViewById(R.id.view);
        registerForContextMenu(listView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namejoueur = editText.getText().toString();
                tarot.add_joueur(namejoueur);
                displaydata(tarot);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tarot_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == listView) {
            menu.setHeaderTitle("Alors sa a fait quoi ?");
            menu.add(Menu.NONE, 1, 1, "Petite");
            menu.add(Menu.NONE, 2, 2, "Garde");
            menu.add(Menu.NONE, 3, 3, "Garde Sans");
            menu.add(Menu.NONE, 4, 4, "Garde Contre");
            menu.add(Menu.NONE, 5, 5, "Misere");
            menu.add(Menu.NONE, 6, 6, "petit au bout");
            menu.add(Menu.NONE, 7, 7, "Poignee");
            menu.add(Menu.NONE, 8, 8, "Double Poignee");
            menu.add(Menu.NONE, 9, 9, "Triple Poignee");
            menu.add(Menu.NONE, 10, 10, "Petit Chlem");
            menu.add(Menu.NONE, 11, 11, "Grand Chlem");
            menu.add(Menu.NONE, 12, 12, "Rien");
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Log.i(TAG, Integer.toString(id));
        nomscore = (NomScore) listView.getItemAtPosition(info.position);
        AlertDialog.Builder dialog3 = new AlertDialog.Builder(this);
        switch(id){
            case 1 :
                affiche(tarot.PETITE);
                break;
            case 2 :
                affiche(tarot.GARDE);
                break;
            case 3 :
                affiche(tarot.GARDE_SANS);
                break;
            case 4 :
                affiche(tarot.GARDE_CONTRE);
                break;
            case 10 :
                affiche(tarot.PETIT_CHLEM);
                break;
            case 11 :
                affiche(tarot.GRAND_CHLEM);
                break;
            case 5 :

                dialog3.setTitle("Gagner ou Perdu ?");
                dialog3.setItems( st4, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i(TAG, Integer.toString(i));
                        if(i == 0){
                            tarot.misere(nomscore.getNom(), tarot.MISERE, true);
                        }else{
                            tarot.misere(nomscore.getNom(), tarot.MISERE, false);
                        }
                        displaydata(tarot);
                    }
                });
                dialog3.show();
                displaydata(tarot);
                break;
            case 6 :

                dialog3.setTitle("Gagner ou Perdu ?");
                dialog3.setItems( st4, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i(TAG, Integer.toString(i));
                        if(i == 0){
                            tarot.misere(nomscore.getNom(), tarot.PETIT_BOUT, true);
                        }else{
                            tarot.misere(nomscore.getNom(), tarot.PETIT_BOUT, false);
                        }
                        displaydata(tarot);
                    }
                });
                dialog3.show();

                displaydata(tarot);
                break;
            case 7:

                dialog3.setTitle("Gagner ou Perdu ?");
                dialog3.setItems( st4, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i(TAG, Integer.toString(i));
                        if(i == 0){
                            tarot.misere(nomscore.getNom(), tarot.POIGNEE, true);
                        }else{
                            tarot.misere(nomscore.getNom(), tarot.POIGNEE, false);
                        }
                        displaydata(tarot);
                    }
                });
                dialog3.show();

                displaydata(tarot);
                break;
            case 8 :

                dialog3.setTitle("Gagner ou Perdu ?");
                dialog3.setItems( st4, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i(TAG, Integer.toString(i));
                        if(i == 0){
                            tarot.misere(nomscore.getNom(), tarot.DOUBLE_POIGNEE, true);
                        }else{
                            tarot.misere(nomscore.getNom(), tarot.DOUBLE_POIGNEE, false);
                        }
                        displaydata(tarot);
                    }
                });
                dialog3.show();

                displaydata(tarot);
                break;
            case 9 :

                dialog3.setTitle("Gagner ou Perdu ?");
                dialog3.setItems( st4, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i(TAG, Integer.toString(i));
                        if(i == 0){
                            tarot.misere(nomscore.getNom(), tarot.TRIPLE_POIGNEE, true);
                        }else{
                            tarot.misere(nomscore.getNom(), tarot.TRIPLE_POIGNEE, false);
                        }
                        displaydata(tarot);
                    }
                });
                dialog3.show();

                displaydata(tarot);
                break;
            case 12 :
                tarot.calculscore( "", nomscore.getNom(), tarot.RIEN, 0, false);
                displaydata(tarot);
                break;
            default :
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void displaydata(Tarot tarot){
        ArrayList<NomScore> arrayList = tarot.getArrayList();
        custom_view = new Custom_View(this, arrayList);
        listView.setAdapter(custom_view);
        custom_view.notifyDataSetChanged();
    }

    public void affiche(int quoi){
        quel = quoi;
        AlertDialog.Builder dialog3 = new AlertDialog.Builder(this);
        dialog3.setTitle("Gagner ou Perdu ?");
        dialog3.setItems( st4, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i(TAG, Integer.toString(i));
                if(i == 0){
                    tarot.calculscore(nomscore.getNom(), name, quel, scoreplus, true);
                }else{
                    tarot.calculscore(nomscore.getNom(), name, quel, scoreplus, false);
                }
                displaydata(tarot);
            }
        });
        dialog3.show();

        AlertDialog.Builder dialog1 = new AlertDialog.Builder(this);
        dialog1.setTitle("Nombre de point");
        String[] st1 = tarot.getPoint();
        dialog1.setItems( st1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i(TAG, Integer.toString(i));
                String[] st12 = tarot.getPoint();
                scoreplus = Integer.parseInt(st12[i]);

            }
        });
        dialog1.show();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Avec qui ?");
        String[] st = tarot.getjoueurs();
        dialog.setItems( st, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i(TAG, Integer.toString(i));
                String[] st = tarot.getjoueurs();
                name = st[i];
                Log.i(TAG, name);
            }
        });
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.menu_tarot_activity :
                    tarot.setcopyArrayList();
                    Log.i(TAG, "Retour");
                    displaydata(tarot);
                break;
            default :
                break;
        }
        return true;
    }
}
