package com.numberonecall.ui.more;
import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.numberonecall.R;
import com.numberonecall.api.SipManager;
import com.numberonecall.api.SipUri;
import com.numberonecall.ui.SipHome;
import com.numberonecall.ui.dialpad.CheckVariable;
import com.numberonecall.writer.StorageFile;

public class Accessno extends Activity {
	public static String str,item;
	public static String msg ="";
	public static CheckBox checkBox11;
	RadioGroup  radioGroup12;
	RadioButton a,b,c,d,e,f,g,h,iii,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll,mm,nn,oo,pp,qq,rr,ss,tt,uu,vv,ww,xx,yy,zz,aaa,bbb,ccc,ddd,eee,fff,ggg,hhh,iiii,jjj,kkk,lll,mmm,nnn,ooo,ppp,qqq;
	public static Boolean bool;
	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.accessno);

	        checkBox11 = (CheckBox) findViewById(R.id.checkBox1);
	        a = (RadioButton) findViewById(R.id.radioButton1Id);
	        b = (RadioButton) findViewById(R.id.radioButton2Id);
	        c = (RadioButton) findViewById(R.id.radioButton3Id);
	        d = (RadioButton) findViewById(R.id.radioButton4Id);
	        e = (RadioButton) findViewById(R.id.radioButton5Id);
	        f = (RadioButton) findViewById(R.id.radioButton6Id);
	        g = (RadioButton) findViewById(R.id.radioButton7Id);
	        h = (RadioButton) findViewById(R.id.radioButton8Id);
	        iii = (RadioButton) findViewById(R.id.radioButton9Id);
	        j = (RadioButton) findViewById(R.id.radioButton10Id);
	        k = (RadioButton) findViewById(R.id.radioButton11Id);
	        l = (RadioButton) findViewById(R.id.radioButton12Id);
	        m = (RadioButton) findViewById(R.id.radioButton13Id);
	        n = (RadioButton) findViewById(R.id.radioButton14Id);
	        o = (RadioButton) findViewById(R.id.radioButton15Id);
	        p = (RadioButton) findViewById(R.id.radioButton16Id);
	        q = (RadioButton) findViewById(R.id.radioButton17Id);
	        r = (RadioButton) findViewById(R.id.radioButton18Id);
	        s = (RadioButton) findViewById(R.id.radioButton19Id);
	        t = (RadioButton) findViewById(R.id.radioButton20Id);
	        u = (RadioButton) findViewById(R.id.radioButton21Id);
	        v = (RadioButton) findViewById(R.id.radioButton22Id);
	        w = (RadioButton) findViewById(R.id.radioButton23Id);
	        x = (RadioButton) findViewById(R.id.radioButton24Id);
	        y = (RadioButton) findViewById(R.id.radioButton25Id);
	        z = (RadioButton) findViewById(R.id.radioButton26Id);
	        aa = (RadioButton) findViewById(R.id.radioButton27Id);
	        bb = (RadioButton) findViewById(R.id.radioButton28Id);
	        cc= (RadioButton) findViewById(R.id.radioButton29Id);
	        dd= (RadioButton) findViewById(R.id.radioButton30Id);
	        ee= (RadioButton) findViewById(R.id.radioButton31Id);
	        ff= (RadioButton) findViewById(R.id.radioButton32Id);
	        gg= (RadioButton) findViewById(R.id.radioButton33Id);
	        hh= (RadioButton) findViewById(R.id.radioButton34Id);
	        ii= (RadioButton) findViewById(R.id.radioButton35Id);
	        jj= (RadioButton) findViewById(R.id.radioButton36Id);
	        kk= (RadioButton) findViewById(R.id.radioButton37Id);
	        ll= (RadioButton) findViewById(R.id.radioButton38Id);
	        mm= (RadioButton) findViewById(R.id.radioButton39Id);
	        nn= (RadioButton) findViewById(R.id.radioButton40Id);
	        oo= (RadioButton) findViewById(R.id.radioButton41Id);
	        pp= (RadioButton) findViewById(R.id.radioButton42Id);
	        qq = (RadioButton) findViewById(R.id.radioButton43Id);
	        rr = (RadioButton) findViewById(R.id.radioButton44Id);
	        ss = (RadioButton) findViewById(R.id.radioButton45Id);
	        tt = (RadioButton) findViewById(R.id.radioButton46Id);
	        uu = (RadioButton) findViewById(R.id.radioButton47Id);
	        vv = (RadioButton) findViewById(R.id.radioButton48Id);
	        ww = (RadioButton) findViewById(R.id.radioButton49Id);
	        xx = (RadioButton) findViewById(R.id.radioButton50Id);
	        yy= (RadioButton) findViewById(R.id.radioButton51Id);
	        zz = (RadioButton) findViewById(R.id.radioButton52Id);
	        aaa = (RadioButton) findViewById(R.id.radioButton54Id);
	        bbb = (RadioButton) findViewById(R.id.radioButton55Id);
	        ccc= (RadioButton) findViewById(R.id.radioButton56Id);
	        ddd= (RadioButton) findViewById(R.id.radioButton57Id);
	        eee= (RadioButton) findViewById(R.id.radioButton58Id);
	        fff= (RadioButton) findViewById(R.id.radioButton59Id);
	        ggg= (RadioButton) findViewById(R.id.radioButton60Id);
	        hhh= (RadioButton) findViewById(R.id.radioButton61Id);
	        iiii= (RadioButton) findViewById(R.id.radioButton62Id);
	        jjj= (RadioButton) findViewById(R.id.radioButton63Id);
	        kkk= (RadioButton) findViewById(R.id.radioButton64Id);
	        lll= (RadioButton) findViewById(R.id.radioButton65Id);
	        mmm= (RadioButton) findViewById(R.id.radioButton66Id);
	        nnn= (RadioButton) findViewById(R.id.radioButton67Id);
	        ooo= (RadioButton) findViewById(R.id.radioButton68Id);
	        ppp= (RadioButton) findViewById(R.id.radioButton69Id);
	        qqq = (RadioButton) findViewById(R.id.radioButton70Id);
	        Boolean mycheck = CheckVariable.checkme;
	        checkBox11.setChecked(mycheck);
	        
	      
	        
	        
	     radioGroup12 = (RadioGroup) findViewById(R.id.radioGroup);
	     radioGroup12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	            @Override
	            public void onCheckedChanged(RadioGroup radioGroup, int i) {
	            	File internalStorageDir =  getApplicationContext().getFilesDir();
    				StorageFile sf = new StorageFile();
    				String filepath="";
    				
	            	//finding file path for access number to store
	            	try {
	        				
	        				File devfile = new File(internalStorageDir, "/numberone");
	        				if (!devfile.exists()){
	        					devfile.mkdir();
	        				}
	        				filepath = devfile+"/accessno.txt";
	        			    
	        		
	        		} catch (Exception e) {
	        			// TODO Auto-generated catch block
	        			e.printStackTrace();
	        		}
	            	
	            	
	                switch (i){
	                
	                case R.id.radioButton54Id:
                    	str = (String) aaa.getText();
                    	System.out.println(str);
                    	 item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent it = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	                  	  it.setAction(SipManager.ACTION_SIP_DIALER);
	                  	  it.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(it);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton55Id:
                    	str = (String) bbb.getText();
                    	System.out.println(str);
                    	 item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent kq = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		kq.setAction(SipManager.ACTION_SIP_DIALER);
	               		kq.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(kq);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton56Id:
                    	str = (String) ccc.getText();
                    	System.out.println(str);
                    	 item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent itht = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		itht.setAction(SipManager.ACTION_SIP_DIALER);
	               		itht.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(itht);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton57Id:
                    	str = (String) ddd.getText();
                    	System.out.println(str);
                    	 item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent iqwt = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		iqwt.setAction(SipManager.ACTION_SIP_DIALER);
	               		iqwt.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(iqwt);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton58Id:
                    	str = (String) eee.getText();
                    	System.out.println(str);
                    	 item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent ihfgt = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		ihfgt.setAction(SipManager.ACTION_SIP_DIALER);
	               		ihfgt.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(ihfgt);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton59Id:
                    	str = (String) fff.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent hds = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		hds.setAction(SipManager.ACTION_SIP_DIALER);
	               		hds.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(hds);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton60Id:
                    	str = (String) ggg.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent itp = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		itp.setAction(SipManager.ACTION_SIP_DIALER);
	               		itp.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(itp);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton61Id:
                    	str = (String) hhh.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent ita = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		ita.setAction(SipManager.ACTION_SIP_DIALER);
	               		ita.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(ita);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton62Id:
                    	str = (String) iiii.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent itt = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		itt.setAction(SipManager.ACTION_SIP_DIALER);
	               		itt.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(itt);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton63Id:
                    	str = (String) jjj.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent iqt = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		iqt.setAction(SipManager.ACTION_SIP_DIALER);
	               		iqt.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(iqt);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton64Id:
                    	str = (String) kkk.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent ity = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		ity.setAction(SipManager.ACTION_SIP_DIALER);
	               		ity.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(ity);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton65Id:
                    	str = (String) lll.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent itl = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		itl.setAction(SipManager.ACTION_SIP_DIALER);
	               		itl.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(itl);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton66Id:
                    	str = (String) mmm.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent hj = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		hj.setAction(SipManager.ACTION_SIP_DIALER);
	               		hj.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(hj);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton67Id:
                    	str = (String) nnn.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent ijt = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		ijt.setAction(SipManager.ACTION_SIP_DIALER);
	               		ijt.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(ijt);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton68Id:
                    	str = (String) ooo.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent idt = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		idt.setAction(SipManager.ACTION_SIP_DIALER);
	               		idt.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(idt);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
	                
	                case R.id.radioButton69Id:
                    	str = (String) ppp.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent itf = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		itf.setAction(SipManager.ACTION_SIP_DIALER);
	               		itf.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(itf);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                        
	                case R.id.radioButton70Id:
                    	str = (String) qqq.getText();
                    	System.out.println(str);
                    	 //item=str.replaceAll("[a-zA-Z,]+", "");
                    	
                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		  Intent iti = new Intent(Accessno.this,SipHome.class);
	                  	//  it.putExtra("did",str);
	               		iti.setAction(SipManager.ACTION_SIP_DIALER);
	               		iti.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
	                  	  startActivity(iti);
                    	
                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
	                
	                
	                
	                    case R.id.radioButton1Id:
	                    	str = "+431253022432";
	                    	System.out.println("DEVTADIYAL "+str);
	                    	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	
	                    	  msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		  Intent itc = new Intent(Accessno.this,SipHome.class);
		                  	//  it.putExtra("did",str);
		               		itc.setAction(SipManager.ACTION_SIP_DIALER);
		               		itc.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
		                  	  startActivity(itc);
	                    	
	                        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
	                        break;
	                    case R.id.radioButton2Id:
	                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFFF00"));
	                    	str = "+431253022432";
	                    	System.out.println(str);
	                    	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	/* item=str.replaceAll("[a-zA-Z,]+", "");
	               		  System.out.println("xxxxxxxxxxxxxxxxxx"+item);*/
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
	               		 Intent mmm = new Intent(Accessno.this,SipHome.class);
		                  	//  it.putExtra("did",str);
		                  	  mmm.setAction(SipManager.ACTION_SIP_DIALER);
		                  	  mmm.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
		                  	  startActivity(mmm);
	                    	
	                    	
	                        break;
	                    case R.id.radioButton3Id:
	                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF00FF"));
	                    	str = "+3235009392";
	                    	System.out.println(str);
	                    	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent nnn = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  nnn.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  nnn.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(nnn);
		               		  
	                        break;
	                    case R.id.radioButton4Id:
	                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+16475032850";
	                    	System.out.println(str); 
	                    	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		  System.out.println("xxxxxxxxxxxxxxxxxx"+item);
		               		 Intent bbb = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  bbb.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  bbb.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(bbb);
	                        break;
	                        
	                    case R.id.radioButton5Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+35724000361";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		  System.out.println("xxxxxxxxxxxxxxxxxx"+item);
		               		 Intent vvv = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  vvv.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  vvv.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(vvv);
		                        break;
		                        
	                    case R.id.radioButton6Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+358974790011";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		  System.out.println("xxxxxxxxxxxxxxxxxx"+item);
		               		 Intent ccc = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  ccc.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  ccc.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(ccc);
		                        break;
		                        
	                    case R.id.radioButton7Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+33170069889";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		  System.out.println("xxxxxxxxxxxxxxxxxx"+item);
		               		 Intent xxx = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  xxx.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  xxx.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(xxx);
		                        break;
		                        
	                    case R.id.radioButton8Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+302111983955";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		  System.out.println("xxxxxxxxxxxxxxxxxx"+item);
		               		 Intent zzz = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  zzz.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  zzz.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(zzz);
		                        break;
		                        
	                    case R.id.radioButton9Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+911171279007";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		  System.out.println("xxxxxxxxxxxxxxxxxx"+item);
		               		 Intent aaa = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  aaa.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  aaa.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(aaa);
		                        break;
		                        
	                    case R.id.radioButton10Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+35314373285";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent sss = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  sss.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  sss.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(sss);
		                        break;
		                        
	                    case R.id.radioButton11Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+390645200147";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent ddd = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  ddd.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  ddd.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(ddd);
		                        break;
		                        
	                    case R.id.radioButton12Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+31202620339";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent fff = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  fff.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  fff.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(fff);
		                        break;
		                        
	                    case R.id.radioButton13Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "40213039730";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent ggg = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  ggg.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  ggg.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(ggg);
		                        break;
		                        
	                    case R.id.radioButton14Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+40374337218";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent hhh = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  hhh.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  hhh.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(hhh);
		                        break;
		                        
	                    case R.id.radioButton15Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+40374337217";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent jjj = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  jjj.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  jjj.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(jjj);
		                        break;
		                        
	                    case R.id.radioButton16Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+40372128620";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent kkk = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  kkk.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  kkk.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(kkk);
		                        break;
		                        
	                    case R.id.radioButton17Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+48221168155";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent lll = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  lll.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  lll.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(lll);
		                        break;
		                        
	                    case R.id.radioButton18Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+34910807961";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 
		               		 Intent ppp = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  ppp.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  ppp.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(ppp);
		                        break;
		                        
	                    case R.id.radioButton19Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+41225550261";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent ooo = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  ooo.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  ooo.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(ooo);
		                        break;
		                        
	                    case R.id.radioButton20Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+908503901931";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent uuu = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  uuu.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  uuu.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(uuu);
		                        break;
		                        
	                    case R.id.radioButton21Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+442078626345";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent yyy = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  yyy.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  yyy.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(yyy);
		                        break;
		                        
	                    case R.id.radioButton22Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+1989898";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent ttt = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  ttt.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  ttt.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(ttt);
		                        break;
		                        
	                    case R.id.radioButton23Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+35627780352";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent rrr = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  rrr.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  rrr.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(rrr);
		                        break;
		                        
	                    case R.id.radioButton24Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+49211361894722";
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent eee = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  eee.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  eee.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(eee);
		                        break;
		                        
	                    case R.id.radioButton25Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) y.getText();
	                    	System.out.println(str);
	                     	 item=str.replaceAll("[a-zA-Z,]+", "");
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent www = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  www.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  www.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(www);
		                        break;
		                        
	                    case R.id.radioButton26Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) z.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent qqq = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  qqq.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  qqq.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(qqq);
		                        break;
		                    
	                    case R.id.radioButton27Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) aa.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent m = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  m.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  m.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(m);
		                        break;
		                        
	                    case R.id.radioButton28Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) bb.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent n = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  n.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  n.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(n);
		                        break;
		                        
	                    case R.id.radioButton29Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) cc.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent b = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  b.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  b.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(b);
		                        break;
		                        
	                    case R.id.radioButton30Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) dd.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent v = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  v.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  v.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(v);
		                        
	                    case R.id.radioButton31Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) ee.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent c = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  c.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  c.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(c);
		                        break;
		                        
	                    case R.id.radioButton32Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) ff.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent x = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  x.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  x.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(x);
		                        break;
		                        
	                    case R.id.radioButton33Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) gg.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent z = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  z.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  z.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(z);
		                        break;
		                        
	                    case R.id.radioButton34Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) hh.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent a = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  a.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  a.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(a);
		                        break;
		                        
	                    case R.id.radioButton35Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) ii.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent s = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  s.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  s.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(s);
		                        break;
		                        
	                    case R.id.radioButton36Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) jj.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent d = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  d.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  d.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(d);
		                        break;
		                        
	                    case R.id.radioButton37Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) kk.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent f = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  f.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  f.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(f);
		                        break;
		                        
	                    case R.id.radioButton38Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) ll.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent g = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  g.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  g.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(g);
		                        break;
		                        
	                    case R.id.radioButton39Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) mm.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent h = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  h.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  h.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(h);
		                        break;
		                        
	                    case R.id.radioButton40Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) nn.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent j = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  j.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  j.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(j);
		                        break;
		                        
	                    case R.id.radioButton41Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) oo.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent k = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  k.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  k.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(k);
		                        break;
		                        
	                    case R.id.radioButton42Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) pp.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent l = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  l.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  l.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(l);
		                        break;
		                        
	                    case R.id.radioButton43Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) qq.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent p = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  p.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  p.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(p);
		                        break;
		                        
	                    case R.id.radioButton44Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) rr.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent o = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  o.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  o.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(o);
		                        break;
		                        
	                    case R.id.radioButton45Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) ss.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent ii = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  ii.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  ii.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(ii);
		                        break;
		                        
	                    case R.id.radioButton46Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) tt.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent u = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  u.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  u.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(u);
		                        break;
		                        
	                    case R.id.radioButton47Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) uu.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent y = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  y.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  y.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(y);
		                        break;
		                        
	                    case R.id.radioButton48Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) vv.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent t = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  t.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  t.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(t);
		                        break;
		                        
	                    case R.id.radioButton49Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) ww.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent r = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  r.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  r.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(r);
		                        break;
		                        
	                    case R.id.radioButton50Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = (String) xx.getText();
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent e = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  e.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  e.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(e);
		                        break;
		                        
	                    case R.id.radioButton51Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+35627780352";
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent w = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  w.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  w.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(w);
		                        break;
		                        
	                    case R.id.radioButton52Id:
		                       // getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
	                    	str = "+49211361894722";
	                    	System.out.println(str);
	                    	msg = sf.writeStorageFile(filepath,str.replaceAll("[a-zA-Z,]+", "")); 
	                    	 System.out.println("HEmant "+msg+":File path "+filepath);
		               		 Intent q = new Intent(Accessno.this,SipHome.class);
			                  	//  it.putExtra("did",str);
			                  	  q.setAction(SipManager.ACTION_SIP_DIALER);
			                  	  q.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
			                  	  startActivity(q);
		                        break;
		                        
		                        
	                }
	            }
	    });

	   
	   }
	   
	
	   
	   
	   
	   public void onClick(View v) {
	     	 
	     	 
	     	  if(checkBox11.isChecked()){
	     		  CheckVariable.checkme=true;
	     		 bool = checkBox11.isChecked();
	     		  System.out.println(bool);
	     		/* Intent q = new Intent(Accessno.this,SipHome.class);
               	//  it.putExtra("did",str);
               	  q.setAction(SipManager.ACTION_SIP_DIALER);
               	  q.setData(SipUri.forgeSipUri(SipManager.PROTOCOL_SIP, ""));
               	  startActivity(q);*/
	     		  
	     	  }
	     	  else
	     	  {
	     		 CheckVariable.checkme=false;
	     	  }
	     	 
	     	}
	   
	   
	   
	}