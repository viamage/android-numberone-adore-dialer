package com.numberonecall.ui.contacts;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.numberonecall.R;

public class ContactListAdapter extends ArrayAdapter<ContactItem> {
	private LayoutInflater vi;
	private static int mResource = R.layout.contact_item_list;

	public ContactListAdapter(Activity activity, final List<ContactItem> items) {
		super(activity, mResource, items);
		vi = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public static class ViewHolder {
		private TextView name;
		private TextView number;
		private ImageView pic;

		public ViewHolder(View v) {
			this.name = (TextView) v
					.findViewById(R.id.contact_entry_title);
			this.number = (TextView) v
					.findViewById(R.id.contact_entry_subtitle);
			this.pic = (ImageView) v
					.findViewById(R.id.contact_entry_icon);
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

		final ContactItem item = getItem(position);
		if (item != null) {
			holder.name
					.setText(Html.fromHtml(item.getName()));
			holder.number.setText(item.getNumber());
			if (item.getBitmap() == null)
				holder.pic
						.setImageResource(R.drawable.ic_contact_picture_180_holo_dark);
			else
				holder.pic.setImageBitmap(item
						.getBitmap());

		}
		return convertView;
	}
}
