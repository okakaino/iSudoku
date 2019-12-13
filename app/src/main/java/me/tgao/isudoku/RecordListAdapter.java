package me.tgao.isudoku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
        long time = getItem(position).getTime();
        long date = getItem(position).getDate();

        Record record = new Record(time, date);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTime = convertView.findViewById(R.id.record_time);
        TextView tvDate = convertView.findViewById(R.id.record_date);

        tvTime.setText(record.getTimeString());
        tvDate.setText(record.getDateString());

        return convertView;
    }
}
