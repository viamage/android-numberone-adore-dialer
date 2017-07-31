package com.numberonecall.ui.more;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numberonecall.R;
import com.numberonecall.api.SipProfile;
import com.numberonecall.db.DBProvider;
import com.numberonecall.utils.Log;
public class Rate extends Activity{ 
	private ProgressDialog dialog;
	
	
	EditText edittext1,edittext2;
	TextView SelectCountry,country1,rate1,prefix1;
	Button button10;
	TextView refill,balance;
 
  public static String str,user,pass,voucher,message;
	SipProfile account;
	ConnectivityManager connMgr;
	NetworkInfo networkInfo;

	public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.rate);
	
	country1= (TextView) findViewById(R.id.textView9);
	rate1= (TextView) findViewById(R.id.textView10);
	prefix1= (TextView) findViewById(R.id.textView11);
	edittext2= (EditText) findViewById(R.id.editText2);
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
		
		
		
			if(dest_Length1!=0)
			{
				new LongOperation().execute(user);
			}
			else
			{
				Toast.makeText(getApplicationContext(),"Please enter a Country code.",Toast.LENGTH_SHORT).show();
			}
			
		
		/*if(dest_Length1!=0 && dest_Length2!=0)
			
		{
			new LongOperation().execute(user);
		}
		
		else
		{
			Toast.makeText(getApplicationContext(),"Please fill all credentials",Toast.LENGTH_SHORT).show();  
		}*/
	
	
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

	public String r="0",country,rate,prefix;
	
    @Override
    protected String doInBackground(String... params) {
    	
								
          return  getBalance(params[0]);
    }      

    @Override
    public void onPostExecute(String result) {
    	
    	r = result;
   country1.setText(country);
   rate1.setText(rate);
   prefix1.setText(prefix);
   
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
    public String getBalance(String user) {
		
		String Currency = "";
		int mode = Context.MODE_PRIVATE;
		try {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ : "+user);
			
		
			long accountId = 1;
			account = SipProfile.getProfileFromDbId(Rate.this, accountId,
					DBProvider.ACCOUNT_FULL_PROJECTION);
			String user1, pass1;
			user1 = account.getSipUserName();
			pass1 = account.getPassword();

			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@DEVTADIYAL "+pass1);
String RateNumber3 = edittext1.getText().toString();
			System.out.println("DEVTADIYAL  "+RateNumber3);
			 URL oracle = new URL("http://portal.numone.keios.eu/api/v1/rates/Antonio?key=834cu9sA7vhS721bjXng9v7a6v118&prefix="+RateNumber3+"&page=1&perPage=1");
		        URLConnection yc = oracle.openConnection();
		        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		       
		        
		        String inputLine;
		       inputLine = in.readLine(); 
		         
		       
		       JSONObject j = new JSONObject(inputLine);
		       String a = j.getString("data");
		       System.out.println(a);
		       
		       JSONArray ja = new JSONArray(a);
		       for(int i=0;i<ja.length();i++)
		       {
		    	   JSONObject j1 = ja.getJSONObject(0);
			       System.out.println(j1);
			     country = j1.getString("description");
			       System.out.println(country);
			     rate = j1.getString("voice_rate");
			       System.out.println(rate);
			     prefix = j1.getString("prefix");
			       System.out.println(prefix);
		       }
		      
		        in.close();
	
		        System.out.println(inputLine+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$@@@@@@@@@@@@@@@@");
		       /* System.out.println(inputlinee.inputline(2,4));*/
		     
		        return  null;

		} catch (Exception e) {
			Log.e("Balance", "XML Pasing Excpetion ");
			e.printStackTrace();
			return "0";
		}

	}
}


}