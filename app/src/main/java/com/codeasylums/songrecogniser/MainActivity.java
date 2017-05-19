package com.codeasylums.songrecogniser;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcelable;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {

  private TextView    txtSpeechInput;
  private ImageButton btnSpeak;
  private final int REQ_CODE_SPEECH_INPUT = 100;
  ProgressBar progressBar;
  SharedPreferences sharedPreferences;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
    btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
     progressBar= (ProgressBar) findViewById(R.id.homeProgressBar);
    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int height = displayMetrics.heightPixels;
    int width = displayMetrics.widthPixels;
    sharedPreferences= getSharedPreferences("Dimen",this.MODE_PRIVATE);
    Editor editor=sharedPreferences.edit();
    editor.putInt("height",height);
    editor.putInt("width",width);
    editor.commit();
    // hide the action bar
//    getActionBar().hide();

   /* String test=getinfo.getmyData(this,"Shape of You",txtSpeechInput, new DataCallback() {
      @Override
      public void onSuccess(List<SongData> songDataList) {
        Toast.makeText(getApplicationContext(),songDataList.get(0).getFull_title(),Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.INVISIBLE);
      Intent intent =new Intent(getApplicationContext(),Song_Suggestions.class);
intent.putParcelableArrayListExtra(getApplicationContext().getString(R.string.SONG_DATA_LIST),
    (ArrayList<? extends Parcelable>) songDataList
);
        startActivity(intent);
      }
    });
progressBar.setVisibility(View.VISIBLE);
*/
    txtSpeechInput.setText("Tap Mic To Detect Song");
 //   Log.d("STRING",test);
    btnSpeak.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        promptSpeechInput();
      }
    });

  }

  /**
   * Showing google speech input dialog
   * */
  private void promptSpeechInput() {
    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
        getString(R.string.speech_prompt));
    try {
      startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
    } catch (ActivityNotFoundException a) {
      Toast.makeText(getApplicationContext(),
          getString(R.string.speech_not_supported),
          Toast.LENGTH_SHORT).show();
    }
  }

  /**
   * Receiving speech input
   * */
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    switch (requestCode) {
      case REQ_CODE_SPEECH_INPUT: {
        if (resultCode == RESULT_OK && null != data) {

          final ArrayList<String> result = data
              .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
          Log.d("INPUT",result.get(0));
          txtSpeechInput.setText("Detecting");
          progressBar.setVisibility(View.VISIBLE);
          new GetData().getmyData(this,result.get(0),txtSpeechInput, new DataCallback() {
            @Override
            public void onSuccess(List<SongData> songDataList) {
              result.clear();
              AppController.getInstance().getRequestQueue().cancelAll("json_obj_req");

              //Toast.makeText(getApplicationContext(),songDataList.get(0).getFull_title(),Toast.LENGTH_LONG).show();
              txtSpeechInput.setText("Tap Mic To Detect Song");
              progressBar.setVisibility(View.INVISIBLE);

              if(songDataList==null || songDataList.size()==0){
               txtSpeechInput.setText("Error Identifying");
              }else {
                Intent intent = new Intent(getApplicationContext(), Song_Suggestions.class);
                intent.putParcelableArrayListExtra(
                    getApplicationContext().getString(R.string.SONG_DATA_LIST),
                    (ArrayList<? extends Parcelable>) songDataList
                );
                startActivity(intent);
              }
            }
          });



        }
        break;
      }

    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
   // getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  public void setRecylView(List<SongData> songDataList,Context context){


  }


}

