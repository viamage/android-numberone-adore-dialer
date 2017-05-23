package com.numberone.ui.more;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.numberone.R;
import com.numberone.api.SipProfile;
import com.numberone.db.DBProvider;
import com.numberone.utils.Log;
public class BalanceTransfer extends Activity{ 
	private ProgressDialog dialog;
	
	
	public static EditText edittext1,edittext2,edittext3;
	TextView SelectCountry;
	Button button10;
	TextView refill,balance;
 
  public static String str,user,pass,voucher,message;
	SipProfile account;
	ConnectivityManager connMgr;
	NetworkInfo networkInfo;

	public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.balancetransfer);
	
	edittext2= (EditText) findViewById(R.id.editText2);
	//edittext3= (EditText) findViewById(R.id.editText3);
	
	edittext1= (EditText) findViewById(R.id.editText1);
	button10= (Button) findViewById(R.id.button1);
	}
public void onResume()
{
	super.onResume();
	
}

public void onClick(View v) {
	int id = v.getId();
	switch (id) {
	
	case R.id.button1:
		String uservalue=edittext1.getText().toString();
		System.out.println(uservalue);
		int dest_Length1=uservalue.length();
		String uservalue2=edittext2.getText().toString();
		System.out.println(uservalue2);
		int dest_Length2=uservalue2.length();
		
		
		if(dest_Length1>20)
		{
			Toast.makeText(getApplicationContext(),"Please enter correct mobile number.",Toast.LENGTH_SHORT).show(); 
			
		}
		else
		{
			if(dest_Length2!=0)
			{
				new LongOperation().execute(user);
			}
			else
			{
				Toast.makeText(getApplicationContext(),"Please enter a amount.",Toast.LENGTH_SHORT).show();
			}
			
		}
	
	
	
		break;

		
	}
}

public boolean validate()
{
	String str=edittext1.getText().toString();
	int dest_Length=str.length();
	
	if(dest_Length==0)
	{
		Toast.makeText(this, "Enter voucher number", Toast.LENGTH_LONG).show();
		
	return false;
	}
	else
	{
		return true;
	}
	}

void showPinAlert() 
{
	new AlertDialog.Builder(this)
			.setTitle("Status")
			.setMessage(message)
			.setNeutralButton("OK", new DialogInterface.OnClickListener()
			{

				public void onClick(DialogInterface dialog, int which)
				{
					
					

					
				}
			}).show();
}




public class LongOperation extends AsyncTask<String, Void, String> {

	  String 	bal="";
	  String 	lab="";
	  public String alb,rf,a1;
	 
	  
	  
    @Override
    protected String doInBackground(String... params) {
    	
									
          return  getBalance(params[0]);
    }      

    @Override
    public void onPostExecute(String result) {
    	
    	new AlertDialog.Builder(BalanceTransfer.this)
		.setTitle("Alert")			
		.setMessage(a1)
		.setNeutralButton("OK", new DialogInterface.OnClickListener()
		{

			public void onClick(DialogInterface dialog, int which)
			{
				
				
				
			}
		}).show();
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
    	long accountId = 1;
		account = SipProfile.getProfileFromDbId(getApplicationContext(), accountId,DBProvider.ACCOUNT_FULL_PROJECTION);
		String user1, pass1;
		user1 = account.getSipUserName();
		pass1 = account.getPassword();
    	
    	String url = "https://api-v1.numberonecall.com/api/v1/transferto/"+user1+"/confirm";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
String a = "834cu9sA7vhS721bjXng9v7a6v118";
		String b = edittext1.getText().toString();
		String d = edittext2.getText().toString();
		String urlParameters = "key="+a+"&amount="+d+"&currency=EUR&phone="+b;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		JSONObject j = new JSONObject(response.toString());
		 a1 = j.getString("message");
		System.out.println(a1);
		
    return bal+lab;

    } catch (Exception e) {
   // Log.e("Balance", "XML Pasing Excpetion ");
    e.printStackTrace();
    return null;
    }
	}	
	}
}