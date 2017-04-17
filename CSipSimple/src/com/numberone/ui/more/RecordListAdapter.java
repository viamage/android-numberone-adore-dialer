package com.numberone.ui.more;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.numberone.R;

public class RecordListAdapter extends ArrayAdapter<File> {
	private LayoutInflater vi;
	private static int mResource = R.layout.record_item;

	public RecordListAdapter(Activity activity, final List<File> items) {
		super(activity, mResource, items);
		vi = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public static class ViewHolder {
		private TextView name;
		private TextView size;
		private TextView time;

		public ViewHolder(View v) {
			this.name = (TextView) v
					.findViewById(R.id.rname);
			this.size = (TextView) v
					.findViewById(R.id.rsize);
			this.time = (TextView) v
					.findViewById(R.id.rtime);
		}
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = vi.inflate(mResource, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		final File item = getItem(position);
		if (item != null) {
			holder.name
					.setText(item.getName());
			String s=Long.toString((item.length())/1024)+"Kb";
			holder.size.setText(s);
			SimpleDateFormat sdf= new SimpleDateFormat("MMM dd,yyyy HH:mm");
			Date date=new Date(item.lastModified());
			holder.time.setText(sdf.format(date));
			

		}
		return convertView;
	}
}
