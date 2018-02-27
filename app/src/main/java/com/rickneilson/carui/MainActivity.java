package com.rickneilson.carui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URI;


public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{



    private int count = 0;
    private long startMillis=0;
    private MediaPlayer[] tracks;
    private MediaPlayer player;
    private GestureDetectorCompat mDetector;
    private static final String DEBUG_TAG = "Gestures";
    private ImageView albumView;
    private TextView volumeView, songNameView, artistNameView, albumNameView;
    private int volume;
    private int tracknumber;
    private int imageResources[];
    private SeekBar seekbar;
    private View mainLayout, coverView;
    private Uri path1, path2, path3;
    private long timeSinceDouble;
    private String[] songNames, albumNames, artistNames;
    private ImageButton albumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        albumView = (ImageView) findViewById(R.id.album_view);
        volumeView = (TextView) findViewById(R.id.volume_text_view);
        songNameView = (TextView) findViewById(R.id.song_name_view);
        artistNameView = (TextView) findViewById(R.id.artist_name_view);
        albumNameView = (TextView) findViewById(R.id.album_name_view);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        coverView = findViewById(R.id.cover);
        mainLayout = findViewById(R.id.main_layout);
        volume = 50;
        tracknumber = 0;
        timeSinceDouble = System.currentTimeMillis();
        albumButton = (ImageButton) findViewById(R.id.albums_button);

//        path1 = Uri.parse("android.resource://com.rickneilson.carui/" + R.raw.iu);
//        path2 = Uri.parse("android.resource://com.rickneilson.carui/" + R.raw.sunmi);
//        path3 = Uri.parse("android.resource://com.rickneilson.carui/" + R.raw.taeyang);

        albumButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        tracks = new MediaPlayer[3];
        tracks[0] = MediaPlayer.create(this, R.raw.iu);
        tracks[1] = MediaPlayer.create(this, R.raw.sunmi);
        tracks[2] = MediaPlayer.create(this, R.raw.taeyang);
        player = tracks[0];

        songNames = new String[] {"Palette", "Heroine", "Eyes, Nose, Lips"};
        artistNames = new String[] {"IU", "Sunmi", "Taeyang"};
        albumNames = new String[] {"Palette", "Heroine", "Rise"};

        imageResources = new int[3];
        imageResources[0] = R.drawable.iu;
        imageResources[1] = R.drawable.sunmi;
        imageResources[2] = R.drawable.taeyang;

       // player = MediaPlayer.create(this, R.raw.iu);
        player.setVolume(0.5f,0.5f);

        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
        volumeView.setVisibility(View.INVISIBLE);
        coverView.setVisibility(View.INVISIBLE);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + event1.toString() + event2.toString());
        coverView.setVisibility(View.VISIBLE);
        volumeView.setVisibility(View.VISIBLE);
        if(event2.getRawY() < event1.getRawY() && (Math.abs(event2.getRawY() - event1.getRawY()) > 50 && volume < 100))
            volume++;
        else if(event2.getRawY() > event1.getRawY() && (Math.abs(event2.getRawY() - event1.getRawY()) > 50 && volume > 1))
            volume--;
        volumeView.setText(Integer.toString(volume));
        float vol = (float) volume / 100;
        player.setVolume(vol, vol);
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
//        player.reset();
//        try{
//            player.setDataSource(this, path2);
//            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    player.start();
//                }
//            });
//
//        } catch(IOException e){
//            player.stop();
//        }

        if((System.currentTimeMillis() - timeSinceDouble) > 1500){
            player.pause();
            player.seekTo(0);
            tracknumber++;
            player = tracks[tracknumber%3];
            player.setVolume(volume,volume);
            player.start();
            albumView.setImageResource(imageResources[tracknumber%3]);
            songNameView.setText(songNames[tracknumber%3]);
            artistNameView.setText(artistNames[tracknumber%3]);
            albumNameView.setText(albumNames[tracknumber%3]);
        }

        timeSinceDouble = System.currentTimeMillis();

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
        if(player.isPlaying())
            player.pause();
        else
            player.start();
        return true;
    }

}
