package com.numberone.ui.favorites;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.ListView;

import com.numberone.R;
import com.numberone.ui.SipHome.ViewPagerVisibilityListener;
import com.numberone.widgets.CSSListFragment;

public class FavListFragment extends CSSListFragment implements ViewPagerVisibilityListener {
    

    private FavAdapter mAdapter;
    private boolean mDualPane;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void attachAdapter() {
        if(getListAdapter() == null) {
            if(mAdapter == null) {
                mAdapter = new FavAdapter(getActivity(), null);
            }
            setListAdapter(mAdapter);
        }
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // View management
        mDualPane = getResources().getBoolean(R.bool.use_dual_panes);

        // Modify list view
        ListView lv = getListView();
        lv.setVerticalFadingEdgeEnabled(true);
        // lv.setCacheColorHint(android.R.color.transparent);
        if (mDualPane) {
            lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            lv.setItemsCanFocus(false);
        } else {
            lv.setChoiceMode(ListView.CHOICE_MODE_NONE);
            lv.setItemsCanFocus(true);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new FavLoader(getActivity());
    }


    boolean alreadyLoaded = false;
    @Override
    public void onVisibilityChanged(boolean visible) {

        if(visible) {
            attachAdapter();
            // Start loading
            if(!alreadyLoaded) {
                getLoaderManager().initLoader(0, null, this);
                alreadyLoaded = true;
            }
        }
    }

    @Override
    public void changeCursor(Cursor c) {
        if(mAdapter != null) {
            mAdapter.changeCursor(c);
        }
    }

}
