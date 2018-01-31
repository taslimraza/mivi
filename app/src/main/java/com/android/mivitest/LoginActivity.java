package com.android.mivitest;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText msnTxt, passwordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        msnTxt = (EditText) findViewById(R.id.msn_id);
        passwordTxt = (EditText) findViewById(R.id.password);
        Button loginBtn = (Button) findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:
                login();
                break;
        }
    }

    private void login() {
        hideKeyboard();
        String msn = msnTxt.getText().toString();
        String password = passwordTxt.getText().toString();

        try {

            Collection data = new Collection();
            JSONObject response = data.getJsonData();
            JSONArray productsArray = response.getJSONArray("included");
            JSONObject productsData = productsArray.getJSONObject(0);
            JSONObject account = productsData.getJSONObject("attributes");

            String msnId = account.getString("msn");

            if(msn.equals(msnId)){
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }else {
                Toast.makeText(this, "Invalid Email or Password!", Toast.LENGTH_SHORT).show();
            }

            Log.i("Response", response.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
