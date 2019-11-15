package com.liveinbits.internshiptest.api;

import com.liveinbits.internshiptest.models.Items;
import com.liveinbits.internshiptest.models.ListItems;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
//repositories?q=android+org:google
    @GET("/search/repositories?q=android+org:google")
    Call<ListItems> getItems();
}
