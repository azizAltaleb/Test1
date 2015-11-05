package com.example.faisal.test1;

//fadfadfadsfadfadfa


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClicked() ;





       /* api.creaUser(u, new Callback<response>() {
            @Override
            public void success(response response, Response response2) {

                Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT) .show(); ;

            }

            @Override
            public void failure(RetrofitError error) {


                Toast.makeText(MainActivity.this,"nooooo",Toast.LENGTH_SHORT) .show(); ;



            }
        });*/


// the exection
        /*api.allUsers(new Callback<List<user>>() {
            @Override
            public void success(List<user> users, Response response) {
                Toast.makeText(MainActivity.this, users.get(0).getEmail() + "", Toast.LENGTH_SHORT).show();
                ;

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });*/

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void btnClicked() {

        Button signup = (Button) findViewById(R.id.signup) ;
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        user u = new user() ;
        u.setUsername(email.toString());
        u.setPassword(password.toString());
        RestAdapter rest = new RestAdapter.Builder().setEndpoint("http://172.20.10.7:8888/api").build() ;
        final API api = rest.create(API.class) ;
        Button login = (Button) findViewById(R.id.login);
        u.setUsername(email.getText().toString().toString());
        u.setPassword(password.getText().toString());


        ///// sing up page

        signup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent i = new Intent(getApplicationContext(), RegsiterPage.class);
                        startActivity(i);

            }
        });

            ///////

        login.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), HomePage.class) ;
                startActivity(i);


                api.allUsers(new Callback<List<user>>() {
                    @Override
                    public void success(List<user> users, Response response) {
                        String[] users_from_data = (String[]) users.toArray();
                        //Toast.makeText(MainActivity.this, users_from_data[1].equals(users_from_data[2]) + "", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, users.size() + "", Toast.LENGTH_SHORT).show();
                        int counter = 0;
                        /*
                        while (counter != users_from_data.length) {

                            if (users_from_data[counter].equals(email)) {

                                Intent i = new Intent(getApplicationContext(), HomePage.class);
                                startActivity(i);
                            } else {
                                counter++;
                            }


                        }*/
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(MainActivity.this, "email or password is error , plz check agin" + "", Toast.LENGTH_SHORT).show();

                    }
                });


                // the post code and it's works
                /*api.creaUser(u, new Callback<response>() {
                    @Override
                    public void success(response response, Response response2) {
                        t.setText(email.getText().toString().indexOf(1)) ;

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        t.setText("nooo");
                    }
                });
                */





















            }




        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
