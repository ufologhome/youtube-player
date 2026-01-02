package com.example.youtubeplayer;

import android.os.Bundle;
import com.google.android.youtube.player.*;

public class MainActivity extends YouTubeBaseActivity {

    private static final String API_KEY = "PASTE_YOUR_API_KEY";
    private static final String VIDEO_ID = "3JIPDZqkeSo"; // пример

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        YouTubePlayerView playerView = findViewById(R.id.youtube_view);
        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(
                    YouTubePlayer.Provider provider,
                    YouTubePlayer player,
                    boolean restored
            ) {
                if (!restored) {
                    player.loadVideo(VIDEO_ID); // autoplay
                }
            }

            @Override
            public void onInitializationFailure(
                    YouTubePlayer.Provider provider,
                    YouTubeInitializationResult error
            ) {
                error.getErrorDialog(MainActivity.this, 0).show();
            }
        });
    }
}
