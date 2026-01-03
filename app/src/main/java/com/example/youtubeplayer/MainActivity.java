import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private static final String API_KEY = "AIzaSyDtG2owBq8mNxzvjgGTvsUebAYUYvkfzas";
    private static final String VIDEO_ID = "3JIPDZqkeSo";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        YouTubePlayerView playerView = findViewById(R.id.youtube_view);
        playerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(
            YouTubePlayer.Provider provider,
            YouTubePlayer youTubePlayer,
            boolean wasRestored
    ) {
        Log.d("YT", "INIT OK");

        if (!wasRestored) {
            youTubePlayer.loadVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(
            YouTubePlayer.Provider provider,
            YouTubeInitializationResult error
    ) {
        Log.e("YT", "INIT FAIL: " + error.toString());
    }
}
