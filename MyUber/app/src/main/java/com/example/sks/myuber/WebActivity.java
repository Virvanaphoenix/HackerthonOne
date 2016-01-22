package com.example.sks.myuber;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by sks on 2016/1/17.
 */
public class WebActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView web = (WebView) findViewById(R.id.tv_title);
        web.loadUrl("http://apis.map.qq.com/uri/v1/routeplan?type=bus&from=我的家&\n" +
                "fromcoord=39.980683,116.302&to=中关村&tocoord=39.9836,116.3164&\n" +
                "policy=1&referer=test");
    }

}
