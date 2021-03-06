package com.missouristate.kolb.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    private TicTacToe tttGame;
    private Button[] [] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        tttGame = new TicTacToe();
        buildGUIByCode();
    }

    private void buildGUIByCode() {

        //  get width of screen
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x/TicTacToe.SIDE;

        //  create layout manager as GridLayout
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(TicTacToe.SIDE);
        gridLayout.setRowCount(TicTacToe.SIDE);

        //  create buttons and add the GridLayout
        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];
        ButtonHandler bh = new ButtonHandler();

        for (int row = 0; row < TicTacToe.SIDE; row++) {
            for (int col = 0; col < TicTacToe.SIDE; col++) {
                buttons[row][col] = new Button(this);
                buttons[row][col].setTextSize((int)(w * .2));
                buttons[row][col].setOnClickListener(bh);
                gridLayout.addView(buttons [row][col], w, w);
            }
        }

        //  set GridLayout as View of Activity
        setContentView(gridLayout);
    }


    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Log.w("MainActivity", "Inside onClick, v=" + v);
            for(int row = 0; row < TicTacToe.SIDE; row++) {
                for(int col = 0; col < TicTacToe.SIDE; col++) {
                    if (v == buttons[row][col]) {
                        update(row,col);
                    }
                }
            }
        }
    }

    private void update(int row, int col) {
        Log.w("MainActivity", "Inside update: " + row + ", " + col);

        int play = tttGame.play(row, col);
        if(play == 1) {
            buttons[row][col].setText("X");
        } else if(play == 2) {
            buttons[row][col].setText("O");
        }
        if(tttGame.isGameOver()) {
            enableButtons(false);
        }
    }

    public void enableButtons(boolean enabled) {
        for(int row = 0; row < TicTacToe.SIDE; row++) {
            for(int col = 0; col < TicTacToe.SIDE; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }
}