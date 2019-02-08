package com.appsmontreal.internetproviders;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appsmontreal.internetproviders.model.Animation;
import com.appsmontreal.internetproviders.model.Sound;
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
    Sound sound = new Sound(this);
    String newString ="";
    Animation animation = new Animation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        customers = (ArrayList<User>) getIntent().getExtras().getSerializable("Usr");





        for (int x = 0; x < customers.size(); x++){
            newString += customers.get(x).toString();
            Log.d(TAG1,customers.get(x).toString());
        }
        Toast.makeText(this,"Total user   =>   " + customers.size(),Toast.LENGTH_LONG).show();
        editTextUser.setText(newString);
        initialize();

    }

    private void initialize(){
        btnEmail = (Button)findViewById(R.id.buttonEmail);
        btnReturn = (Button)findViewById(R.id.buttonReturn);
        btnEmail.setOnClickListener(this);
        btnReturn.setOnClickListener(this);
//        sound = new Sound(this);
    }

    public void sendEmail(){
        Intent intentEmail = new Intent(Intent.ACTION_SENDTO);
        intentEmail.setType("message/rfc822");
        intentEmail.setData(Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_EMAIL  , new String[]{"escobar.marlon@gmail.com"});
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Internet Providers");
        intentEmail.putExtra(Intent.EXTRA_TEXT   , "USER ID ..................... COMPANY\n\n" + newString);
        try {
            startActivity(Intent.createChooser(intentEmail, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Email service was not found in this phone.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        animation.buttonRotateYanimation((Button) v);
        switch (v.getId()){
            case R.id.buttonReturn :
                sound.chargeSound("return");
                finish();
                break;

            case R.id.buttonEmail :
                sound.chargeSound("next");
                sendEmail();
                break;
        }

    }
}
