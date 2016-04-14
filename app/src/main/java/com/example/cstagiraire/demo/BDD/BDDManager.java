package com.example.cstagiraire.demo.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by cstagiaire on 06/04/2016.
 */
public class BDDManager {
    private static final String BD_NAME = "Demo.db";
    private static final int BD_VERSION = 1 ;
    private static final String BD_TAB_INSCRIPTION = "Inscription" ;
    private static final String COL_INSCRIPTION_Id = "Id_client" ;
    private static final String COL_INSCRIPTION_Nom = "Nom" ;
    private static final String COL_INSCRIPTION_Prenom = "Prenom" ;
    private static final String COL_INSCRIPTION_Ville = "Ville ";
    private static final String COL_INSCRIPTION_Cp = "Cp" ;

    private BDD BDD;

    public BDDManager(Context context) {
        BDD = new BDD(context,BD_NAME,null,BD_VERSION);
    }
    public void ajouter_Inscription(int Id , String Nom , String Prenom , String Ville , int Cp){
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_INSCRIPTION_Id,Id);
        valeurs.put(COL_INSCRIPTION_Nom,Nom);
        valeurs.put(COL_INSCRIPTION_Prenom,Prenom);
        valeurs.put(COL_INSCRIPTION_Ville,Ville);
        valeurs.put(COL_INSCRIPTION_Cp,Cp);
        SQLiteDatabase bd = BDD.getWritableDatabase();
        bd.insert(BD_TAB_INSCRIPTION,null,valeurs);
    }
    public void supprimerInscription(){
        SQLiteDatabase bd = BDD.getWritableDatabase();
        bd.delete(BD_TAB_INSCRIPTION,null,null);
    }
    public Cursor getToutInfos(){
        String [] colonnes = new String[] {COL_INSCRIPTION_Id,COL_INSCRIPTION_Nom,COL_INSCRIPTION_Prenom,COL_INSCRIPTION_Ville,COL_INSCRIPTION_Cp};
        String where = null;
        String groupBy = null;
        String having = null ;
        SQLiteDatabase bd = BDD.getWritableDatabase();
        Cursor cursor = bd.query(BD_TAB_INSCRIPTION, null, null, null, null, null, null); // il faut 7 arguments
        return cursor;
    }



}
