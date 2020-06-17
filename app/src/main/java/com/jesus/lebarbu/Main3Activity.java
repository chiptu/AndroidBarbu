package com.jesus.lebarbu;

import android.content.Intent;
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
    private ImageButton btnRetour;
    private ImageView Carte;
    private ImageView Carte2;
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

        int[] HistoriqueCarte;

        MaDb.close();

        btnPiocher = (Button) findViewById(R.id.btnPiocher);

        btnRegle = (ImageButton) findViewById(R.id.btnRegle);

        Carte = (ImageView) findViewById(R.id.imageView) ;

        Carte2 = (ImageView) findViewById(R.id.imageView2) ;

        tPrenom = (TextView) findViewById(R.id.tPrenom);

        tRegle = (TextView) findViewById(R.id.tRegle);

        btnInfos = (ImageButton) findViewById(R.id.btnInfos);

        btnRetour = (ImageButton) findViewById(R.id.btnRetour);

        tPrenom.setText("Veuillez piocher une carte");

        CarteJoue.add(0);

        btnInfos.setVisibility(View.INVISIBLE);

        Carte2.setVisibility(View.INVISIBLE);

        btnPiocher.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){




                if(CarteJoue.size()==53)
                {
                   CarteJoue.clear();
                   CarteJoue.add(0);
                   int idcarte = getResources().getIdentifier("doscarte","drawable",getPackageName());
                   Carte.setImageResource(idcarte);
                    tRegle.setText("Toutes les cartes ont été piochées");
                    tPrenom.setText("Veuillez piocher une carte");

                    Carte2.setVisibility(View.INVISIBLE);
                }
                else
                    {
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

                        btnInfos.setVisibility(View.VISIBLE);

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
                            Pop2.setMaRegle(ArrayRegle.get(31));
                        }
                        else if (numCarte % 13 ==7)
                        {
                            tRegle.setText(ArrayRegle.get(1)+"!"+" "+ArrayRegle.get(2) );
                            Pop2.setMaRegle(ArrayRegle.get(3));
                        }
                        else if (numCarte % 13 ==8)
                        {
                            tRegle.setText(ArrayRegle.get(5)+"!"+" "+ArrayRegle.get(6) );
                            Pop2.setMaRegle(ArrayRegle.get(7));
                        }
                        else if (numCarte % 13 ==9)
                        {
                            tRegle.setText(ArrayRegle.get(9)+"!"+" "+ArrayRegle.get(10) );
                            Pop2.setMaRegle(ArrayRegle.get(11));
                        }
                        else if (numCarte % 13 ==10)
                        {
                            tRegle.setText(ArrayRegle.get(13)+"!"+" "+ArrayRegle.get(14) );
                            Pop2.setMaRegle(ArrayRegle.get(15));
                        }
                        else if (numCarte % 13 ==11)
                        {
                            tRegle.setText(ArrayRegle.get(17)+"!"+" "+ArrayRegle.get(18) );
                            Pop2.setMaRegle(ArrayRegle.get(19));
                        }
                        else if (numCarte % 13 ==12)
                        {
                            tRegle.setText(ArrayRegle.get(21)+"!"+" "+ArrayRegle.get(22) );
                            Pop2.setMaRegle(ArrayRegle.get(23));
                        }
                        else if (numCarte % 13 ==0)
                        {
                            tRegle.setText(ArrayRegle.get(25)+"!"+" "+ArrayRegle.get(26) );
                            Pop2.setMaRegle(ArrayRegle.get(27));
                        }

                        else
                        {
                            tRegle.setText(ArrayPrenom.get(monNum)+" distribue "+numCarte%13+ " gorgées.");
                            btnInfos.setVisibility(View.INVISIBLE);
                        }


                        String macarte = "c"+String.valueOf(numCarte);


                        int idcarte = getResources().getIdentifier(macarte,"drawable",getPackageName());


                        Carte.setImageResource(idcarte);

                        if (CarteJoue.size()>2)
                        {
                            Carte2.setVisibility(View.VISIBLE);

                            String ancienneCarte = "c"+String.valueOf(CarteJoue.get(CarteJoue.size()-2));

                            int idcarte2 = getResources().getIdentifier(ancienneCarte,"drawable",getPackageName());

                            Carte2.setImageResource(idcarte2);
                        }


                    }





            }

        });

        btnRetour.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openRetour();
            }
        });

        btnInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main3Activity.this, Pop2.class));

            }
        });

        btnRegle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this, MainActivity4.class));
            }
        });
    }



    public void openRetour()
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }



    public void toastMessage()
    {
        AccesBDD MaDb = new AccesBDD(getApplicationContext());

        MaDb.open();

        ArrayList <String> ArrayPrenom = new ArrayList<String>();
        ArrayPrenom = MaDb.getLesRegles();

        Toast toast1 = Toast.makeText(getApplicationContext(), Integer.toString(CarteJoue.size()), Toast.LENGTH_LONG);
        toast1.show();

    }

}
