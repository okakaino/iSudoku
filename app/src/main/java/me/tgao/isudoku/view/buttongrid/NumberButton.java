package me.tgao.isudoku.view.buttongrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.widget.AppCompatButton;

import me.tgao.isudoku.GameEngine;

public class NumberButton extends AppCompatButton implements OnClickListener{

    private int number;

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        GameEngine.getInstance().setNumber(number);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}