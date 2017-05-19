package com.codeasylums.songrecogniser;

import java.util.List;

/**
 * Created by raunak on 19/5/17.
 */

public interface DataCallback {
  void onSuccess(List<SongData> result);
}
