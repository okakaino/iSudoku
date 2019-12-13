package me.tgao.isudoku;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button newGameBTN;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DatabaseHelper(this);

        Log.d(TAG, "onCreate: started");

        populateRecord();

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

    private void populateRecord() {
        ListView recordListView = findViewById(R.id.record_list_view);

        ArrayList<Record> records = new ArrayList<>();

        Cursor recordData = db.getListContents();

        if (recordData.getCount() > 0) {
            while (recordData.moveToNext()) {
                long duration = recordData.getLong(recordData.getColumnIndex(DatabaseHelper.DURATION));
                long date = recordData.getLong(recordData.getColumnIndex(DatabaseHelper.DATE));
                Record r = new Record(duration, date);
                records.add(r);
            }

            RecordListAdapter adapter = new RecordListAdapter(this, R.layout.record_item, records);
            recordListView.setAdapter(adapter);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        populateRecord();
    }
}
