package com.numberonecall.ui.more;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;

import com.numberonecall.R;

public class Storage extends Activity{
	private Context context;
	Storage(Context context){
		this.context=context;
	}
    public List<MoreItem> getItems() {
        List<MoreItem> list = new ArrayList<MoreItem>();
        list.add(new MoreItem(getString(R.string.prefs),R.drawable.ic_menu_preferences,getString(R.string.prefs_network_desc)));
        //    list.add(new MoreItem("Add Contacts",R.drawable.ic_add_contact,"add a new contact to phonebook"));
        //    list.add(new MoreItem("CDR",R.drawable.cdr_img,"call history"));
            //   list.add(new MoreItem("Rates",R.drawable.rate,"check international call rates"));
    //    list.add(new MoreItem("Recharge",R.drawable.recharge,"recharge your existing account"));
        list.add(new MoreItem(getString(R.string.about),R.drawable.about,getString(R.string.about_desc)));
        list.add(new MoreItem(getString(R.string.exit),R.drawable.exit,getString(R.string.exit_desc)));
              return list;
    }

}
