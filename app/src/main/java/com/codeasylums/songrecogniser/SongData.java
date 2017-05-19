package com.codeasylums.songrecogniser;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by raunak on 19/5/17.
 */

public class SongData implements Parcelable{
  String  header_image_url;
  String full_title;
  String path;
  String name; //artist name


  protected SongData(Parcel in) {
    header_image_url = in.readString();
    full_title = in.readString();
    path = in.readString();
    name = in.readString();
  }

  public static final Creator<SongData> CREATOR = new Creator<SongData>() {
    @Override
    public SongData createFromParcel(Parcel in) {
      return new SongData(in);
    }

    @Override
    public SongData[] newArray(int size) {
      return new SongData[size];
    }
  };

  public SongData() {

  }

  public String getHeader_image_url() {
    return header_image_url;
  }

  public void setHeader_image_url(String header_image_url) {
    this.header_image_url = header_image_url;
  }

  public String getFull_title() {
    return full_title;
  }

  public void setFull_title(String full_title) {
    this.full_title = full_title;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(header_image_url);
    dest.writeString(full_title);
    dest.writeString(path);
    dest.writeString(name);
  }
}
