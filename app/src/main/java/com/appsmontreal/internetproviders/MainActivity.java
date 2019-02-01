package com.appsmontreal.internetproviders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.appsmontreal.internetproviders.model.Sound;
import com.appsmontreal.internetproviders.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSave;
    Button btnNew;
    Button btnNext;
    Button btnExit;
    EditText editTextClientNumber;
    RadioGroup radioGroupProviders;
    ArrayList<User> userList;
    Sound sound = new Sound(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize(){
        btnNew = (Button)findViewById(R.id.buttonNew);
        btnNext = (Button)findViewById(R.id.buttonNext);
        btnSave = (Button)findViewById(R.id.buttonSave);
        btnExit = (Button)findViewById(R.id.buttonExit);
        editTextClientNumber = (EditText)findViewById(R.id.editTextClientNumber);
        radioGroupProviders = (RadioGroup)findViewById(R.id.radioGroupProviders);
        btnNew.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        editTextClientNumber.requestFocus();
        userList = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {
        Intent myIntent;
        User user;


        switch (v.getId()){

            case R.id.buttonNew :
                radioGroupProviders.clearCheck();
                editTextClientNumber.setText(null);
                editTextClientNumber.requestFocus();
                sound.chargeSound("new");
                break;

            case R.id.buttonSave :
                try {
                    int idUser = Integer.valueOf(editTextClientNumber.getText().toString());
                    int provider = 0;
                    int rbId = radioGroupProviders.getCheckedRadioButtonId();
                    sound.chargeSound("save");

                    switch (rbId) {
                        case R.id.radioButtonBell:
                            provider = 1;
                            break;

                        case R.id.radioButtonFido:
                            provider = 2;
                            break;

                        case R.id.radioButtonBravo:
                            provider = 3;
                            break;

                        case R.id.radioButtonVideotron:
                            provider = 4;
                            break;

                    }
                    user = new User(idUser, provider);
                    userList.add(user);
                    Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();


                }
                catch (Exception e){
                    Toast.makeText(this,"Please Fill up all blank spaces",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.buttonNext :
                myIntent = new Intent(this,PrintActivity.class);
                myIntent.putExtra("Usr",(ArrayList<User>)userList);
                startActivity(myIntent);
                sound.chargeSound("next");
                break;

            case R.id.buttonExit :
                finish();
                sound.chargeSound("exit");
                break;
        }
//        sound.releaseSound();

    }
}
