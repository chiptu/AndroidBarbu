package com.jesus.lebarbu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;


import java.util.ArrayList;

// ACCESBDD VA FAIRE ROLE DE DAO (SAUF QUE LA JE N AI PAS D OBJET MAIS DES REQUETES EN DUR)
public class AccesBDD

{

    private SQLiteDatabase bdd;

    private MySQLite maBaseSQLite;

    public AccesBDD(Context context)
    {
        //On crée la BDD et sa table
        if (maBaseSQLite == null)
        {
             maBaseSQLite = new MySQLite(context);

        }
    }



    public void open()

    {
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public void AjouterLesPrenoms(String [] LesPrenoms)

    {
        String ajouterPrenoms ="INSERT INTO PRENOMS (idPrenom,nomPrenom) VALUES ";
        for (int i =0;i!= LesPrenoms.length;i++)
        {
            if ((i+1) == LesPrenoms.length)
            {
                ajouterPrenoms += "("+(i+1)+","+"'"+LesPrenoms[i]+"'"+");";
                //bdd.execSQL(ajouterPrenoms);


            }
            else
            {
                ajouterPrenoms += "("+(i+1)+","+"'"+LesPrenoms[i]+"'"+"),";
            }

        }
        bdd.execSQL(ajouterPrenoms);
    }



    public void supprimerLesPrenoms()

    {
        String requeteSupprimerLesPrenoms ="DELETE FROM PRENOMS;";
        bdd.execSQL(requeteSupprimerLesPrenoms);
    }

    public ArrayList<String> getLesPrenoms()
    {
        /*String requeteRecupererPrenoms ="SELECT * FROM PRENOMS;";
        bdd.execSQL(requeteRecupererPrenoms);*/

        ArrayList<String> array_list = new ArrayList<String>();

        Cursor res = bdd.rawQuery( "SELECT * FROM PRENOMS", null );
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex("idPrenom")));
            array_list.add(res.getString(res.getColumnIndex("nomPrenom")));
            res.moveToNext();
        }
        return array_list;

    }

    public void RegleDeBases()
    {

        String requeteSupprimerLesRegles ="DELETE FROM REGLES;";
        bdd.execSQL(requeteSupprimerLesRegles);

        String requeteAjouterLesRegles ="INSERT INTO REGLES (idCarte,nomCarte,nomRegle,descriptifRegle) VALUES (7,'SEPT','Dans ma valise','Pour jouer à \"Dans ma valise\" il faut qu un premier joueur prononce la phrase \"Dans ma valise il y a...\" et ajoute un mot pour compléter la phrase. Le deuxième joueur doit reprendre entièrement la phrase du premier joueur et y ajouter aussi un mot.Le jeu continue ainsi jusqu à ce qu un joueur se trompe !'),";
        requeteAjouterLesRegles += "(8, 'HUIT', 'J ai déjà/ je n ai jamais','Le joueur dont c est le tour dit quelque chose qui l a déjà ou jamais fait et ceux dont ce n est pas le cas boivent'),";
        requeteAjouterLesRegles += "(9, 'NEUF', 'L anecdote', 'Le joueur dont c est le tour doit raconter une anecdote vraie ou fausse.'),";
        requeteAjouterLesRegles += "(10, 'DIX', 'Qui pourrait', 'Le joueur dont c est le tour doit dire une fantaisie après un décompte de 3 secondes chacun doit pointer du doigt la personne et chacun doit boire autant de gorgées qu il est désigné'),";
        requeteAjouterLesRegles += "(11, 'VALET', 'Tu es le roi des pouces', 'Le joueur dont c est le tour devient le roi des pouces. Dès qu il met son pouce sur son menton tout le monde doit faire de même ,le dernier a perdu'),";
        requeteAjouterLesRegles += "(12, 'DAME', 'Tournée générale', 'Tous les joueurs boivent le même nombre de gorgées'),";
        requeteAjouterLesRegles += "(13, 'ROI', 'Invente une règle', 'Le joueur dont c est le tour invente une règle et peut enlever une règle précédente si l envie lui prend.'),";
        requeteAjouterLesRegles += "(14, 'AS', 'Cul Sec!', 'Le joueur dont c est le tour doit prendre cul sec.');";

        bdd.execSQL(requeteAjouterLesRegles);


    }

    public void supprimerLesRegles()

    {
        String requeteSupprimerLesRegles ="DELETE FROM REGLES;";
        bdd.execSQL(requeteSupprimerLesRegles);
    }

    public void ModifierRegle(int idCarte , String nomRegle, String descriptifRegle)
    {
        String requeteModifierRegle ="UPDATE REGLES SET nomRegle='"+nomRegle+"', descriptifRegle ='"+descriptifRegle+"' WHERE idCarte ="+idCarte+";";
        bdd.execSQL(requeteModifierRegle);
    }


    public ArrayList<String> getLesRegles()
    {
        /*String requeteRecupererRegles ="SELECT * FROM REGLES;";
        bdd.execSQL(requeteRecupererRegles);
        Impossible read avec execsql car void*/

        try {

            ArrayList<String> array_list = new ArrayList<String>();

            Cursor res = bdd.rawQuery("SELECT * FROM REGLES", null);
            res.moveToFirst();
            while (res.isAfterLast() == false) {
                array_list.add(res.getString(res.getColumnIndex("idCarte")));
                array_list.add(res.getString(res.getColumnIndex("nomCarte")));
                array_list.add(res.getString(res.getColumnIndex("nomRegle")));
                array_list.add(res.getString(res.getColumnIndex("descriptifRegle")));
                res.moveToNext();
            }
            return array_list;
        }
        catch(Exception e)
        {
            return null;
        }
    }


}
