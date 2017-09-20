package org.libreflix.app;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    WebView webview;

    final String LIBREFLIX_URL = "https://libreflix.org";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        webview = (WebView) findViewById(R.id.web_view);
        webview.setWebViewClient(new LibreFlixWebViewClient());

        WebSettings settings = webview.getSettings();
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setJavaScriptEnabled(true);

        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webview.setScrollbarFadingEnabled(false);

        webview.loadUrl(LIBREFLIX_URL);

    }


    @Override
    public void onBackPressed() {

        if (webview.canGoBack()) {
            webview.goBack();
            return;
        }
        super.onBackPressed();
    }

    public class LibreFlixWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
        }
    }


}
