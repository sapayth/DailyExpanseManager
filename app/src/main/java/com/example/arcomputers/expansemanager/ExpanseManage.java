package com.example.arcomputers.expansemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExpanseManage extends AppCompatActivity {


    ExpenseDataSource expenseDataSource = new ExpenseDataSource(ExpanseManage.this);
    List<Expense> expenses = new ArrayList<>();
    TextView emptyExpense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expanse_manage);

        ListView expanseLV = findViewById(R.id.showExpanseLV);
        emptyExpense = findViewById(R.id.emptyExpenseTV);

        if (expenses.size()>0){
            emptyExpense.setVisibility(View.VISIBLE);
        }else {

            expenses= expenseDataSource.getAllExpense();
            ExpenseAdapter expenseAdapter = new ExpenseAdapter(ExpanseManage.this,expenses);
            expanseLV.setAdapter(expenseAdapter);
        }


    }

    public void addNewExpanse(View view) {
        Intent intent = new Intent(ExpanseManage.this,ExpanseAdd.class);
        startActivity(intent);
        // Toast.makeText(this, "going to add new expanse page", Toast.LENGTH_SHORT).show();

    }

    public void viewExpanse(View view) {
        Intent intent = new Intent(ExpanseManage.this,ViewExpanse.class);
        startActivity(intent);
        // Toast.makeText(this, "going to view expanse page", Toast.LENGTH_SHORT).show();
    }
}
