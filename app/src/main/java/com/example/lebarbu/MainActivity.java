package com.example.lebarbu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnJouer;
    private ImageButton imageBtnAds;
    private ImageButton imagebtnPi;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJouer = (Button) findViewById(R.id.btnJouer);
        imageBtnAds = (ImageButton) findViewById(R.id.imageBtnAds);
        imagebtnPi = (ImageButton) findViewById(R.id.imagebtnPi);

        btnJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJoueurs();
            }
        });

        imagebtnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Pop.class));
            }
        });
        imageBtnAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  openActivity_Pub(); */
            }
        });


        MySQLite MaDb = new MySQLite(getApplicationContext());
    }



    public void openJoueurs(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);



    }

}
