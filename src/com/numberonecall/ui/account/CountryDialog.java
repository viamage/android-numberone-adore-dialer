package com.numberonecall.ui.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.numberonecall.R;
import com.numberonecall.api.SipProfile;
import com.numberonecall.db.DBProvider;

import android.annotation.SuppressLint;
import android.app.Activity; 
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

@SuppressLint("NewApi")
public class CountryDialog extends Activity implements SearchView.OnQueryTextListener
{
	  
	ListView listview;
	SearchView searchView;
	List<Map<String, Object>> list;
	protected static SipProfile account;
	public static String countryCode,code;
	public static String countryName;
	public static int countryFlag;
	public static String countryId;
	public static ImageView flag;
	
	 Object f,c,n;
	
	public static final String myData = "mySharedPreferences";
	int mode=Context.MODE_PRIVATE;
	
	public static String savedCountryCode="Country";
	public static String savedCountryName="Select Country";
	public static int savedCountryFlag=R.drawable.unitedstates;
	public static String savedCountryId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.country_dialog);
		
		searchView=(SearchView)findViewById(R.id.search_view);
		listview=(ListView)findViewById(R.id.countryList);
		
		final List<Map<String,Object>> listData=getListData();
		 
		SimpleAdapter adapter =new SimpleAdapter(this, (List<? extends Map<String, ?>>) listData, R.layout.country_list_row, new String [] {"countryFlag","countryName","countryCode","countryId"}, new int[]{R.id.COUNTRY_FLAG,R.id.COUNTRY_NAME,R.id.COUNTRY_CODE});
		 
		listview.setAdapter(adapter);
		
         listview.setTextFilterEnabled(true);
		 
		 setupSearchView();
	
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id)
			{
				 //Toast.makeText(CountryDialog.this, "You selected : " +list.get(position), Toast.LENGTH_SHORT).show();
				
				  Map<String, Object> map=list.get(position);
					
					for(Map.Entry<String, Object> entry :map.entrySet())
					{
						System.out.println("value of :"+position);
						//System.out.println("key : "+entry.getKey()+" and value :"+entry.getValue());
						String key=entry.getKey();
						
						System.out.println("value of key : "+key);
						
					if(key.equals("countryCode"))
						{
							f=entry.getValue();
							countryCode=String.valueOf(f);
							System.out.println("inside countryCode : "+countryCode);
						}
					if(key.equals("countryFlag"))	
						{
							c=entry.getValue();
							countryFlag=(Integer)c;
						    System.out.println("inside countryFlag : "+countryFlag);
						}
					if(key.equals("countryName"))
						{
							n=entry.getValue();
							countryName=String.valueOf(n);
							System.out.println("inside countryName : "+countryName+"\n");
						}
					if(key.equals("countryId"))
					{
						n=entry.getValue();
						countryId=String.valueOf(n);
						System.out.println("inside countryName : "+countryId+"\n");
					}
					}		
					setSavedContryValues(countryName, countryCode,countryFlag,countryId);
					
					AccountWizard.tv1.setText(CountryDialog.countryCode);
					finish();
					
					
					/*try {
						if( AccountWizard.accountvalue != null  )
						{
							String tempname = AccountWizard.accountvalue;
							//tempname = tempname.replace("+", "");
							tempname = tempname.substring((AccountWizard.ss.length())-1);
							System.out.println("SS length"+AccountWizard.ss);
							
							//AccountWizard.user.setText(CountryDialog.countryCode+tempname);
							
							code = CountryDialog.countryCode+tempname;
							//AccountWizard.pass.setText(account.getPassword());
							System.out.println("!!!DEV TADIUAL ))))))))))))))hhh@"+CountryDialog.countryCode+tempname);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					
						e.printStackTrace();
						
					}*/
					
				}
			});	
		getSavedCountryValues();
		}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getSavedCountryValues();
	}
	
	public void setSavedContryValues(String name, String code,int flag,String Id)
	{
		
		SharedPreferences sharedPreference=this.getSharedPreferences(myData, mode);
		
		SharedPreferences.Editor editer= sharedPreference.edit();
		
		editer.putString("CNAME", name);
		editer.putString("CCODE", code);
		editer.putInt("CFLAG", flag);
		editer.putString("CId",Id);
		
		editer.commit();
		
		getSavedCountryValues();
		
	}
	
	public void getSavedCountryValues()
	{
		SharedPreferences sharedPreference=this.getSharedPreferences(myData, mode);
		
		savedCountryName=sharedPreference.getString("CNAME", "");
		savedCountryCode=sharedPreference.getString("CCODE", "");
		savedCountryFlag=sharedPreference.getInt("CFLAG", 0);
		savedCountryId=sharedPreference.getString("CId", "");
		
		System.out.println(" saveed value in load method in CountryDialog  countryCode : "+countryCode);
		System.out.println(" saved value in load method  in CountryDialog   countryName : "+countryName);
		System.out.println(" saved value in load method  in CountryDialog    countryFlag : "+countryFlag);
		System.out.println(" saved value in load method  in CountryDialog    countryId : "+countryId);
	}
		
	public List<Map<String, Object>> getListData() 
	{
		list=new ArrayList<Map<String, Object>>();
		
	/*	Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("countryFlag", R.drawable.unitedstates);
		map1.put("countryName", "USA");
		map1.put("countryCode", "+1");
		map1.put("countryId", "1");
		
		list.add(map1);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("countryFlag", R.drawable.unitedkingdom);
		map.put("countryName", "United Kingdom");
		map.put("countryCode", "+44");
		map.put("countryId", "224");
		
		list.add(map);*/
		
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("countryFlag", R.drawable.albania);
		map2.put("countryName", "Albania");
		map2.put("countryCode", "+355");
		map2.put("countryId", "2");
		
		list.add(map2);
		
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("countryFlag", R.drawable.algeria);
		map3.put("countryName", "Algeria");
		map3.put("countryCode", "+213");
		map3.put("countryId", "3");
		
		list.add(map3);
		
		Map<String, Object> map4=new HashMap<String, Object>();
		map4.put("countryFlag", R.drawable.americansamoa);
		map4.put("countryName", "American Samoa");
		map4.put("countryCode", "+684");
		map4.put("countryId", "4");
		
		list.add(map4);
		
		Map<String, Object> map5=new HashMap<String, Object>();
		map5.put("countryFlag", R.drawable.andorra);
		map5.put("countryName", "Andorra");
		map5.put("countryCode", "+376");
		map5.put("countryId", "5");
		
		list.add(map5);
		
		Map<String, Object> map6=new HashMap<String, Object>();
		map6.put("countryFlag", R.drawable.angola);
		map6.put("countryName", "Angola");
		map6.put("countryCode", "+244");
		map6.put("countryId", "6");
		
		list.add(map6);
		
		Map<String, Object> map7=new HashMap<String, Object>();
		map7.put("countryFlag", R.drawable.argentina);
		map7.put("countryName", "Argentina");
		map7.put("countryCode", "+54");
		map7.put("countryId", "10");
		
		list.add(map7);
		
		Map<String, Object> map8=new HashMap<String, Object>();
		map8.put("countryFlag", R.drawable.anguilla);
		map8.put("countryName", "Anguilla");
		map8.put("countryCode", "+1264");
		map8.put("countryId", "7");
		
		list.add(map8);
		
		Map<String, Object> map9=new HashMap<String, Object>();
		map9.put("countryFlag", R.drawable.australia);
		map9.put("countryName", "Australia");
		map9.put("countryCode", "+61");
		
		list.add(map9);
		
		Map<String, Object> map10=new HashMap<String, Object>();
		map10.put("countryFlag", R.drawable.afganistan);
		map10.put("countryName", "Afganistan");
		map10.put("countryCode", "+93");
		map10.put("countryId", "1");
			
		list.add(map10);
		
		
		Map<String, Object> map200=new HashMap<String, Object>();
		map200.put("countryFlag", R.drawable.anguilla);
		map200.put("countryName", "Anguilla");
		map200.put("countryCode", "+1264");
		map200.put("countryId", "1");
			
		list.add(map200);
		
		Map<String, Object> map201=new HashMap<String, Object>();
		map201.put("countryFlag", R.drawable.ag);
		map201.put("countryName", "Antigua and Barbuda");
		map201.put("countryCode", "+1268");
		map201.put("countryId", "1");
			
		list.add(map201);
		
		Map<String, Object> map202=new HashMap<String, Object>();
		map202.put("countryFlag", R.drawable.armenia);
		map202.put("countryName", "Armenia");
		map202.put("countryCode", "+374");
		map202.put("countryId", "1");
			
		list.add(map202);
		
		Map<String, Object> map203=new HashMap<String, Object>();
		map203.put("countryFlag", R.drawable.aruba);
		map203.put("countryName", "Aruba");
		map203.put("countryCode", "+297");
		map203.put("countryId", "1");
			
		list.add(map203);
		
		Map<String, Object> map204=new HashMap<String, Object>();
		map204.put("countryFlag", R.drawable.austria);
		map204.put("countryName", "Austria");
		map204.put("countryCode", "+43");
		map204.put("countryId", "1");
			
		list.add(map204);
		
		
		Map<String, Object> map205=new HashMap<String, Object>();
		map205.put("countryFlag", R.drawable.azerbaijan);
		map205.put("countryName", "Azerbaijan");
		map205.put("countryCode", "+994");
		map205.put("countryId", "1");
			
		list.add(map205);
		
		Map<String, Object> map206=new HashMap<String, Object>();
		map206.put("countryFlag", R.drawable.belarus);
		map206.put("countryName", "Belarus");
		map206.put("countryCode", "+375");
		map206.put("countryId", "1");
			
		list.add(map206);
		
		Map<String, Object> map207=new HashMap<String, Object>();
		map207.put("countryFlag", R.drawable.belgium);
		map207.put("countryName", "Belgium");
		map207.put("countryCode", "+32");
		map207.put("countryId", "1");
			
		list.add(map207);
		
		Map<String, Object> map208=new HashMap<String, Object>();
		map208.put("countryFlag", R.drawable.ba);
		map208.put("countryName", "Bosnia Herzegovina");
		map208.put("countryCode", "+387");
		map208.put("countryId", "1");
			
		list.add(map208);
		
		Map<String, Object> map209=new HashMap<String, Object>();
		map209.put("countryFlag", R.drawable.botswana);
		map209.put("countryName", "Botswana");
		map209.put("countryCode", "+267");
		map209.put("countryId", "1");
			
		list.add(map209);
		
		Map<String, Object> map210=new HashMap<String, Object>();
		map210.put("countryFlag", R.drawable.vi);
		map210.put("countryName", "British Virgin Isl");
		map210.put("countryCode", "+1284");
		map210.put("countryId", "1");
			
		list.add(map210);
		
		
		Map<String, Object> map211=new HashMap<String, Object>();
		map211.put("countryFlag", R.drawable.bulgaria);
		map211.put("countryName", "Bulgaria");
		map211.put("countryCode", "+359");
		map211.put("countryId", "1");
			
		list.add(map211);
		
		Map<String, Object> map212=new HashMap<String, Object>();
		map212.put("countryFlag", R.drawable.bf);
		map212.put("countryName", "Burkina Faso");
		map212.put("countryCode", "+226");
		map212.put("countryId", "1");
			
		list.add(map212);
		
		
		
		Map<String, Object> map11=new HashMap<String, Object>();
		map11.put("countryFlag", R.drawable.bahamas);
		map11.put("countryName", "Bahamas");
		map11.put("countryCode", "+1242");
		
		list.add(map11);
		
		Map<String, Object> map12=new HashMap<String, Object>();
		map12.put("countryFlag", R.drawable.bangladesh);
		map12.put("countryName", "Bangladesh");
		map12.put("countryCode", "+880");
		map12.put("countryId", "18");
		
		list.add(map12);
		
		Map<String, Object> map13=new HashMap<String, Object>();
		map13.put("countryFlag", R.drawable.barbados);
		map13.put("countryName", "Barbados");
		map13.put("countryCode", "+1246");
		map13.put("countryId", "19");
		
		list.add(map13);
		
		Map<String, Object> map14=new HashMap<String, Object>();
		map14.put("countryFlag", R.drawable.bahrain);
		map14.put("countryName", "Bahrain");
		map14.put("countryCode", "+973");
		map14.put("countryId", "17");
			
		list.add(map14);
		
		Map<String, Object> map15=new HashMap<String, Object>();
		map15.put("countryFlag", R.drawable.belgiumcivil);
		map15.put("countryName", "Belgium Civil");
		map15.put("countryCode", "+21");
		
		list.add(map15);
		
		Map<String, Object> map16=new HashMap<String, Object>();
		map16.put("countryFlag", R.drawable.bermuda);
		map16.put("countryName", "Bermuda");
		map16.put("countryCode", "+1441");
		
		list.add(map16);
		
		
		Map<String, Object> map17=new HashMap<String, Object>();
		map17.put("countryFlag", R.drawable.benin);
		map17.put("countryName", "Benin");
		map17.put("countryCode", "+229");
		map17.put("countryId", "23");
		
		list.add(map17);
		
		Map<String, Object> map18=new HashMap<String, Object>();
		map18.put("countryFlag", R.drawable.bhutan);
		map18.put("countryName", "Bhutan");
		map18.put("countryCode", "+975");
		
		list.add(map18);
		

		Map<String, Object> map19=new HashMap<String, Object>();
		map19.put("countryFlag", R.drawable.bolivia);
		map19.put("countryName", "Bolivia");
		map19.put("countryCode", "+591");
		map19.put("countryId", "26");
			
		list.add(map19);
		
		Map<String, Object> map20=new HashMap<String, Object>();
		map20.put("countryFlag", R.drawable.brazil);
		map20.put("countryName", "Brazil");
		map20.put("countryCode", "+501");
		map20.put("countryId", "30");
		
		list.add(map20);
		
		Map<String, Object> map21=new HashMap<String, Object>();
		map21.put("countryFlag", R.drawable.brunei);
		map21.put("countryName", "Brunei");
		map21.put("countryCode", "+673");
		map21.put("countryId", "6252");
			
		list.add(map21);
		
		Map<String, Object> map22=new HashMap<String, Object>();
		map22.put("countryFlag", R.drawable.burundi);
		map22.put("countryName", "Burundi");
		map22.put("countryCode", "+257");
		map22.put("countryId", "35");
			
		list.add(map22);
		
		Map<String, Object> map23=new HashMap<String, Object>();
		map23.put("countryFlag", R.drawable.cambodia);
		map23.put("countryName", "Cambodia");
		map23.put("countryCode", "+855");
		map23.put("countryId", "36");
			
		list.add(map23);
		
		Map<String, Object> map24=new HashMap<String, Object>();
		map24.put("countryFlag", R.drawable.cameroon);
		map24.put("countryName", "Cameroon");
		map24.put("countryCode", "+237");
		map24.put("countryId", "37");
			
		list.add(map24);
		
		Map<String, Object> map25=new HashMap<String, Object>();
		map25.put("countryFlag", R.drawable.centralafricanrepublic);
		map25.put("countryName", "Central African Republic");
		map25.put("countryCode", "+236");
		map25.put("countryId", "41");
			
		list.add(map25);
		
		Map<String, Object> map26=new HashMap<String, Object>();
		map26.put("countryFlag", R.drawable.canada);
		map26.put("countryName", "Canada");
		map26.put("countryCode", "+1");
		map26.put("countryId", "38");
		
		list.add(map26);
		
		Map<String, Object> map27=new HashMap<String, Object>();
		map27.put("countryFlag", R.drawable.china);
		map27.put("countryName", "China");
		map27.put("countryCode", "+86");
		map27.put("countryId", "44");
		
		list.add(map27);
		
		Map<String, Object> map28=new HashMap<String, Object>();
		map28.put("countryFlag", R.drawable.chile);
		map28.put("countryName", "Chile");
		map28.put("countryCode", "+56");
		map28.put("countryId", "43");
		
		list.add(map28);
		
		Map<String, Object> map29=new HashMap<String, Object>();
		map29.put("countryFlag", R.drawable.colombia);
		map29.put("countryName", "Colombia");
		map29.put("countryCode", "+57");
		map29.put("countryId", "47");
		
		list.add(map29);
		
		Map<String, Object> map30=new HashMap<String, Object>();
		map30.put("countryFlag", R.drawable.comoros);
		map30.put("countryName", "Comoros");
		map30.put("countryCode", "+269");
		
		list.add(map30);
		
		Map<String, Object> map31=new HashMap<String, Object>();
		map31.put("countryFlag", R.drawable.cuba);
		map31.put("countryName", "Cuba");
		map31.put("countryCode", "+53");
		map31.put("countryId", "55");
		
		Map<String, Object> map213=new HashMap<String, Object>();
		map213.put("countryFlag", R.drawable.cv);
		map213.put("countryName", "Cape Verde");
		map213.put("countryCode", "+53");
		map213.put("countryId", "238");
		
		
		list.add(map213);
		
		Map<String, Object> map214=new HashMap<String, Object>();
		map214.put("countryFlag", R.drawable.ky);
		map214.put("countryName", "Cayman Islands");
		map214.put("countryCode", "+1345");
		map214.put("countryId", "238");
		
		
		list.add(map214);
		
		Map<String, Object> map215=new HashMap<String, Object>();
		map215.put("countryFlag", R.drawable.chad);
		map215.put("countryName", "Chad");
		map215.put("countryCode", "+235");
		map215.put("countryId", "238");
		
		
		list.add(map215);
		
		Map<String, Object> map216=new HashMap<String, Object>();
		map216.put("countryFlag", R.drawable.cx);
		map216.put("countryName", "Christmas Islands");
		map216.put("countryCode", "+6189");
		map216.put("countryId", "238");
		
		
		list.add(map216);
		
		Map<String, Object> map217=new HashMap<String, Object>();
		map217.put("countryFlag", R.drawable.cd);
		map217.put("countryName", "Congo Dem. Rep.");
		map217.put("countryCode", "+243");
		map217.put("countryId", "238");
		
		
		list.add(map217);
		
		Map<String, Object> map218=new HashMap<String, Object>();
		map218.put("countryFlag", R.drawable.cg);
		map218.put("countryName", "Congo Rep.");
		map218.put("countryCode", "+242");
		map218.put("countryId", "238");
		
		
		list.add(map218);
		
		Map<String, Object> map219=new HashMap<String, Object>();
		map219.put("countryFlag", R.drawable.cr);
		map219.put("countryName", "Costa Rica");
		map219.put("countryCode", "+506");
		map219.put("countryId", "238");
		
		
		list.add(map219);
		
		
		Map<String, Object> map220=new HashMap<String, Object>();
		map220.put("countryFlag", R.drawable.croatia);
		map220.put("countryName", "Croatia");
		map220.put("countryCode", "+385");
		map220.put("countryId", "238");
		
		
		list.add(map220);
		
		
		
		Map<String, Object> map221=new HashMap<String, Object>();
		map221.put("countryFlag", R.drawable.cy);
		map221.put("countryName", "Cyprus");
		map221.put("countryCode", "+357");
		map221.put("countryId", "238");
		
		
		list.add(map221);
		
		Map<String, Object> map222=new HashMap<String, Object>();
		map222.put("countryFlag", R.drawable.djibouti);
		map222.put("countryName", "Djibouti");
		map222.put("countryCode", "+253");
		map222.put("countryId", "238");
		
		
		list.add(map222);
		
		
		Map<String, Object> map223=new HashMap<String, Object>();
		map223.put("countryFlag", R.drawable.doo);
		map223.put("countryName", "Dominican Republic");
		map223.put("countryCode", "+1809");
		map223.put("countryId", "238");
		
		list.add(map223);
		
		
		
		Map<String, Object> map32=new HashMap<String, Object>();
		map32.put("countryFlag", R.drawable.denmark);
		map32.put("countryName", "denmark");
		map32.put("countryCode", "+45");
		map32.put("countryId", "58");
		
		list.add(map32);
		
		Map<String, Object> map33=new HashMap<String, Object>();
		map33.put("countryFlag", R.drawable.dominica);
		map33.put("countryName", "Dominica");
		map33.put("countryCode", "+1767");
		map33.put("countryId", "60");
			
		list.add(map33);
		
		
		Map<String, Object> map34=new HashMap<String, Object>();
		map34.put("countryFlag", R.drawable.ecuador);
		map34.put("countryName", "Ecuador");
		map34.put("countryCode", "+593");
		map34.put("countryId", "62");
		
		list.add(map34);
		
		Map<String, Object> map35=new HashMap<String, Object>();
		map35.put("countryFlag", R.drawable.elsalvador);
		map35.put("countryName", "El Salvador");
		map35.put("countryCode", "+503");
		map35.put("countryId", "64");
			
		list.add(map35);
		
		Map<String, Object> map224=new HashMap<String, Object>();
		map224.put("countryFlag", R.drawable.eritrea);
		map224.put("countryName", "Eritrea");
		map224.put("countryCode", "+291");
		map224.put("countryId", "238");
		
		
		list.add(map224);
		
		Map<String, Object> map225=new HashMap<String, Object>();
		map225.put("countryFlag", R.drawable.estonia);
		map225.put("countryName", "Estonia");
		map225.put("countryCode", "+372");
		map225.put("countryId", "238");
		
		
		list.add(map225);
		
		
		
		Map<String, Object> map36=new HashMap<String, Object>();
		map36.put("countryFlag", R.drawable.egypt);
		map36.put("countryName", "Egypt");
		map36.put("countryCode", "+20");
		map36.put("countryId", "63");
		
		list.add(map36);
		
		Map<String, Object> map37=new HashMap<String, Object>();
		map37.put("countryFlag", R.drawable.ethiopia);
		map37.put("countryName", "Ethiopia");
		map37.put("countryCode", "+251");
		map37.put("countryId", "68");
		list.add(map37);
		
		
		Map<String, Object> map226=new HashMap<String, Object>();
		map226.put("countryFlag", R.drawable.fo);
		map226.put("countryName", "Faroe Islands");
		map226.put("countryCode", "+298");
		map226.put("countryId", "238");
		
	    list.add(map226);
		
		
		Map<String, Object> map227=new HashMap<String, Object>();
		map227.put("countryFlag", R.drawable.gy);
		map227.put("countryName", "French Guyana");
		map227.put("countryCode", "+594");
		map227.put("countryId", "238");
		
	    list.add(map227);
		
		
		Map<String, Object> map228=new HashMap<String, Object>();
		map228.put("countryFlag", R.drawable.pf);
		map228.put("countryName", "French Polynesia");
		map228.put("countryCode", "+689");
		map228.put("countryId", "238");
		
	    list.add(map228);
		
		
		Map<String, Object> map38=new HashMap<String, Object>();
		map38.put("countryFlag", R.drawable.finland);
		map38.put("countryName", "finland");
		map38.put("countryCode", "+358");
		map38.put("countryId", "72");
		
		list.add(map38);
		
		Map<String, Object> map39=new HashMap<String, Object>();
		map39.put("countryFlag", R.drawable.fiji);
		map39.put("countryName", "Fiji");
		map39.put("countryCode", "+679");
		map39.put("countryId", "71");
		
		list.add(map39);
		
		Map<String, Object> map40=new HashMap<String, Object>();
		map40.put("countryFlag", R.drawable.france);
		map40.put("countryName", "France");
		map40.put("countryCode", "+33");
		map40.put("countryId", "73");
		
		list.add(map40);
		
		Map<String, Object> map229=new HashMap<String, Object>();
		map229.put("countryFlag", R.drawable.guam);
		map229.put("countryName", "Guam");
		map229.put("countryCode", "+1671");
		map229.put("countryId", "238");
		
	    list.add(map229);
	
	
	    Map<String, Object> map230=new HashMap<String, Object>();
		map230.put("countryFlag", R.drawable.guatemala);
		map230.put("countryName", "Guatemala");
		map230.put("countryCode", "+502");
		map230.put("countryId", "238");
		
	    list.add(map230);
		
		Map<String, Object> map231=new HashMap<String, Object>();
		map231.put("countryFlag", R.drawable.gn);
		map231.put("countryName", "Guinea Rep.");
		map231.put("countryCode", "+224");
		map231.put("countryId", "238");
		
	    list.add(map231);
		
		
		Map<String, Object> map2311=new HashMap<String, Object>();
		map2311.put("countryFlag", R.drawable.gy);
		map2311.put("countryName", "Guyana");
		map2311.put("countryCode", "+592");
		map2311.put("countryId", "238");
		
	    list.add(map2311);
		
				
		Map<String, Object> map232=new HashMap<String, Object>();
		map232.put("countryFlag", R.drawable.ga);
		map232.put("countryName", "Gabon");
		map232.put("countryCode", "+241");
		map232.put("countryId", "238");
		
	    list.add(map232);
		
		/*Map<String, Object> map233=new HashMap<String, Object>();
		map233.put("countryFlag", R.drawable.georgia.);
		map233.put("countryName", "Georgia");
		map233.put("countryCode", "+995");
		map233.put("countryId", "238");
		
	    list.add(map233);*/
		
		
		Map<String, Object> map234=new HashMap<String, Object>();
		map234.put("countryFlag", R.drawable.gl);
		map234.put("countryName", "Greenland");
		map234.put("countryCode", "+299");
		map234.put("countryId", "238");
		
	    list.add(map234);
		
		/*Map<String, Object> map235=new HashMap<String, Object>();
		map235.put("countryFlag", R.drawable.guadeloupe.);
		map235.put("countryName", "Guadeloupe");
		map235.put("countryCode", "+590");
		map235.put("countryId", "238");
		
	    list.add(map235);*/
		
		
		
		Map<String, Object> map41=new HashMap<String, Object>();
		map41.put("countryFlag", R.drawable.guinea);
		map41.put("countryName", "Guinea Bissau");
		map41.put("countryCode", "+245");
		map41.put("countryId", "90");
			
		list.add(map41);
		
		Map<String, Object> map42=new HashMap<String, Object>();
		map42.put("countryFlag", R.drawable.germany);
		map42.put("countryName", "Germany");
		map42.put("countryCode", "+49");
		map42.put("countryId", "80");
		list.add(map42);
		
		Map<String, Object> map43=new HashMap<String, Object>();
		map43.put("countryFlag", R.drawable.ghana);
		map43.put("countryName", "Ghana");
		map43.put("countryCode", "+233");
		map43.put("countryId", "81");
		
		list.add(map43);
		
		Map<String, Object> map44=new HashMap<String, Object>();
		map44.put("countryFlag", R.drawable.greece);
		map44.put("countryName", "Greece");
		map44.put("countryCode", "+30");
		map44.put("countryId", "83");
		
		list.add(map44);
		
		Map<String, Object> map45=new HashMap<String, Object>();
		map45.put("countryFlag", R.drawable.grenada);
		map45.put("countryName", "Grenada");
		map45.put("countryCode", "+1473");
		map45.put("countryId", "85");
		
		list.add(map45);
		
		Map<String, Object> map46=new HashMap<String, Object>();
		map46.put("countryFlag", R.drawable.haiti);
		map46.put("countryName", "Haiti");
		map46.put("countryCode", "+509");
		map46.put("countryId", "92");
			
		list.add(map46);
		
		Map<String, Object> map47=new HashMap<String, Object>();
		map47.put("countryFlag", R.drawable.hongkong);
		map47.put("countryName", "Hongkong");
		map47.put("countryCode", "+852");
		map47.put("countryId", "96");
	
		list.add(map47);
		
		
		Map<String, Object> map48=new HashMap<String, Object>();
		map48.put("countryFlag", R.drawable.hungary);
		map48.put("countryName", "Hungary");
		map48.put("countryCode", "+97");
		map48.put("countryId", "97");
		
		list.add(map48);
		
		
		Map<String, Object> map236=new HashMap<String, Object>();
		map236.put("countryFlag", R.drawable.hn);
		map236.put("countryName", "Honduras");
		map236.put("countryCode", "+504");
		map236.put("countryId", "238");
		
	    list.add(map236);
		
		Map<String, Object> map237=new HashMap<String, Object>();
		map237.put("countryFlag", R.drawable.is);
		map237.put("countryName", "Iceland");
		map237.put("countryCode", "+354");
		map237.put("countryId", "238");
		
	    list.add(map237);
		
		
		Map<String, Object> map238=new HashMap<String, Object>();
		map238.put("countryFlag", R.drawable.ie);
		map238.put("countryName", "Ivory Coast");
		map238.put("countryCode", "+255");
		map238.put("countryId", "238");
		
	    list.add(map238);
		
		
	
		Map<String, Object> map49=new HashMap<String, Object>();
		map49.put("countryFlag", R.drawable.india);
		map49.put("countryName", "India");
		map49.put("countryCode", "+91");
		map49.put("countryId", "99");
		
		list.add(map49);
		
		
		Map<String, Object> map50=new HashMap<String, Object>();
		map50.put("countryFlag", R.drawable.indonesia);
		map50.put("countryName", "Indonesia");
		map50.put("countryCode", "+62");
		map50.put("countryId", "100");
		
		list.add(map50);
		
		Map<String, Object> map51=new HashMap<String, Object>();
		map51.put("countryFlag", R.drawable.iran);
		map51.put("countryName", "Iran");
		map51.put("countryCode", "+98");
		map51.put("countryId", "101");
		
		list.add(map51);
		
		Map<String, Object> map52=new HashMap<String, Object>();
		map52.put("countryFlag", R.drawable.iraq);
		map52.put("countryName", "Iraq");
		map52.put("countryCode", "+964");
		map52.put("countryId", "102");
		
		list.add(map52); 
		
		Map<String, Object> map53=new HashMap<String, Object>();
		map53.put("countryFlag", R.drawable.ireland);
		map53.put("countryName", "Ireland");
		map53.put("countryCode", "+353");
		map53.put("countryId", "103");
		
		list.add(map53);
		
		Map<String, Object> map54=new HashMap<String, Object>();
		map54.put("countryFlag", R.drawable.israel);
		map54.put("countryName", "Israel");
		map54.put("countryCode", "+972");
		map54.put("countryId", "104");
		
		list.add(map54);
		
		Map<String, Object> map55=new HashMap<String, Object>();
		map55.put("countryFlag", R.drawable.italy);
		map55.put("countryName", "Italy");
		map55.put("countryCode", "+39");
		map55.put("countryId", "105");
		
		list.add(map55);
		
		Map<String, Object> map56=new HashMap<String, Object>();
		map56.put("countryFlag", R.drawable.jamaica);
		map56.put("countryName", "Jamaica");
		map56.put("countryCode", "+1876");
		map56.put("countryId", "106");
			
		list.add(map56);
		
		Map<String, Object> map57=new HashMap<String, Object>();
		map57.put("countryFlag", R.drawable.jordan);
		map57.put("countryName", "Jordan");
		map57.put("countryCode", "+962");
		map57.put("countryId", "108");
			
		list.add(map57);
		
			
		Map<String, Object> map239=new HashMap<String, Object>();
		map239.put("countryFlag", R.drawable.japan);
		map239.put("countryName", "Japan");
		map239.put("countryCode", "+81");
		map239.put("countryId", "238");
		
	    list.add(map239);
		
			
		Map<String, Object> map240=new HashMap<String, Object>();
		map240.put("countryFlag", R.drawable.kr);
		map240.put("countryName", "KoreaSouth");
		map240.put("countryCode", "+82");
		map240.put("countryId", "238");
		
	    list.add(map240);
		
		Map<String, Object> map241=new HashMap<String, Object>();
		map241.put("countryFlag", R.drawable.kyrgyzstan);
		map241.put("countryName", "Kyrgyzstan");
		map241.put("countryCode", "+996");
		map241.put("countryId", "238");
		
	    list.add(map241);
		
		
		
		Map<String, Object> map58=new HashMap<String, Object>();
		map58.put("countryFlag", R.drawable.kazakhstan);
		map58.put("countryName", "Kazakhstan");
		map58.put("countryCode", "+7");
		map58.put("countryId", "109");
			
		list.add(map58);
		
		Map<String, Object> map59=new HashMap<String, Object>();
		map59.put("countryFlag", R.drawable.kenya);
		map59.put("countryName", "Kenya");
		map59.put("countryCode", "+254");
		map59.put("countryId", "110");
		
		list.add(map59);
		
		Map<String, Object> map60=new HashMap<String, Object>();
		map60.put("countryFlag", R.drawable.kuwait);
		map60.put("countryName", "Kuwait");
		map60.put("countryCode", "+965");
		map60.put("countryId", "114");
		
		list.add(map60);
		
		Map<String, Object> map242=new HashMap<String, Object>();
		map242.put("countryFlag", R.drawable.latvia);
		map242.put("countryName", "Latvia");
		map242.put("countryCode", "+371");
		map242.put("countryId", "238");
		
	    list.add(map242);
		
		Map<String, Object> map243=new HashMap<String, Object>();
		map243.put("countryFlag", R.drawable.lesotho);
		map243.put("countryName", "Lesotho");
		map243.put("countryCode", "+266");
		map243.put("countryId", "238");
		
	    list.add(map243);
		
		Map<String, Object> map244=new HashMap<String, Object>();
		map244.put("countryFlag", R.drawable.liberia);
		map244.put("countryName", "Liberia");
		map244.put("countryCode", "+231");
		map244.put("countryId", "238");
		
	    list.add(map244);
		
		Map<String, Object> map245=new HashMap<String, Object>();
		map245.put("countryFlag", R.drawable.li);
		map245.put("countryName", "Liechtenstein");
		map245.put("countryCode", "+423");
		map245.put("countryId", "238");
		
	    list.add(map245);
		
		Map<String, Object> map246=new HashMap<String, Object>();
		map246.put("countryFlag", R.drawable.luxembourg);
		map246.put("countryName", "Luxembourgn");
		map246.put("countryCode", "+352");
		map246.put("countryId", "238");
		
	    list.add(map246);
		
		
	
		Map<String, Object> map61=new HashMap<String, Object>();
		map61.put("countryFlag", R.drawable.laos);
		map61.put("countryName", "Laos");
		map61.put("countryCode", "+856");
		map61.put("countryId", "116");
			
		list.add(map61);
		
		Map<String, Object> map62=new HashMap<String, Object>();
		map62.put("countryFlag", R.drawable.lebanon);
		map62.put("countryName", "Lebanon");
		map62.put("countryCode", "+961");
		map62.put("countryId", "118");
			
		list.add(map62);
		
		Map<String, Object> map63=new HashMap<String, Object>();
		map63.put("countryFlag", R.drawable.libya);
		map63.put("countryName", "Libya");
		map63.put("countryCode", "+218");
		map63.put("countryId", "120");
			
		list.add(map63);
		
		Map<String, Object> map64=new HashMap<String, Object>();
		map64.put("countryFlag", R.drawable.malaysia);
		map64.put("countryName", "Malaysia");
		map64.put("countryCode", "+60");
		map64.put("countryId", "129");
		
		list.add(map64);
		
		Map<String, Object> map65=new HashMap<String, Object>();
		map65.put("countryFlag", R.drawable.maldives);
		map65.put("countryName", "Maldives");
		map65.put("countryCode", "+960");
		map65.put("countryId", "130");
			
		list.add(map65);
		

		Map<String, Object> map66=new HashMap<String, Object>();
		map66.put("countryFlag", R.drawable.madagascar);
		map66.put("countryName", "Madagascar");
		map66.put("countryCode", "+261");
		map66.put("countryId", "127");
			
		list.add(map66);
		
		Map<String, Object> map67=new HashMap<String, Object>();
		map67.put("countryFlag", R.drawable.mali);
		map67.put("countryName", "Mali");
		map67.put("countryCode", "+223");
		map67.put("countryId", "131");
			
		list.add(map67);
		
		Map<String, Object> map68=new HashMap<String, Object>();
		map68.put("countryFlag", R.drawable.mauritius);
		map68.put("countryName", "Mauritius");
		map68.put("countryCode", "+230");
		map68.put("countryId", "136");
			
		list.add(map68);
		
		Map<String, Object> map69=new HashMap<String, Object>();
		map69.put("countryFlag", R.drawable.mexico);
		map69.put("countryName", "Mexico");
		map69.put("countryCode", "+52");
		map69.put("countryId", "138");
		
		list.add(map69);
		
		Map<String, Object> map70=new HashMap<String, Object>();
		map70.put("countryFlag", R.drawable.morocco);
		map70.put("countryName", "Morocco");
		map70.put("countryCode", "+212");
		map70.put("countryId", "144");
		
		list.add(map70);
		
		
		Map<String, Object> map247=new HashMap<String, Object>();
		map247.put("countryFlag", R.drawable.mo);
		map247.put("countryName", "Macau");
		map247.put("countryCode", "+853");
		map247.put("countryId", "238");
		
	    list.add(map247);
		
		Map<String, Object> map248=new HashMap<String, Object>();
		map248.put("countryFlag", R.drawable.macedonia);
		map248.put("countryName", "Macedonia");
		map248.put("countryCode", "+389");
		map248.put("countryId", "238");
		
	    list.add(map248);
		
		
		Map<String, Object> map249=new HashMap<String, Object>();
		map249.put("countryFlag", R.drawable.malawi);
		map249.put("countryName", "Malawi");
		map249.put("countryCode", "+265");
		map249.put("countryId", "238");
		
	    list.add(map249);
		
		
		
	    Map<String, Object> map250=new HashMap<String, Object>();
		map250.put("countryFlag", R.drawable.malta);
		map250.put("countryName", "Malta");
		map250.put("countryCode", "+356");
		map250.put("countryId", "238");
		
	    list.add(map250);
		
		
		/* Map<String, Object> map251=new HashMap<String, Object>();
		map251.put("countryFlag", R.drawable.marshall Islands);
		map251.put("countryName", "Marshall Islands");
		map251.put("countryCode", "+692");
		map251.put("countryId", "238");
		
	    list.add(map251);*/
		
		
		/* Map<String, Object> map252=new HashMap<String, Object>();
		map252.put("countryFlag", R.drawable.martinique);
		map252.put("countryName", "Martinique");
		map252.put("countryCode", "+596");
		map252.put("countryId", "238");
		
	    list.add(map252);*/
		
		
		 Map<String, Object> map253=new HashMap<String, Object>();
		map253.put("countryFlag", R.drawable.mauritania);
		map253.put("countryName", "Mauritania");
		map253.put("countryCode", "+222");
		map253.put("countryId", "238");
		
	    list.add(map253);
		
		/* Map<String, Object> map254=new HashMap<String, Object>();
		map254.put("countryFlag", R.drawable.mayotte);
		map254.put("countryName", "Mayotte");
		map254.put("countryCode", "+262");
		map254.put("countryId", "238");
		
	    list.add(map254);*/
		
		
		 Map<String, Object> map255=new HashMap<String, Object>();
		map255.put("countryFlag", R.drawable.micronesia);
		map255.put("countryName", "Micronesia");
		map255.put("countryCode", "+691");
		map255.put("countryId", "238");
		
	    list.add(map255);
		
		 Map<String, Object> map256=new HashMap<String, Object>();
		map256.put("countryFlag", R.drawable.moldova);
		map256.put("countryName", "Moldova");
		map256.put("countryCode", "+373");
		map256.put("countryId", "238");
		
	    list.add(map256);
		
		Map<String, Object> map257=new HashMap<String, Object>();
		map257.put("countryFlag", R.drawable.monaco);
		map257.put("countryName", "Monaco");
		map257.put("countryCode", "+377");
		map257.put("countryId", "238");
		
	    list.add(map257);
		
		
		Map<String, Object> map258=new HashMap<String, Object>();
		map258.put("countryFlag", R.drawable.mongolia);
		map258.put("countryName", "Mongolia");
		map258.put("countryCode", "+976");
		map258.put("countryId", "238");
		
	    list.add(map258);
		
		Map<String, Object> map259=new HashMap<String, Object>();
		map259.put("countryFlag", R.drawable.montenegro);
		map259.put("countryName", "Montenegro");
		map259.put("countryCode", "+382");
		map259.put("countryId", "238");
		
	    list.add(map259);
		
		
		Map<String, Object> map260=new HashMap<String, Object>();
		map260.put("countryFlag", R.drawable.ms);
		map260.put("countryName", "Montserrat");
		map260.put("countryCode", "+1664");
		map260.put("countryId", "238");
		
	    list.add(map260);
		
		
		Map<String, Object> map261=new HashMap<String, Object>();
		map261.put("countryFlag", R.drawable.mz);
		map261.put("countryName", "Mozambique");
		map261.put("countryCode", "+258");
		map261.put("countryId", "238");
		
	    list.add(map261);
		
		
		
		Map<String, Object> map262=new HashMap<String, Object>();
		map262.put("countryFlag", R.drawable.myanmar);
		map262.put("countryName", "Myanmar");
		map262.put("countryCode", "+95");
		map262.put("countryId", "238");
		
	    list.add(map262);
		
		
		
		
		Map<String, Object> map263=new HashMap<String, Object>();
		map263.put("countryFlag", R.drawable.netherlands);
		map263.put("countryName", "Netherlands Fixed");
		map263.put("countryCode", "+31");
		map263.put("countryId", "238");
		
	    list.add(map263);
		
		
		/*Map<String, Object> map264=new HashMap<String, Object>();
		map264.put("countryFlag", R.drawable.newCaledonia);
		map264.put("countryName", "NewCaledonia");
		map264.put("countryCode", "+687");
		map264.put("countryId", "238");
		
	    list.add(map264);*/
		
		Map<String, Object> map71=new HashMap<String, Object>();
		map71.put("countryFlag", R.drawable.namibia);
		map71.put("countryName", "namibia");
		map71.put("countryCode", "+264");
		map71.put("countryId", "147");
		list.add(map71);
		
		Map<String, Object> map72=new HashMap<String, Object>();
		map72.put("countryFlag", R.drawable.nepal);
		map72.put("countryName", "nepal");
		map72.put("countryCode", "+977");
		map72.put("countryId", "149");
		
		list.add(map72);
		
		Map<String, Object> map73=new HashMap<String, Object>();
		map73.put("countryFlag", R.drawable.netherlands);
		map73.put("countryName", "Netherlands Antilles");
		map73.put("countryCode", "599");
		map73.put("countryId", "150");
		
		list.add(map73);
		
		Map<String, Object> map74=new HashMap<String, Object>();
		map74.put("countryFlag", R.drawable.newzealand);
		map74.put("countryName", "New Zealand");
		map74.put("countryCode", "+64");
		map74.put("countryId", "153");
		list.add(map74);
		
		Map<String, Object> map75=new HashMap<String, Object>();
		map75.put("countryFlag", R.drawable.niger);
		map75.put("countryName", "Niger");
		map75.put("countryCode", "+227");
		map75.put("countryId", "155");
			
		list.add(map75);
		
		Map<String, Object> map76=new HashMap<String, Object>();
		map76.put("countryFlag", R.drawable.nicaragua);
		map76.put("countryName", "Nicaragua");
		map76.put("countryCode", "+505");
		map76.put("countryId", "154");
			
		list.add(map76);
		
		Map<String, Object> map77=new HashMap<String, Object>();
		map77.put("countryFlag", R.drawable.nigeria);
		map77.put("countryName", "Nigeria");
		map77.put("countryCode", "+234");
		map77.put("countryId", "156");
		
		list.add(map77);
		
		Map<String, Object> map78=new HashMap<String, Object>();
		map78.put("countryFlag", R.drawable.norway);
		map78.put("countryName", "Norway");
		map78.put("countryCode", "47");
		
		list.add(map78);
		
		Map<String, Object> map79=new HashMap<String, Object>();
		map79.put("countryFlag", R.drawable.oman);
		map79.put("countryName", "Oman");
		map79.put("countryCode", "+968");
		map79.put("countryId", "161");
		
		list.add(map79);
		
		Map<String, Object> map265=new HashMap<String, Object>();
		map265.put("countryFlag", R.drawable.pg);
		map265.put("countryName", "Papua New Guinea");
		map265.put("countryCode", "+675");
		map265.put("countryId", "238");
		
	    list.add(map265);
		
		
	/*	Map<String, Object> map266=new HashMap<String, Object>();
		map266.put("countryFlag", R.drawable.Peru);
		map266.put("countryName", "Peru");
		map266.put("countryCode", "+51");
		map266.put("countryId", "238");
		
	    list.add(map266);*/
		
		
		Map<String, Object> map80=new HashMap<String, Object>();
		map80.put("countryFlag", R.drawable.pakistan);
		map80.put("countryName", "Pakistan");
		map80.put("countryCode", "+92");
		map80.put("countryId", "162");
		
		list.add(map80);
		
		Map<String, Object> map81=new HashMap<String, Object>();
		map81.put("countryFlag", R.drawable.paraguay);
		map81.put("countryName", "Paraguay");
		map81.put("countryCode", "+595");
		map81.put("countryId", "167");
		
		list.add(map81);
		
		Map<String, Object> map82=new HashMap<String, Object>();
		map82.put("countryFlag", R.drawable.panama);
		map82.put("countryName", "Panama");
		map82.put("countryCode", "+507");
		map82.put("countryId", "165");
		
		list.add(map82);
		
		
		Map<String, Object> map83=new HashMap<String, Object>();
		map83.put("countryFlag", R.drawable.philippines);
		map83.put("countryName", "Philippines");
		map83.put("countryCode", "+63");
		map83.put("countryId", "169");
		
		list.add(map83);
		
		Map<String, Object> map84=new HashMap<String, Object>();
		map84.put("countryFlag", R.drawable.poland);
		map84.put("countryName", "Poland");
		map84.put("countryCode", "+48");
		map84.put("countryId", "171");
		
		list.add(map84);
		
		
		Map<String, Object> map85=new HashMap<String, Object>();
		map85.put("countryFlag", R.drawable.portugal);
		map85.put("countryName", "portugal");
		map85.put("countryCode", "351");
		
		list.add(map85);
		
		Map<String, Object> map86=new HashMap<String, Object>();
		map86.put("countryFlag", R.drawable.puertorico);
		map86.put("countryName", "Puerto Rico");
		map86.put("countryCode", "+1");
		map86.put("countryId", "173");
			
		list.add(map86);
		
		Map<String, Object> map87=new HashMap<String, Object>();
		map87.put("countryFlag", R.drawable.qatar);
		map87.put("countryName", "Qatar");
		map87.put("countryCode", "+974");
		map87.put("countryId", "174");
		
		list.add(map87);
		
	/*	Map<String, Object> map267=new HashMap<String, Object>();
		map267.put("countryFlag", R.drawable.reunion Island);
		map267.put("countryName", "Reunion Island");
		map267.put("countryCode", "+262");
		map267.put("countryId", "238");
		
	    list.add(map267);*/
		
		
		
		
		Map<String, Object> map88=new HashMap<String, Object>();
		map88.put("countryFlag", R.drawable.rwanda);
		map88.put("countryName", "Rwanda");
		map88.put("countryCode", "+250");
		map88.put("countryId", "178");
		
		list.add(map88);
		
		Map<String, Object> map89=new HashMap<String, Object>();
		map89.put("countryFlag", R.drawable.romania);
		map89.put("countryName", "Romania");
		map89.put("countryCode", "+40");
		map89.put("countryId", "176");
		
		list.add(map89);
		
		Map<String, Object> map90=new HashMap<String, Object>();
		map90.put("countryFlag", R.drawable.russia);
		map90.put("countryName", "Russia");
		map90.put("countryCode", "+7");
		map90.put("countryId", "177");
		
		list.add(map90);
		
		Map<String, Object> map268=new HashMap<String, Object>();
		map268.put("countryFlag", R.drawable.reunion);
		map268.put("countryName", "Reunion Island");
		map268.put("countryCode", "+262");
		map268.put("countryId", "238");
		
	    list.add(map268);
		
		Map<String, Object> map269=new HashMap<String, Object>();
		map269.put("countryFlag", R.drawable.as);
		map269.put("countryName", "Samoa US");
		map269.put("countryCode", "+1684");
		map269.put("countryId", "238");
		
	    list.add(map269);
		
		Map<String, Object> map270=new HashMap<String, Object>();
		map270.put("countryFlag", R.drawable.sm);
		map270.put("countryName", "San Marino");
		map270.put("countryCode", "+378");
		map270.put("countryId", "238");
		
	    list.add(map270);
		
		Map<String, Object> map271=new HashMap<String, Object>();
		map271.put("countryFlag", R.drawable.serbia );
		map271.put("countryName", "Serbia ");
		map271.put("countryCode", "+381");
		map271.put("countryId", "238");
		
	    list.add(map271);
		
		Map<String, Object> map272=new HashMap<String, Object>();
		map272.put("countryFlag", R.drawable.seychelles);
		map272.put("countryName", "Seychelles");
		map272.put("countryCode", "+248");
		map272.put("countryId", "238");
		
	    list.add(map272);
		
		Map<String, Object> map273=new HashMap<String, Object>();
		map273.put("countryFlag", R.drawable.sl);
		map273.put("countryName", "Sierra Leone");
		map273.put("countryCode", "+232");
		map273.put("countryId", "238");
		
	    list.add(map273);
		
		Map<String, Object> map274=new HashMap<String, Object>();
		map274.put("countryFlag", R.drawable.slovakia);
		map274.put("countryName", "Slovakia");
		map274.put("countryCode", "+421");
		map274.put("countryId", "238");
		
	    list.add(map274);
		
		Map<String, Object> map275=new HashMap<String, Object>();
		map275.put("countryFlag", R.drawable.slovenia);
		map275.put("countryName", "Slovenia");
		map275.put("countryCode", "+386");
		map275.put("countryId", "238");
		
	    list.add(map275);
		
		
		
		Map<String, Object> map276=new HashMap<String, Object>();
		map276.put("countryFlag", R.drawable.ss);
		map276.put("countryName", "South Sudan");
		map276.put("countryCode", "+211");
		map276.put("countryId", "238");
		
	    list.add(map276);
		
		
		Map<String, Object> map277=new HashMap<String, Object>();
		map277.put("countryFlag", R.drawable.kn);
		map277.put("countryName", "St Kitts & Nevis");
		map277.put("countryCode", "+1869");
		map277.put("countryId", "238");
		
	    list.add(map277);
		
		
		Map<String, Object> map278=new HashMap<String, Object>();
		map278.put("countryFlag", R.drawable.lc);
		map278.put("countryName", "St Lucia");
		map278.put("countryCode", "+1758");
		map278.put("countryId", "238");
		
	    list.add(map278);
		
		
		Map<String, Object> map279=new HashMap<String, Object>();
		map279.put("countryFlag", R.drawable.ph);
		map279.put("countryName", "St Maarten");
		map279.put("countryCode", "+1721");
		map279.put("countryId", "238");
		
	    list.add(map279);
		
		
		Map<String, Object> map280=new HashMap<String, Object>();
		map280.put("countryFlag", R.drawable.www);
		map280.put("countryName", "St Pierre & Miquelon");
		map280.put("countryCode", "+508");
		map280.put("countryId", "238");
		
	    list.add(map280);
		
		
		Map<String, Object> map281=new HashMap<String, Object>();
		map281.put("countryFlag", R.drawable.vc);
		map281.put("countryName", "St Vincent & Grenadines");
		map281.put("countryCode", "+1784");
		map281.put("countryId", "238");
		
	    list.add(map281);
		
		
		Map<String, Object> map282=new HashMap<String, Object>();
		map282.put("countryFlag", R.drawable.suriname);
		map282.put("countryName", "Suriname");
		map282.put("countryCode", "+597");
		map282.put("countryId", "238");
		
	    list.add(map282);
		
		
		Map<String, Object> map283=new HashMap<String, Object>();
		map283.put("countryFlag", R.drawable.swaziland);
		map283.put("countryName", "Swaziland");
		map283.put("countryCode", "+268");
		map283.put("countryId", "238");
		
	    list.add(map283);
		
	
		
		Map<String, Object> map91=new HashMap<String, Object>();
		map91.put("countryFlag", R.drawable.saudiarabia);
		map91.put("countryName", "Saudi Arabia");
		map91.put("countryCode", "966");
		
		list.add(map91);
		

		Map<String, Object> map92=new HashMap<String, Object>();
		map92.put("countryFlag", R.drawable.senegal);
		map92.put("countryName", "Senegal");
		map92.put("countryCode", "+221");
		map92.put("countryId", "188");
		
		list.add(map92);
		
		Map<String, Object> map93=new HashMap<String, Object>();
		map93.put("countryFlag", R.drawable.singapore);
		map93.put("countryName", "Singapore");
		map93.put("countryCode", "+65");
		map93.put("countryId", "191");
		
		list.add(map93);
		
		Map<String, Object> map94=new HashMap<String, Object>();
		map94.put("countryFlag", R.drawable.southafrica);
		map94.put("countryName", "South Africa");
		map94.put("countryCode", "+27");
		map94.put("countryId", "196");
		
		list.add(map94);
		
		Map<String, Object> map95=new HashMap<String, Object>();
		map95.put("countryFlag", R.drawable.somalia);
		map95.put("countryName", "Somalia");
		map95.put("countryCode", "+252");
		map95.put("countryId", "195");
			
		list.add(map95);
		
		Map<String, Object> map96=new HashMap<String, Object>();
		map96.put("countryFlag", R.drawable.spain);
		map96.put("countryName", "Spain");
		map96.put("countryCode", "+34");
		map96.put("countryId", "198");
		
		list.add(map96);
		
		
		Map<String, Object> map97=new HashMap<String, Object>();
		map97.put("countryFlag", R.drawable.srilanka);
		map97.put("countryName", "Sri Lanka");
		map97.put("countryCode", "+94");
		map97.put("countryId", "199");
		
		list.add(map97);
		
		Map<String, Object> map98=new HashMap<String, Object>();
		map98.put("countryFlag", R.drawable.sudan);
		map98.put("countryName", "Sudan");
		map98.put("countryCode", "+249");
		map98.put("countryId", "200");
			
		list.add(map98);
		
		Map<String, Object> map99=new HashMap<String, Object>();
		map99.put("countryFlag", R.drawable.sweden);
		map99.put("countryName", "Sweden");
		map99.put("countryCode", "+46");
		map99.put("countryId", "204");
		
		list.add(map99);
		
		
		Map<String, Object> map100=new HashMap<String, Object>();
		map100.put("countryFlag", R.drawable.switzerland);
		map100.put("countryName", "Switzerland");
		map100.put("countryCode", "+41");
		map100.put("countryId", "205");
		
		list.add(map100);
		
		Map<String, Object> map101=new HashMap<String, Object>();
		map101.put("countryFlag", R.drawable.syria);
		map101.put("countryName", "Syria");
		map101.put("countryCode", "+963");
		map101.put("countryId", "206");
		
		list.add(map101);
		
			
		Map<String, Object> map284=new HashMap<String, Object>();
		map284.put("countryFlag", R.drawable.taiwan);
		map284.put("countryName", "Taiwan");
		map284.put("countryCode", "+886");
		map284.put("countryId", "238");
		
	    list.add(map284);
			
		Map<String, Object> map285=new HashMap<String, Object>();
		map285.put("countryFlag", R.drawable.tajikistan);
		map285.put("countryName", "Tajikistan");
		map285.put("countryCode", "+268");
		map285.put("countryId", "238");
		
	    list.add(map285);
			
		Map<String, Object> map286=new HashMap<String, Object>();
		map286.put("countryFlag", R.drawable.togo);
		map286.put("countryName", "Togo");
		map286.put("countryCode", "+228");
		map286.put("countryId", "238");
		
	    list.add(map286);
			
		Map<String, Object> map287=new HashMap<String, Object>();
		map287.put("countryFlag", R.drawable.tonga);
		map287.put("countryName", "Tonga");
		map287.put("countryCode", "+676");
		map287.put("countryId", "238");
		
	    list.add(map287);
			
		Map<String, Object> map288=new HashMap<String, Object>();
		map288.put("countryFlag", R.drawable.tunisia);
		map288.put("countryName", "Tunisia");
		map288.put("countryCode", "+216");
		map288.put("countryId", "238");
		
	    list.add(map288);
			
		Map<String, Object> map289=new HashMap<String, Object>();
		map289.put("countryFlag", R.drawable.tm);
		map289.put("countryName", "Turkmenistan");
		map289.put("countryCode", "+993");
		map289.put("countryId", "238");
		
	    list.add(map289);
			
		Map<String, Object> map290=new HashMap<String, Object>();
		map290.put("countryFlag", R.drawable.tc);
		map290.put("countryName", "Turks & Caicos Islands");
		map290.put("countryCode", "+1649");
		map290.put("countryId", "238");
		
	    list.add(map290);
		

		
		
		Map<String, Object> map102=new HashMap<String, Object>();
		map102.put("countryFlag", R.drawable.tanzania);
		map102.put("countryName", "Tanzania");
		map102.put("countryCode", "+255");
		map102.put("countryId", "209");
		
		list.add(map102);
		
		Map<String, Object> map103=new HashMap<String, Object>();
		map103.put("countryFlag", R.drawable.thailand);
		map103.put("countryName", "Thailand");
		map103.put("countryCode", "+66");
		map103.put("countryId", "210");
		
		list.add(map103);
		
		Map<String, Object> map104=new HashMap<String, Object>();
		map104.put("countryFlag", R.drawable.turkey);
		map104.put("countryName", "Turkey");
		map104.put("countryCode", "+90");
		map104.put("countryId", "217");
		
		list.add(map104);
		
		Map<String, Object> map291=new HashMap<String, Object>();
		map291.put("countryFlag", R.drawable.ae);
		map291.put("countryName", "United Arab Emirates");
		map291.put("countryCode", "+971");
		map291.put("countryId", "238");
		
	    list.add(map291);
		
        Map<String, Object> map292=new HashMap<String, Object>();
		map292.put("countryFlag", R.drawable.uruguay);
		map292.put("countryName", "Uruguay");
		map292.put("countryCode", "+598");
		map292.put("countryId", "238");
		
	    list.add(map292);
		
 		
		Map<String, Object> map105=new HashMap<String, Object>();
		map105.put("countryFlag", R.drawable.ukraine);
		map105.put("countryName", "Ukraine");
		map105.put("countryCode", "+280");
		map105.put("countryId", "222");
			
		list.add(map105);
		
		Map<String, Object> map106=new HashMap<String, Object>();
		map106.put("countryFlag", R.drawable.uganda);
		map106.put("countryName", "Uganda");
		map106.put("countryCode", "+256");
		map106.put("countryId", "221");
		
		list.add(map106);
		
		Map<String, Object> map107=new HashMap<String, Object>();
		map107.put("countryFlag", R.drawable.unitedkingdom);
		map107.put("countryName", "United Kingdom");
		map107.put("countryCode", "+44");
		map107.put("countryId", "224");
		
		list.add(map107);
		
		Map<String, Object> map108=new HashMap<String, Object>();
		map108.put("countryFlag", R.drawable.unitedstates);
		map108.put("countryName", "USA");
		map108.put("countryCode", "+1");
		map108.put("countryId", "1");
		
		list.add(map108);
		
		Map<String, Object> map109=new HashMap<String, Object>();
		map109.put("countryFlag", R.drawable.uzbekistan);
		map109.put("countryName", "Uzbekistan");
		map109.put("countryCode", "+998");
		map109.put("countryId", "228");
		
		list.add(map109);
		
		
		
        Map<String, Object> map293=new HashMap<String, Object>();
		map293.put("countryFlag", R.drawable.vanuatu);
		map293.put("countryName", "Vanuatu");
		map293.put("countryCode", "+678");
		map293.put("countryId", "238");
		
	    list.add(map293);
		
   
	
		
		Map<String, Object> map110=new HashMap<String, Object>();
		map110.put("countryFlag", R.drawable.vietnam);
		map110.put("countryName", "Vietnam");
		map110.put("countryCode", "+84");
		map110.put("countryId", "231");
		
		list.add(map110);
		
		Map<String, Object> map111=new HashMap<String, Object>();
		map111.put("countryFlag", R.drawable.venezuela);
		map111.put("countryName", "Venezuela");
		map111.put("countryCode", "+58");
		map111.put("countryId", "230");
			
		list.add(map111);
		
	/*	  Map<String, Object> map294=new HashMap<String, Object>();
		map294.put("countryFlag", R.drawable.wwf);
		map294.put("countryName", "Wallis and Futuna");
		map294.put("countryCode", "+681");
		map294.put("countryId", "238");
		
	    list.add(map294);*/
		
		  Map<String, Object> map295=new HashMap<String, Object>();
		map295.put("countryFlag", R.drawable.ws);
		map295.put("countryName", "Western Samoa");
		map295.put("countryCode", "+685");
		map295.put("countryId", "238");
		
	    list.add(map295);
		
		
		Map<String, Object> map112=new HashMap<String, Object>();
		map112.put("countryFlag", R.drawable.yemen);
		map112.put("countryName", "Yemen");
		map112.put("countryCode", "+967");
		map112.put("countryId", "236");
		
		list.add(map112);
		
		
		Map<String, Object> map113=new HashMap<String, Object>();
		map113.put("countryFlag", R.drawable.zambia);
		map113.put("countryName", "Zambia");
		map113.put("countryCode", "+260");
		map113.put("countryId", "238");
		
		list.add(map113);
		
		
		Map<String, Object> map114=new HashMap<String, Object>();
		map114.put("countryFlag", R.drawable.zimbabwe);
		map114.put("countryName", "Zimbabwe");
		map114.put("countryCode", "+263");
		map114.put("countryId", "239");
		
		list.add(map114);
		
		
		/*Map<String, Object> map911=new HashMap<String, Object>();
		map911.put("countryFlag", R.drawable.australia);
		map911.put("countryName", "Antarctica");
		map911.put("countryCode", "8");
		map911.put("countryId", "8");
		
		list.add(map911);
		*/
		
		System.out.println("LIST "+list.size());
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
		
		return list;
	}
	
	



	private void setupSearchView() {
		
		searchView.setIconifiedByDefault(false);
		searchView.setOnQueryTextListener(this);
		searchView.setSubmitButtonEnabled(true);
		searchView.setQueryHint("Search here");
	}

	@Override
	public boolean onQueryTextSubmit(String query)
	{
		
		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText)
	{
		if(TextUtils.isEmpty(newText))
		{
			listview.clearTextFilter();
		}
		else
		{
			listview.setFilterText(newText.toString());
		}
		return true;
	}
	
	
}
