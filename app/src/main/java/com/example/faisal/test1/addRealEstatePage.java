package com.example.faisal.test1;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class addRealEstatePage extends AppCompatActivity {


    private static int RESULT_LOAD_IMAGE = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_real_estate_page);

        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);







        btnCLicked() ;




        buttonLoadImage.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }



        });
    }

    private void btnCLicked() {

        final TextView price = (TextView) findViewById(R.id.price) ;
        final TextView Neighborhood = (TextView) findViewById(R.id.realEstateNeighborhood) ;
        TextView dec = (TextView) findViewById(R.id.Description) ;
        Button click = (Button) findViewById(R.id.button) ;
        RestAdapter rest = new RestAdapter.Builder().setEndpoint("http://10.131.203.127:8888/api").build() ;
        final API api = rest.create(API.class) ;
        final realEstate real = new realEstate() ;

        click.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                real.setPrice(price.getText().toString());
                real.setNeighborhood(Neighborhood.getText().toString());
                //real.setLocation_lacationID();
                //real.setAgent_agentEmail();
                api.creatrealEstate(real, new Callback<response>() {
                    @Override
                    public void success(response response, Response response2) {
                        Toast.makeText(addRealEstatePage.this, "your registeration has been successful", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(addRealEstatePage.this, "errorin adding estate", Toast.LENGTH_SHORT).show();
                        ;
                    }
                });






            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }







}