package com.missouristate.kolb.hangman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Hangman game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(game == null) {
            game = new Hangman((Hangman.DEFAULT_GUESSES));
        }
        setContentView(R.layout.activity_main);
        TextView status = findViewById(R.id.status);
        status.setText("" + game.getGuessesLeft());

        FragmentManager fm = getSupportFragmentManager();
        if(fm.findFragmentById(R.id.game_state) == null) {
            FragmentTransaction ft = fm.beginTransaction();
            GameStateFragment fragment = new GameStateFragment();
            ft.add(R.id.game_state, fragment);
            ft.commit();
        }

        if(fm.findFragmentById(R.id.game_result) == null) {
            FragmentTransaction ft = fm.beginTransaction();
            GameResultFragment fragment = new GameResultFragment();
            ft.add(R.id.game_result, fragment);
            ft.commit();
        }

    }





    public void play(View view) {

    }

    public Hangman getGame() {
        return game;
    }
}