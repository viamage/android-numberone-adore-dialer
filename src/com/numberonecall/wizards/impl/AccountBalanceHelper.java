package com.numberonecall.wizards.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.numberonecall.api.SipProfile;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AccountBalanceHelper extends Handler {

    protected static final int DID_SUCCEED = 0;
    protected static final int DID_ERROR = 1;
    
    
    public void launchRequest(final SipProfile acc) {
        Thread t = new Thread() {

            public void run() {
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpRequestBase req = getRequest(acc);
                    if(req == null) {
                        return;
                    }
                    // Create a response handler
                    HttpResponse httpResponse = httpClient.execute(req);
                    if(httpResponse.getStatusLine().getStatusCode() == 200) {
                        InputStreamReader isr = new InputStreamReader(httpResponse.getEntity().getContent());
                        BufferedReader br = new BufferedReader(isr);

                        String line = null;
                        while( (line = br.readLine() ) != null ) {
                            String res = parseResponseLine(line);
                            if(!TextUtils.isEmpty(res)) {
                                AccountBalanceHelper.this.sendMessage(AccountBalanceHelper.this.obtainMessage(DID_SUCCEED, res));
                                break;
                            }
                        }
                        
                    }else {
                        AccountBalanceHelper.this.sendMessage(AccountBalanceHelper.this.obtainMessage(DID_ERROR));
                    }
                } catch (Exception e) {
                    AccountBalanceHelper.this.sendMessage(AccountBalanceHelper.this.obtainMessage(DID_ERROR));
                }
            }
        };
        t.start();
    }
    
    public void handleMessage(Message message) {
        switch (message.what) {
        case DID_SUCCEED: {
            //Here we get the credit info, now add a row in the interface
            String response = (String) message.obj;
            applyResultSuccess(response);
            break;
        }
        case DID_ERROR: {
            applyResultError();
            break;
        }
        }
    }
    
    /**
     * Build account balance request
     * @param acc the sip profile to build request for
     * @return
     */
    public abstract HttpRequestBase getRequest(SipProfile acc) throws IOException;
    /**
     * Search account result in the line.
     * @param line The line to parse
     * @return The account balance text if any parsed in this line. Else return empty or null chain to get next line
     */
    public abstract String parseResponseLine(String line);
    
    /**
     * Apply the error result of balance check
     * This is done in user interface thread so ui can be safely updated here
     */
    public abstract void applyResultError();

    /**
     * Apply the content result of balance check
     * This is done in user interface thread so ui can be safely updated here
     */
    public abstract void applyResultSuccess(String balanceText);
}
