package com.example.tarot.compteurtarot;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jean_jean on 4/26/2015.
 */
public class Custom_View extends BaseAdapter{

    private Activity activity;
    private ArrayList<NomScore> arrayList = new ArrayList<NomScore>();

    public Custom_View(Activity act, ArrayList map){
        activity = act;
        arrayList = map;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.custom_view, null);
        TextView textViewn = (TextView) view.findViewById(R.id.name);
        TextView textViews = (TextView) view.findViewById(R.id.score);

        NomScore ns = arrayList.get(i);

        textViewn.setText(ns.getNom());
        textViews.setText(Integer.toString(ns.getScore()));
        if(ns.isMort().equals("mort")){
           view.setBackgroundColor(Color.RED);
        }
        return view;
    }
}
