package com.numberone.ui.account;

import android.content.Context;
import android.content.SharedPreferences;

public class AdoreSharedPreferences 
{   Context context;
	public AdoreSharedPreferences(Context c)
	{
		context=c;
	}
private static String accessNum;
private static String pinNum;
private static String dtmfNum;
public static final String myData = "mySharedPreferences";
public static String accessnum,pinnumber,dtmfnumber;
public static String numm,pinval,dtmfval,f,g,h;

public static String getAccessNum() {
	return accessNum;
}
public static void setAccessNum(String accessNum) {
	AdoreSharedPreferences.accessNum = accessNum;
}
public static String getPinNum() {
	return pinNum;
}
public static void setPinNum(String pinNum) {
	AdoreSharedPreferences.pinNum = pinNum;
}
public static String getDtmfNum() {
	return dtmfNum;
}
public static void setDtmfNum(String dtmfNum) {
	AdoreSharedPreferences.dtmfNum = dtmfNum;
}

public void  saveAccesssValue(String accesss,String pinvall,String dtmfvall) 
{
	
	// int mode = Context.MODE_PRIVATE;
		SharedPreferences mySharedPreferences =context.getSharedPreferences(myData,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = mySharedPreferences.edit();
		
		 f = accesss;
		 g = pinvall;
		 h = dtmfvall;
	
		

		
		editor.putString("accc",f);
		editor.putString("pinn",g);
		editor.putString("dtmff",h);
		
		
		editor.commit();
		loadCountryValue() ;
}

public void loadCountryValue() 
{
		
		//int mode = Context.MODE_PRIVATE;
		SharedPreferences mySharedPreferences = context.getSharedPreferences(myData,
				Context.MODE_PRIVATE);
				
		
		accessnum = mySharedPreferences.getString("accc", "");
		pinnumber = mySharedPreferences.getString("pinn", "");
		dtmfnumber = mySharedPreferences.getString("dtmff", "");

        setAccessNum(accessnum);
        setPinNum(pinnumber);
        setDtmfNum(dtmfnumber);
		
		
		
		System.out.println("country  ++++++++++++++"+accessnum);
		
		
		
	}


}
