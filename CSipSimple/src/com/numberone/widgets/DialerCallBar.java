package com.numberone.widgets;

import java.io.File;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.numberone.R;
import com.numberone.api.SipProfile;
import com.numberone.ui.account.AccountWizard;
import com.numberone.ui.account.AdoreSharedPreferences;
import com.numberone.ui.dialpad.DialerFragment;
import com.numberone.ui.dialpad.DialerFragment.LongOperation;
import com.numberone.ui.more.Accessno;
import com.numberone.writer.StorageFile;

public class DialerCallBar extends LinearLayout implements OnClickListener, OnLongClickListener {
	protected static SipProfile account;
	
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
      //  void editAccount();

		void phonebook();

		void gsmCall();
    }
    private AdoreSharedPreferences adorePreferences;
    public static Button local;

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
      //  findViewById(R.id.accountButton).setOnClickListener(this);
    TextView balance = (TextView) findViewById(R.id.accountButton);
    DialerFragment df = new DialerFragment();
   df.new LongOperation().execute("");
   LongOperation l = df.new LongOperation();
    
    //String data1 = account.getSipUserName();
   // String data2=account.getPassword();
    //l.execute("Antonio");
   // System.out.println("HEMANT .........."+l.rr);
   // balance.setText(l.r);
      //  findViewById(R.id.accountButton).setEnabled(true);
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
            //if (viewId == R.id.accountButton) {
               // actionListener.editAccount();
            //}
        if (viewId == R.id.phonebook) {
                actionListener.phonebook();
            }
            else if(viewId == R.id.dialButton) {
            	
            	try {
					String a = Accessno.item;
					System.out.println("ACCESSNO^^^^^^^^^^^^^^^^^^^^^^^^^"+a);
					
					Boolean b = Accessno.bool;
					System.out.println("BOOLEAN VALUE "+b);
     	
					
					if(b==true)
					{
						System.out.println("DEVTADIYAL");
						final Dialog dialog = new Dialog(getContext());
						dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
						dialog.setContentView(R.layout.customcall);
						
					
						
						Button sip=(Button)dialog.findViewById(R.id.sipcall);
						
						sip.setOnClickListener(new OnClickListener() 
						{ 
							
							ConnectivityManager connMgr = (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

					       NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
					    //  AccountStatusDisplay accountStatusDisplay = AccountListUtils.getAccountDisplay(getContext(), 1);
							@Override
							public void onClick(View v)
							{
					         if(networkInfo != null && networkInfo.isConnected())
								  //|| jsonvalue.contains("you are authorized person")
					         {
					        	 // if(b==true)  
								//{
								 actionListener.placeCall();
								  
								
					         }else
					         {
					        	 Toast.makeText(getContext(), "Please make sure you have Network Enabled ", Toast.LENGTH_LONG).show(); 
					         }
							}
						});
						local=(Button)dialog.findViewById(R.id.localcall);
						
						local.setOnClickListener(new OnClickListener() 
						{
						
							@Override
							public void onClick(View v)
							{   
							     
								try {
									adorePreferences.loadCountryValue();
									File internalStorageDir = getContext().getFilesDir();
									File devfile = new File(internalStorageDir, "/ukww");
									String filepath = devfile+"/accessno.txt";
									StorageFile sf = new StorageFile();
									String accessno =null;
									
									accessno = sf.readStorageFile(filepath);
									System.out.println(" WHILE CALLING HEMANT FILE PATH: "+filepath+" DEVTADIYAL04 ACCESS NO "+accessno);
									 
									  actionListener.gsmCall();
									  dialog .dismiss();
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
								//	showSavingNmberAlert();
									 dialog .dismiss();
									System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ "+e);
								
							        }
							}
						});
						
						
						dialog.show();	
					}
					else
					{
						ConnectivityManager connMgr = (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

					   NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
					   
					 if(networkInfo != null && networkInfo.isConnected())
						  
					 {
						
						 actionListener.placeCall();
						 
						
					 }
					 else
					 {
						 Toast.makeText(getContext(), "Please make sure you have Network Enabled ", Toast.LENGTH_LONG).show(); 
					 }
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 actionListener.placeCall();
				}
            	
            }	
             
            }
            
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
