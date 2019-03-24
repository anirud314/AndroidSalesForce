package com.example.alannoun.salesforceclone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;


import SalesModel.CustomerList;
import SalesModel.EmployeeList;
import SalesModel.EmployeeModel;
import SalesModel.Logger;


public class EmployeeActivity extends AppCompatActivity implements EmployeeView.ItemClickListener {
    EmployeeList employees;
    CustomerList customers;
    Logger log;

    EmployeeView adapter;

    EmployeeModel employee;
    List<String> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        // data to populate the RecyclerView with
        log = new Logger();
        customers = new CustomerList();

        customers.addCustomer("cust1", "pass", log);
        customers.addCustomer("cust2", "pass", log);
        customers.addCustomer("cust3", "pass", log);
        customers.addCustomer("cust4", "pass", log);
//        employees.addEmployee("donnie", "1234", log, customers);

        employee = new EmployeeModel("sad",  "pass", log, customers);
        options = employee.getOptions();





        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.EmployeeOptions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EmployeeView(this, employee);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        if (position == 0) {
            Context context = view.getContext();
            Intent intent = new Intent(this, OpenSalesView.class);
            intent.putExtra("OpenSales", employee);
            context.startActivity(intent);
        }

        else if (position == 1) {
            Context context = view.getContext();
            Intent intent = new Intent(this, ClosedSalesView.class);
            intent.putExtra("ClosedSales", employee);
            context.startActivity(intent);
        }

        else if (position == 2) {
            Context context = view.getContext();
            Intent intent = new Intent(this, NewSaleView.class);
            intent.putExtra("NewSale", employee);
            context.startActivity(intent);
        }


    }
}
