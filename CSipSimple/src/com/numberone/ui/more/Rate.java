package com.numberone.ui.more;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
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
import android.app.ProgressDialog;
import android.content.Context;
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
import com.numberone.api.SipManager;
import com.numberone.api.SipProfile;
import com.numberone.api.SipUri;
import com.numberone.db.DBProvider;
import com.numberone.ui.SipHome;
public class Rate extends Activity{ 
	private ProgressDialog dialog;
	
	
	EditText edittext1,edittext2;
	TextView SelectCountry;
	Button button10;
	TextView refill,balance;
 
  public static String str,user,pass,voucher,message;
	SipProfile account;
	ConnectivityManager connMgr;
	NetworkInfo networkInfo;

	public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.rate);
	
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
		
		
		if(dest_Length1!=9)
		{
			Toast.makeText(getApplicationContext(),"Please enter a 9 digit mobile number.",Toast.LENGTH_SHORT).show(); 
			
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






private class LongOperation extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
    	
								
          return  getBalance(params[0]);
    }      

    @Override
    protected void onPostExecute(String result) {  

    	
    	if(message.contains("The balance was transferred successfully."))
    	{  
    		new AlertDialog.Builder(Rate.this)
			.setTitle("Status")			
			.setMessage(message)
			.setNeutralButton("OK", new DialogInterface.OnClickListener()
			{

				public void onClick(DialogInterface dialog, int which)
				{
					 Intent it = new Intent(Rate.this,SipHome.class);
			        	//  it.putExtra("did",str);
			        	  it.setAction(SipManager.ACTION_SIP_DIALER);
			        	  it.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			        	  startActivity(it);
					
					
				}
			}).show();
    	}
    	
    	else if(message.contains("Not enough balance available,please top up.."))
    	{
    		new AlertDialog.Builder(Rate.this)
			.setTitle("Alert")			
			.setMessage(message)
			.setNeutralButton("OK", new DialogInterface.OnClickListener()
			{

				public void onClick(DialogInterface dialog, int which)
				{
					 Intent it = new Intent(Rate.this,SipHome.class);
			        	//  it.putExtra("did",str);
			        	  it.setAction(SipManager.ACTION_SIP_DIALER);
			        	  it.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			        	  startActivity(it);
					
					
				}
			}).show();
    	}
    	else
    	{    
    		
    		new AlertDialog.Builder(Rate.this)
			.setTitle("Alert")			
			.setMessage(message)
			.setNeutralButton("OK", new DialogInterface.OnClickListener()
			{

				public void onClick(DialogInterface dialog, int which)
				{
					 Intent it = new Intent(Rate.this,SipHome.class);
			        	//  it.putExtra("did",str);
			        	  it.setAction(SipManager.ACTION_SIP_DIALER);
			        	  it.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			        	  startActivity(it);
					
					
				}
			}).show();
    	}  	
    }
     }
 
   protected void onPreExecute() {
	   
	/*   dialog=new ProgressDialog(RefillVoucher.this);
		dialog.setTitle("Please wait.....");
		dialog.setMessage("Recharge........");
		dialog.setCancelable(false);

		dialog.show();
	   */
    }

    protected void onProgressUpdate(Void... values) {
    }
    public String getBalance(String user) {
		
		String Currency = "";
		try {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ : "+user);
			
			SipProfile account;
			long accountId = 1;
			account = SipProfile.getProfileFromDbId(Rate.this, accountId,
					DBProvider.ACCOUNT_FULL_PROJECTION);
			String user1, pass1;
			//String key = "8f3dfsd45345dr";
			String key = "34a5b6c1&d*F8#97";
			  
			user1 = account.getSipUserName();
			pass1 = account.getPassword();
			String uservalue=edittext1.getText().toString();
			System.out.println(uservalue);
			String uservalue2=edittext2.getText().toString();
			System.out.println(uservalue2);
			
			
			  String output1 =encrypt(user1, key);
			  System.out.println(output1);
			  String output2 =encrypt(pass1, key);
			  System.out.println(output2);
			  String output3= encrypt(uservalue, key);
			  System.out.println(output3);
			  String output4= encrypt(uservalue2, key); 
			  System.out.println(output4);
			
			  String a=(asHex(output1.getBytes()));
			  System.out.println(a);
				String b=(asHex(output2.getBytes()));
				System.out.println(b);
				String c=(asHex(output3.getBytes()));
				System.out.println(c);
				String d=(asHex(output4.getBytes()));
				System.out.println(d);
			  
            String url = "https://billing.yepingo.com/maltatech/billing_balance_transfer_balance/balance_transfer.php";
	        URL obj = new URL(url);
	        System.out.println("URL REUEST SEND TO SERVER");
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
//add reuqest header
con.setRequestMethod("POST");
//con.setRequestProperty("User-Agent", USER_AGENT);
con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
String urlParameters = "cust_id="+a+"&cust_pass="+b+"&transferaccount="+c+"&credit="+d;
System.out.println("cust_id"+a+"cust_pass"+b+"transferaccount"+c  +d);
System.out.println("REFILL VOUCHER CLASS UPDATED");
// Send post request
con.setDoOutput(true);
DataOutputStream wr = new DataOutputStream(con.getOutputStream());
wr.writeBytes(urlParameters);
wr.flush();
wr.close();

BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuilder response = new StringBuilder();

while ((inputLine = in.readLine()) != null) {
 response.append(inputLine);
}
in.close();
//print result
System.out.println("DEV"+response.toString()); 
voucher=response.toString();
System.out.println(voucher);
JSONObject j;
try {
	j = new JSONObject(voucher);
	message  = j.getString("msg");
	System.out.println("MESSAGE "+message);
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

  
   
		}
catch (IOException e) {
	            e.printStackTrace();
	        }
		return Currency;
			

		} 
		
    private String encrypt(String input, String key) {
		// TODO Auto-generated method stub
		byte[] crypted = null;
		try{
		SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skey);
		crypted = cipher.doFinal(input.getBytes());
		}catch(Exception e){
		System.out.println(e.toString());
		}
		return new String(Base64.encodeBase64(crypted));
		}

		public final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

		public  String asHex(byte[] buf)
		{
		char[] chars = new char[2 * buf.length];
		for (int i = 0; i < buf.length; ++i)
		{
		chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
		chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
		}
		return new String(chars);
		}
	}









