package com.numberonecall.ui.more;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.numberonecall.R;
import com.numberonecall.api.SipManager;
import com.numberonecall.api.SipProfile;
import com.numberonecall.db.DBProvider;
import com.numberonecall.ui.SipHome.ViewPagerVisibilityListener;
import com.numberonecall.ui.account.AccountWizard;
import com.numberonecall.ui.contacts.AddContactDialog;
import com.numberonecall.utils.Log;
import com.numberonecall.utils.PreferencesProviderWrapper;
import com.numberonecall.utils.PreferencesWrapper;

public class More extends SherlockFragment implements ViewPagerVisibilityListener{
	
	private Context c;
	private List<MoreItem> items;
	private ListView listView;
	private MoreListAdapter adapter; 
	private PreferencesProviderWrapper prefProviderWrapper;
	private final static int CHANGE_PREFS = 1;
	//private final static int SETTINGS = 0;
	//private final static int RECORDING = 1;
	//private final static int ABOUT = 4;
	private final static int Authorise = 0;
	private final static int VOUCHER = 1;
	private final static int ACCESSNO = 2;
	//private final static int PROFILE = 3;
	private final static int Help = 3;
	private final static int EXIT1= 4; 
	private final static int EXIT= 5;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 prefProviderWrapper = new PreferencesProviderWrapper(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.more, container, false);
		c = getActivity().getBaseContext();
		items =getItems();
		adapter = new MoreListAdapter(getActivity(), items);
		listView = (ListView) v.findViewById(R.id.list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(onListClick);  
		return v;
	} 
    public List<MoreItem> getItems() {
        List<MoreItem> list = new ArrayList<MoreItem>();
        String prefs_desc=getString(R.string.prefs_network)+""+getString(R.string.prefs_media)+" ";
       // list.add(new MoreItem(getString(R.string.prefs),R.drawable.ic_menu_preferences,""));
           // list.add(new MoreItem("Account",R.drawable.account_over,"Check Account"));
        //    list.add(new MoreItem("CDR",R.drawable.cdr_img,"call history"));
            //   list.add(new MoreItem("Rates",R.drawable.rate,"check international call rates"));
        list.add(new MoreItem(getString(R.string.authorise),R.drawable.auth,getString(R.string.authorise_desc)));
        list.add(new MoreItem(getString(R.string.voucher),R.drawable.voucher,getString(R.string.voucher_desc)));
        list.add(new MoreItem(getString(R.string.access),R.drawable.access,getString(R.string.access_desc)));
      //  list.add(new MoreItem(getString(R.string.profile),R.drawable.profile,getString(R.string.profile_desc)));  
      //  list.add(new MoreItem(getString(R.string.about),R.drawable.about,getString(R.string.about_desc)));  
   list.add(new MoreItem(getString(R.string.balance),R.drawable.help,getString(R.string.balance_desc)));
         
        list.add(new MoreItem(getString(R.string.account),R.drawable.accountt,getString(R.string.account_desc)));
        list.add(new MoreItem(getString(R.string.exit),R.drawable.exit,getString(R.string.exit_desc)));
              return list;
    }
	 @Override
	    public void onVisibilityChanged(boolean visible) {}
	private ListView.OnItemClickListener onListClick = new ListView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> mAdapterView, View v,
				int position, long id) {
			try {
				switch(position){
				/*case SETTINGS:
					startActivityForResult(new Intent(SipManager.ACTION_UI_PREFS_GLOBAL), CHANGE_PREFS);
					break;*/
				
				case VOUCHER:
					//TODO: CDR
					openAboutDialog1();
					
					
					/*	SipProfile account;
        			long accountId = 1;
        			account = SipProfile.getProfileFromDbId(getActivity(), accountId,
        					DBProvider.ACCOUNT_FULL_PROJECTION);
        			String user1, pass1;
        			
        			user1 = account.getSipUserName();
        			pass1 = account.getPassword();
    				Uri uri = Uri.parse("https://numberonecall.com/voucher/"+user1+"?"); // missing 'http://' will cause crashed
    				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    				
    				System.out.println("USERNAME VALUE "+user1);
    				startActivity(intent);*/
						
					break;
					
			/*	case PROFILE:
					//TODO: CDR
					openAboutDialog6();
					
					break;*/
					
				case ACCESSNO:
					//TODO: CDR
					openAboutDialog2();
					
					break;
					
				case Authorise:
					//TODO: CDR
					openAboutDialog7();
					
					break;
					
				case Help:
					//TODO: CDR
					openAboutDialog8();
					
					break;
				/*case BALANCE:
					//TODO: CDR
					openAboutDialog7();
					
					break;*/
					
				case EXIT1:
					//TODO: CDR
					startActivity(new Intent(getActivity(),AccountWizard.class));
					
					break;
					
				case EXIT:
					//TODO: Rates
					Log.e("exit", "pressed");
					
					new AlertDialog.Builder(getActivity())
					.setTitle("Quit Dialer ")
					.setMessage(
							"Are you sure to quit the dialer ?")
					.setNeutralButton("OK", new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which)
						{
							 prefProviderWrapper.setPreferenceBooleanValue(PreferencesWrapper.HAS_BEEN_QUIT, true);
				                disconnect(true);
								
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
					
					
					
					break;
				
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void openAboutDialog7() {
			// TODO Auto-generated method stub
			startActivity(new Intent(getActivity(),Authorised.class));
		}
		
		private void openAboutDialog8() {
			// TODO Auto-generated method stub
			startActivity(new Intent(getActivity(),Help.class));
		}
		
		private void openAboutDialog6() {
			// TODO Auto-generated method stub
			startActivity(new Intent(getActivity(),Rate.class));
		}
		private void openAboutDialog3() {
			// TODO Auto-generated method stub
			startActivity(new Intent(getActivity(),MobileMessage.class));
		}
		private void openAboutDialog2() {
			// TODO Auto-generated method stub
			startActivity(new Intent(getActivity(),DidFront.class));
		}
		private void openAboutDialog1() {
			// TODO Auto-generated method stub
			startActivity(new Intent(getActivity(),Support.class));
		}
		void openAboutDialog(){
			startActivity(new Intent(getActivity(),AboutDialog.class));
		}
		private void addContactDailog() {
			// TODO Auto-generated method stub
			startActivity(new Intent(getActivity(),AddContactDialog.class));
		}
	};
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CHANGE_PREFS) {
            getActivity().sendBroadcast(new Intent(SipManager.ACTION_SIP_REQUEST_RESTART));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void disconnect(boolean quit) {      
        Intent intent = new Intent(SipManager.ACTION_OUTGOING_UNREGISTER);
        intent.putExtra(SipManager.EXTRA_OUTGOING_ACTIVITY, new ComponentName(getActivity(), More.class));
        getActivity().sendBroadcast(intent);
        if(quit) {
        	getActivity().finish();
        }
    }
    
}
