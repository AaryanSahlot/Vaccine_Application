package com.mastercoding.recyclerview_vaccineapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    //Steps to follow:------>
//    layout
//    designing a data source
//    creating the siurce data models
//    adapters
//    then main activity and join parts together

    //------ 1- AdapterView: RecyclerView
    RecyclerView recyclerView;

    //------ 2- Data Source:
    VaccineModel[] myListData;

    //------ 3- Adapter:
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        myListData = new VaccineModel[]{
                new VaccineModel("Hepatitis B Vaccine", R.drawable.vaccine_1),
                new VaccineModel("Tetanus Vaccine", R.drawable.vaccine),
                new VaccineModel("Pneumococcal Vaccine", R.drawable.vaccine_3),
                new VaccineModel("RotaVirus Vaccine", R.drawable.vaccines),
                new VaccineModel("Measles Virus", R.drawable.medicine),
                new VaccineModel("Cholera Virus", R.drawable.boy),
                new VaccineModel("Covid-19 Virus", R.drawable.vaccine_2)
        };

        //Adapter
        adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        // Handling the click Events
        adapter.setClickListener(this);

    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this,
                "Vaccine name: "+myListData[pos].getTitle(), Toast.LENGTH_SHORT).show();
    }
    // ye second last app hai
}