package com.andrewaprianto.myroom;

import android.os.AsyncTask;

import com.andrewaprianto.myroom.adapter.ContactsAdapter;
import com.andrewaprianto.myroom.db.entity.Contact;
import com.andrewaprianto.myroom.db.entity.ContactsAppDatabase;

import java.util.ArrayList;

public class AsyncCreateContact extends AsyncTask<Contact, Void, Void> {

    private ContactsAppDatabase contactsAppDatabase;
    private ContactsAdapter contactsAdapter;
    private ArrayList<Contact> contactArrayList;

    public AsyncCreateContact(ContactsAppDatabase contactsAppDatabase,
                              ContactsAdapter contactsAdapter, ArrayList<Contact> contactArrayList)
    {
        this.contactsAppDatabase = contactsAppDatabase;
        this.contactsAdapter = contactsAdapter;
        this.contactArrayList = contactArrayList;
    }

    @Override
    protected Void doInBackground(Contact... contacts) {
        long id = contactsAppDatabase.getContactDAO().addContact(contacts[0]);

        Contact contact = contactsAppDatabase.getContactDAO().getContact(id);

        if(contact != null){
            contactArrayList.add(0, contact);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        contactsAdapter.notifyDataSetChanged();
    }
}
