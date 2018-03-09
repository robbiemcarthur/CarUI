package com.rickneilson.carui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FavouriteViewJ extends AppCompatActivity implements View.OnClickListener{
    private Button back_Button;
    private ArrayList<String> favouriteSongs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        ListView faveList = (ListView) findViewById(R.id.faveView);


        favouriteSongs = new ArrayList<>();
        favouriteSongs.add("Jenny Was a Friend of Mine");
        favouriteSongs.add("Mr Brightside");
        favouriteSongs.add("Smile Like You Mean It");
        favouriteSongs.add("Somebody Told Me");

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favouriteSongs);
        faveList.setAdapter(arrayAdapter);


        back_Button=(Button) findViewById(R.id.back_button);
        back_Button.setOnClickListener(this);




    }
    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.back_button){
            onBackPressed();
        }

        // default method for handling onClick Events..
    }
}