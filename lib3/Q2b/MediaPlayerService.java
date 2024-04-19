// // Add audio file to the project:
// // Place your audio file (e.g., song.mp3) in the res(create a folder named 
// raw inside res and place audio file in raw) directory of your Android project.

package com.example.slips;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MediaPlayerService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer.setLooping(true); // Loop the audio
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start(); // Start playing the audio
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop(); // Stop the audio
        mediaPlayer.release(); // Release resources
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
