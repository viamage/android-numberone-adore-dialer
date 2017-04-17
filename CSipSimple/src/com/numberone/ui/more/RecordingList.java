package com.numberone.ui.more;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.numberone.R;

public class RecordingList extends Activity {
	private static final String THIS_FILE = "file activity";
	ListView records;
	ArrayAdapter<String> adapter;
	ArrayAdapter<File> adapter1;
	String[] record;
	ArrayList<File> recordings=new ArrayList<File>();

	// ,stopped=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recording_list);
		records = (ListView) findViewById(R.id.records);

		try {
			Log.e(THIS_FILE, "IN 33");
			recordings=populateAdapter();
			if (recordings != null) {
				Log.e(THIS_FILE, "IN 36");
				adapter1 = new RecordListAdapter(this,recordings);
				records.setAdapter(adapter1);
			} else {
				adapter = new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, record);
				records.setAdapter(adapter);
			}
			
			records.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					try {
						Intent intent = new Intent(RecordingList.this, Player.class);
						String f=((File)records.getAdapter().getItem(position)).getName();
						
						intent.putExtra("media-file", f);
						startActivity(intent);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
			});
			records.setOnItemLongClickListener(new OnItemLongClickListener(){

				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
						int position, long id) {
					try {
						final File f=(File)records.getAdapter().getItem(position);
						
						new AlertDialog.Builder(RecordingList.this)
								.setTitle("Delete File")
								.setMessage(
										"Are you sure you want to delete this recording.")
								.setNeutralButton("OK", new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog, int which) {
										// anurag
										if(f.delete()){
											((BaseAdapter)records.getAdapter()).notifyDataSetChanged();
											Toast.makeText(RecordingList.this,"File Deleted", Toast.LENGTH_SHORT).show();
										}
											else
										Toast.makeText(RecordingList.this,"File not Deleted", Toast.LENGTH_SHORT).show();
										
									}
								})
								.setNegativeButton("Cancel",
										new DialogInterface.OnClickListener() {

											public void onClick(DialogInterface dialog,
													int which) {
												// TODO Auto-generated method stub
												// anurag.
											}
										}).show();


						return false;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
				}

			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onPause() {
		super.onPause();

	}

	public void onResume() {
		super.onResume();
		/*
		 * if(stopped) findViewById(R.id.controls).setVisibility(View.GONE);
		 * else findViewById(R.id.controls).setVisibility(View.VISIBLE);
		 */
	}

	private ArrayList<File> populateAdapter() {
		ArrayList<File> recordings=new ArrayList<File>();
		final String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			File file = new File("mnt/sdcard/AdoreSoftphone/records");// Environment.getExternalStorageDirectory();
			Log.e(THIS_FILE, file.getName());
			File f[] = file.listFiles();
			Log.e(THIS_FILE, Integer.toString(f.length));
			for (int i = 0; i < (f.length - 1); i++) {
				recordings.add(f[i]);
				Log.e(THIS_FILE, recordings.get(i).getName());
			}
			record = file.list();
			return recordings;
		}
		else {
			record = new String[] { "No SD Card Found" };
			return null;
		}
		
	}

}
/*

*/