package com.numberonecall.ui;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import com.numberonecall.R;
import com.numberonecall.utils.Log;

public class ScreenSplash extends Activity {
    public static String anj;
    boolean start = true;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.screen_splash);
        screenSplash();

    }

    public void onResume() {
        super.onResume();
        new LongOperation44().execute("");
    }

    void screenSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ConnectivityManager connMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {
                    // fetch data

                    startActivity(new Intent(ScreenSplash.this, SipHome.class));
                    finish();
                } else {
                    showNetworkAlert();
                }


            }
        }, 500);

    }

    void showNetworkAlert() {
        new AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage(
                        "Please make sure you have Network Enabled")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        /*Intent siphome = new Intent(getApplicationContext(),SipHome.class);
						startActivity(siphome);*/

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        startActivity(intent);
                        finish();
                        System.exit(0);

                    }
                }).show();

    }

    public static class LongOperation44 extends AsyncTask<String, Void, String> {
        String bal = "";
        String lab = "";

        public static String encrypt(String input, String key) {
            byte[] crypted = null;
            try {
                SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, skey);
                crypted = cipher.doFinal(input.getBytes());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            return new String(Base64.encodeBase64(crypted));
        }

        private final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

        private String asHex(byte[] buf) {
            char[] chars = new char[2 * buf.length];
            for (int i = 0; i < buf.length; ++i) {
                chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
                chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
            }
            return new String(chars);
        }


        @Override
        protected String doInBackground(String... params) {


            return getBalance(params[0]);
        }

        @Override
        protected void onPostExecute(String result) {

            System.out.println("xcxcxccxcxcxccxcxcxcxcxcxcxcccxxcxxxxcxctaddy" + result);
            //balance.setText("Balance: $"+bal);
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

        public String getBalance(String user) {
            try {

                //System.out.println("88888888888888888888888888888888888888888888");

            } catch (ClassCastException e1) {
                //TODO Auto-generated catch block
                e1.printStackTrace();
            }


            try {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@166666 : " + user);

                String url = "http://ip-api.com/json";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                //add reuqest header
                con.setRequestMethod("POST");
                //con.setRequestProperty("User-Agent", USER_AGENT);
                con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                String key = "19638&^$%#$35962";
		/*String data1 = account.getSipUserName();
		String data2=account.getPassword();
		String output =LongOperation.encrypt(data1, key);
		String output1 =LongOperation.encrypt(data2, key);
		String a=(asHex(output.getBytes()));
		String b=(asHex(output1.getBytes()));
		System.out.println("TADIYAL "+a);
		System.out.println("DEVTAIYAL "+b);
		String urlParameters ="cust_id="+a+"&cust_pass="+b;*/

                //Send post request
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                //	wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();

                System.out.println("\nSending 'POST' request to URL : " + url);
                //	System.out.println("Post parameters : " + urlParameters);
                //System.out.println("Response Code : " + responseCode);

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                inputLine = in.readLine();

                try {
                    JSONObject json = new JSONObject(inputLine);
                    anj = json.getString("country");
                    System.out.println("value of port" + anj);
                } catch (JSONException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(bal + "}}}}}}}}}}}}}}}}}}}}}}44444" + inputLine);

                return bal + lab;

            } catch (Exception e) {
                Log.e("Balance", "XML Pasing Excpetion ");
                e.printStackTrace();
                return null;
            }
        }
    }

}
