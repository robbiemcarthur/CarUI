package com.rickneilson.carui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private Button musicButton;
    private Button buttonA,buttonB,buttonC,buttonD,buttonE,buttonF,buttonG,buttonH,buttonI,buttonJ,buttonK,buttonL, buttonM;
    private Button buttonN, buttonO,buttonP,buttonQ,buttonR,buttonS,buttonT,buttonU,buttonV,buttonW, buttonX, buttonY,buttonZ;
    private String alphabet;
    private String search;
    private ArrayList<String> ablums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = "";

        musicButton = (Button) findViewById(R.id.music_button);
        buttonA = (Button) findViewById(R.id.button_a);
        buttonA.setOnClickListener(this);
        buttonB = (Button) findViewById(R.id.button_b);
        buttonB.setOnClickListener(this);
        buttonC = (Button) findViewById(R.id.button_c);
        buttonC.setOnClickListener(this);
        buttonD = (Button) findViewById(R.id.button_d);
        buttonD.setOnClickListener(this);
        buttonE = (Button) findViewById(R.id.button_e);
        buttonE.setOnClickListener(this);
        buttonF = (Button) findViewById(R.id.button_f);
        buttonF.setOnClickListener(this);
        buttonG = (Button) findViewById(R.id.button_g);
        buttonG.setOnClickListener(this);
        buttonH = (Button) findViewById(R.id.button_h);
        buttonA.setOnClickListener(this);
        buttonI = (Button) findViewById(R.id.button_i);
        buttonI.setOnClickListener(this);
        buttonJ = (Button) findViewById(R.id.button_j);
        buttonJ.setOnClickListener(this);
        buttonK = (Button) findViewById(R.id.button_k);
        buttonK.setOnClickListener(this);
        buttonL = (Button) findViewById(R.id.button_l);
        buttonL.setOnClickListener(this);
        buttonM = (Button) findViewById(R.id.button_m);
        buttonM.setOnClickListener(this);
        buttonN = (Button) findViewById(R.id.button_n);
        buttonN.setOnClickListener(this);
        buttonO = (Button) findViewById(R.id.button_o);
        buttonO.setOnClickListener(this);
        buttonP = (Button) findViewById(R.id.button_p);
        buttonP.setOnClickListener(this);
        buttonQ = (Button) findViewById(R.id.button_q);
        buttonQ.setOnClickListener(this);
        buttonR = (Button) findViewById(R.id.button_r);
        buttonR.setOnClickListener(this);
        buttonS = (Button) findViewById(R.id.button_s);
        buttonS.setOnClickListener(this);
        buttonT = (Button) findViewById(R.id.button_t);
        buttonT.setOnClickListener(this);
        buttonU = (Button) findViewById(R.id.button_u);
        buttonU.setOnClickListener(this);
        buttonV = (Button) findViewById(R.id.button_v);
        buttonV.setOnClickListener(this);
        buttonW = (Button) findViewById(R.id.button_w);
        buttonW.setOnClickListener(this);
        buttonX = (Button) findViewById(R.id.button_x);
        buttonX.setOnClickListener(this);
        buttonY = (Button) findViewById(R.id.button_y);
        buttonY.setOnClickListener(this);
        buttonZ = (Button) findViewById(R.id.button_z);
        buttonZ.setOnClickListener(this);

        //this doen't actually work
        //just removes background
        //need to use Color.COLOR instead
        //but that removes border shape
        buttonZ.setBackgroundColor(0x9e9e9e);
        buttonY.setBackgroundColor(0x9e9e9e);
        buttonX.setBackgroundColor(0x9e9e9e);
        buttonQ.setBackgroundColor(0x9e9e9e);
        buttonV.setBackgroundColor(0x9e9e9e);
        buttonJ.setBackgroundColor(0x9e9e9e);



        alphabet = "abcdefghijklmnopqrstuvwxyz";

        ablums = new ArrayList<>();
        ablums.add("Hotel California");
        ablums.add("Thriller");
        ablums.add("Ride the lightning");
        ablums.add("Hybrid theory");
        ablums.add("Apetite for destruction");
        ablums.add("Nevermind");
        ablums.add("Rage against the machine");

        musicButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SearchActivity.this.finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        // default method for handling onClick Events..
    }

    private void updateButtons(){
        ArrayList<String> letters = new ArrayList<>();
        int l = search.length();
        for(String s : ablums){
            letters.add(s.substring(0,l+1));
        }



    }

}
