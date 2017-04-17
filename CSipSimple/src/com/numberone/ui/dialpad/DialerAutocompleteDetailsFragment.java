package com.numberone.ui.dialpad;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.numberone.ui.SipHome;
import com.numberone.utils.contacts.ContactsSearchAdapter;

public class DialerAutocompleteDetailsFragment extends SherlockListFragment {
    private ContactsSearchAdapter autoCompleteAdapter;
    private CharSequence constraint = "";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        autoCompleteAdapter = new ContactsSearchAdapter(getActivity());
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        setListAdapter(autoCompleteAdapter);
        proposeRestoreFromBundle(savedInstanceState);
        proposeRestoreFromBundle(getArguments());
    }
    
    private void proposeRestoreFromBundle(Bundle b) {
        if(b != null && b.containsKey(EXTRA_FILTER_CONSTRAINT)) {
            filter(b.getCharSequence(EXTRA_FILTER_CONSTRAINT));
        }
    }
    
    public final static String EXTRA_FILTER_CONSTRAINT = "constraint";
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putCharSequence(EXTRA_FILTER_CONSTRAINT, constraint);
        super.onSaveInstanceState(outState);
    }
    

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object selectedItem = autoCompleteAdapter.getItem(position);
        if (selectedItem != null) {

            // Well that a little bit too direct it should be more a listener
            // But not sure how fragments will behaves on restore for now
            Activity superAct = getActivity();
            if (superAct instanceof SipHome) {
                Fragment frag = ((SipHome) superAct).getCurrentFragment();
                if (frag != null && frag instanceof DialerFragment) {
                    ((DialerFragment) frag).setTextFieldValue(autoCompleteAdapter.getFilter()
                            .convertResultToString(selectedItem));
                }
            }
        }
    }

    /**
     * Filter the query to some filter string
     * 
     * @param constraint the string to filter on
     */
    public void filter(CharSequence constraint) {
        autoCompleteAdapter.getFilter().filter(constraint);
        this.constraint = constraint;
    }
}
