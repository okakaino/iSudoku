package me.tgao.isudoku;

public enum DifficultyLevel {
    DEMO(3), EASY(30), MEDIUM(45), HARD(60);

    private final int value;

    private DifficultyLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
