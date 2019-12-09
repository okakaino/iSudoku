package me.tgao.isudoku;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button newGameBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(TAG, "onCreate: started");

        ListView recordListView = findViewById(R.id.record_list_view);

        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(Duration.ofSeconds(13), LocalDate.of(2019, 11, 11)));
        records.add(new Record(Duration.ofSeconds(13), LocalDate.of(2019, 11, 11)));
        records.add(new Record(Duration.ofSeconds(13), LocalDate.of(2019, 11, 11)));

        RecordListAdapter adapter = new RecordListAdapter(this, R.layout.record_item, records);
        recordListView.setAdapter(adapter);

        newGameBTN = findViewById(R.id.newGameBtn);

        newGameBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame();
            }
        });
    }

    public void startNewGame() {
        Intent intent = new Intent(this, PuzzleActivity.class);
        startActivity(intent);
    }
}
