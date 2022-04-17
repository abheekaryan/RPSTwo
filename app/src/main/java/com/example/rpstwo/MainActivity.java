package com.example.rpstwo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button0,button1,button2;
    TextView tV1,tV2,tV3;
    ImageView usrInput,compInput;
    MediaPlayer lost, won, matchdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usrInput = findViewById(R.id.usrInput);
        compInput = findViewById(R.id.compInput);

        won = new MediaPlayer();
        won = MediaPlayer.create(this, R.raw.win);
        lost = new MediaPlayer();
        lost = MediaPlayer.create(this, R.raw.lost);
        matchdraw = new MediaPlayer();
        matchdraw = MediaPlayer.create(this, R.raw.matchdraw);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV3);

        String[] arr = {"Rock","Paper","Scissor"};
        final String[] comp = {""};
        // Rock button

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = "Rock";
                usrInput.setImageResource(R.drawable.rock_round);
                tV1.setText(input);

                comp[0] = getRandom(arr);
                String finalComp = comp[0];
                if(finalComp.equals("Rock")){ compInput.setImageResource(R.drawable.rock_round);}
                else if(finalComp.equals("Scissor")){compInput.setImageResource(R.drawable.scissors_round);}
                else{compInput.setImageResource(R.drawable.paper_round);}
                tV2.setText(finalComp);

                //tV2.setText(comp);
                if(input.equals(finalComp)){ tV3.setText(R.string.matchDraw);
                    matchdraw.start();
                }else if(finalComp.equals("Paper")){ tV3.setText(R.string.youLose);
                    lost.start();
                }else{ tV3.setText(R.string.youWon);
                    won.start();;
                }
            }
        });

        // Paper Button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = "Paper";
                usrInput.setImageResource(R.drawable.paper_round);
                tV1.setText(input);

                comp[0] = getRandom(arr);
                String finalComp = comp[0];
                tV2.setText(finalComp);
                if(finalComp.equals("Rock")){ compInput.setImageResource(R.drawable.rock_round);}
                else if(finalComp.equals("Scissor")){compInput.setImageResource(R.drawable.scissors_round);}
                else{compInput.setImageResource(R.drawable.paper_round);}
                tV2.setText(finalComp);
//                switch (finalComp){
//                    case "Rock": compInput.setImageResource(R.drawable.rock_round);
//                    case "Paper": compInput.setImageResource(R.drawable.paper_round);
//                    case "Scissor": compInput.setImageResource(R.drawable.scissors_round);
//                    default: compInput.setImageResource(R.drawable.blankgrey);
//                }
                //tV2.setText(comp);
                if(input.equals(finalComp)){
                    tV3.setText(R.string.matchDraw);
                    matchdraw.start();;
                }else if(finalComp.equals("Scissor")){
                    tV3.setText(R.string.youLose);
                    lost.start();
                }else{
                    tV3.setText(R.string.youWon);
                    won.start();
                }
            }
        });

        // Scissors Button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usrInput.setImageResource(R.drawable.scissors_round);
                String input = "Scissor";
                tV1.setText(input);

                comp[0] = getRandom(arr);
                String finalComp = comp[0];
                tV2.setText(finalComp);
                if(finalComp.equals("Rock")){ compInput.setImageResource(R.drawable.rock_round);}
                else if(finalComp.equals("Scissor")){compInput.setImageResource(R.drawable.scissors_round);}
                else{compInput.setImageResource(R.drawable.paper_round);}
                tV2.setText(finalComp);
//                switch (finalComp){
//                    case "Rock": compInput.setImageResource(R.drawable.rock_round);
//                    case "Paper": compInput.setImageResource(R.drawable.paper_round);
//                    case "Scissor": compInput.setImageResource(R.drawable.scissors_round);
//                    default: compInput.setImageResource(R.drawable.blankgrey);
//                }
                //tV2.setText(comp);
                if(input.equals(finalComp)){
                    tV3.setText(R.string.matchDraw);
                    matchdraw.start();
                }else if(finalComp.equals("Rock")){
                    tV3.setText(R.string.youLose);
                    lost.start();
                }else{
                    tV3.setText(R.string.youWon);
                    won.start();
                }
            }
        });
    }

    private String getRandom(String[] arr) {
        int rnd = new Random().nextInt(arr.length);
        return arr[rnd];
    }
}