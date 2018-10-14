package com.musiquera.bsanchezg.musiquera.mainActivity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.widget.DataBufferAdapter;
import com.musiquera.bsanchezg.musiquera.R;

import java.util.List;

public class ResultsAdapter extends DataBufferAdapter<Metadata> {
    public ResultsAdapter(Context context) {
        super(context, R.layout.bs__list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(getContext(), android.R.layout.simple_list_item_1, null);
        }
        Metadata metadata = getItem(position);
        TextView titleTextView = convertView.findViewById(android.R.id.text1);
        titleTextView.setText(metadata.getTitle());
        return convertView;
    }
}
