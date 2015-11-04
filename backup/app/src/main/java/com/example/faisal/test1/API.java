package com.example.faisal.test1;


import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Faisal on 10/15/15.
 */


public interface API {

    @POST("/user")
    void creaUser(@Body user user, Callback<response> userCallback) ;


    @GET("/users")
    void allUsers(Callback<List<user>> users);





}
