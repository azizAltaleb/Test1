package com.example.faisal.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RegsiterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter_page);
        btnClicked();

    }
        private void btnClicked() {
        RestAdapter rest = new RestAdapter.Builder().setEndpoint("http://172.20.10.7:8888/api").build() ;
        API api = rest.create(API.class) ;
        user u = new user() ;




            Button register = (Button) findViewById(R.id.register);
            final RadioButton customer = (RadioButton) findViewById(R.id.radioButton2) ;
            RadioButton agent = (RadioButton) findViewById(R.id.radioButton) ;


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = (EditText) findViewById(R.id.email);
                EditText password = (EditText) findViewById(R.id.password);
                EditText username = (EditText) findViewById(R.id.username);
                EditText phoneNumber = (EditText) findViewById(R.id.phonenumber);
                String Email = email.getText().toString();
                String pwd = password.getText().toString();
                String us= username.getText().toString();
                String pn=phoneNumber.getText().toString();
                user u = new user() ;
                agent g = new agent() ;
                u.setUsername(Email);
                u.setPassword(pwd);
                u.setName(us);
                u.setPhoneNumber(pn);
                RestAdapter rest = new RestAdapter.Builder().setEndpoint("http://172.20.10.7:8888/api").build() ;
                API api = rest.create(API.class) ;

                if(customer.isChecked() == true ) {

                    api.creaUser(u, new Callback<response>() {
                        @Override
                        public void success(response response, Response response2) {
                            Toast.makeText(RegsiterPage.this, "your registeration has been successful", Toast.LENGTH_SHORT).show();
                            try {
                                synchronized (this) {
                                    wait(3000);
                                }
                            } catch (InterruptedException ex) {
                            }
                            ;
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(RegsiterPage.this, "your email already registred with us", Toast.LENGTH_SHORT).show();
                            ;
                        }
                    });
                }else {
                    g.setAgentEmail(Email);
                    g.setAgentName(us);
                    g.setAgentNumber(pn);
                    g.setAgentPassword(pwd);
                    api.creatAgent(g, new Callback<response>() {
                        @Override
                        public void success(response response, Response response2) {
                            Toast.makeText(RegsiterPage.this, "your registeration as agent has been successful", Toast.LENGTH_SHORT).show();
                            try {
                                wait(3000) ;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(RegsiterPage.this, "your email already registred with us", Toast.LENGTH_SHORT).show();

                        }
                    });

                }

            }
        });




    }






}