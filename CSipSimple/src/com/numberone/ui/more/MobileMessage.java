package com.numberone.ui.more;
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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numberone.R;
import com.numberone.api.SipProfile;
import com.numberone.db.DBProvider;
import com.numberone.ui.dialpad.DigitsEditText;
import com.numberone.utils.Log;


      
    public class MobileMessage extends Activity{ 
    	
	private ProgressDialog dialog;
	EditText edittext1,mobile;
	public static EditText job;
	TextView refill,balance,country;
    public static String str,user,pass,msg,ccp,jsonvalue;
	SipProfile account;
    Button send,cancel,contact;
    private static final int PICK_CONTACT = 0;
    private DigitsEditText digits;
    
	public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.mobile_message);
	
	mobile = (EditText) findViewById(R.id.cw_mob);
	
	job = (EditText) findViewById(R.id.cw_job);
	/*if(More.count==1)
	{
	job.setText("Please download the numberone app! Calls starting to International destination from 1/2p. Click the link https://www.numberone.co.uk/download.php. numberone Call More Pay Less");
	More.count=0;
	}else
	{
		job.setText("");
	}*/
	
	
    send=(Button)findViewById(R.id.save_bt);
	cancel=(Button)findViewById(R.id.cancel_bt);
	contact=(Button)findViewById(R.id.contacts);
	
	
	 /*if(More.count==1)
		{
		job.setText("hello");
		}else
		if(DialerCallBar.count==2)
		{
			job.setText("");
			
		}*/
			
	
	/* country.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				//Toast.makeText(getApplication(),"Hello I am your OPCODE", Toast.LENGTH_LONG).show();
				
				Intent moveToCountryDialog=new Intent(InviteFriend.this, CountryDialog.class);
				startActivity(moveToCountryDialog);
				
				
	              System.out.println("saved value of country name in AccountWizard : "+CountryDialog.savedCountryName);
				//  System.out.println("saved value of country flag in AccountWizard : "+CountryDialog.savedCountryFlag);
	              System.out.println("saved value of country code in AccountWizard : "+CountryDialog.savedCountryCode);
				
			}
		});
	*/
	
	}
	
  public void onResume()
  {
	super.onResume();
			
	 send.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				
				ConnectivityManager connMgr = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

			       NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
				//Toast.makeText(getApplication(),"Hello I am send button", Toast.LENGTH_LONG).show();
				String MobileNumber = mobile.getText().toString();
				String jobTitle = job.getText().toString();
		        
				System.out.println("loooloooooooooooooo: "+jobTitle+"loooooooooooolaaaaaa: "+MobileNumber);
			

				 if( networkInfo != null && networkInfo.isConnected())
		   	     {
					 if(validate())
					 { 
		   		 str=mobile.getText().toString();
		   		 msg=job.getText().toString();
		   		 
		   		  System.out.println("destination number : "+str);
		   		  System.out.println("destination message : "+msg);
		   		  
		   		 new LongOperation().execute(user);
					 }
		   		  }
				 
	             else
			      {
			    	  showNetworkAlert(); 
			      }
					
				}
		});
	 
	 cancel.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				
				String text = "";
				mobile.setText(text);
			    job.setText(text);
			    finish();
			
		        // fetch data
				
		    	  //showNetworkAlert();  
		    	
		    
				
			}
		});
	 contact.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				//Toast.makeText(getApplication(),"Hello I am your Contact button", Toast.LENGTH_LONG).show();
				contact();
			}
		});
  }
  
  void showNetworkAlert() 
	{
		new AlertDialog.Builder(this)
				.setTitle("Status")
				.setMessage(
						"Ensure Network is enabled")
				.setNeutralButton("OK", new DialogInterface.OnClickListener()
				{

					public void onClick(DialogInterface dialog, int which)
					{
						/*Intent siphome = new Intent(getApplicationContext(),SipHome.class);
						startActivity(siphome);*/
						
						
							}
				}).show();
				
	}

  
  
 	public void onActivityResult(int requestCode, int resultCode, Intent data) {
 	    // TODO Auto-generated method stub
 	    super.onActivityResult(requestCode, resultCode, data);
 	    
 	    try{

 	   if(requestCode == PICK_CONTACT){
 	   if(resultCode == resultCode){
 	    Uri contactData = data.getData();
 	    Cursor cursor =  getContentResolver().query(contactData, null, null, null, null);
 	                    
 	      cursor.moveToFirst();

 	      String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
 	      mobile.setText(number);
 	      mobile.requestFocus();
 	      
 	      System.out.println(cursor+"xxxxxxxxxxxxxxxxxxxxxxxnumber="+number);

 	      //contactName.setText(name);
 	      //contactNumber.setText(number);
 	      //contactEmail.setText(email);
 	     }
 	     }
 	   
 	    }catch(NullPointerException e){
 	    	System.out.println(e);
 	    }
 	     }
  @SuppressLint("NewApi") public void contact() {
		// TODO Auto-generated method stub

		
	   // Toast.makeText(getApplication(),"Hello ", Toast.LENGTH_LONG).show();
	    
		Intent pickContactIntent = new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
	    pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
	    startActivityForResult(pickContactIntent, PICK_CONTACT);
        
	    System.out.println("hello you had click the contact method <*><*><*><*><*><*>");
	
	}

  
  
  
  
  
public boolean validate()
{
	String str=mobile.getText().toString();
	 msg=job.getText().toString();
	int dest_Length=str.length();
	int dest_Length1=msg.length();
	if(dest_Length==0 && dest_Length1==0)
	{
		Toast.makeText(this, "Enter mobile number and message.", Toast.LENGTH_LONG).show();
		
	return false;
	}
	
	if (job.getText().length() == 0) {
		
		Toast.makeText(this, "Enter message.", Toast.LENGTH_LONG).show();
		
		return false;
	}
	if (dest_Length<=6) {
		Toast.makeText(this, "Please enter correct mobile number.", Toast.LENGTH_LONG).show();
		return false;
	}
	
	/*if(dest_Length==0 && dest_Length1==0)
	{
		Toast.makeText(this, "Please first enter Mobile Number and write your message first.", Toast.LENGTH_LONG).show();
		
	return false;}*/
	else
	{
		return true;}
	
}

void showPinAlert() 
{
	new AlertDialog.Builder(this)
			.setTitle("Status")
			.setMessage(
					"Invalid mobile number, check your account")
			.setNeutralButton("OK", new DialogInterface.OnClickListener()
			{

				public void onClick(DialogInterface dialog, int which)
				{
					
					// anurag
					/*Intent intent = new Intent(Intent.ACTION_MAIN);
					intent.setAction(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
					startActivity(intent);*/
				}
			}).show();
}






private class LongOperation extends AsyncTask<String, Void, String> {
    
	 JSONObject json;
	 String message;
	
   @Override
   protected String doInBackground(String... params) {
   	
								
         return  getBalance(params[0]);
   }      

   @Override
   public void onPostExecute(String result) {  
   	 try{
   		
   		 System.out.println("DEVTADIYAL"+ccp);
   	    	json = new JSONObject(jsonvalue);
   	    	message=json.getString("msg");
   	    	System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQ"+message);
   	    	
   	       
   	    	if(message.contains("You have enter wrong Number.")||message.contains("Error loading your account information!"))
   	    	{  
   	    		showPinAlert();	
   	    	}else
   	    	{ 
   		
   		new AlertDialog.Builder(MobileMessage.this)
			.setTitle("Alert")
			.setMessage(message)
			.setNeutralButton("OK", new DialogInterface.OnClickListener()
			{

				public void onClick(DialogInterface dialog, int which)
				{
					
					if(message.startsWith("You Enter wrong Mobile Number."))
					{
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						
					}else
					{
						/* Intent it = new Intent(InviteFriend.this,SipHome.class);
				        	//  it.putExtra("did",str);
				        	  it.setAction(SipManager.ACTION_SIP_DIALER);
				        	  it.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
				        	  startActivity(it);*/
						finish();
					}
									// anurag
					/*Intent intent = new Intent(Intent.ACTION_MAIN);
					intent.setAction(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
					startActivity(intent);*/
				}
			}).show();
   	}
   	
       }
       catch(Exception e)
       {
       	
       }
   	
   
    }

  protected void onPreExecute() {
	  
	 /*  dialog=new ProgressDialog(MobileMessage.this);
		//dialog.setTitle("Please wait.....");
	   dialog.setTitle("Alert");
		//dialog.setMessage("sending........");
		dialog.setMessage("Message sending...");
		dialog.setCancelable(true);

		dialog.show();*/
		
		
		
    }
	   
   

   protected void onProgressUpdate(Void... values) {
   }
   public String getBalance(String user) {
		
		try {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ : "+user);
			
			SipProfile account;
			long accountId = 1;
			account = SipProfile.getProfileFromDbId(MobileMessage.this, accountId,
					DBProvider.ACCOUNT_FULL_PROJECTION);
			String inputLine;
			String str=mobile.getText().toString();
		   String   str1=str.replaceAll("[()\\s-]+", "");
			System.out.println(str+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+str1);
			 msg=job.getText().toString();
			 
		//	 String numberCode=CountryDialog.savedCountryCode.substring(1, CountryDialog.savedCountryCode.length());
			 String url = "https://sarge.virtualsystems.co.za/nontech/billing_send_sms/send_web_sms_clickatell.php";
			 
		        URL obj = new URL(url);
		        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    
	  //add reuqest header
	  con.setRequestMethod("POST");
	  //con.setRequestProperty("User-Agent", USER_AGENT);
	  con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	  String key = "887&try&%F834512";
	  String data1 = account.getSipUserName();
	  System.out.println("USERNAME "+data1);
	  String data2=account.getPassword();	  
	  System.out.println("PASSWORD "+data2);
	  String data3=mobile.getText().toString();
	  System.out.println("MOBILENUMBER "+data3);
	  String data4=job.getText().toString();
	  System.out.println("MESSAGE "+data4);
	  
	  String output1 =encrypt(data1, key);
	  String output2 =encrypt(data2, key);
	  String output3= encrypt(data3, key);
	  String output4=encrypt(data4, key);
		
	  
		String a=(asHex(output1.getBytes()));
		System.out.println("ENCRYPTED USERNAME " +a);
		String b=(asHex(output2.getBytes()));
		System.out.println("ENCRYPTED PASSWORD "+b);
		String c=(asHex(output3.getBytes()));
		System.out.println("ENCRYPTED MOBILENUMBER "+c);
		String d=(asHex(output4.getBytes()));
		System.out.println("ENCRYPTED MESSAGE "+d);
		
		String e  = d.replaceAll(" ", "%20");
	  
	  String urlParameters = "username="+a+"&password="+b+"&receiver="+c+"&r_message="+e;

	  // Send post request
	  con.setDoOutput(true);
	  DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	  wr.writeBytes(urlParameters);
	  wr.flush();
	  wr.close();

	  // System.out.println("\nSending 'POST' request to URL : " + url);
	//  System.out.println("Post parameters : " + urlParameters);
	  //System.out.println("Response Code : " + responseCode);

	  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	 
	  StringBuilder response = new StringBuilder();
	  while ((inputLine = in.readLine()) != null) {
		   response.append(inputLine);
		  }
		  in.close();
		  System.out.println(response.toString());  
		  jsonvalue=response.toString();
		  System.out.println("TADIYALSINGHDEV"+jsonvalue);
		  JSONObject json = null;
		  try {
		  	json = new JSONObject(response.toString());
		  	String  result123 = json.getString("result");
		  /*String msg123 = json.getString("msg");
		  ccp=msg123;
		  System.out.println(ccp);*/
		    
		  //  System.out.println("balance "+result123  +"\n curreny "+msg123);
		  }
		  catch (JSONException e1) {
		  	// TODO Auto-generated catch block
		  	e1.printStackTrace();
		  }
			return inputLine;

		} catch (Exception e) {
			Log.e("Balance", "XML Pasing Excpetion ");
			e.printStackTrace();
			return null;
		}

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
   }








