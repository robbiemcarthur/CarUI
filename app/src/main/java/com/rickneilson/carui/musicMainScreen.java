package com.rickneilson.carui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class musicMainScreen extends AppCompatActivity {
    private Button back_Button, favorites_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_main);

        back_Button=(Button) findViewById(R.id.back_button);
        back_Button.setOnClickListener((View.OnClickListener) this);

        favorites_button=(Button) findViewById(R.id.favorites_button);
        favorites_button.setOnClickListener((View.OnClickListener) this);
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
        if(v.getId()==R.id.favorites_button){
            onBackPressed();
        }

        // default method for handling onClick Events..
    }
}

