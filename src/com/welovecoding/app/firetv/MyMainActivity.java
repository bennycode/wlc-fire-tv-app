package com.welovecoding.app.firetv;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.VideoView;

// http://stackoverflow.com/questions/12708890/youtube-video-not-playing-in-webview-android
// http://blog.erayince.com.tr/?p=202
public class MyMainActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    WebView webview = new WebView(this);
    setContentView(webview);

    webview.getSettings().setBuiltInZoomControls(true);
    webview.getSettings().setJavaScriptEnabled(true);
    webview.setWebChromeClient(new WebChromeClient() {

      @Override
      public void onShowCustomView(View view, CustomViewCallback callback) {
        Log.i("fire-tv", "Show custom view");

        super.onShowCustomView(view, callback);
        if (view instanceof FrameLayout) {
          FrameLayout frame = (FrameLayout) view;
          if (frame.getFocusedChild() instanceof VideoView) {
            VideoView video = (VideoView) frame.getFocusedChild();
            frame.removeView(video);
            setContentView(video);
            video.start();
          }
        }
      }

      @Override
      public void onHideCustomView() {
        Log.i("fire-tv", "Hide custom view.");
      }

    });

    webview.setWebViewClient(new WebViewClient() {

      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
      }

    });

    final String mimeType = "text/html";
    final String encoding = "UTF-8";
    String html = getHTML();

    Log.i("fire-tv", "Loading: " + html);
    webview.loadDataWithBaseURL("", html, mimeType, encoding, "");
  }

  private String getHTML() {
    String html = "<iframe class=\"youtube-player\" style=\"border: 0; width: 100%; height: 100%; padding:0px; margin:0px\" id=\"ytplayer\" type=\"text/html\" src=\"http://www.youtube.com/embed/"
            + "h11u3vtcpaY"
            + "?fs=0\" frameborder=\"0\">\n"
            + "</iframe>\n";

    return html;
  }
}
