package me.tgao.isudoku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

class RecordListAdapter extends ArrayAdapter<Record> {
    private static final String TAG = "Record";

    private Context mContext;
    int mResource;

    public RecordListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Record> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Duration time = getItem(position).getTime();
        LocalDate date = getItem(position).getDate();

        Record record = new Record(time, date);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTime = (TextView) convertView.findViewById(R.id.record_time);
        TextView tvDate = (TextView) convertView.findViewById(R.id.record_date);

        tvTime.setText(record.getTimeString());
        tvDate.setText(record.getDate().toString());

        return convertView;
    }
}
