package com.andrewaprianto.myroom;

import android.os.AsyncTask;

import com.andrewaprianto.myroom.adapter.ContactsAdapter;
import com.andrewaprianto.myroom.db.entity.Contact;
import com.andrewaprianto.myroom.db.entity.ContactsAppDatabase;

public class AsyncUpdateContact extends AsyncTask<Contact, Void, Void> {

    private ContactsAppDatabase contactsAppDatabase;
    private ContactsAdapter contactsAdapter;

    public AsyncUpdateContact(ContactsAppDatabase contactsAppDatabase,
                              ContactsAdapter contactsAdapter) {
        this.contactsAppDatabase = contactsAppDatabase;
        this.contactsAdapter = contactsAdapter;
    }

    @Override
    protected Void doInBackground(Contact... contacts) {
        contactsAppDatabase.getContactDAO().updateContact(contacts[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        contactsAdapter.notifyDataSetChanged();
    }
}
