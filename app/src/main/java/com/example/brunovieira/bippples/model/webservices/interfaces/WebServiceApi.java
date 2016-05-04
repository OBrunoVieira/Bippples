package com.example.brunovieira.bippples.model.webservices.interfaces;

import com.example.brunovieira.bippples.model.entities.ShotsVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public interface WebServiceApi {

    /*
     * GET
     */
    @GET("shots")
    Call<List<ShotsVO>> getShotsList(@Query("access_token") String accessToken);


    /*
     * PUT
     */



    /*
     * POST
     */



    /*
     * DELETE
     */

}
