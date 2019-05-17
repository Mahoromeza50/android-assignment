package com.example.carinem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.example.carinem.Adapter.searchadapter;
import com.example.carinem.database.database;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    searchadapter adapter;
    SearchView searchView;
    List<String>suggestList=new ArrayList<>();
      com.example.carinem.database.database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       recyclerView=(RecyclerView) findViewById(R.id.recycler_search);
       layoutManager=new LinearLayoutManager(this);
       recyclerView.setLayoutManager(layoutManager);
       recyclerView.setHasFixedSize(true);
       searchView=(SearchView) findViewById(R.id.search_bar);



database =new database(this);
adapter=new searchadapter(this, database.getfriends());
searchView.setQueryHint("search");
loadSuggestList();


{
}
    }

    private void loadSuggestList() {
        suggestList=database.getNames();


    }
}
