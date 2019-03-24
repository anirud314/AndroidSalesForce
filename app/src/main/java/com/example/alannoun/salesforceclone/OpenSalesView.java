package com.example.alannoun.salesforceclone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import SalesModel.EmployeeModel;
import SalesModel.Sale;

public class OpenSalesView extends AppCompatActivity implements OpenSalesActivity.ItemClickListener{

    Map<Integer, Sale> openSales;
    EmployeeModel employee;
    OpenSalesActivity adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_sales);
        employee = (EmployeeModel)getIntent().getSerializableExtra("OpenSales");

        openSales = employee.getOpenSales();

        RecyclerView recyclerView = findViewById(R.id.openSales);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OpenSalesActivity(this, employee);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

    }
}
