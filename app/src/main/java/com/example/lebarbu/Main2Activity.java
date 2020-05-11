package com.example.lebarbu;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity
{

    private Button btnRetour;
    private Button btnPartie;

    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private TextView t5;
    private TextView t6;
    private TextView t7;
    private TextView t8;
    private TextView t9;
    private TextView t10;

    private EditText e1;
    private EditText e2;
    private EditText e3;
    private EditText e4;
    private EditText e5;
    private EditText e6;
    private EditText e7;
    private EditText e8;
    private EditText e9;
    private EditText e10;

    private boolean PrenomRempli;

    private static int  position2;

    private  ArrayList <EditText> lesEditText =new ArrayList<EditText>();

    private  ArrayList <TextView> lesTextView =new ArrayList<TextView>();







    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);


        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);


        Integer[] items = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, items);
        spinner1.setAdapter(adapter);

        btnRetour = (Button) findViewById(R.id.btnRetour);

        btnPartie = (Button) findViewById(R.id.btnPartie);




        btnRetour.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openRetour();
            }
        });




        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // Do your stuff at item selection time p// position +1


                    position2 = position+1;

                    EnleverEditText(position+1);
                    AjouterEditText(position+1);

                    EnleverTextView(position+1);
                    AjouterTextView(position+1);




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // Intentionally kept blank
            }
        });




        t1 = (TextView) findViewById(R.id.textView3);
        t2 = (TextView) findViewById(R.id.textView4);
        t3 = (TextView) findViewById(R.id.textView5);
        t4= (TextView) findViewById(R.id.textView6);
        t5 = (TextView) findViewById(R.id.textView7);
        t6 = (TextView) findViewById(R.id.textView8);
        t7 = (TextView) findViewById(R.id.textView9);
        t8 = (TextView) findViewById(R.id.textView10);
        t9 = (TextView) findViewById(R.id.textView11);
        t10 = (TextView) findViewById(R.id.textView12);


        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);
        e5 = (EditText) findViewById(R.id.editText5);
        e6 = (EditText) findViewById(R.id.editText6);
        e7 = (EditText) findViewById(R.id.editText7);
        e8 = (EditText) findViewById(R.id.editText8);
        e9 = (EditText) findViewById(R.id.editText9);
        e10 = (EditText) findViewById(R.id.editText10);


        lesEditText.add(e1);
        lesEditText.add(e2);
        lesEditText.add(e3);
        lesEditText.add(e4);
        lesEditText.add(e5);
        lesEditText.add(e6);
        lesEditText.add(e7);
        lesEditText.add(e8);
        lesEditText.add(e9);
        lesEditText.add(e10);

        lesTextView.add(t1);
        lesTextView.add(t2);
        lesTextView.add(t3);
        lesTextView.add(t4);
        lesTextView.add(t5);
        lesTextView.add(t6);
        lesTextView.add(t7);
        lesTextView.add(t8);
        lesTextView.add(t9);
        lesTextView.add(t10);




        btnPartie.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View view)
            {


                PrenomRempli = true;

                String[] TabPrenoms = new String[position2];

                for (int k=0; k< position2;k++)
                {
                    String verif = lesEditText.get(k).getText().toString();

                    TabPrenoms[k] = verif;


                    if (verif.matches(""))
                    {
                        PrenomRempli = false;
                    }



                }
                if (PrenomRempli == false)
                {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Il faut remplir tous les prenoms", Toast.LENGTH_LONG);
                    toast1.show();
                }
                else
                {
                    AccesBDD MaDb = new AccesBDD(getApplicationContext());
                    MaDb.open();
                    String MaRequete = MaDb.AjouterLesPrenoms(TabPrenoms);

                    Toast toast2 = Toast.makeText(getApplicationContext(), MaRequete, Toast.LENGTH_LONG);
                    toast2.show();
                    MaDb.close();
                    //Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    //startActivity(intent);
                }




            }
        });
    }

    public void EnleverEditText(int i)
    {
        for (int k = i; k<10;k++)
        {
            lesEditText.get(k).setVisibility(View.INVISIBLE);
            lesEditText.get(k).setText("");
        }
    }

    public void EnleverTextView(int i)
    {
        for (int k=i; k<10;k++)
        {
            lesTextView.get(k).setVisibility(View.INVISIBLE);
        }
    }


    public void AjouterEditText(int i)
    {
        for (int k=0; k<i;k++)
        {
            lesEditText.get(k).setVisibility(View.VISIBLE);

        }
    }

    public void AjouterTextView(int i)
    {
        for (int k=0; k<i;k++)
        {
            lesTextView.get(k).setVisibility(View.VISIBLE);
        }
    }


    public void openRetour()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
