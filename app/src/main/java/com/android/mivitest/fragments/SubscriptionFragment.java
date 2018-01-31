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
public class SubscriptionFragment extends Fragment {


    public SubscriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subscription, container, false);

        TextView balanceTxt = view.findViewById(R.id.balance);
        TextView expiryDateTxt = view.findViewById(R.id.expired_date);

        try {
            Collection data = new Collection();
            JSONObject response = data.getJsonData();
            JSONArray productsArray = response.getJSONArray("included");
            JSONObject productsData = productsArray.getJSONObject(1);
            JSONObject product = productsData.getJSONObject("attributes");

            balanceTxt.setText("Balance - " + product.getString("included-data-balance"));
            expiryDateTxt.setText("Expired Date - " + product.getString("expiry-date"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return view;
    }

}
