package com.codeasylums.songrecogniser;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import java.util.List;

public class Song_Suggestions extends AppCompatActivity {

  RecyclerView songListRecyclerView;
  List<SongData> songDataList;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_song_suggestion);
     songDataList =getIntent().getParcelableArrayListExtra(this.getString(R.string.SONG_DATA_LIST));
Log.d("SONG", String.valueOf(songDataList.size()));
    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
    actionBar.setHomeButtonEnabled(true);
    actionBar.setDisplayHomeAsUpEnabled(true);


    songListRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    songListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    SongSuggestionAdatpter songSuggestionAdatpter =new SongSuggestionAdatpter(songDataList,this);
songListRecyclerView.setAdapter(songSuggestionAdatpter);

    songListRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
        new RecyclerItemClickListener.OnItemClickListener() {
          @Override
          public void onItemClick(View view, int position) {
            Intent intent = new Intent(view.getContext(),Lyrics.class);
            intent.putExtra(getResources().getString(R.string.LYRICS_PATH),songDataList.get(position).getPath());
            startActivity(intent);
          }
        }));

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
  onBackPressed();

    return super.onOptionsItemSelected(item);

  }
}
