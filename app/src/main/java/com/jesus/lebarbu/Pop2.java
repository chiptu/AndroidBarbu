package com.jesus.lebarbu;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class Pop2 extends Activity {

    private TextView t1;
    private static String MaRegle;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop2);


        t1 = (TextView) findViewById(R.id.textView);

        t1.setText(MaRegle);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.75),(int)(height*0.3));

    }

    public static void setMaRegle (String pMaRegle)
    {
        MaRegle = pMaRegle;
    }
}
