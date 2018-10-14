package com.musiquera.bsanchezg.musiquera.mediaPlayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class MusiqueraMediaPlayer {

    private static final String TAG = "MUSIQUERA MEDIA PLAYER";

    private static MediaPlayer mediaPlayer;

    private MusiqueraMediaPlayer() { }

    public static MediaPlayer getOrCreateMediaPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        return mediaPlayer;
    }

    public static void playSong(String url) {
        if (mediaPlayer != null) {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            try {
                mediaPlayer.setDataSource(url);
            } catch (IllegalArgumentException e) {
                Log.d(TAG, e.getMessage());
            } catch (SecurityException e) {
                Log.d(TAG, e.getMessage());
            } catch (IllegalStateException e) {
                Log.d(TAG, e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                mediaPlayer.prepare();
            } catch (IllegalArgumentException e) {
                Log.d(TAG, e.getMessage());
            } catch (IOException e) {
                Log.d(TAG, e.getMessage());
            }

            mediaPlayer.start();
        }
    }

}
