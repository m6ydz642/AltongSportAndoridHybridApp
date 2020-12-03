package co.kr.altongsports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView mWebView; //웹뷰 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 별도의 에러처리 없음

        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                /*
                * 처음 엑티비티에 로드할 경우에는 문제가 없지만 WebView 상에서 페이지 이동이 일어날 겨우 보통 디바이스의 브라우저로 실행된다.
        이 경우에는 WebViewClient 의 shouldOverrideUrlLoading 함수를 사용하여 아주 간단하게 해결된다.
        쉽게 말해서 loadUrl 로 호출하던 방법을 WebViewClient 에서 대신 호출한다고 생각하면 된다.
        https://cofs.tistory.com/186 [CofS]
                *
                *
                * */
                view.loadUrl(url);
                return true;
            }
        });

        mWebView.loadUrl("https://altongsports.com/");


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { // 뒤로가기 이벤트

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (mWebView.canGoBack()) {

                mWebView.goBack();

                return false;

            }

        }
        return super.onKeyDown(keyCode, event);

    }




}

