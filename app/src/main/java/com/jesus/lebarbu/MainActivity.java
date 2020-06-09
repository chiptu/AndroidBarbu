package com.jesus.lebarbu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
public class MainActivity extends AppCompatActivity {

    private Button btnJouer;
    private ImageButton imageBtnAds;
    private ImageButton imagebtnPi;
    private AdView Mapub;




    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        btnJouer = (Button) findViewById(R.id.btnJouer);
        imageBtnAds = (ImageButton) findViewById(R.id.imageBtnAds);
        imagebtnPi = (ImageButton) findViewById(R.id.imagebtnPi);
        Mapub = (AdView)findViewById(R.id.maPub);

        AdRequest adRequest = new AdRequest.Builder().build();
        Mapub.loadAd(adRequest);

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
              Mapub.setVisibility(View.INVISIBLE);
            }
        });

        AccesBDD MaDb = new AccesBDD(this);
        MaDb.open();
        MaDb.RegleDeBases();
        MaDb.close();

    }


    public void openJoueurs(){
        Intent intent = new Intent(this, Main2Activity.class);


        startActivity(intent);



    }

}
