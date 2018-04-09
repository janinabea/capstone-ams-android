package hernandez.com.iics.materializedattendance;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class addEventActivity extends AppCompatActivity {

    EditText txtDateFrom, txtDateTo, txtTimeFrom, txtTimeTo;
    Button txtSDF, txtSDT, TPF, TPT;
    Calendar currentDate, currentTime;
    int day, month, year, day2, month2, year2, hour, minute, hour22, minute22;
    String timeFormat;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        s = (Spinner) findViewById(R.id.selectEventType);
        String[] eventType = {"UST-Wide Event", "Meeting", "Seminar/Workshop", "Local Event", "International Event", "Fieldtrip", "Retreat/Recollection"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, eventType);
        s.setAdapter(adapter);



        DatePicker();
        TimePicker();

    }


    public void DatePicker() {
        txtDateFrom = (EditText) findViewById(R.id.inputEventDateFrom);
        txtDateTo = (EditText) findViewById(R.id.inputEventDateTo);
        currentDate = Calendar.getInstance();
        day = currentDate.get(Calendar.DAY_OF_MONTH);
        month = (currentDate.get(Calendar.MONTH)) + 1;
        year = currentDate.get(Calendar.YEAR);

        day2 = currentDate.get(Calendar.DAY_OF_MONTH);
        month2 = (currentDate.get(Calendar.MONTH)) + 1;
        year2 = currentDate.get(Calendar.YEAR);
        txtSDF = (Button) findViewById(R.id.btnSelectDateFrom);
        txtSDT = (Button) findViewById(R.id.btnSelectDateTo);


        txtSDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePD = new DatePickerDialog(addEventActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear + 1;
                        txtDateFrom.setText(monthOfYear + "/" + dayOfMonth + "/" + year);
                    }
                }, year, month, day);
                datePD.show();
            }

        });

        txtSDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePD2 = new DatePickerDialog(addEventActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year2, int monthOfYear2, int dayOfMonth2) {
                        monthOfYear2 = monthOfYear2 + 1;
                        txtDateTo.setText(monthOfYear2 + "/" + dayOfMonth2 + "/" + year2);
                    }
                }, year2, month2, day2);
                datePD2.show();
            }
        });

    }

    public void TimePicker(){
        txtTimeFrom = (EditText)findViewById(R.id.inputEventTimeFrom);
        txtTimeTo = (EditText)findViewById(R.id.inputEventTimeTo);
        TPF = (Button) findViewById(R.id.btnSelectTimeFrom);
        TPT = (Button)findViewById(R.id.btnSelectTimeTo);
        currentTime = Calendar.getInstance();
        hour = currentTime.get(Calendar.HOUR_OF_DAY);
        minute = currentTime.get(Calendar.MINUTE);
        hour22 = currentTime.get(Calendar.HOUR_OF_DAY);
        minute22 = currentTime.get(Calendar.MINUTE);

        //selectedTimeFormat(hour);

        TPF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TimePickerDialog timePickerDialog = new TimePickerDialog(addEventActivity.this, new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                        selectedTimeFormat(hourOfDay);
                        txtTimeFrom.setText(hourOfDay+" : " + minute + " " +timeFormat);
                    }
                },hour, minute, true);
                timePickerDialog.show();
            }
        });

        TPT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TimePickerDialog timePickerDialog = new TimePickerDialog(addEventActivity.this, new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay2, int minute2){
                        selectedTimeFormat(hourOfDay2);
                        txtTimeTo.setText(hourOfDay2+" : " + minute2 + " " +timeFormat);
                    }
                },hour22, minute22, true);
                timePickerDialog.show();
            }
        });


    }
    public void selectedTimeFormat(int hour){
        if(hour == 0){
            hour+=12;
            timeFormat = "AM";
        }else if(hour == 12){
            timeFormat = "PM";
        }else if(hour > 12){
            hour -= 12;
            timeFormat = "PM";
        }else{
            timeFormat = "AM";
        }
    }

}
