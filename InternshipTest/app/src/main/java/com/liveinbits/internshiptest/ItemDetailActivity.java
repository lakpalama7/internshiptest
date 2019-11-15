package com.liveinbits.internshiptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.liveinbits.internshiptest.models.Items;
import com.liveinbits.internshiptest.models.Owner;

import org.w3c.dom.Text;

import java.io.Serializable;

public class ItemDetailActivity extends AppCompatActivity {

    private TextView txt_name, txt_language, txt_watch, txt_score, txt_owner_id, txt_login_name, txt_url, txt_org_url, txt_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        txt_name = findViewById(R.id.name);
        txt_language = findViewById(R.id.language);
        txt_watch = findViewById(R.id.watch);
        txt_score = findViewById(R.id.score);

        txt_owner_id = findViewById(R.id.owner_id);
        txt_login_name = findViewById(R.id.login_name);
        txt_url = findViewById(R.id.url);
        txt_org_url = findViewById(R.id.org_url);
        txt_type = findViewById(R.id.type);

        Intent intent = getIntent();
        Owner owner = (Owner) intent.getSerializableExtra("owner");
        Items item = (Items) intent.getSerializableExtra("item");

        txt_name.setText(getResources().getString(R.string.reponame) + " : " + item.getName());
        txt_language.setText(getResources().getString(R.string.language) + " : " + item.getLanguage());
        txt_watch.setText(getResources().getString(R.string.watchers) + " : " + item.getWatchers());
        txt_score.setText(getResources().getString(R.string.score) + " : " + item.getScore());
        txt_owner_id.setText(getResources().getString(R.string.ownerid) + " : " + owner.getId());
        txt_login_name.setText(getResources().getString(R.string.loginname) + " : " + owner.getLogin());
        txt_url.setText(getResources().getString(R.string.url) + " : " + owner.getUrl());
        txt_org_url.setText(getResources().getString(R.string.orgurl) + " : " + owner.getOrganizational_url());
        txt_type.setText(getResources().getString(R.string.type) + " : " + owner.getType());

    }
}
