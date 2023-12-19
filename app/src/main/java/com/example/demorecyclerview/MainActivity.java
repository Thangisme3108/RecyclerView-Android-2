package com.example.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.demorecyclerview.Adapter.CatAdapter;
import com.example.demorecyclerview.DAO.CatDAO;
import com.example.demorecyclerview.DTO.CatDTO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CatDAO catDAO;
    ArrayList<CatDTO> listCat;
    RecyclerView rc_cat;
    CatAdapter catAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rc_cat = findViewById(R.id.rc_cat);

        catDAO = new CatDAO(this);
        listCat = catDAO.getList();
        catAdapter = new CatAdapter(listCat, this);
        rc_cat.setAdapter(catAdapter);
    }
}