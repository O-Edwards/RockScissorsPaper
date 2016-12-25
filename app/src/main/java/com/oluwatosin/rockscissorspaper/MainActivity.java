package com.oluwatosin.rockscissorspaper;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.oluwatosin.rockscissorspaper.R.drawable.paper;
import static com.oluwatosin.rockscissorspaper.R.drawable.rock;
import static com.oluwatosin.rockscissorspaper.R.drawable.scissors;

public class    MainActivity extends AppCompatActivity {

    //Global Music
    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }

    MediaPlayer mediaPlayer;

    //Variable Declaration
    Button b_rock,b_paper,b_scissors;
    TextView tv_score;
    ImageView iv_computerChoice,iv_yourChoice;
    int humanScore, computerScore, drawScore =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Music
        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();



        //Variable Assignment
        //Buttons
        b_paper = (Button) findViewById(R.id.b_paper);
        b_rock = (Button) findViewById(R.id.b_rock);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        //Image View
        iv_computerChoice = (ImageView) findViewById(R.id.iv_ComputerChoice);
        iv_yourChoice = (ImageView) findViewById(R.id.iv_yourChoice);
        //Text View
        tv_score = (TextView) findViewById(R.id.tv_score);

        //Set Actions for Buttons
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                iv_yourChoice.setImageResource(rock);
                String info = game_play("rock");
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: User: " + Integer.toString(humanScore)+ " Computer: " +Integer.toString(computerScore)+ " Draws: " +Integer.toString(drawScore));
            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                iv_yourChoice.setImageResource(scissors);
                String info = game_play("scissors");
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: User: " + Integer.toString(humanScore)+ " Computer: " +Integer.toString(computerScore)+ " Draws: " +Integer.toString(drawScore));

            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                iv_yourChoice.setImageResource(paper);
                String info = game_play("paper");
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: User: " + Integer.toString(humanScore)+ " Computer: " +Integer.toString(computerScore)+ " Draws: " +Integer.toString(drawScore));
            }
        });


    }

    public String game_play(String player_choice) {
        //Declaration Variable
        String computer_choice = "";

        //Random Generator Instantiate
        Random rand = new Random();

        //Random Number from 1 to 3
        int computer_choice_number = rand.nextInt(3)+1;

        //Conditional
        if (computer_choice_number == 1) {
            computer_choice = "rock";}
        else if (computer_choice_number==2){
            computer_choice = "scissors";}
        else if (computer_choice_number==3){
            computer_choice = "paper";}

        //Set Image for Choice
        if (computer_choice.equals("rock")) {
            iv_computerChoice.setImageResource(rock);
        }
        else if (computer_choice.equals("paper")) {
            iv_computerChoice.setImageResource(paper);
        }
        else if (computer_choice.equals("scissors")) {
            iv_computerChoice.setImageResource(scissors);
        }

        //Game Logic
        if(computer_choice == player_choice){
            drawScore++;
            return "It was a draw";
        }
        else if(player_choice == "rock" && computer_choice == "scissors"){
            humanScore++;
            return "Rock beats Scissors, You Win!";
        }
        else if(player_choice == "rock" && computer_choice == "paper"){
            computerScore++;
            return "Paper Beats Rock, You Lose!";
        }
        else if(player_choice == "scissors" && computer_choice == "rock"){
            computerScore++;
            return "Rock beats Scissors, You Lose!";
        }
        else if(player_choice == "scissors" && computer_choice == "paper"){
            humanScore++;
            return "Scissors beats Paper, You Win!";
        }
        else if(player_choice == "paper" && computer_choice == "rock"){
            humanScore++;
            return "Paper beats Rock, You Win!";
        }
        else if(player_choice == "paper" && computer_choice == "scissors"){
            computerScore++;
            return "Scissors beats Paper, You Lose!";
        }
        else return "Impossible lol";
    }

}
