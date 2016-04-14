package com.example.cstagiaire.demo_bloc;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cstagiaire.demo_drag.R;
import com.example.cstagiraire.demo.BDD.BDDManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Intent intent;
    private LinearLayout base ;
    private LinearLayout recipient_1;
    private LinearLayout recipient_2;
    private LinearLayout recipient_3;
    private LinearLayout recipient_4;
    private LinearLayout recipient_5;
    private Colors colors;
    private int id_temporaire = 0;
    // pour ajouter les id dans Android4.0 , on dois créer une XML qui contient de tout les contenues de id , et on lire le XML et stocker les id dans une class
    private Ids ids ;
    // On suppose que maintenant on déja bien obtenu les contenues sur serveur , on les stocker dans une liste
    private ArrayList<ArrayList<String>> contenues = new ArrayList();
    private TextView temps;
    private TextView nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int compter_nombre_recipient = 0;
        ids = new Ids();

        recipient_1 = (LinearLayout)findViewById(R.id.recipient_1);
        recipient_2 = (LinearLayout)findViewById(R.id.recipient_2);
        recipient_3 = (LinearLayout)findViewById(R.id.recipient_3);
        recipient_4 = (LinearLayout)findViewById(R.id.recipient_4);
        recipient_5 = (LinearLayout)findViewById(R.id.recipient_5);

        Log.d("condition", this.getResources().getConfiguration().orientation+" "+compter_nombre_recipient);
        base = (LinearLayout)findViewById(R.id.base);
    // Cette BDD est une demo  , on supporser cette BDD comtient les contenues
        BDDManager bddManager = new BDDManager(this);
        // ici on peut ajouter les commandes dynamique

        //   -----end------
        ArrayList<Cursor> contenuesBDD = new ArrayList();
        //contenuesBDD.get(0) est la table Inscription
        contenuesBDD.add(bddManager.getToutInfos());
        String info = "" ;
        info += "Aujourd'hui s'inscrit \n\n";
        //for(Cursor.moveToFirst;!Cursor.isAfgerLast,Cursor.moveToNext)
        for(contenuesBDD.get(0).moveToFirst();!contenuesBDD.get(0).isAfterLast();contenuesBDD.get(0).moveToNext()){
            info += contenuesBDD.get(0).getString(1)+" "+contenuesBDD.get(0).getString(2)+"\n";
        }

        RelativeLayout bloc_test = getBloc(info, getParames(), Color.BLUE);
        bloc_test.setOnTouchListener(new BlocTouchLisenter());
        bloc_test.setId(R.id.bloc_20);
        recipient_2.addView(bloc_test);
    //  ---end----

        colors = new Colors(this);
         /*
                On suppose que maintenant on déja bien obtenu les contenues sur serveur , on les stocker dans une liste
                Par exemple les contenues dans serveur sont suivant:
                    0    Entrée (Dureil Monique,Pascal François)
                    1   Sorties(Adam Adelle,Piacé Albert)
                    2    Soins(3 prélèvements , 4 glycémies,2 pansements)
                    3    Anniversaires(Dupont Jacques,Marie Simone)
                    4    Notiffications(3 non lues)
                    5    Absences(David, Nick ,Kea,Caroline)

          */
        // ici on n'a pas encore connecter avec serveur , donc on ajouter les contenues à la main
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        contenues.add(new ArrayList<String>());
        // ajouter les contenues dans Entrée
        contenues.get(0).add("Entrée");
        contenues.get(0).add("Dureil Monique");
        contenues.get(0).add("Pascal François");
        contenues.get(0).add("Dureil Monique");
        contenues.get(0).add("Pascal François");
        contenues.get(0).add("Dureil Monique");
        contenues.get(0).add("Pascal François");
        contenues.get(0).add("Dureil Monique");
        contenues.get(0).add("Pascal François");

        // ajouter les contenues dans Sorties
        contenues.get(1).add("Sorties");
        contenues.get(1).add("Adam Adelle");
        contenues.get(1).add("Piacé Albert");
        // ajouter les contenues dans Soins
        contenues.get(2).add("Soins");
        contenues.get(2).add("3 prélèvements");
        contenues.get(2).add("4 glycémies");
        contenues.get(2).add("2 pansements");
        // ajouter les contenues dans Anniversaires
        contenues.get(3).add("Anniversaires");
        contenues.get(3).add("Dupent JAcques");
        contenues.get(3).add("Maries Simone");
        // ajouter les contenues dans Notiffications
        contenues.get(4).add("Notiffications");
        contenues.get(4).add("3 non lues");
        // ajouter les contenues dans Absences
        contenues.get(5).add("Absences");
        contenues.get(5).add("David");
        contenues.get(5).add("Nick");
        contenues.get(5).add("Kea");
        contenues.get(5).add("Caroline");
        // ajouter les contenues dans Exemple 1
        contenues.get(6).add("Titre");
        contenues.get(6).add("information 1");
        contenues.get(6).add("information 2");
        contenues.get(6).add("information 3");
        contenues.get(6).add("information 4");
        contenues.get(6).add("information 5");
        contenues.get(6).add("infromation 6");
        contenues.get(6).add("infromation 7");
        // ajouter les contenues dans Exemple 2
        contenues.get(7).add("Titre");
        contenues.get(7).add("info 1");
        contenues.get(7).add("info 2");
        contenues.get(7).add("info 3");
        //ajouter les contenues dans Exemple 3
        contenues.get(8).add("Titre");
        contenues.get(8).add("infos 1");
        contenues.get(8).add("infos 2");
        contenues.get(8).add("infos 3");
        contenues.get(8).add("infos 4");
        contenues.get(8).add("infos 5");
        contenues.get(8).add("infos 6");
        //Exemple 4 est vide
        contenues.get(9).add("");
        contenues.get(10).add("");
        // fin d'ajouter
        // créer les blos en boucle
        Log.d("taille_color", colors.taille() + "");

        String infos_temporaire = "";
        // test si c'est nuxes 10
        if(getWindowManager().getDefaultDisplay().getWidth() >= 1300){
            for(int i = 0 ; i < contenues.size() ; i ++){
                infos_temporaire = contenues.get(i).get(0)+"\n"+"\n";
                for(int j = 1 ; j < contenues.get(i).size() ; j ++){
                    infos_temporaire += contenues.get(i).get(j)+"\n";
                }
                RelativeLayout bloc = getBloc(infos_temporaire, getParames(), colors.getColor(i % colors.taille()));
                bloc.setId(ids.getId(i));

                if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                    if(i%3 == 0){
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        recipient_1.addView(bloc);
                        recipient_1.setGravity(Gravity.CENTER_HORIZONTAL);

                        //  recipient_1.setOnDragListener(new MyDragListener());
                    }
                    else if(i%3 == 1){
                        recipient_2.addView(bloc);
                        recipient_2.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        //  recipient_2.setOnDragListener(new MyDragListener());
                    } else{
                        recipient_3.addView(bloc);
                        recipient_3.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        // recipient_3.setOnDragListener(new MyDragListener());
                    }
                }
                // c'est horizontal
                else if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    if(i%5 == 0){
                        recipient_1.addView(bloc);
                        recipient_1.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        //recipient_1.setOnDragListener(new MyDragListener());
                    }
                    else if(i%5 == 1){
                        recipient_2.addView(bloc);
                        recipient_2.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        // recipient_2.setOnDragListener(new MyDragListener());
                    }
                    if(i%5 == 2){
                        recipient_3.addView(bloc);
                        recipient_3.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        // recipient_3.setOnDragListener(new MyDragListener());
                    }
                    else if(i%5 == 3){
                        recipient_4.addView(bloc);
                        recipient_4.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        //  recipient_4.setOnDragListener(new MyDragListener());
                    }
                    else if(i%5 == 4){
                        recipient_5.addView(bloc);
                        recipient_5.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        //  recipient_5.setOnDragListener(new MyDragListener());
                    }
                }
            }
        }
        // test c'est Nuxes 7
        else{
            for(int i = 0 ; i < contenues.size() ; i ++){
                infos_temporaire = contenues.get(i).get(0)+"\n";
                // pour contrôle les lignes d'afficher , il faut inférieur 3 lignes , ici je mis 4 parce que "j" commence avec "1"
                int limite = 4;

                if (limite < contenues.get(i).size()){
                    limite = 4;
                }
                else{
                    limite = contenues.get(i).size();
                }
                // ici on limite qu'afficher 3 ligne au plus
                for(int j = 1 ; j < limite ; j ++){
                    infos_temporaire += contenues.get(i).get(j)+"\n";
                }
                RelativeLayout bloc = getBloc(infos_temporaire, getParames(), colors.getColor(i % colors.taille()));
                bloc.setId(ids.getId(i));
                // test c'est vertical
                if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                    if(i%2 == 0){
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        recipient_1.addView(bloc);
                        recipient_1.setGravity(Gravity.CENTER_HORIZONTAL);

                        //  recipient_1.setOnDragListener(new MyDragListener());
                    }
                    else if(i%2 == 1){
                        recipient_2.addView(bloc);
                        recipient_2.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        //  recipient_2.setOnDragListener(new MyDragListener());
                    }
                }
                // test c'est horizontal
                else if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    if(i%4 == 0){
                        recipient_1.addView(bloc);
                        recipient_1.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        //recipient_1.setOnDragListener(new MyDragListener());
                    }
                    else if(i%4 == 1){
                        recipient_2.addView(bloc);
                        recipient_2.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        // recipient_2.setOnDragListener(new MyDragListener());
                    }
                    if(i%4 == 2){
                        recipient_3.addView(bloc);
                        recipient_3.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        // recipient_3.setOnDragListener(new MyDragListener());
                    }
                    else if(i%4 == 3){
                        recipient_4.addView(bloc);
                        recipient_4.setGravity(Gravity.CENTER_HORIZONTAL);
                        bloc.setOnTouchListener(new BlocTouchLisenter());
                        //  recipient_4.setOnDragListener(new MyDragListener());
                    }
                }
            }
        }

        temps = (TextView)findViewById(R.id.temps);
        nom = (TextView)findViewById(R.id.nom);
        Jour jour = new Jour(this);
        temps.setText(jour.getDate());
        nom.setText("Bonjour Elsa !");


    }

    private void ajouterDansInscription(){
        BDDManager bddManager = new BDDManager(this);
        bddManager.ajouter_Inscription(1, "AAA", "aaaaaa", "Caen", 14000);
        bddManager.ajouter_Inscription(2, "BBBB", "bbbbbbb", "Hérouville saint clair", 14200);
        bddManager.ajouter_Inscription(3, "CCCC", "ccccccc", "Paris", 75001);
    }


    private LinearLayout.LayoutParams getParames(){

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(20,0,0,20);
        return params;
    }


    private RelativeLayout getBloc(String information, LinearLayout.LayoutParams params, int color){
        RelativeLayout bloc = new RelativeLayout(this);
        TextView text = new TextView(this);
        text.setTextSize(20);
        text.setText(information);
        text.setGravity(Gravity.CENTER);
        bloc.addView(text);
        bloc.setBackgroundColor(color);
        bloc.setGravity(Gravity.CENTER);
        bloc.setLayoutParams(params);  // ajouter paramas pour bloc , c'est à dire que on utilise margin pour contrôler le position

        return bloc;
    }

    public int changeColor(int id_color){
        return colors.getColor(id_color);
    }

    public void getDialog( final int id_bloc){
        new AlertDialog.Builder(this).setTitle("Changer la couleur").setSingleChoiceItems(
                new String[]{"LightCoral", "DarkKhaki", "NavajoWhite", "LightPink", "DarkViolet",
                        "Turguoise", "Orange", "HotPink", "RoyalBlue", "Gold", "CornflowerBlue", "GreenYellow"},
                0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        nom.setText("sélectionner" + which);
                        RelativeLayout bloc = (RelativeLayout) findViewById(id_bloc);
                        bloc.setBackgroundColor(changeColor(which));
                        dialog.dismiss();
                    }
                }).show();
    }

    private final class BlocTouchLisenter implements View.OnTouchListener{

        float x = 0 ;
        float y = 0 ;
        public boolean onTouch(View view ,MotionEvent event){
            if(event.getAction() == event.ACTION_DOWN){
                ClipData date = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(date, shadowBuilder, view, 0);
                x = event.getX();
                y = event.getY();
                getDialog(view.getId());
                nom.setText("x : " + x + "y " + y + " id : " + view.getId());
                return true;
            }
            else {
                return false;
            }
        }
    }

/*
    class MyDragListener implements View.OnDragListener {
        float x = 0 ;
        float deltaX = 0;
        float y = 0 ;
        float deltatY =0;
        public boolean onDrag(View view ,DragEvent event){
           switch(event.getAction()){
               case DragEvent.ACTION_DRAG_STARTED:
                   nom.setText("action_start!");
                   x = event.getX();
                   y = event.getY();
                   break;
               case DragEvent.ACTION_DRAG_ENTERED:
                   nom.setText("action_entered!");
                   break;
               case DragEvent.ACTION_DRAG_EXITED:
                   nom.setText("action_exited!");
                   break;
               case DragEvent.ACTION_DROP:
                   nom.setText("action_Drop!");
                   deltaX = event.getX() - x ;
                   deltatY = event.getY() - y ;
                   break;
               case DragEvent.ACTION_DRAG_ENDED:
                   if(deltaX > 200 && deltatY > 200){
                       nom.setText("ok!");
                   }
                   break;
           }
           return true ;
         }
    }
*/



}

