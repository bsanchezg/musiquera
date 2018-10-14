package com.musiquera.bsanchezg.musiquera.mainActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.widget.DataBufferAdapter;
import com.musiquera.bsanchezg.musiquera.R;
import com.musiquera.bsanchezg.musiquera.mediaPlayer.MusiqueraMediaPlayer;

import java.util.List;

public class ResultsAdapter extends DataBufferAdapter<Metadata> {

    private Listener listener;

    public ResultsAdapter(Context context, Listener listener) {
        super(context, R.layout.bs__list);
        this.listener = listener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(getContext(), android.R.layout.simple_list_item_1, null);
        }

        final MediaPlayer mediaPlayer = MusiqueraMediaPlayer.getOrCreateMediaPlayer();
        final Metadata metadata = getItem(position);
        TextView titleTextView = convertView.findViewById(android.R.id.text1);
        titleTextView.setText(metadata.getTitle());

        Log.d("FILE: embeded", metadata.getEmbedLink() + "");
        Log.d("FILE: alternate", metadata.getAlternateLink() + "");
        Log.d("FILE: webContent", metadata.getWebContentLink() + "");
        Log.d("FILE: webView", metadata.getWebViewLink() + "");

        convertView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClicked(metadata);
                    }
                }
        );
        return convertView;
    }

    public interface Listener {
        void onItemClicked(Metadata metadata);
    }
}
