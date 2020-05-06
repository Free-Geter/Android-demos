package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWV = findViewById(R.id.wv_1);
        //加载本地URL
        //mWV.loadUrl("file:///android_asset/text.html");
        mWV.getSettings().setJavaScriptEnabled(true);  //当加载需要JavaScript支持的网页时，需要加上这一句
        mWV.setWebViewClient(new MyWebViewClient());     //防止跳转到手机浏览器打开网页，而使用webview打开
        mWV.setWebChromeClient(new MyWebChromeClient());  //监听网页信息对app进行操作
        mWV.loadUrl("https://m.baidu.com");
    }
    class MyWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
           // Log.d("WebView","onPageStarted");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //Log.d("WebView","onPageFinished");
        }
    }

    class MyWebChromeClient extends WebChromeClient{
        public MyWebChromeClient() {
            super();
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {           //复写onKeyDown方法
        if(keyCode == KeyEvent.KEYCODE_BACK && mWV.canGoBack()) {
            mWV.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
