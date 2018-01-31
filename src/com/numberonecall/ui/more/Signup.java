package com.numberonecall.ui.more;


import com.numberonecall.R;
import com.numberonecall.api.SipProfile;
import com.numberonecall.db.DBProvider;
import com.numberonecall.ui.account.AccountWizard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("NewApi") public class Signup extends Activity {

	//private Button button;
	private WebView webView;
	SipProfile account;
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		long accountId = 1;
		account = SipProfile.getProfileFromDbId(this, accountId,
				DBProvider.ACCOUNT_FULL_PROJECTION);
		String user1, pass1;
		user1 = account.getSipUserName();
		pass1 = account.getPassword();
		//Get webview 
		webView = (WebView) findViewById(R.id.webView1);
		//https://numberone.co.uk/terms-conditions.html
		startWebView("http://portal.numone.keios.eu/signup");
		
	}
	
	private void startWebView(String url) {
	    
		//Create new webview Client to show progress dialog
		//When opening a url or click on link
		
		webView.setWebViewClient(new WebViewClient() {      
	        ProgressDialog progressDialog;
	     
	        //If you will not use this method url links are opeen in new brower not in webview
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {              
	            view.loadUrl(url);
	            return true;
	        }
	   
	        //Show loader on url load
	        public void onLoadResource (WebView view, String url) {
	            if (progressDialog == null) {
	                // in standard case YourActivity.this
	                progressDialog = new ProgressDialog(Signup.this);
	                progressDialog.setMessage("Caricamento in corso...");
	                progressDialog.setCancelable(true);
	               // progressDialog.show();
	            }
	            
	        }
	        public void onPageFinished(WebView view, String url) 
	        {
	           
	            if (progressDialog.isShowing()) 
	            {
	                progressDialog.dismiss();
	                //progressDialog = null;
	            }
	            
	        }
	        
	    }); 
	     
	     // Javascript inabled on webview  
	    webView.getSettings().setJavaScriptEnabled(true); 
	    
	    // Other webview options
	    /*
	    webView.getSettings().setLoadWithOverviewMode(true);
	    webView.getSettings().setUseWideViewPort(true);
	    webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
	    webView.setScrollbarFadingEnabled(false);
	    webView.getSettings().setBuiltInZoomControls(true);
	    */
	    
	    /*
	     String summary = "<html><body>You scored <b>192</b> points.</body></html>";
         webview.loadData(summary, "text/html", null); 
	     */
	    
	    //Load url in webview
	    webView.loadUrl(url);
	     
	     
	}
	
	// Open previous opened link from history on webview when back button pressed
	
	
	@Override
    public void onBackPressed() {
            super.onBackPressed();
            this.finish();
    }
	
	

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	};
}
