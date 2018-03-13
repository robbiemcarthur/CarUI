package com.rickneilson.carui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class searchMedia extends AppCompatActivity {
    private Button back_Button, app_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_main);

        back_Button=(Button) findViewById(R.id.back_button);
        back_Button.setOnClickListener((View.OnClickListener) this);

        app_button=(Button) findViewById(R.id.app_button);
        app_button.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.back_button){
            onBackPressed();
        }

        // default method for handling onClick Events..
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.app_button){
            onBackPressed();
        }

        // default method for handling onClick Events..
    }
}

