package com.andrewaprianto.myroom;

import android.os.AsyncTask;

import com.andrewaprianto.myroom.adapter.ContactsAdapter;
import com.andrewaprianto.myroom.db.entity.Contact;
import com.andrewaprianto.myroom.db.entity.ContactsAppDatabase;

import java.util.ArrayList;

public class AsyncGetAllContact extends AsyncTask<Void, Void, Void> {

    private ContactsAppDatabase contactsAppDatabase;
    private ContactsAdapter contactsAdapter;
    private ArrayList<Contact> contactArrayList;

    public AsyncGetAllContact(ContactsAppDatabase contactsAppDatabase,
                              ContactsAdapter contactsAdapter, ArrayList<Contact> contactArrayList)
    {
        this.contactsAppDatabase = contactsAppDatabase;
        this.contactsAdapter = contactsAdapter;
        this.contactArrayList = contactArrayList;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        contactArrayList.addAll(contactsAppDatabase.getContactDAO().getAllContacts());
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        contactsAdapter.notifyDataSetChanged();
    }
}
