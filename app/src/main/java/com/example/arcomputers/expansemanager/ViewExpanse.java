package com.example.arcomputers.expansemanager;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ViewExpanse extends AppCompatActivity {

    EditText viewExpanseNameET,viewExpanseAmountET;
    Spinner viewExpanseCatagorySP;
    TextView dateTV, timeTV;
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    int hour = calendar.get(Calendar.HOUR);
    int min = calendar.get(Calendar.MINUTE);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expanse);

        viewExpanseNameET = findViewById(R.id.expanseNameET);
        viewExpanseAmountET = findViewById(R.id.expanseAmountET);
        viewExpanseCatagorySP = findViewById(R.id.expanseCatSP);
        dateTV= findViewById(R.id.dateTV);
        timeTV=findViewById(R.id.timeTV);


        String[] Catagory = getResources().getStringArray(R.array.expanseCatagory);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ViewExpanse.this,R.layout.support_simple_spinner_dropdown_item,Catagory);
        viewExpanseCatagorySP.setAdapter(arrayAdapter);

        viewExpanseCatagorySP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int item, long l) {
                String catagory = (String) adapterView.getItemAtPosition(item);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        dateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ViewExpanse.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        String date = day+"/"+month+"/"+year;
                        dateTV.setText(date);
                        Toast.makeText(ViewExpanse.this, "date is"+date, Toast.LENGTH_SHORT).show();

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });




        timeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ViewExpanse.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        if (hour>12)
                        {
                            String time = hour+":"+min+"PM";
                            timeTV.setText(time);
                            Toast.makeText(ViewExpanse.this, "time is"+time, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String time = hour+":"+min+"AM";
                            timeTV.setText(time);
                            Toast.makeText(ViewExpanse.this, "time is"+time, Toast.LENGTH_SHORT).show();
                        }

                    }
                }, hour, min, true);
                timePickerDialog.show();
            }
        });


    }
}
