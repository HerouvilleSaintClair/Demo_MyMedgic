package com.example.cstagiaire.demo_bloc;

import android.content.Context;

import java.util.Calendar;

/**
 * Created by cstagiaire on 01/04/2016.
 */
public class Jour {

    public Jour(Context context){

    }
    public String getSemaine(){
        String semaine = "";
        Calendar calendar = Calendar.getInstance();
       switch( calendar.get(Calendar.DAY_OF_WEEK)){
           case 0 :
               semaine += "Lundi";
               break;
           case 1 :
               semaine += "Mardi";
               break;
           case 2:
               semaine += "Mercredi";
               break;
           case 3:
               semaine += "Jeudi";
               break;
           case 4:
               semaine += "Vendredi";
               break;
           case 5 :
               semaine += "Samedi";
               break;
           case 6 :
               semaine += "Dimanche";
               break;
       }
        return semaine ;
    }
    public String getMois(){
        String mois = "" ;
        Calendar calendar = Calendar.getInstance();
        switch( calendar.get(Calendar.MONTH)){
            case 0 :
                mois += "Janvier";
                break;
            case 1 :
                mois += "Février";
                break;
            case 2 :
                mois += "Mars";
                break;
            case 3 :
                mois += "Avril";
                break;
            case 4 :
                mois += "Mai";
                break;
            case 5 :
                mois += "Juin";
                break;
            case 6 :
                mois += "Juillet";
                break;
            case 7 :
                mois += "Août";
                break;
            case 8 :
                mois += "Septembre";
                break;
            case 9 :
                mois += "Octobre";
                break;
            case 10 :
                mois += "Novenmbre";
                break;
            case 11 :
                mois += "Décembre";
                break;
        }
        return mois ;
    }
    public String getDate(){
        String date = "";
        Calendar calendar = Calendar.getInstance();
        date += getSemaine()+" "+ calendar.get(Calendar.DAY_OF_MONTH)+" "+getMois();
        return date;
    }

}
