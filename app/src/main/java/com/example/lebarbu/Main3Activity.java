package com.example.lebarbu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Main3Activity extends AppCompatActivity {

    private TextView tPrenom;
    private Button btnPiocher;
    private ImageButton btnRegle;
    private ImageView Carte;
    private int monNum = -1;

    private TextView tRegle;
    private ImageButton btnInfos;

    private ArrayList <Integer> CarteJoue = new ArrayList<>();


    Random myRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        AccesBDD MaDb = new AccesBDD(getApplicationContext());

        MaDb.open();

        final ArrayList <String> ArrayPrenom = MaDb.getLesPrenoms();


        final int numPrenom = ArrayPrenom.size();

        final ArrayList <String> ArrayRegle = MaDb.getLesRegles();

        MaDb.close();

        btnPiocher = (Button) findViewById(R.id.btnPiocher);

        btnRegle = (ImageButton) findViewById(R.id.btnRegle);

        Carte = (ImageView) findViewById(R.id.imageView) ;

        tPrenom = (TextView) findViewById(R.id.tPrenom);

        tRegle = (TextView) findViewById(R.id.tRegle);

        btnInfos = (ImageButton) findViewById(R.id.btnInfos);

        tPrenom.setText("Veuillez piocher une carte");

        CarteJoue.add(0);

        btnPiocher.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){

                if (monNum+1 != numPrenom)
                {
                    monNum += 2;
                    tPrenom.setText("Carte pioché par "+ArrayPrenom.get(monNum));

                }
                else
                {
                    monNum =1;
                    tPrenom.setText("Carte pioché par "+ArrayPrenom.get(monNum));
                }


                toastMessage();
                int numCarte =0;


                while (CarteJoue.indexOf(numCarte) !=-1)
                {
                    numCarte = myRandom.nextInt(53);
                }

                if (CarteJoue.indexOf(numCarte) ==-1)
                {
                    CarteJoue.add(numCarte);
                }



                if (numCarte % 13 ==1)
                {
                   tRegle.setText(ArrayRegle.get(29)+"!"+" "+ArrayRegle.get(30) );
                }
                else if (numCarte % 13 ==7)
                {
                    tRegle.setText(ArrayRegle.get(1)+"!"+" "+ArrayRegle.get(2) );
                }
                else if (numCarte % 13 ==8)
                {
                    tRegle.setText(ArrayRegle.get(5)+"!"+" "+ArrayRegle.get(6) );
                }
                else if (numCarte % 13 ==9)
                {
                    tRegle.setText(ArrayRegle.get(9)+"!"+" "+ArrayRegle.get(10) );
                }
                else if (numCarte % 13 ==10)
                {
                    tRegle.setText(ArrayRegle.get(13)+"!"+" "+ArrayRegle.get(14) );
                }
                else if (numCarte % 13 ==11)
                {
                    tRegle.setText(ArrayRegle.get(17)+"!"+" "+ArrayRegle.get(18) );
                }
                else if (numCarte % 13 ==12)
                {
                    tRegle.setText(ArrayRegle.get(21)+"!"+" "+ArrayRegle.get(22) );
                }
                else if (numCarte % 13 ==0)
                {
                    tRegle.setText(ArrayRegle.get(25)+"!"+" "+ArrayRegle.get(26) );
                }

                else
                    {
                        tRegle.setText(ArrayPrenom.get(monNum)+" distribue "+numCarte%13+ " gorgées.");
                    }


                String macarte = "c"+String.valueOf(numCarte);

                int idcarte = getResources().getIdentifier(macarte,"drawable",getPackageName());

                Carte.setImageResource(idcarte);



            }

        });


    }

    public void toastMessage()
    {
        AccesBDD MaDb = new AccesBDD(getApplicationContext());

        MaDb.open();

        ArrayList <String> ArrayPrenom = new ArrayList<String>();
        ArrayPrenom = MaDb.getLesRegles();



        Toast toast1 = Toast.makeText(getApplicationContext(),"voici le num de la carte "+ ArrayPrenom.get(29), Toast.LENGTH_LONG);
        toast1.show();
    }

}
