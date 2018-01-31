package com.numberonecall.ui.account;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
//import com.androidquery.service.MarketService;
import com.numberonecall.R;
import com.numberonecall.api.SipManager;
import com.numberonecall.api.SipProfile;
import com.numberonecall.db.DBProvider;
import com.numberonecall.models.Filter;
import com.numberonecall.ui.ScreenSplash;
import com.numberonecall.ui.SipHome;
import com.numberonecall.ui.dialpad.DialerFragment;
import com.numberonecall.ui.more.Signup;
import com.numberonecall.utils.AccountListUtils;
import com.numberonecall.utils.PreferencesWrapper;
import com.numberonecall.utils.AccountListUtils.AccountStatusDisplay;
import com.numberonecall.utils.animation.ActivitySwitcher;
import com.numberonecall.wizards.WizardIface;
import com.numberonecall.wizards.impl.Basic;



public class AccountWizard extends SherlockActivity {
	private static final int PARAMS_MENU = 0;
	private final static int CHANGE_PREFS = 1;
	TextView term;
	
	CheckBox cbS;
	 TextView tv;
	TextView status ;
	public static TextView tv1;
	TextView status1;
	// CheckBox cb;
	boolean toggle=false;
	public static EditText pass, user, sip, proxy,mobilenumber,acc_Mobile,textView11,textView22;
	String no;
	protected static SipProfile account;
	private WizardIface wizard = null;
	LongOperation1 asyncTask2 =new LongOperation1(AccountWizard.this);
	private String wizardId = "";
	private BroadcastReceiver mReceiver;
	ImageView imageView11;
	public static Button register,button11;
	public static String str,b,c,accountvalue,message,a,num,code,ss="";
	IntentFilter intentFilter;
	private ProgressDialog dialog;
	protected void onCreate(Bundle savedInstanceState) {
		setWizardId();
		
		super.onCreate(savedInstanceState);
		
	
		setContentView(R.layout.account_wizard);

      
		// cb = (CheckBox) findViewById(R.id.acc_checkbox);
		mobilenumber = (EditText) findViewById(R.id.acc_Mobile);
		pass = (EditText) findViewById(R.id.acc_pass);
		tv1 = (TextView) findViewById(R.id.textView1);
		user = (EditText) findViewById(R.id.acc_user);
		textView22 = (EditText) findViewById(R.id.textView2);
		register = (Button) findViewById(R.id.acc_Register);
	//	button11 = (Button) findViewById(R.id.button1);
		//proxy = (EditText) findViewById(R.id.acc_proxy);
		status = (TextView) findViewById(R.id.status);
		status1 = (TextView) findViewById(R.id.status1);
		imageView11 = (ImageView) findViewById(R.id.imageView1);
	//	textView11 = (EditText) findViewById(R.id.textView1);
		long accountId = 1;
		account = SipProfile.getProfileFromDbId(this, accountId,
				DBProvider.ACCOUNT_FULL_PROJECTION);
		
		
//em.out.println("ms.level(MarketService.MINOR).checkVersion();===="+ms.level(MarketService.MINOR));
		
		
	}

	
	
	
	public void onResume() {
		super.onResume();
		
		ActivitySwitcher.animationIn(findViewById(R.id.account_layout),
				getWindowManager());
		
		CountryDialog cd  = new CountryDialog();
		cd.getListData();
		CountryDialog.sortinggg(CountryDialog.list);
		textView22.setText(ScreenSplash.anj);
		imageView11.setImageResource(CountryDialog.flagg);
		tv1.setText(CountryDialog.cc);
		//sip.setText(account.getSipDomain());
		try {
			 no = user.getText().toString();
			 accountvalue = account.getSipUserName();
			 System.out.println("ACCOUNT NUMBER "+accountvalue);
			 
			
			   user.setText(account.getSipUserName());
				pass.setText(account.getPassword());
				
				b = CountryDialog.countryCode;
				c = ScreenSplash.anj;
				System.out.println("Value of country code iss 3333 :"+b);
				System.out.println("Value of country code iss 3222 :"+c);
				if(num != null && num != "")
				{
					user.setText(num);
					pass.setText(account.getPassword());
				}
				if(code != null && code != "")
				{
					tv1.setText(code);
					pass.setText(account.getPassword());
					System.out.println("Value of country code iss 44444 :"+tv1);
				}
				if( CountryDialog.countryCode != null)
				{   
					tv1.setText(CountryDialog.countryCode);
					pass.setText(account.getPassword());
					System.out.println("Value of country code iss 5555 :"+tv1);
				}
				if( CountryDialog.countryName != null)
				{   imageView11.setImageResource(CountryDialog.countryFlag);
					textView22.setText(CountryDialog.countryName);
					pass.setText(account.getPassword());
					System.out.println("Value of country code iss 6666 :"+textView22);
				}
				
				/*if( c != null)
				{   
					
					tv1.setText(CountryDialog.cc);
				
					//textView22.setText(CountryDialog.countryName);
					//pass.setText(account.getPassword());
					System.out.println("Value of country code iss 8999 :");
					System.out.println("Value of country code iss 8777 :"+CountryDialog.cc);
					System.out.println("Value of country code iss 8888 :"+textView22);
				}*/
			
			//imageView11.setImageResource(CountryDialog.countryFlag);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//tv1.setText(b);
			e.printStackTrace();
		}
		
		this.resolveStatus();
		
		// Register Broadcast Reciever
		intentFilter = new IntentFilter(
				SipManager.ACTION_SIP_REGISTRATION_CHANGED);
		mReceiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				Log.e("Broadcast", "registration changed");
				 IntentFilter intentfilter = new IntentFilter();
					intentfilter.addAction(SipManager.ACTION_GET_EXTRA_CODECS);
					System.out.println("Intent call!!!!!!!!!!!!");
				AccountStatusDisplay accountStatusDisplay = AccountListUtils
						.getAccountDisplay(getApplicationContext(), 1);
				status.setTextColor(accountStatusDisplay.statusColor);
				status.setText(accountStatusDisplay.statusLabel);
				if (accountStatusDisplay.statusLabel == getString(R.string.acct_registered))
					animate();
			}
		};
		this.registerReceiver(mReceiver, intentFilter);
		
	}

	public void onPause() {
		super.onPause();
		this.unregisterReceiver(this.mReceiver);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, PARAMS_MENU, Menu.NONE, R.string.prefs)
				.setIcon(android.R.drawable.ic_menu_preferences)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case PARAMS_MENU:
			startActivityForResult(
					new Intent(SipManager.ACTION_UI_PREFS_GLOBAL), CHANGE_PREFS);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CHANGE_PREFS) {
			sendBroadcast(new Intent(SipManager.ACTION_SIP_REQUEST_RESTART));
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		/*
		 * case R.id.acc_checkbox: // checkbox script to save account
		 * saveAccounts(); break;203.123.147.41
		 */
		
		
		case R.id.acc_Register:
		
			String str=mobilenumber.getText().toString();
			int dest_Length=str.length();
			Toast.makeText(this, "Under Development", Toast.LENGTH_LONG).show();
			
			break;		
			
		case R.id.imageView1:
			
			Intent i = new Intent(this,CountryDialog.class);
			startActivity(i);
			break;
			
		case R.id.acc_login:
			
			// login script
			ConnectivityManager connMgr = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

		       NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			
			if(networkInfo != null && networkInfo.isConnected())
			{   
				String a = code+user.getText().toString();
				String b = user.getText().toString();
				//System.out.println(a+"           EVDE                "+accountvalue);
				
				if(!(b.startsWith("0")))
				{
					if(!(b.contains("+")))
					{
					new Authrosied().execute("");
					saveAndFinish();
					}
				
					else
					{
						Toast toast1 = Toast.makeText(this,"Please remove prefix + sign from entered number",Toast.LENGTH_SHORT);
				        toast1.setGravity(Gravity.CENTER,0,0);
				        toast1.show();
					}
				}
				else
				{
					Toast toast1 = Toast.makeText(this,"Please remove 0 before the number",Toast.LENGTH_SHORT);
			        toast1.setGravity(Gravity.CENTER,0,0);
			        toast1.show();
				}
				
				
				
				
			}
			else
			{
				Toast toast1 = Toast.makeText(this,"Please Turn On internet connection",Toast.LENGTH_SHORT);
		        toast1.setGravity(Gravity.CENTER,0,0);
		        toast1.show();
				
			}
			
			
			
			// user.setText(a+account.getSipUserName());
			try {
				File f = new File(getFilesDir(), "devii.txt");
				try {
					FileWriter fw = new FileWriter(f);
					String s = user.getText().toString();
					
					
					fw.write(s);
					System.out.println(f.getAbsolutePath());
					
					fw.close();
					
					BufferedReader bf = new BufferedReader(new FileReader(f));
					String sss;
					while((sss = bf.readLine())!=null)
					{
						num=sss;
						System.out.println("READING VALUE IN ACCOUNT WIZARD"+sss);
					}
					System.out.println("VALUE OF STATIC type number "+num);
					bf.close();
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				File f = new File(getFilesDir(), "devi.txt");
				try {
					FileWriter fw = new FileWriter(f);
					String s = b;//AccountWizard.creditStatus;
					
					
					fw.write(s);
					System.out.println(f.getAbsolutePath());
					
					fw.close();
					
					BufferedReader bf = new BufferedReader(new FileReader(f));
					String sss;
					while((sss = bf.readLine())!=null)
					{
						code=sss;
					
					}
					System.out.println("VALUE OF STATIC country code "+code);
					bf.close();
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*else
			{   
				
				
				if(validate3())
				method();
				System.out.println("@@@@@@@@@@@@@**********Hello user is on offline ");
				
			}*/
			
			break;
			
			
		case R.id.Login_page:
		/*	// Go to login page (Already I have a PIN)
			findViewById(R.id.acc_Mobile).setVisibility(View.GONE);
			findViewById(R.id.Login_page).setVisibility(View.GONE);
		//	findViewById(R.id.checkBox1).setVisibility(View.GONE);
			findViewById(R.id.forget_button).setVisibility(View.VISIBLE);
			findViewById(R.id.REGISTER_BUTTON_LAY).setVisibility(View.GONE);
			findViewById(R.id.textView1).setVisibility(View.GONE);
			findViewById(R.id.acc_Mobclear).setVisibility(View.GONE);
			findViewById(R.id.Register_page).setVisibility(View.VISIBLE);
			findViewById(R.id.acc_login).setVisibility(View.VISIBLE);
			findViewById(R.id.acc_pass).setVisibility(View.VISIBLE);
	findViewById(R.id.acc_clear).setVisibility(View.VISIBLE);
			findViewById(R.id.acc_user).setVisibility(View.VISIBLE);
			findViewById(R.id.status).setVisibility(View.VISIBLE);*/
			
			break;
			
		case R.id.Register_page:
		/*	// Go to Register Page 
			findViewById(R.id.acc_Mobile).setVisibility(View.VISIBLE);
			//findViewById(R.id.term).setVisibility(View.VISIBLE);
			findViewById(R.id.Login_page).setVisibility(View.VISIBLE);
		//	findViewById(R.id.checkBox1).setVisibility(View.VISIBLE);
			findViewById(R.id.forget_button).setVisibility(View.GONE);
			findViewById(R.id.textView1).setVisibility(View.VISIBLE);
			findViewById(R.id.REGISTER_BUTTON_LAY).setVisibility(View.VISIBLE);
			findViewById(R.id.acc_login).setVisibility(View.GONE);
			findViewById(R.id.acc_clear).setVisibility(View.GONE);
			findViewById(R.id.acc_pass).setVisibility(View.GONE);
			findViewById(R.id.acc_user).setVisibility(View.GONE);
			findViewById(R.id.Register_page).setVisibility(View.GONE);
			findViewById(R.id.status).setVisibility(View.GONE);*/
			break;
		case R.id.acc_clear:
			// checkbox script
			
			clearAlll();
			break;
			
			
		case R.id.forget_button:
			Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse("https://portal.numberonecall.com/signin?mobile=1"));
			startActivity(intent);
		//	http://portal.numone.keios.eu/signup
			  break;
			  
	/*	case R.id.button1:
			Toast.makeText(this, "Under Development", Toast.LENGTH_LONG).show();
			  Intent intent1 = new Intent(this, Signup.class);
			    startActivity(intent1);
			  break;*/
			  
		}		  			  
		
	}
   
	
	protected Context getActivity() {
		// TODO Auto-generated method stub
		return null;
	}




	public void method()
	   {
		   Intent it=new Intent(this,SipHome.class);
		
		   startActivity(it);
		
	   }
	void saveAccounts() {

	}

	private boolean setWizardId() {

		try {
		//			wizard = Advanced.class.newInstance();
			wizard = Basic.class.newInstance();
		} catch (IllegalAccessException e) {

			return false;
		} catch (InstantiationException e) {

			return false;
		}
	//		wizardId = "Advanced";
	wizardId = "Basic";
		// wizard.setParent(this);
		return true;
	}

	public void saveAndFinish() {
		if (validate()) {
			this.registerReceiver(mReceiver, intentFilter);			
			saveAccount(wizardId);
			updateStatus();
			// IntentFilter intentfilter = new IntentFilter();
		//	intentfilter.addAction(SipManager.ACTION_GET_EXTRA_CODECS);
			//presenceMgr = new PresenceManager();
	       
			
			Intent intent = getIntent();
			setResult(RESULT_OK, intent);
		}

	}

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		return cm.getActiveNetworkInfo() != null
				&& cm.getActiveNetworkInfo().isConnectedOrConnecting();
	}
   
	
   
	 public boolean validate1()
	   {
		String str=mobilenumber.getText().toString();
		int dest_Length=str.length();
		
		if(dest_Length==0)
		{
			Toast.makeText(this, "Please enter your number with country-code", Toast.LENGTH_LONG).show();
			
		return false;
		}
		else
		{
			return true;
		}
		}
	
	boolean validate3() {
		
		if (user.getText().length() == 0) {
			status.setTextColor(Color.RED);
			status.setText("campo numero di telefono non può essere vuoto.");
			user.requestFocus();
			return false;
		}
		if (pass.getText().length() == 0) {
			status.setTextColor(Color.RED);
			status.setText("Il campo Password non può essere vuoto.");
			pass.requestFocus();
			return false;
		}
		return true;
	}
	
	
	
	
	
	boolean validate() {
		if (!isOnline()) {
			status.setTextColor(Color.RED);
			showNetworkAlert();
			// status.setText("There is no active network..");
			return false;
		}
		/*if (sip.getText().length() == 0) {
			status.setTextColor(Color.RED);
			status.setText("SIP IP field can not be blank..");
			sip.requestFocus();
			return false;
		}*/
		if (user.getText().length() == 0) {
			status.setTextColor(Color.RED);
			status.setText("Enter Your Phone Number and Password");
			user.requestFocus();
			return false;
		}
		if (pass.getText().length() == 0) {
			status.setTextColor(Color.RED);
			status.setText("Enter Your Phone Number and Password");
			pass.requestFocus();
			return false;
		}
		return true;
	}

	void showNetworkAlert() {
		new AlertDialog.Builder(this)
				.setTitle("Avviso")
				.setMessage(
						"No active network detected...press ok to check network settings")
				.setNeutralButton("OK", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// anurag
						Intent intent = new Intent(Intent.ACTION_MAIN);
						intent.setAction(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
						startActivity(intent);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								// anurag.
							}
						}).show();
	}

	void updateStatus() {
		AccountStatusDisplay accountStatusDisplay = AccountListUtils
				.getAccountDisplay(this, account.id);
		status.setTextColor(getResources().getColor(R.color.account_inactive));
		status.setText(getString(R.string.acct_registering));
	}

	private void saveAccount(String wizardId) {
		boolean needRestart = false;

		PreferencesWrapper prefs = new PreferencesWrapper(
				getApplicationContext());
		account = wizard.buildAccount(account);
		account.wizard = wizardId;
		if (account.id == SipProfile.INVALID_ID) {
			// This account does not exists yet
			prefs.startEditing();
			wizard.setDefaultParams(prefs);
			prefs.endEditing();
			Uri uri = getContentResolver().insert(SipProfile.ACCOUNT_URI,
					account.getDbContentValues());

			// After insert, add filters for this wizard
			account.id = ContentUris.parseId(uri);
			List<Filter> filters = wizard.getDefaultFilters(account);
			if (filters != null) {
				for (Filter filter : filters) {
					// Ensure the correct id if not done by the wizard
					filter.account = (int) account.id;
					getContentResolver().insert(SipManager.FILTER_URI,
							filter.getDbContentValues());
				}
			}
			// Check if we have to restart
			needRestart = wizard.needRestart();

		} else {
			// TODO : should not be done there but if not we should add an
			// option to re-apply default params
			prefs.startEditing();
			wizard.setDefaultParams(prefs);
			prefs.endEditing();
			getContentResolver().update(
					ContentUris.withAppendedId(SipProfile.ACCOUNT_ID_URI_BASE,
							account.id), account.getDbContentValues(), null,
					null);
		}

		// Mainly if global preferences were changed, we have to restart sip
		// stack
		if (needRestart) {
			Intent intent = new Intent(SipManager.ACTION_SIP_REQUEST_RESTART);
			sendBroadcast(intent);
		}
	}

	private void resolveStatus() {

		AccountStatusDisplay accountStatusDisplay = AccountListUtils
				.getAccountDisplay(this, 1);
		status.setTextColor(accountStatusDisplay.statusColor);
		status.setText(accountStatusDisplay.statusLabel);

	}

	private void clearAlll() {
		String clear = "";
		pass.setText(clear);
		user.setText(clear);
		//mobilenumber.setText(clear);
		//sip.setText(clear);
		//proxy.setText(clear);
			}

	private static final String WIZARD_PREF_NAME = "Wizard";

	@Override
	public SharedPreferences getSharedPreferences(String name, int mode) {
		return super.getSharedPreferences(WIZARD_PREF_NAME, mode);
	}

	void animate() {

		ActivitySwitcher.animationOut(findViewById(R.id.account_layout),
				getWindowManager(),
				new ActivitySwitcher.AnimationFinishedListener() {
					@Override
					public void onAnimationFinished() {
						DialerFragment.wasAccount = true;
						finish();
					}
				});

	}
	
	
	@Override
	public void onBackPressed() {
		AccountStatusDisplay accountStatusDisplay = AccountListUtils
				.getAccountDisplay(this, 1);
		if (accountStatusDisplay.statusLabel == getString(R.string.acct_registered)) {
			animate();
		} else {
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			startActivity(intent);
		}
	}
///////////////////////////////////////////////Authorised API//////////////////////////////////////////////////

public static class Authrosied extends AsyncTask<String, Void, String> {

public static String 	bal;
public static String 	lab;
public static String alb;
public static String encrypt(String input, String key){
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

private final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

private  String asHex(byte[] buf)
{
char[] chars = new char[2 * buf.length];
for (int i = 0; i < buf.length; ++i)
{
chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
}
return new String(chars);
}


@Override
protected String doInBackground(String... params) {


return  getBalance(params[0]);
}      

@Override
protected void onPostExecute(String result) {

System.out.println("xcxcxccxcxcxccxcxcxcxcxcxcxcccxxcxxxxcxctaddy"+result);
//balance.setText(bal+" "+lab);
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
System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ : "+user);

String url = "http://181.215.214.207/webtech5890/billing_apis_login/get_login_apis.php";
URL obj = new URL(url);
HttpURLConnection con = (HttpURLConnection) obj.openConnection();

//add reuqest header
con.setRequestMethod("POST");
//con.setRequestProperty("User-Agent", USER_AGENT);
con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
String key = "hdjdtie36457jdir";
String data1 = account.getSipUserName();
String data2=account.getPassword();
String output =Authrosied.encrypt(data1, key);
String output1 =Authrosied.encrypt(data2, key);
String a=(asHex(output.getBytes()));
String b=(asHex(output1.getBytes()));
System.out.println("TADIYAL "+a);
System.out.println("DEVTAIYAL "+b);
//String urlParameters ="cust_id="+a+"&cust_pass="+b;

//Send post request
con.setDoOutput(true);
DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//wr.writeBytes(urlParameters);
wr.flush();
wr.close();
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
inputLine=in.readLine();

try {  
JSONObject json=new JSONObject(inputLine);
bal=json.getString("balance_domain_api");
lab=json.getString("rate_domain_api");
alb=json.getString("ip_address");
System.out.println("ip "+alb);
//alb=json.getString("callprefix");
System.out.println("DEVTADIYAL BALANCE"+ bal);
System.out.println("DEVTADIYAL RATE"+ bal);
} catch (JSONException e) {
//TODO Auto-generated catch block
e.printStackTrace();
}
System.out.println(bal+"}}}}}}}}}}}}}}}}}}}}}}2221"+inputLine);  		

return bal+lab;

} catch (Exception e) {
Log.e("Balance", "XML Pasing Excpetion ");
e.printStackTrace();
return null;
}
}
}

/////////////////////////////////////sign up ///////////////////////////////////////////////////////////////////////

public static  class LongOperation1 extends AsyncTask<String, Void, String> {
String 	bal="";
String 	lab="";
public  String alb;
public static String encrypt(String input, String key){
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

private final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

private  String asHex(byte[] buf)
{
char[] chars = new char[2 * buf.length];
for (int i = 0; i < buf.length; ++i)
{
chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
}
return new String(chars);
}


@Override
protected String doInBackground(String... params) {


return  getBalance(params[0]);
}      
private static Context ctx;

public LongOperation1(Context ctx) {
       this.ctx=ctx;
}
@Override
protected void onPostExecute(String result) {

System.out.println("xcxcxccxcxcxccxcxcxcxcxcxcxcccxxcxxxxcxctaddy"+result);
//balance.setText(bal+" "+lab);
if(result !="")
{
	AlertDialog alertDialog = new AlertDialog.Builder(ctx).create();
	alertDialog.setTitle("Alert");
	alertDialog.setMessage(bal);
	alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",	
	    new DialogInterface.OnClickListener() {
		
		
		
		
		
	        public void onClick(DialogInterface dialog, int which) {
	        	// Mobiletopup.a01.setText("");
	        	
	        /*	if(message.contains("Your OTP is sent to your Mobile number."))
				{
					findViewById(R.id.acc_Mobile).setVisibility(View.GONE);
				//	findViewById(R.id.term).setVisibility(View.GONE);
				//	findViewById(R.id.checkBox1).setVisibility(View.GONE);
					findViewById(R.id.Login_page).setVisibility(View.GONE);
					//findViewById(R.id.acc_Mobclear).setVisibility(View.VISIBLE);
					findViewById(R.id.REGISTER_BUTTON_LAY).setVisibility(View.GONE);
					findViewById(R.id.Register_page).setVisibility(View.VISIBLE);
					findViewById(R.id.acc_login).setVisibility(View.VISIBLE);
					findViewById(R.id.acc_clear).setVisibility(View.VISIBLE);
					findViewById(R.id.acc_pass).setVisibility(View.VISIBLE);
					findViewById(R.id.acc_user).setVisibility(View.VISIBLE);
					findViewById(R.id.status).setVisibility(View.VISIBLE);
				}else{
					
				}*/
	        	
	        	
	            dialog.dismiss();
	          
	        }
	    });
	alertDialog.show();

}
else
{
   
}

new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
    	 ((Activity)ctx).finish();
    }
}, 3500);
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
System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ : "+user);

String url = "http://181.215.214.207/webtech5890/billing_registration/otp_reg_phone_twilio.php";
System.out.println("BALNCE API " +url);
URL obj = new URL(url);
HttpURLConnection con = (HttpURLConnection) obj.openConnection();

//add reuqest header
con.setRequestMethod("POST");
//con.setRequestProperty("User-Agent", USER_AGENT);
con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
String key = "hdjdtie36457jdir";
String data1 = mobilenumber.getText().toString();

//String data2=account.getPassword();
String output =LongOperation1.encrypt(data1, key);
//String output1 =LongOperation.encrypt(data2, key);
String a=(asHex(output.getBytes()));
//String b=(asHex(output1.getBytes()));
System.out.println("TADIYAL "+a);
//System.out.println("DEVTAIYAL "+b);
String urlParameters ="phone_user="+a;

//Send post request
con.setDoOutput(true);
DataOutputStream wr = new DataOutputStream(con.getOutputStream());
wr.writeBytes(urlParameters);
wr.flush();
wr.close();

System.out.println("\nSending 'POST' request to URL : " + url);
System.out.println("Post parameters : " + urlParameters);
//System.out.println("Response Code : " + responseCode);

BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;

inputLine=in.readLine();

try {  
JSONObject json=new JSONObject(inputLine);
bal=json.getString("OTP");
//lab=json.getString("currency");
//alb=json.getString("callprefix");
//System.out.println(alb +"  "+lab +" " + bal);
} catch (JSONException e) {
//TODO Auto-generated catch block
e.printStackTrace();
}
System.out.println(bal+"}}}}}}}}}}}}}}}}}}}}}}1222"+inputLine);  		

return bal;

} catch (Exception e) {
Log.e("Balance", "XML Pasing Excpetion ");
e.printStackTrace();
return null;
}
}	
}



////////////////////////////////////////////Account Register API   ///////////////////////////////////////////////
           public class LongOperation extends AsyncTask<String, Void, String> {


        	   JSONObject json;
    		   @Override
    		   protected String doInBackground(String... params) {
    		     
    			   return  getBalance(params[0]);
    		           }      
    		   @Override
    		   protected void onPostExecute(final String result) {
    		   	
    		   	     String action = null;
    				 String number=null;
    				
    		         	System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+result);
    		   	
    		   	       try {
    						json = new JSONObject(result);} 
    					catch (JSONException e2) {
    						// TODO Auto-generated catch block
    						e2.printStackTrace();}
    					   try {
    						message = json.getString("password");
    						} catch (JSONException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();}
    						System.out.println("message value inside the register web service@@@@@@@@@@@@@@@@@@ "+message+"decription "+message);
    					    dialog.dismiss();
    						final android.app.AlertDialog.Builder alert=new AlertDialog.Builder(AccountWizard.this);
    					    
    						   alert.setTitle("Avviso");
    						   alert.setMessage(message);
    					       alert.setPositiveButton("OK", new DialogInterface.OnClickListener() 
    					       {				   
    							@Override
    							public void onClick(DialogInterface dialog, int which) 
    							{
    							if(message.contains("Your OTP is sent to your Mobile number."))
    							{
    								/*findViewById(R.id.acc_Mobile).setVisibility(View.GONE);
    							//	findViewById(R.id.term).setVisibility(View.GONE);
    							//	findViewById(R.id.checkBox1).setVisibility(View.GONE);
    								findViewById(R.id.Login_page).setVisibility(View.GONE);
    								//findViewById(R.id.acc_Mobclear).setVisibility(View.VISIBLE);
    								findViewById(R.id.REGISTER_BUTTON_LAY).setVisibility(View.GONE);
    								findViewById(R.id.textView1).setVisibility(View.GONE);
    								findViewById(R.id.Register_page).setVisibility(View.VISIBLE);
    								findViewById(R.id.acc_login).setVisibility(View.VISIBLE);
    								findViewById(R.id.acc_clear).setVisibility(View.VISIBLE);
    								findViewById(R.id.acc_pass).setVisibility(View.VISIBLE);
    								findViewById(R.id.acc_user).setVisibility(View.VISIBLE);
    								findViewById(R.id.status).setVisibility(View.VISIBLE);*/
    							}else{
    								
    							}
    								
    							}
    						});
    					       
    					       alert.show();
    						}

    		   @Override
    		   protected void onPreExecute() {
    		   	
    		   	dialog=new ProgressDialog(AccountWizard.this);
    				dialog.setTitle("Attendere.");
    				dialog.setMessage("Creazione del PIN.");
    				dialog.setCancelable(false);

    				dialog.show();
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
    					  account = SipProfile.getProfileFromDbId(getApplicationContext(), accountId,DBProvider.ACCOUNT_FULL_PROJECTION);
    					  System.out.println("REGISTER_PHONE value in moveToRegister method  "+str);
    					
    					  //  https://billing.yepingo.it/web/server-itly.php?phone="+str
    			//		  URL oracle = new URL("https://billing.yepingo.it/web/server-itly.php?phone="+str);
    					  URL oracle = new URL("https://billing.yepingo.it/web/serverdum-itly.php?phone="+str+"&phonetype=Android");
    							 
    		             BufferedReader in = new BufferedReader(
    					 new InputStreamReader(oracle.openStream()));

    					 String inputLine;
    					 int i=1;
    				     inputLine=in.readLine();
    				System.out.println("zeroxxxxxxxxxxxxxxxxxxxxxxxx"+inputLine);			     		    		
    				    return inputLine;
    		           
    				} catch (Exception e) {
    					Log.e("Balance", "XML Pasing Excpetion ");
    					e.printStackTrace();
    					return null;
    				}

    			}
           }
	}
	