package com.jesus.lebarbu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLite extends SQLiteOpenHelper

{

        private static final int versionBD =1;
        private static final String nomBD ="PrenomsRegles";


        private String requeteCreerTableRegles = "CREATE TABLE REGLES (idCarte INTEGER PRIMARY KEY, nomCarte VARCHAR NOT NULL, nomRegle VARCHAR NOT NULL, descriptifRegle VARCHAR NOT NULL);";
        private String requeteCreerTablePrenoms = "CREATE TABLE PRENOMS (idPrenom INTEGER PRIMARY KEY, nomPrenom VARCHAR NOT NULL);";

        private String requeteDropTablePrenoms = "DROP TABLE IF EXISTS PRENOMS;";
        private String requeteDropTableRegles = "DROP TABLE IF EXISTS REGLES;";



        public MySQLite(Context context)

        {

            super(context,nomBD,null,versionBD);
            SQLiteDatabase MaDb = this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(requeteDropTableRegles);
            db.execSQL(requeteDropTablePrenoms);

            db.execSQL(requeteCreerTableRegles);
            db.execSQL(requeteCreerTablePrenoms);
        }







        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {

            db.execSQL(requeteDropTableRegles);
            db.execSQL(requeteDropTablePrenoms);
            onCreate(db);
            Log.d("Test","Passage dans onUpgrade");

        }
}



