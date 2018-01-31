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
public class ProductsFragment extends Fragment {


    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        TextView productName = view.findViewById(R.id.product_name);
        TextView productPrice = view.findViewById(R.id.product_price);

        try {
            Collection data = new Collection();
            JSONObject response = data.getJsonData();
            JSONArray productsArray = response.getJSONArray("included");
            JSONObject productsData = productsArray.getJSONObject(2);
            JSONObject product = productsData.getJSONObject("attributes");

            productName.setText("Plan - " + product.getString("name"));
            productPrice.setText("Price - " + product.getString("price"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return view;
    }

}
