package com.numberonecall.ui.account;

import com.actionbarsherlock.app.SherlockActivity;
import com.numberonecall.R;
import com.numberonecall.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SignUpWebView extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up_web_view);
		
		WebView webView = (WebView) findViewById(R.id.signUpWebView);
		webView.loadUrl("https://portal.numberonecall.com/signin?mode=dialer");
		
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
      	final SignUpWebView currentActivity = this;
		webView.setWebViewClient(new WebViewClient() {
			@Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        if (url.equals("https://portal.numberonecall.com/")) {
					currentActivity.finish();
		            return true;
		        }
		        return false;
		    }
		});
	}
}
