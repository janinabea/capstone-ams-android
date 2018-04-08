package hernandez.com.iics.materializedattendance;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class addEventActivity extends AppCompatActivity {

    EditText txtDate;
    TextView txtSD;
    Calendar currentDate;
    int day, month, year;
    String monthWord, a,b;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        s = (Spinner)findViewById(R.id.selectEventType);
        String [] eventType = {"UST-Wide Event", "Meeting", "Seminar/Workshop", "Local Event", "International Event","Fieldtrip","Retreat/Recollection"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, eventType);
        s.setAdapter(adapter);

        txtDate = (EditText)findViewById(R.id.inputEventDate);
        currentDate = Calendar.getInstance();
        day = currentDate.get(Calendar.DAY_OF_MONTH);
        month = (currentDate.get(Calendar.MONTH))+1;
        year = currentDate.get(Calendar.YEAR);

        txtSD = (TextView)findViewById(R.id.txtSelectDate);

        txtSD.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v){
                DatePickerDialog datePD = new DatePickerDialog(addEventActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        txtDate.setText( monthOfYear+ "/"+ dayOfMonth +"/" + year);
                    }
                }, year, month, day);
                datePD.show();
            }

        });



    }

}

//public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{
//    EditText txtDate;
//
//    public DateDialog(View v){
//        txtDate = (EditText)v;
//    }
//    public Dialog onCreateDialog(Bundle savedInstanceState){
//        final Calendar c = Calendar.getInstance();
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
//        return new DatePickerDialog(getActivity(), this, year, month,day);
//    }
//    public void onDateSet(DatePicker view, int year, int  month, int day){
//        String date = day + " " + (month +1) + " " +year;
//        txtDate.setText(date);
//    }
//}
