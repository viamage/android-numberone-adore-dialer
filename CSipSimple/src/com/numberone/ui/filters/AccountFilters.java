package com.numberone.ui.filters;

import android.os.Bundle;
import android.text.TextUtils;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.numberone.R;
import com.numberone.api.SipProfile;
import com.numberone.utils.Compatibility;
import com.numberone.utils.Log;
import com.numberone.wizards.WizardUtils;

public class AccountFilters extends SherlockFragmentActivity {

    private static final String THIS_FILE = "AccountFilters";
    private long accountId = SipProfile.INVALID_ID;
    private AccountFiltersListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String accountName = null;
        String wizard = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            accountId = extras.getLong(SipProfile.FIELD_ID, -1);
            accountName = extras.getString(SipProfile.FIELD_DISPLAY_NAME);
            wizard = extras.getString(SipProfile.FIELD_WIZARD);
        }

        if (accountId == -1) {
            Log.e(THIS_FILE, "You provide an empty account id....");
            finish();
        }
        if(!TextUtils.isEmpty(accountName)) {
            setTitle(getResources().getString(R.string.filters) + " : " + accountName);
        }
        if(!TextUtils.isEmpty(wizard)) {
            ActionBar ab = getSupportActionBar();
            if(ab != null) {
                ab.setIcon(WizardUtils.getWizardIconRes(wizard));
            }
        }

        setContentView(R.layout.account_filters_view);
        listFragment = (AccountFiltersListFragment) getSupportFragmentManager().findFragmentById(R.id.list);
        listFragment.setAccountId(accountId);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == Compatibility.getHomeMenuId()) {
            finish();
            return true;
        }
        return false;
    }
}
