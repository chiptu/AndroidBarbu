package com.example.lebarbu;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    private TextView t11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        t11 = (TextView) findViewById(R.id.editText11);

        Toast toast1 = Toast.makeText(getApplicationContext(), "Mon test", Toast.LENGTH_LONG);
        toast1.show();
    }
}
