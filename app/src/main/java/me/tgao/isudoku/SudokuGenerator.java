package me.tgao.isudoku;

import java.util.ArrayList;
import java.util.Random;

public class SudokuGenerator {

    // singleton instance
    private static SudokuGenerator instance;

    private ArrayList<ArrayList<Integer>> available = new ArrayList<>();

    private Random rand = new Random();

    private SudokuGenerator() { }

    public static SudokuGenerator getInstance() {
        if (instance == null) {
            instance = new SudokuGenerator();
        }
        return instance;
    }

    // generate 9 by 9 sudoku grid
    public int[][] generateGrid() {
        int[][] sudoku = new int[9][9];

        int currentPos = 0;

        while (currentPos < 81) {
            if (currentPos == 0) {
                clearGrid(sudoku);
            }

            if (available.get(currentPos).size() != 0) {
                int i = rand.nextInt(available.get(currentPos).size());
                int number = available.get(currentPos).get(i);

                if( !checkConflict(sudoku, currentPos , number)){
                    int xPos = currentPos % 9;
                    int yPos = currentPos / 9;

                    sudoku[xPos][yPos] = number;

                    available.get(currentPos).remove(i);

                    currentPos++;
                }else{
                    available.get(currentPos).remove(i);
                }

            }else{
                for( int i = 1 ; i <= 9 ; i++ ){
                    available.get(currentPos).add(i);
                }
                currentPos--;
            }
        }

        return sudoku;
    }

    public int[][] removeElements(int[][] sudoku, DifficultyLevel difficultyLevel) {
        int i = 0;

        while (i < difficultyLevel.getValue()) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);

            if (sudoku[x][y] != 0) {
                sudoku[x][y] = 0;
                i++;
            }
        }

        return sudoku;
    }

    // clear sudoku grid
    private void clearGrid(int [][] sudoku){
        available.clear();

        for (int y =  0; y < 9 ; y++) {
            for (int x = 0 ; x < 9 ; x++) {
                sudoku[x][y] = -1;
            }
        }

        for (int x = 0 ; x < 81 ; x++) {
            available.add(new ArrayList<Integer>());
            for (int i = 1 ; i <= 9 ; i++) {
                available.get(x).add(i);
            }
        }
    }

    /**
     * Return true if there is a conflict
     * @param sudoku
     * @param xPos
     * @param yPos
     * @param number
     * @return
     */
    private boolean checkConflict(int[][] sudoku, int currentPos, final int number) {
        int xPos = currentPos % 9;
        int yPos = currentPos / 9;

        if(checkLinearConflict(sudoku, xPos, yPos, number) || checkRegionConflict(sudoku, xPos, yPos, number)) {
            return true;
        }

        return false;
    }

    private boolean checkLinearConflict(final int[][] sudoku, final int xPos, final int yPos, final int number) {
        // check horizontally
        for (int x = xPos - 1; x >= 0; x--) {
            if (number == sudoku[x][yPos]) {
                return true;
            }
        }

        //check vertically
        for (int y = yPos - 1; y >= 0; y--) {
            if (number == sudoku[xPos][y]) {
                return true;
            }
        }

        return false;
    }

    private boolean checkRegionConflict(final int[][] sudoku, final int xPos, final int yPos, final int number) {
        int xRegion = xPos / 3;
        int yRegion = yPos / 3;

        for (int x = xRegion * 3; x < xRegion * 3 + 3; x++) {
            for (int y = yRegion * 3; y < yRegion * 3 + 3; y++) {
                if ((x != xPos || y != yPos) && number == sudoku[x][y]) {
                    return true;
                }
            }
        }

        return false;
    }
}
