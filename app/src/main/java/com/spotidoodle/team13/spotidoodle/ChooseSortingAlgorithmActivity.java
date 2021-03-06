package com.spotidoodle.team13.spotidoodle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import kaaes.spotify.webapi.android.models.AudioFeaturesTrack;

/**
 * Created by Oxana on 19.06.2017.
 */

public class ChooseSortingAlgorithmActivity extends AppCompatActivity {

    private String CLIENT_ID;
    private String playlist;
    private String playlistUri;
    private AudioFeaturesTrack trackAnalyser;
    private int REQUEST_CODE;
    private String ACCSSES_TOKEN;
    private String userID;
    private String playlistTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_algorithm);

        this.trackAnalyser = new AudioFeaturesTrack();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            this.CLIENT_ID = bundle.getString("clientID");
            this.REQUEST_CODE = bundle.getInt("requestCode");
            this.playlist = bundle.getString("playlist");
            this.playlistUri =  bundle.get("playlistUri").toString();
            this.ACCSSES_TOKEN = bundle.getString("accessToken");
            this.userID = bundle.getString("userID");
            this.playlistTitle = bundle.getString("playlistTitle");
        }

        final Button danceability = (Button) findViewById(R.id.algorithmDance);
        final Button bpm = (Button) findViewById(R.id.algorithmBPM);
        final Button energy = (Button) findViewById(R.id.algorithmEnergy);
        final Button loudness = (Button) findViewById(R.id.algorithmLoudness);
        danceability.setOnClickListener(onClickListener);
        bpm.setOnClickListener(onClickListener);
        energy.setOnClickListener(onClickListener);
        loudness.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Intent intent;
            Bundle bundle;
            switch(v.getId()){
                case R.id.algorithmDance:
                    intent = new Intent(ChooseSortingAlgorithmActivity.this, SortedPlaylists.class);
                    bundle = new Bundle();
                    bundle.putString("algorithm", "danceability");
                    bundle.putString("playlist", playlist);
                    bundle.putString("playlistUri", playlistUri);
                    bundle.putString("accessToken", ACCSSES_TOKEN);
                    bundle.putString("userID", userID);
                    bundle.putString("playlistTitle", playlistTitle);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case R.id.algorithmBPM:
                    intent = new Intent(ChooseSortingAlgorithmActivity.this, SortedPlaylists.class);
                    bundle = new Bundle();
                    bundle.putString("algorithm", "tempo");
                    bundle.putString("playlist", playlist);
                    bundle.putString("playlistUri", playlistUri);
                    bundle.putString("accessToken", ACCSSES_TOKEN);
                    bundle.putString("userID", userID);
                    bundle.putString("playlistTitle", playlistTitle);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case R.id.algorithmEnergy:
                    intent = new Intent(ChooseSortingAlgorithmActivity.this, SortedPlaylists.class);
                    bundle = new Bundle();
                    bundle.putString("algorithm", "energy");
                    bundle.putString("playlist", playlist);
                    bundle.putString("playlistUri", playlistUri);
                    bundle.putString("accessToken", ACCSSES_TOKEN);
                    bundle.putString("userID", userID);
                    bundle.putString("playlistTitle", playlistTitle);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case R.id.algorithmLoudness:
                    intent = new Intent(ChooseSortingAlgorithmActivity.this, SortedPlaylists.class);
                    bundle = new Bundle();
                    bundle.putString("algorithm", "loudness");
                    bundle.putString("playlist", playlist);
                    bundle.putString("playlistUri", playlistUri);
                    bundle.putString("accessToken", ACCSSES_TOKEN);
                    bundle.putString("userID", userID);
                    bundle.putString("playlistTitle", playlistTitle);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
            }
        }
    };
}
