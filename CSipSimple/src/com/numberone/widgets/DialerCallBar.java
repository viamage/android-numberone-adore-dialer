package com.numberone.widgets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.numberone.R;
import com.numberone.ui.account.AccountWizard;
import com.numberone.ui.account.AdoreSharedPreferences;

public class DialerCallBar extends LinearLayout implements OnClickListener, OnLongClickListener {

    public interface OnDialActionListener {
        /**
         * The make call button has been pressed
         */
        void placeCall();

        /**
         * The video button has been pressed
         */
        void placeVideoCall();
        /**
         * The delete button has been pressed
         */
        void deleteChar();
        /**
         * The delete button has been long pressed
         */
        void deleteAll();
        /**
         * The account button has been pressed
         */
        void editAccount();

		void phonebook();

		void gsmCall();
    }
    private AdoreSharedPreferences adorePreferences;

    private OnDialActionListener actionListener;
    
    public DialerCallBar(Context context) {
        this(context, null, 0);
    }

    public DialerCallBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public DialerCallBar(Context context, AttributeSet attrs, int style) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.dialpad_additional_buttons, this, true);
        findViewById(R.id.phonebook).setOnClickListener(this);
        findViewById(R.id.phonebook).setEnabled(true);
        findViewById(R.id.accountButton).setOnClickListener(this);
        findViewById(R.id.accountButton).setEnabled(true);
        findViewById(R.id.dialButton).setOnClickListener(this);
      //  findViewById(R.id.deleteButton1).setOnClickListener(this);
      //  findViewById(R.id.deleteButton1).setOnLongClickListener(this);
        adorePreferences=new AdoreSharedPreferences(getContext());
        if(getOrientation() == LinearLayout.VERTICAL) {
            LayoutParams lp;
            for(int i=0; i < getChildCount(); i++) {
                lp = (LayoutParams) getChildAt(i).getLayoutParams();
                int w = lp.width;
                lp.width = lp.height;
                lp.height = w;
                lp.gravity = Gravity.CENTER_HORIZONTAL;
                // Added for clarity but not necessary
                getChildAt(i).setLayoutParams(lp);
                
            }
        }
    }

    /**
     * Set a listener for this widget actions
     * @param l the listener called back when some user action is done on this widget
     */
    public void setOnDialActionListener(OnDialActionListener l) {
        actionListener = l;
    }
    
    /**
     * Set the action buttons enabled or not
     */
    public void setEnabled(boolean enabled) {
        findViewById(R.id.dialButton).setEnabled(enabled);
        //findViewById(R.id.deleteButton).setEnabled(enabled);
    }
    
    /**
     * Set the video capabilities
     * @param enabled whether the client is able to make video calls
     */
    public void setVideoEnabled(boolean enabled) {
      //  findViewById(R.id.dialVideoButton).setVisibility(enabled ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (actionListener != null) {
            int viewId = v.getId();
            if (viewId == R.id.accountButton) {
                actionListener.editAccount();
            }if (viewId == R.id.phonebook) {
                actionListener.phonebook();
            }
            else if(viewId == R.id.dialButton) {
        		
            	final Dialog dialog = new Dialog(getContext());
            	dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    			dialog.setContentView(R.layout.customcall);
    			
    		
    			
    			Button sip=(Button)dialog.findViewById(R.id.sipcall);
    			
    			sip.setOnClickListener(new OnClickListener() 
            	{
					
					@Override
					public void onClick(View v)
					{
						
						 actionListener.placeCall();
						
						
						 dialog .dismiss();
						
						

					}
				});
            	Button local=(Button)dialog.findViewById(R.id.localcall);
            	
            	local.setOnClickListener(new OnClickListener() 
            	{
					
					@Override
					public void onClick(View v)
					{   adorePreferences.loadCountryValue();
					    
						if(adorePreferences.accessnum!=null)
	                   	{
						 actionListener.gsmCall();
	                   	}else
	                	{
	                		showSavingNmberAlert();
	                	}
						 dialog .dismiss();
						
					}
				});
            	
            	
    			dialog.show();	
            	
            	
               
            }
            }/*else if(viewId == R.id.deleteButton1) {
                actionListener.deleteChar();
            }*/
        }
    

    @Override
    public boolean onLongClick(View v) {
        if (actionListener != null) {
            int viewId = v.getId();
            if(viewId == R.id.deleteButton1) {
                actionListener.deleteAll();
                v.setPressed(false);
                return true;
            }
        }
        return false;
    }
    void showSavingNmberAlert() 
	{
		new AlertDialog.Builder(getContext())
				.setTitle("Alert")
				.setMessage(
						" Access number is not available for making the call")
				.setNeutralButton("OK", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which)
					{
						
							
					}
				}).show();
		}

}
