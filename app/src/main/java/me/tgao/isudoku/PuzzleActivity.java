package me.tgao.isudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PuzzleActivity extends AppCompatActivity {

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_layout);

        db = new DatabaseHelper(this);

        GameEngine gameEngine = GameEngine.getInstance();

        gameEngine.createGrid(this, DifficultyLevel.DEMO);
        gameEngine.setActivity(this);
        gameEngine.setDB(db);
        gameEngine.startTimer();
    }
}
