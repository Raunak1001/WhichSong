package com.codeasylums.songrecogniser;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.codeasylums.songrecogniser.SongSuggestionAdatpter.SongViewHolder;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by raunak on 19/5/17.
 */

public class SongSuggestionAdatpter extends RecyclerView.Adapter<SongViewHolder> {
List<SongData> songDataList;
  Context context;

  public SongSuggestionAdatpter(List<SongData> songDataList,Context context) {
  this.songDataList=songDataList;
    this.context=context;

  }

  @Override
  public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View v = LayoutInflater
        .from(parent.getContext()).inflate(R.layout.son_suggestion_list_object, parent, false);
   return new SongViewHolder(v);
  }

  @Override
  public void onBindViewHolder(SongViewHolder holder, int i) {
holder.artistName.setText(Html.fromHtml("<b>Artist:</b> "+songDataList.get(i).getName()));
    holder.songTitle.setText(songDataList.get(i).getFull_title());
int height=holder.sharedPreferences.getInt("height",0);
int width=holder.sharedPreferences.getInt("width",0);
Picasso.with(context)
    .load(songDataList.get(i).getHeader_image_url())

    .transform(new CircleTransform())
.resize(height,width)
    .centerCrop()
    .into(holder.songHeaderImage);
  }


  @Override
  public int getItemCount() {
    return songDataList.size();
  }

  public class SongViewHolder extends RecyclerView.ViewHolder{
TextView songTitle,artistName;
    ImageView songHeaderImage;
    SharedPreferences sharedPreferences;
    public SongViewHolder(View itemView) {
      super(itemView);

      songTitle= (TextView) itemView.findViewById(R.id.SongTitle);
artistName= (TextView) itemView.findViewById(R.id.ArtistName);
      songHeaderImage= (ImageView) itemView.findViewById(R.id.songHeaderImage);
      sharedPreferences=context.getSharedPreferences("Dimen",context.MODE_PRIVATE);
    }
  }

}
