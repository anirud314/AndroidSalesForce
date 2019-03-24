package com.example.alannoun.salesforceclone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import SalesModel.EmployeeModel;

public class NewSaleView extends AppCompatActivity {
    private Button button;
    private EmployeeModel employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sale_view);

        employee = (EmployeeModel)getIntent().getSerializableExtra("NewSale");
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewSale(v);
            }
        });


    }

    public void createNewSale(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(this, NewSalesActivity.class);
        intent.putExtra("OpenSales", employee);
        context.startActivity(intent);
    }

}
