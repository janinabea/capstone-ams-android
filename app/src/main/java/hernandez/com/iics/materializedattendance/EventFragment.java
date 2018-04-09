package hernandez.com.iics.materializedattendance;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class EventFragment extends Fragment {
    ListView list;
    String[] eventMonth = {"JAN", "FEB", "AUG","APR", "MAY","DEC"};
    String[] eventDate = {"01", "14","16","27","15","25"};
    String[]  eventName = {"New Year","Android Seminar", "IT Curriculum Meeting","IICS WEEK","Red Cross Seminar","CHRISTMAS" };
    String[] eventDay ={"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};



    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);

        list = (ListView) v.findViewById(R.id.eventListView);
        MyAdapter cs  = new MyAdapter(getActivity(), eventMonth, eventDate,eventDay,eventName);
        list.setAdapter(cs);
        return v;
    }

    class MyAdapter extends ArrayAdapter {

        String[] txtName;
        String[] txtDate;
        String[] txtDay;
        String[] txtMonth;

        public MyAdapter(Context context, String[] eventMonth, String[] eventDate, String[] eventDay, String[] eventName){
            super(context, R.layout.listview_event, R.id.eventButton, eventName);
            this.txtDate = eventDate;
            this.txtName = eventName;
            this.txtDay = eventDay;
            this.txtMonth = eventMonth;
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.listview_event, parent, false);

            TextView a = (TextView) view.findViewById(R.id.month);
            TextView b = (TextView) view.findViewById(R.id.date);
            TextView c = (TextView) view.findViewById(R.id.day);
            TextView d = (TextView) view.findViewById(R.id.eventButton);

            //this is where we set values and show to the facultyListView in the fragment
            a.setText(eventMonth[position]);
            b.setText(eventDate[position]);
            c.setText(eventDay[position]);
            d.setText(eventName[position]);

            Button eventButton = (Button) view.findViewById(R.id.eventButton);
            eventButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), EventActivity.class);
                    startActivity(i);


                    //you have to change the header of the appbar with the event name
                    //String selectedFromList = (String) eventName.getItemAtPosition(position);
                }
            });
            return view;
        }

    }







}
