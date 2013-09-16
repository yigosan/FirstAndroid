package com.example.firstproject;

import com.example.firstproject.variables.Degiskenler;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebDisplay extends Activity {

	public WebDisplay() {
		// TODO Auto-generated constructor stub
	}
	
	WebView w1 = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webdisplay);
        
        w1 = (WebView)findViewById(R.id.webView1);
        w1.loadUrl(getIntent().getExtras().getString(Degiskenler.URL));
    }

}
