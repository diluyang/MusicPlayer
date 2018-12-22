package com.example.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MusicActivity extends AppCompatActivity {
    String path;
    String presongPath;
    String nextsongPath;
    MediaPlayer mediaPlayer=new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Intent intent = getIntent();
         path = intent.getStringExtra("path");
         presongPath = intent.getStringExtra("presongpath");
         nextsongPath = intent.getStringExtra("nextsongpath");


        Button startbutton = (Button)findViewById(R.id.start);
        Button stopbutton = (Button)findViewById(R.id.stop);
        Button pausebutton = (Button)findViewById(R.id.pause);
        Button prebutton = (Button)findViewById(R.id.pre);
        Button nextbutton = (Button)findViewById(R.id.next);
        //播放
        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(path);

            }
        });

        //停止
        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });

        //暂停
        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }else{
                    mediaPlayer.start();
                }
            }
        });

        //播放下一曲
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("MusicActivite","nextSong");
               play(nextsongPath);

            }
        });

        //播放上一曲
        prebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(presongPath);
            }
        });
    }

    //播放
            public void play(String path){
            try{

                mediaPlayer.reset();

                mediaPlayer.setDataSource(path);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaP) {
                        mediaP.start();
                    }
                });


            }catch (Exception e){
                Log.v("MusicService", e.getMessage());
                }

            }
}
