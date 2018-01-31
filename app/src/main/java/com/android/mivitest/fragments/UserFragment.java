package com.android.mivitest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.mivitest.Collection;
import com.android.mivitest.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        TextView userName = view.findViewById(R.id.username);
        TextView dob = view.findViewById(R.id.dob);
        TextView number= view.findViewById(R.id.number);
        TextView email = view.findViewById(R.id.email);

        try {
            Collection data = new Collection();
            JSONObject response = data.getJsonData();

            JSONObject accountData = response.getJSONObject("data");
            JSONObject accountInfo = accountData.getJSONObject("attributes");

            userName.setText("Name - " + accountInfo.getString("title") + " " + accountInfo.getString("first-name")
                                + " " + accountInfo.getString("last-name"));
            dob.setText("DOB - " + accountInfo.getString("date-of-birth"));
            number.setText("Contact - " + accountInfo.getString("contact-number"));
            email.setText("Email - " + accountInfo.getString("email-address"));

        } catch (JSONException e) {
            e.printStackTrace();
        }



        return view;
    }

}
