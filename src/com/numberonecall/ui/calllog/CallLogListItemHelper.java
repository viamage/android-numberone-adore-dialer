package com.numberonecall.ui.calllog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

import com.numberonecall.R;
import com.numberonecall.utils.Theme;

/**
 * Helper class to fill in the views of a call log entry.
 */
/* package */class CallLogListItemHelper {
    /** Helper for populating the details of a phone call. */
    private final PhoneCallDetailsHelper mPhoneCallDetailsHelper;
    /** Resources to look up strings. */
    private final Resources mResources;
    private final Theme mTheme;

    /**
     * Creates a new helper instance.
     * 
     * @param phoneCallDetailsHelper used to set the details of a phone call
     * @param phoneNumberHelper used to process phone number
     */
    public CallLogListItemHelper(PhoneCallDetailsHelper phoneCallDetailsHelper, Context ctxt) {
        mPhoneCallDetailsHelper = phoneCallDetailsHelper;
        mResources = ctxt.getResources();
        mTheme = Theme.getCurrentTheme(ctxt);
    }

    /**
     * Sets the name, label, and number for a contact.
     * 
     * @param views the views to populate
     * @param details the details of a phone call needed to fill in the data
     * @param isHighlighted whether to use the highlight text for the call
     */
    public void setPhoneCallDetails(CallLogListItemViews views, PhoneCallDetails details) {
        mPhoneCallDetailsHelper.setPhoneCallDetails(views.phoneCallDetailsViews, details);

    }

    /** Returns the description used by the call action for this phone call. */
    private CharSequence getCallActionDescription(PhoneCallDetails details) {
        CharSequence recipient;
        if (!TextUtils.isEmpty(details.name)) {
            recipient = details.name;
        } else {
            recipient = details.number;
        }
        return mResources.getString(R.string.description_call, recipient);
    }

}
