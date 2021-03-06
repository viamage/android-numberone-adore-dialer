package com.numberonecall.ui.account;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.numberonecall.R;
import com.numberonecall.api.SipProfile;
import com.numberonecall.utils.Compatibility;
import com.numberonecall.wizards.BasePrefsWizard;

public class AccountsEditList extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.accounts_view);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		Intent intent = new Intent();
        intent.setClass(this, BasePrefsWizard.class);
        
        intent.putExtra(SipProfile.FIELD_ID, SipProfile.INVALID_ID);
        startActivity(intent);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == Compatibility.getHomeMenuId()) {
			finish();
			return true;
		}
		return false;
	}

}
