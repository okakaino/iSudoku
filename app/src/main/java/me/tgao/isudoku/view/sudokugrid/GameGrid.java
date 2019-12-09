package me.tgao.isudoku.view.sudokugrid;

import android.content.Context;
import android.widget.Toast;

import me.tgao.isudoku.GameEngine;
import me.tgao.isudoku.SudokuChecker;

public class GameGrid {

    private SudokuCell[][] sudoku = new SudokuCell[9][9];

    private Context context;

    public GameGrid(Context context) {
        this.context = context;

        for (int x = 0 ; x < 9 ; x++) {
            for (int y = 0 ; y < 9 ; y++) {
                sudoku[x][y] = new SudokuCell(context);
            }
        }
    }

    public void setGrid(int[][] grid) {
        for (int x = 0 ; x < 9 ; x++) {
            for (int y = 0 ; y < 9 ; y++) {
                sudoku[x][y].setInitValue(grid[x][y]);

                if (grid[x][y] != 0) {
                    sudoku[x][y].setNotModifiable();
                }
            }
        }
    }

    public SudokuCell[][] getGrid() {
        return sudoku;
    }

    public SudokuCell getItem(int x, int y) {
        return sudoku[x][y];
    }

    public SudokuCell getItem(int position) {
        int x = position % 9;
        int y = position / 9;

        return sudoku[x][y];
    }

    public void setItem(int x , int y , int number) {
        sudoku[x][y].setValue(number);
    }

    public void checkGame() {
        int [][] sudGrid = new int[9][9];
        for (int x = 0 ; x < 9 ; x++) {
            for (int y = 0 ; y < 9 ; y++) {
                sudGrid[x][y] = getItem(x, y).getValue();
            }
        }

        if (SudokuChecker.getInstance().checkSudoku(sudGrid)) {
            Toast.makeText(context, "You solved the sudoku.", Toast.LENGTH_LONG).show();
            GameEngine.getInstance().finish();
        }
    }
}
