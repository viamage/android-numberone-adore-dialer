package com.numberone.ui.contacts;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.numberone.R;
import com.numberone.api.SipManager;
import com.numberone.api.SipUri;
import com.numberone.ui.SipHome;
import com.numberone.ui.SipHome.ViewPagerVisibilityListener;
import com.numberone.utils.Log;

public class ContactManager extends SherlockFragment implements TextWatcher,
		ViewPagerVisibilityListener {
	private static final String THIS_FILE = "Contact Manager";
	public static final String ACTION_CONTACTS = "com.numberone.ui.contacts.ContactAdded";
	private static final int CLOSE_MENU = 0;
	private Context c;
	private List<ContactItem> countries;
	private EditText editTextFilter;
	private ListView listViewContacts;
	private ContactListAdapter adapter;
	Button add;
	private Drawable digitsBackground, digitsEmptyBackground;
	View v;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setHasOptionsMenu(true);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.phonebook, container, false);
		Resources r = getResources();
		digitsBackground = r.getDrawable(R.drawable.search_over);
		digitsEmptyBackground = r.getDrawable(R.drawable.search);
		c = getActivity().getBaseContext();
		this.add=(Button)v.findViewById(R.id.button1);
		this.add.setOnClickListener(this.save_OnClickListener);
		updateContacts();
		
		
/*		  BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
			    @Override
			    public void onReceive(Context context, Intent intent) {
			    	c = getActivity().getBaseContext();
			    	updateContacts();
			    	//adapter.notifyDataSetChanged();
			    	//Toast.makeText(getActivity(),"Contacts Updated", Toast.LENGTH_SHORT).show();
			    }
			};
			 LocalBroadcastManager.getInstance(getActivity()).registerReceiver(
			            mMessageReceiver, new IntentFilter(ACTION_CONTACTS));*/
		
		return v;
	}
	
	public void updateContacts(){
		countries = new Storage(c).getItems();
		adapter = new ContactListAdapter(getActivity(), countries);
		editTextFilter = (EditText) v.findViewById(R.id.editTextFilter);
		editTextFilter.addTextChangedListener(this);
		final boolean notEmpty = editTextFilter.length() != 0;
		editTextFilter.setBackgroundDrawable(notEmpty ? digitsBackground
				: digitsEmptyBackground);

		listViewContacts = (ListView) v.findViewById(R.id.listViewContacts);
		listViewContacts.setAdapter(adapter);
		listViewContacts.setOnItemClickListener(onListClick);
		listViewContacts.setFastScrollEnabled(true);
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 1) {

		     if(resultCode == getActivity().RESULT_OK){
		    	 updateContacts();		     
		}

		if (resultCode == getActivity().RESULT_CANCELED) {

		     //Write your code on no result return 

		}
		}}
	public void onResume(){
		super.onResume();
		listViewContacts.setOnItemClickListener(onListClick);
		   Log.e(THIS_FILE, "On Resume contact manager");
	}
	public void onPause() {
		super.onPause();
		editTextFilter.setText("");
	}

	@Override
	public void onVisibilityChanged(boolean visible) {
		Log.e(THIS_FILE, "VISIBILITY CHANGED");
		if (!visible) {
			InputMethodManager imm = (InputMethodManager) getActivity()
					.getSystemService(getActivity().INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(editTextFilter.getWindowToken(), 0);
			editTextFilter.setText("");
		}
if(visible && isResumed()){
	  Log.e(THIS_FILE, "contact manager visible");
	onResume();
}
	}
	
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		adapter.getFilter().filter(s);
		final boolean notEmpty = editTextFilter.length() != 0;
		editTextFilter.setBackgroundDrawable(notEmpty ? digitsBackground
				: digitsEmptyBackground);

	}

	@Override
	public void afterTextChanged(Editable s) {
		listViewContacts.setOnItemClickListener(onListClick);
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	private ListView.OnItemClickListener onListClick = new ListView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> mAdapterView, View v,
				int position, long id) {
			InputMethodManager imm = (InputMethodManager) getActivity()
					.getSystemService(getActivity().INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(editTextFilter.getWindowToken(), 0);
			try {
				String number = ((ContactItem) listViewContacts.getAdapter()
						.getItem(position)).getNumber();

				
		/*		//send number for dialer digits 
				Intent intent = new Intent(SipManager.ACTION_SIP_DIALER);
				  intent.putExtra("message", number);
				  LocalBroadcastManager.getInstance(getSherlockActivity()).sendBroadcast(intent);*/
				Intent it = new Intent(getActivity(),SipHome.class);
				it.setAction(SipManager.ACTION_SIP_DIALER);
				it.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, number));
				startActivity(it);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	

	@Override
	    public void onCreateOptionsMenu (Menu menu,MenuInflater inflater) {
	      super.onCreateOptionsMenu(menu,inflater);
	      Log.e("menu ","called");
	        int actionRoom = getResources().getBoolean(R.bool.menu_in_bar) ? MenuItem.SHOW_AS_ACTION_IF_ROOM : MenuItem.SHOW_AS_ACTION_NEVER;
	        menu.add(Menu.NONE, CLOSE_MENU, Menu.NONE, "Add new")
            .setIcon(R.drawable.ic_add_contact)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
/*	        MenuItem enu = menu.add("Add new");
	        enu.setIcon(R.drawable.ic_add_contact).setShowAsAction(actionRoom);
	        enu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
	            @Override 
	            	            	            
	            public boolean onMenuItemClick(MenuItem item) {
	            	startActivity(new Intent(getActivity(),AddContactDialog.class));
	                return true;
	            }
	        });
*/	    }	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	startActivityForResult(new Intent(getActivity(),AddContactDialog.class),1);
    	return super.onOptionsItemSelected(item);
    }
    
    private OnClickListener save_OnClickListener = new OnClickListener(){
		@Override
		public void onClick(View v) {
			
			//Uri uri = Uri.parse("http://www.adoresoftphone.com");
			 Intent intent = new Intent(getActivity(), AddContactDialog.class);
			 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			 startActivity(intent);
			//finish();
		}
	};
}