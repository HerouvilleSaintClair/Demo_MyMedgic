package com.example.cstagiaire.demo_bloc;

import android.content.Context;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by cstagiaire on 31/03/2016.
 */
public class Bloc {

    private Context context ;
    private String information ;
    private RelativeLayout.LayoutParams params ;
    private int color ;
    private int id ;
    public Bloc(Context context,String information,RelativeLayout.LayoutParams params,int color,int id){
        this.context = context ;
        this.information = information ;
        this.params = params ;
        this.color = color ;
        this.id = id ;
    }

    public RelativeLayout getBloc(){
        RelativeLayout bloc = new RelativeLayout(this.context);
        TextView text = new TextView(this.context);
        text.setText(information);
        text.setGravity(Gravity.FILL);
        bloc.addView(text);
        bloc.setBackgroundColor(color);
        bloc.setLayoutParams(params);
        return bloc;
    }
    public String getInformation(){
        return this.information;
    }
    public void setInformation(String newInformation){
        this.information = newInformation;
    }
    public RelativeLayout.LayoutParams getParams(){
        return this.params ;
    }
    public void setParams(RelativeLayout.LayoutParams newParams){
        this.params = newParams ;
    }
    public int getColor(){
        return this.color ;
    }
    public void setColor(int newColor){
        this.color = newColor ;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int newId){
        this.id = newId ;
    }
}
