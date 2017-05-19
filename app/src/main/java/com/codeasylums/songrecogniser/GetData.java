package com.codeasylums.songrecogniser;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by raunak on 18/5/17.
 */

public class GetData {

  public String url          = "https://api.genius.com/search?q=";
  public String tag_json_obj = "json_obj_req";
  public String SongTitle    = "Not recieved";
  SharedPreferences sharedpreferences;
  List<SongData> songDataList;
  public String getmyData(final Context context, String query, final TextView tv, final DataCallback callback) {

    query.replaceAll("\\s+", "%20");
    url = url + query;

    final JsonRequest jsonRequest = new JsonObjectRequest(Method.GET, url, null,
        new Response.Listener<JSONObject>() {

          @Override
          public void onResponse(JSONObject response) {
Log.d("GET_DATA",url);
            Log.d("MAIN", response.toString());
            try {
              JSONArray hitsArray = response.getJSONObject(context.getString(R.string.RESPONSE))
                  .getJSONArray(
                      String.valueOf(context.getString(R.string.HITS)));
              JSONObject hitsObject = new JSONObject();
              JSONObject resultObject = new JSONObject();
              songDataList= new ArrayList<>();
              for (int i = 0; i < hitsArray.length(); i++) {
                SongData songData = new SongData();
                hitsObject = (JSONObject) (hitsArray.get(i));
                resultObject = hitsObject
                    .getJSONObject(context.getString(R.string.RESULT));
                songData.setFull_title(resultObject.getString(
                    context.getString(R.string.SONG_FULL_TITLE)));
                songData.setHeader_image_url(resultObject.getString(
                    context.getString(R.string.HEADER_IMAGE_URL)));
                songData.setPath(resultObject.getString(context.getString(R.string.PATH)));
                songData.setName(
                    resultObject.getJSONObject(context.getString(R.string.PRIMARY_ARTIST))
                        .getString(
                            context.getString(R.string.ARTIST_NAME)));
                songDataList.add(songData);
                Log.d("DATA", songDataList.get(i).getFull_title());

              }

              callback.onSuccess(songDataList);
             AppController.getInstance().getRequestQueue().cancelAll(tag_json_obj);

            } catch (JSONException e) {
              callback.onSuccess(songDataList);

              e.printStackTrace();

            }

          }
        }, new Response.ErrorListener() {


      @Override
      public void onErrorResponse(VolleyError error) {
        Log.d("ABCD", "ABCD");
callback.onSuccess(songDataList);
      }
    }) {
      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization",
            "Bearer wUYt9n04cMRcHUIM9DdFd8WQRo7zgnIPsZIGVkHimaDDDvejmDvA7QyrYeVZ8yDu");
        // params.put("Accept-Language", "fr");

        return params;
      }
    };

    AppController.getInstance().addToRequestQueue(jsonRequest, tag_json_obj);
    return "dsf";
  }

}
