package com.codeasylums.songrecogniser;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import java.util.List;

public class Song_Suggestions extends AppCompatActivity {

  RecyclerView songListRecyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_song_suggestion);
    List<SongData> songDataList =getIntent().getParcelableArrayListExtra(this.getString(R.string.SONG_DATA_LIST));
Log.d("SONG", String.valueOf(songDataList.size()));
    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
    actionBar.setHomeButtonEnabled(true);
    actionBar.setDisplayHomeAsUpEnabled(true);


    songListRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    songListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    SongSuggestionAdatpter songSuggestionAdatpter =new SongSuggestionAdatpter(songDataList,this);
songListRecyclerView.setAdapter(songSuggestionAdatpter);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
  onBackPressed();

    return super.onOptionsItemSelected(item);

  }
}
