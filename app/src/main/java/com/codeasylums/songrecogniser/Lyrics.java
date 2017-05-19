package com.codeasylums.songrecogniser;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by raunak on 19/5/17.
 */

public class Lyrics extends AppCompatActivity {
  TextView lyricsTextview;
  String url="https://genius.com/Ed-sheeran-shape-of-you-lyrics";
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.lyrics);
    lyricsTextview= (TextView) findViewById(R.id.text_view_lyrics);
   /* String test=android.text.Html.fromHtml(
        "<div initial-content-for=\"lyrics\">\\n<lyrics canonical-lyrics-html=\"lyrics_data.body.html\" class=\"lyrics\" remove-class-on-angular-load=\"lyrics\" yields-anchorer=\"lyrics_anchorer = anchorer\">\\n<!--sse-->\\n<p>[Verse 1]<br>\\n<a annotation-fragment=\"11127616\" class=\"referent\" classification=\"accepted\" data-id=\"11127616\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11127616\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">The club isn't the best place to find a lover<br>\\nSo the bar is where I go<br>\\nMe and my friends at the table doing shots<br>\\nDrinking fast and then we talk slow<br>\\nAnd you come over and start up a conversation with just me<br>\\nAnd trust me I'll give it a chance now</br></br></br></br></br></a><br>\\n<a annotation-fragment=\"11127378\" class=\"referent\" classification=\"accepted\" data-id=\"11127378\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11127378\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Take my hand, stop, put Van the Man on the jukebox<br>\\nAnd then we start to dance, and now I'm singing like</br></a><br>\\n<br>\\n[Pre-Chorus]<br>\\n<a annotation-fragment=\"11523376\" class=\"referent\" classification=\"accepted\" data-id=\"11523376\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11523376\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Girl, you know I want your love<br>\\nYour love was handmade for somebody like me</br></a><br>\\n<a annotation-fragment=\"11285900\" class=\"referent\" classification=\"accepted\" data-id=\"11285900\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11285900\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Come on now, follow my lead<br>\\nI may be crazy, don't mind me</br></a><br>\\n<a annotation-fragment=\"11137272\" class=\"referent\" classification=\"accepted\" data-id=\"11137272\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11137272\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"2\" possibly-branded=\"false\" prevent-default-click=\"\">Say, boy, let's not talk too much<br>\\nGrab on my waist and put that body on me</br></a><br>\\n<a annotation-fragment=\"11285900\" class=\"referent\" classification=\"accepted\" data-id=\"11285900\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11285900\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Come on now, follow my lead<br>\\nCome, come on now, follow my lead</br></a><br>\\n<br>\\n[Chorus]<br>\\n<a annotation-fragment=\"11133466\" class=\"referent\" classification=\"accepted\" data-id=\"11133466\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11133466\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">I'm in love with the shape of you<br>\\nWe push and pull like a magnet do</br></a><br>\\nAlthough my heart is falling too<br>\\nI'm in love with your body<br>\\nAnd last night you were in my room<br>\\nAnd now my bedsheets smell like you<br>\\n<a annotation-fragment=\"11302046\" class=\"referent\" classification=\"accepted\" data-id=\"11302046\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11302046\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Every day discovering something brand new<br>\\nI'm in love with your body</br></a><br>\\nOh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I<br>\\nI'm in love with your body<br>\\nOh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I<br>\\nI'm in love with your body<br>\\nOh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I<br>\\nI'm in love with your body<br>\\n<a annotation-fragment=\"11302046\" class=\"referent\" classification=\"accepted\" data-id=\"11302046\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11302046\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Every day discovering something brand new<br>\\nI'm in love with the shape of you</br></a><br>\\n<br>\\n[Verse 2]<br>\\n<a annotation-fragment=\"11301675\" class=\"referent\" classification=\"accepted\" data-id=\"11301675\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11301675\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">One week in we let the story begin<br>\\nWe're going out on our first date</br></a><br>\\n<a annotation-fragment=\"11129030\" class=\"referent\" classification=\"accepted\" data-id=\"11129030\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11129030\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">You and me are thrifty, so go all you can eat<br>\\nFill up your bag and I fill up a plate<br>\\nWe talk for hours and hours about the sweet and the sour</br></br></a><br>\\n<a annotation-fragment=\"11301694\" class=\"referent\" classification=\"accepted\" data-id=\"11301694\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11301694\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">And how your family is doing okay<br>\\nLeave and get in a taxi, then kiss in the backseat<br>\\nTell the driver make the radio play, and I'm singing like</br></br></a><br>\\n<br>\\n[Pre-Chorus]<br>\\n<a annotation-fragment=\"11523376\" class=\"referent\" classification=\"accepted\" data-id=\"11523376\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11523376\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Girl, you know I want your love<br>\\nYour love was handmade for somebody like me</br></a><br>\\n<a annotation-fragment=\"11285900\" class=\"referent\" classification=\"accepted\" data-id=\"11285900\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11285900\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Come on now, follow my lead<br>\\nI may be crazy, don't mind me</br></a><br>\\n<a annotation-fragment=\"11137272\" class=\"referent\" classification=\"accepted\" data-id=\"11137272\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11137272\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"2\" possibly-branded=\"false\" prevent-default-click=\"\">Say, boy, let's not talk too much<br>\\nGrab on my waist and put that body on me</br></a><br>\\n<a annotation-fragment=\"11285900\" class=\"referent\" classification=\"accepted\" data-id=\"11285900\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11285900\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Come on now, follow my lead<br>\\nCome, come on now, follow my lead</br></a><br>\\n<br>\\n[Chorus]<br>\\n<a annotation-fragment=\"11133466\" class=\"referent\" classification=\"accepted\" data-id=\"11133466\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11133466\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">I'm in love with the shape of you<br>\\nWe push and pull like a magnet do</br></a><br>\\nAlthough my heart is falling too<br>\\nI'm in love with your body<br>\\nAnd last night you were in my room<br>\\nAnd now my bedsheets smell like you<br>\\n<a annotation-fragment=\"11302046\" class=\"referent\" classification=\"accepted\" data-id=\"11302046\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11302046\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Every day discovering something brand new<br>\\nI'm in love with your body</br></a><br>\\nOh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I<br>\\nI'm in love with your body<br>\\nOh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I<br>\\nI'm in love with your body<br>\\nOh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I\\u2014oh\\u2014I<br>\\nI'm in love with your body<br>\\n<a annotation-fragment=\"11302046\" class=\"referent\" classification=\"accepted\" data-id=\"11302046\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11302046\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Every day discovering something brand new<br>\\nI'm in love with the shape of you</br></a><br>\\n<br>\\n[Bridge]<br>\\nCome on, be my baby, come on<br>\\nCome on, be my baby, come on<br>\\nCome on, be my baby, come on<br>\\nCome on, be my baby, come on<br>\\nCome on, be my baby, come on<br>\\nCome on, be my baby, come on<br>\\nCome on, be my baby, come on<br>\\nCome on, be my baby, come on<br>\\n<br>\\n[Chorus]<br>\\n<a annotation-fragment=\"11133466\" class=\"referent\" classification=\"accepted\" data-id=\"11133466\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11133466\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">I'm in love with the shape of you<br>\\nWe push and pull like a magnet do</br></a><br>\\nAlthough my heart is falling too<br>\\nI'm in love with your body<br>\\nLast night you were in my room<br>\\nAnd now my bedsheets smell like you<br>\\n<a annotation-fragment=\"11302046\" class=\"referent\" classification=\"accepted\" data-id=\"11302046\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11302046\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Every day discovering something brand new<br>\\nI'm in love with your body</br></a><br>\\n<i>Come on, be my baby, come on</i><br>\\n<i>Come on, be my baby, come on</i><br>\\nI'm in love with your body<br>\\n<i>Come on, be my baby, come on</i><br>\\n<i>Come on, be my baby, come on</i><br>\\nI'm in love with your body<br>\\n<i>Come on, be my baby, come on</i><br>\\n<i>Come on, be my baby, come on</i><br>\\nI'm in love with your body<br>\\n<a annotation-fragment=\"11302046\" class=\"referent\" classification=\"accepted\" data-id=\"11302046\" href=\"/Ed-sheeran-shape-of-you-lyrics#note-11302046\" image=\"false\" ng-class=\"{\\n          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),\\n          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),\\n          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)\\n        }\" ng-click=\"open()\" on-hover-with-no-digest=\"set_current_hover_and_digest(hover ? fragment_id : undefined)\" pending-editorial-actions-count=\"0\" possibly-branded=\"false\" prevent-default-click=\"\">Every day discovering something brand new<br>\\nI'm in love with the shape of you</br></a></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></p>\\n<!--/sse-->\\n</lyrics>\\n</div>")
        .toString();*/
    //Log.d("TEST",test);
    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
    actionBar.setHomeButtonEnabled(true);
    actionBar.setDisplayHomeAsUpEnabled(true);
    new myTask().execute();

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    onBackPressed();

    return super.onOptionsItemSelected(item);

  }

  public class myTask extends AsyncTask<String,String,String> {

String lyricsString;
    @Override
    protected String doInBackground(String... params) {
      Log.d("AYA","AYA");
      Document document = null;
      try {
        document = Jsoup.connect(url).get();
      } catch (IOException e) {
        e.printStackTrace();
      }
      Elements info = document.select("div.song_body-lyrics");
      Log.d("HTML",info.toString());
     // doSomething(info.toString(info));
       lyricsString=android.text.Html.fromHtml(info.toString()).toString();

      return null;
    }

    @Override
    protected void onPostExecute(String s) {
      super.onPostExecute(s);
    // doSomething(lyricsString);
      int index = lyricsString.indexOf("More on Genius");
    if(index>0)
      lyricsString=lyricsString.substring(0,index);
      lyricsTextview.setText(lyricsString);

    }
  }


}