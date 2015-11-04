package com.example.faisal.test1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        RestAdapter rest = new RestAdapter.Builder().setEndpoint("http://192.168.100.124:8888/api").build() ;
        API api = rest.create(API.class) ;
        user u = new user() ;
        u.setEmail("adfadfa@fsfsf.com");
        u.setPassword("121212");
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
        user u = new user() ;
        u.setEmail("adfadfa@fsfsf.com");
        u.setPassword("121212");
        RestAdapter rest = new RestAdapter.Builder().setEndpoint("http://192.168.100.124:8888/api").build() ;
        final API api = rest.create(API.class) ;
        Button login = (Button) findViewById(R.id.button);
        final EditText username = (EditText) findViewById(R.id.editText);
        final EditText password = (EditText) findViewById(R.id.editText2);
        login.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {

                String userName = username.getText().toString() ;
                String pwd = password.getText().toString() ;


                api.creaUser(u, new Callback<response>() {
                    @Override
                    public void success(response response, Response response2) {

                        Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT) .show(); ;

                    }

                    @Override
                    public void failure(RetrofitError error) {


                        Toast.makeText(MainActivity.this,"nooooo",Toast.LENGTH_SHORT) .show(); ;



                    }
                });





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
