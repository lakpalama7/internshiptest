package com.liveinbits.internshiptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.liveinbits.internshiptest.api.ApiClient;
import com.liveinbits.internshiptest.api.ApiInterface;
import com.liveinbits.internshiptest.models.Items;
import com.liveinbits.internshiptest.models.ListItems;
import com.liveinbits.internshiptest.models.Owner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CustomAdapter.MyItemListener {

    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private List<Items> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        LoadJson();
    }


    public void LoadJson() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<ListItems> call = null;

        call = apiInterface.getItems();

        call.enqueue(new Callback<ListItems>() {
            @Override
            public void onResponse(Call<ListItems> call, Response<ListItems> response) {
                if (response.isSuccessful() && response.body() != null) {
                    items = response.body().getItems();

                    adapter = new CustomAdapter(items, getApplicationContext());
                    adapter.setMyListener(MainActivity.this);

                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } else {
                    String errorCode = "";
                    switch (response.code()) {
                        case 404:
                            errorCode = "404 Not Found ";
                            break;
                        case 500:
                            errorCode = "500 Server Error";
                            break;
                        default:
                            errorCode = "Unknown Error";
                    }
                    Toast.makeText(MainActivity.this, errorCode, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ListItems> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No result ", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Owner owner = new Owner();
        owner = (Owner) items.get(position).getOwner();
        Items item = new Items();
        item = items.get(position);
        Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
        intent.putExtra("owner", owner);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}
