package com.example.lebarbu;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    private TextView t11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        AccesBDD MaDb = new AccesBDD(getApplicationContext());
        MaDb.open();
        ArrayList <String> monArray = new ArrayList<String>();
        monArray = MaDb.getLesPrenoms();
        MaDb.close();

        Toast toast1 = Toast.makeText(getApplicationContext(),"0 : "+ monArray.get(0)+ " 1 : "+monArray.get(1) , Toast.LENGTH_LONG);
        toast1.show();
    }
}
