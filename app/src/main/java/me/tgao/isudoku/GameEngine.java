package me.tgao.isudoku;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.time.Duration;

import me.tgao.isudoku.view.sudokugrid.GameGrid;

public class GameEngine {

    private static GameEngine instance;

    private AppCompatActivity activity;
    private GameGrid grid = null;

    private int selectedPosX = -1, selectedPosY = -1;

    private GameEngine() { }

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }

        return instance;
    }

    public void createGrid(Context context, DifficultyLevel difficultyLevel) {
        int[][] Sudoku = SudokuGenerator.getInstance().generateGrid();
        Sudoku = SudokuGenerator.getInstance().removeElements(Sudoku, difficultyLevel);
        grid = new GameGrid(context);
        grid.setGrid(Sudoku);
    }

    public GameGrid getGrid() {
        return grid;
    }

    public void setSelectedPosition(int x , int y) {
        selectedPosX = x;
        selectedPosY = y;
    }

    public void setNumber(int number) {
        if (selectedPosX != -1 && selectedPosY != -1) {
            grid.setItem(selectedPosX,selectedPosY,number);
        }

        grid.checkGame();
    }

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }

    private void finishActivity() {
        activity.finish();
    }

    public void startTimer() {
        GameTimer.getInstance().start();
    }

    public void finish() {
        GameTimer.getInstance().finish();

        saveRecord(GameTimer.getInstance().getDuration());
        finishActivity();
    }

    public void saveRecord(Duration duration) {

    }
}

