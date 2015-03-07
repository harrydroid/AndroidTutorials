package listviewex.example.com.androidtutorials;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import listviewex.example.com.androidtutorials.ContactInfo;
import listviewex.example.com.androidtutorials.R;

/**
 * Created by maheshgupta on 3/4/15.
 */
public class ListViewExample extends Activity {

    private ArrayList<ContactInfo> mContacts = null;

    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_example);
        initUI();
    }


    private void initContacts() {
        mContacts = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            String contactname = String.format("%c%c%c", i + 'a', i + 'a', i + 'a');
            String phoneNumber = String.format("" + i + "" + i + "" + i + "" + i);
            mContacts.add((new ContactInfo(contactname, phoneNumber)));
        }
    }


    private void initUI() {

        initContacts();

        listView = (ListView) findViewById(R.id.contactsListView);

        ContactsAdapter adapter = new ContactsAdapter(this, R.layout.row_contact, mContacts);

        listView.setAdapter(adapter);
    }


    /**
     * Create custom adapter.
     */

    private class ContactsAdapter extends ArrayAdapter<ContactInfo> {

        ArrayList<ContactInfo> mData;

        public ContactsAdapter(Context context, int resource, ArrayList<ContactInfo> objects) {
            super(context, resource, objects);
            this.mData = objects;
        }

        @Override
        public int getCount() {
            return this.mData.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ContactInfo info = null;

            TextView txtViewContactName = null;
            TextView txtViewInitals = null;
            TextView txtViewContactPhNum = null;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.row_contact, null, false);
            }

            txtViewContactName = (TextView) view.findViewById(R.id.txtViewContactName);
            txtViewInitals = (TextView) view.findViewById(R.id.txtViewInitial);
            txtViewContactPhNum = (TextView) view.findViewById(R.id.txtViewPhoneNumber);

            info = this.mData.get(position);

            txtViewInitals.setText("A");
            txtViewContactName.setText(info.contactName);
            txtViewContactPhNum.setText(info.phoneNumber);


            return view;
        }
    }


}
