package me.tgao.isudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PuzzleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_layout);

        GameEngine gameEngine = GameEngine.getInstance();

        gameEngine.createGrid(this, DifficultyLevel.DEMO);
        gameEngine.startTimer();
        gameEngine.setActivity(this);
    }
}
