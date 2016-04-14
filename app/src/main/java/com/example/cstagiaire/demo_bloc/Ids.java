package com.example.cstagiaire.demo_bloc;

import com.example.cstagiaire.demo_drag.R;

import java.util.ArrayList;

/**
 * Created by cstagiaire on 31/03/2016.
 */
public class Ids {

    public ArrayList<Integer> ids;

    public Ids(){
        ids = new ArrayList();
        ids.add(R.id.bloc_1);
        ids.add(R.id.bloc_2);
        ids.add(R.id.bloc_3);
        ids.add(R.id.bloc_4);
        ids.add(R.id.bloc_5);
        ids.add(R.id.bloc_6);
        ids.add(R.id.bloc_7);
        ids.add(R.id.bloc_8);
        ids.add(R.id.bloc_9);
        ids.add(R.id.bloc_10);
        ids.add(R.id.bloc_11);
        ids.add(R.id.bloc_12);
        ids.add(R.id.bloc_13);
        ids.add(R.id.bloc_14);
        ids.add(R.id.bloc_15);
        ids.add(R.id.bloc_16);
        ids.add(R.id.bloc_17);
        ids.add(R.id.bloc_18);
        ids.add(R.id.bloc_19);
        ids.add(R.id.bloc_20);

    }
    public int getId(int index){
        return ids.get(index);
    }
}
