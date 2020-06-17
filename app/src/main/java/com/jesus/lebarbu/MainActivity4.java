package com.jesus.lebarbu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity4 extends AppCompatActivity {

    private ImageButton btnRetour;
    private ImageButton btnSave;

    private EditText eNom1;
    private EditText eNom2;
    private EditText eNom3;
    private EditText eNom4;
    private EditText eNom5;
    private EditText eNom6;
    private EditText eNom7;
    private EditText eNom8;

    private EditText eRegle1;
    private EditText eRegle2;
    private EditText eRegle3;
    private EditText eRegle4;
    private EditText eRegle5;
    private EditText eRegle6;
    private EditText eRegle7;
    private EditText eRegle8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        AccesBDD MaDb = new AccesBDD(getApplicationContext());

        MaDb.open();

        final ArrayList<String> ArrayRegle = MaDb.getLesRegles();

        eNom1 = (EditText) findViewById(R.id.InputNom7);
        eNom2 = (EditText) findViewById(R.id.InputNom8);
        eNom3 = (EditText) findViewById(R.id.InputNom9);
        eNom4 = (EditText) findViewById(R.id.InputNom10);
        eNom5 = (EditText) findViewById(R.id.InputNomValet);
        eNom6 = (EditText) findViewById(R.id.InputNomDame);
        eNom7 = (EditText) findViewById(R.id.InputNomRoi);
        eNom8 = (EditText) findViewById(R.id.InputNomAs);

        eRegle1 = (EditText) findViewById(R.id.InputDescription7);
        eRegle2 = (EditText) findViewById(R.id.InputDescription8);
        eRegle3 = (EditText) findViewById(R.id.InputDescription9);
        eRegle4 = (EditText) findViewById(R.id.InputDescription10);
        eRegle5 = (EditText) findViewById(R.id.InputDescriptionValet);
        eRegle6 = (EditText) findViewById(R.id.InputDescriptionDame);
        eRegle7 = (EditText) findViewById(R.id.InputDescriptionRoi);
        eRegle8 = (EditText) findViewById(R.id.InputDescriptionAs);

        eRegle8.setText(ArrayRegle.get(31));
        eNom8.setText(ArrayRegle.get(30));

        eRegle7.setText(ArrayRegle.get(27));
        eNom7.setText(ArrayRegle.get(26));

        eRegle6.setText(ArrayRegle.get(23));
        eNom6.setText(ArrayRegle.get(22));

        eRegle5.setText(ArrayRegle.get(19));
        eNom5.setText(ArrayRegle.get(18));

        eRegle4.setText(ArrayRegle.get(15));
        eNom4.setText(ArrayRegle.get(14));

        eRegle3.setText(ArrayRegle.get(11));
        eNom3.setText(ArrayRegle.get(10));

        eRegle2.setText(ArrayRegle.get(7));
        eNom2.setText(ArrayRegle.get(6));

        eRegle1.setText(ArrayRegle.get(3));
        eNom1.setText(ArrayRegle.get(2));


        btnRetour = (ImageButton) findViewById(R.id.btnRetour3);

        btnSave = (ImageButton) findViewById(R.id.btnSave);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRetour();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaDb.ModifierRegle(7,eNom1.getText().toString(),eRegle1.getText().toString());
                MaDb.ModifierRegle(8,eNom2.getText().toString(),eRegle2.getText().toString());
                MaDb.ModifierRegle(9,eNom3.getText().toString(),eRegle3.getText().toString());
                MaDb.ModifierRegle(10,eNom4.getText().toString(),eRegle4.getText().toString());
                MaDb.ModifierRegle(11,eNom5.getText().toString(),eRegle5.getText().toString());
                MaDb.ModifierRegle(12,eNom6.getText().toString(),eRegle6.getText().toString());
                MaDb.ModifierRegle(13,eNom7.getText().toString(),eRegle7.getText().toString());
                MaDb.ModifierRegle(14,eNom8.getText().toString(),eRegle8.getText().toString());

                Toast toast = Toast.makeText(getApplicationContext(), "Regles bien modifiées", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }





    public void openRetour()
    {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}