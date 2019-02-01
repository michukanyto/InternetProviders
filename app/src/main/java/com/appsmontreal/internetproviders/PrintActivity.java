package com.appsmontreal.internetproviders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appsmontreal.internetproviders.model.User;

import java.util.ArrayList;
import java.util.List;

public class PrintActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewUser;
    EditText editTextUser;
    String TAG1 ="USER";
    ArrayList<User> customers;
    Button btnEmail;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        customers = (ArrayList<User>) getIntent().getExtras().getSerializable("Usr");

        String newString ="";
        for (int x = 0; x < customers.size(); x++){
            newString += customers.get(x).toString();
            Log.d(TAG1,customers.get(x).toString());

        }
        Toast.makeText(this,newString,Toast.LENGTH_LONG).show();
        editTextUser.setText(newString);
        initialize();

    }

    private void initialize(){
        btnEmail = (Button)findViewById(R.id.buttonEmail);
        btnReturn = (Button)findViewById(R.id.buttonReturn);
        btnEmail.setOnClickListener(this);
        btnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonReturn :
                finish();
                break;

            case R.id.buttonEmail :
                finish();
                break;
        }

    }
}
