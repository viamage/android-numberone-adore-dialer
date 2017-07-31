package com.numberonecall.ui.contacts;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.util.Log;

public class Storage {
	private final List<String> mContactName = new ArrayList<String>();
	private final List<String> mContactNumber = new ArrayList<String>();
	private final List<String> mContactId = new ArrayList<String>();
	List<ContactItem> list;
	private Context context;
	Storage(Context context){
		this.context=context;
	}
	public List<ContactItem> getItems() {		
		list = new ArrayList<ContactItem>();
		populateHashMap();
		for (final ContactItem entry : getContactEntries()) {
			list.add(entry);
		}
		return list;
	}
	 void addAdapter() {
		
	}
	private List<ContactItem> getContactEntries() {

		final List<ContactItem> entries = new ArrayList<ContactItem>();

		for (int i = 0; i < mContactName.size(); i++) {
			Bitmap bp = BitmapFactory.decodeStream(openPhoto(Long
					.parseLong(mContactId.get(i))));
			entries.add(new ContactItem(mContactName.get(i), bp,mContactNumber
					.get(i)));

		}
		
		return entries;
	}
	private void populateHashMap() {
		try {
			// Gets all the contacts from the phone Database.
			final Cursor cur = context.getContentResolver().query(
					ContactsContract.Data.CONTENT_URI,
					new String[] { ContactsContract.Data.DISPLAY_NAME,
							ContactsContract.Data.RAW_CONTACT_ID,
							ContactsContract.Data.MIMETYPE,
							ContactsContract.Data.DATA1 }, null, null,
					"UPPER("+Phone.DISPLAY_NAME + ") ASC");
			if (cur.moveToFirst()) {
				String contactName;
				String contactNumber;
				String contactId;
				do {
					contactName = cur.getString(cur
							.getColumnIndex(Data.DISPLAY_NAME));
					contactId = cur.getString(cur
							.getColumnIndex(Data.RAW_CONTACT_ID));
					if (cur.getString(cur.getColumnIndex(Data.MIMETYPE))
							.equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)) {
						contactNumber = cur.getString(cur
								.getColumnIndex(Data.DATA1));

						// TODO: fetch profile pic

						mContactName.add(contactName);
						mContactNumber.add(contactNumber);
						mContactId.add(contactId);
				
					}
				} while (cur.moveToNext());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public InputStream openPhoto(long contactId) {
		Uri contactUri = ContentUris.withAppendedId(Contacts.CONTENT_URI,
				contactId);
		Uri photoUri = Uri.withAppendedPath(contactUri,
				Contacts.Photo.CONTENT_DIRECTORY);
		Cursor cursor = context.getContentResolver().query(photoUri,
				new String[] { Contacts.Photo.PHOTO }, null, null, null);
		if (cursor == null) {
			return null;
		}
		try {
			if (cursor.moveToFirst()) {
				byte[] data = cursor.getBlob(0);
				if (data != null) {
					return new ByteArrayInputStream(data);
				}
			}
		} finally {
			cursor.close();
		}
		return null;
	}

}
