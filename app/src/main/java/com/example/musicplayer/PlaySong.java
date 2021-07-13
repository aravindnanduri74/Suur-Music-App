package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;



import java.io.File;
import java.util.ArrayList;

public class PlaySong extends AppCompatActivity {
    TextView txtView;
Button play,pause,previous,next,fastrewind,fastforward;

    ArrayList<File> mySongs;
    MediaPlayer mediaPlayer;
    String textContent;
    int position;
    SeekBar seekBar;
    Thread updateSeek;
    String txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        play=findViewById(R.id.play);

        previous=findViewById(R.id.prev);
        next=findViewById(R.id.next);
        fastrewind=findViewById(R.id.fastrewind);
        fastforward=findViewById(R.id.fastforward);
        seekBar=findViewById(R.id.seekBar);
;




        txtView=findViewById(R.id.textView);

        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
  mySongs = (ArrayList) bundle.getParcelableArrayList("songs");
position= bundle.getInt("pos",0);
        textContent = intent.getStringExtra("songsName");
        Uri uri=Uri.parse(mySongs.get(position).toString());
        txt= mySongs.get(position).getName();
        txtView.setText(txt);
        mediaPlayer = MediaPlayer.create(this,uri);
        mediaPlayer.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    //to change bg
                    play.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);

                    mediaPlayer.pause();
                }
                else{

                    play.setBackgroundResource(R.drawable.ic_baseline_pause_24); //first button changed
                    mediaPlayer.start();
                }


            }
        });





    }
}