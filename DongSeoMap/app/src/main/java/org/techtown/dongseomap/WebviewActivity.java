package org.techtown.dongseomap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebviewActivity extends AppCompatActivity {

    ProgressDialog mProgressDialog;
    private static String baseUrl = "https://www.dongseo.ac.kr/kr/index.php?pCode=MN2000191";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent intent = getIntent();
        processIntent(intent);

        initialize(); // 웹뷰 보여주기 함수

    }

    private void processIntent(Intent intent){
        if(intent != null)
        {
            Bundle bundle = intent.getExtras();
            if(intent != null){
                baseUrl = bundle.getString("src");
            }
        }
    }

    // 웹뷰
    public void initialize() {
        final WebView webView = (WebView) findViewById(R.id.WebView);
        webView.setHorizontalScrollBarEnabled(false); // 가로 스크롤 방지
        webView.setVerticalScrollBarEnabled(false); // 세로 스크롤 방지
        webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null); // 속도 향상
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null); // 속도 향상
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);  // 캐시모드
        webView.setWebViewClient(new WebViewClient()); // 이걸 안해주면 새창이 뜸

        mProgressDialog = ProgressDialog.show(this, "", "잠시만 기다려 주세요.", true);  // 인트로 후 로딩바

        // HTML을 파싱하여 웹뷰에서 보여주거나 하는 작업
        // width, height가 화면 크기와 맞지 않는 버그 해결
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        // javascript의 window.opne 허용
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        // 자바 스크립트 허용
        webView.getSettings().setJavaScriptEnabled(true);

        //meta태그의 viewport사용 가능
        webView.getSettings().setUseWideViewPort(true);

        webView.loadUrl(baseUrl);

        mProgressDialog.dismiss(); // 로딩바 종료
    }
}