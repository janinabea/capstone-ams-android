package hernandez.com.iics.materializedattendance;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity {
    GridView gv;
    int[] facultyImg = {R.drawable.acula, R.drawable.alberto, R.drawable.ballon, R.drawable.barcelo,
            R.drawable.cabero, R.drawable.delfinado};
    //R.drawable.estabillo, R.drawable.ladao, R.drawable.mariano,
    //R.drawable.marollano, R.drawable.padua, R.drawable.ponay, R.drawable.sanidad, R.drawable.tupaz

    ListView list;
    String[] facultyName = {"Alexie Ballon","Eugenia Ramirez", "Mike Victorio", "Mylene Domingo"};
    String[] facultyDept = {"IT Dept","IT Dept", "IT Chair","Institute Secretary"};
    int[] facultyPic = {R.drawable.ballon,R.drawable.zhuo, R.drawable.victorio, R.drawable.domingo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("details");
        spec.setContent(R.id.details);
        spec.setIndicator("Details");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("attendance");
        spec.setContent(R.id.attendance);
        spec.setIndicator("Attendance");
        host.addTab(spec);


//        FacultyGridViewAdapter fd = new FacultyGridViewAdapter(this, facultyImg );
//        gv.setAdapter(fd);
        list = (ListView) findViewById(R.id.facultyCheckListView);
        CustomAdapter cs  = new CustomAdapter(EventActivity.this, facultyName, facultyDept,facultyPic);
        list.setAdapter(cs);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapter, View v, int position, long arg3){
               long a = adapter.getItemIdAtPosition(position);
               String value = Long.toString(a);

                Toast.makeText(EventActivity.this, value, Toast.LENGTH_SHORT).show();
            }

        });

    }

    class CustomAdapter extends ArrayAdapter {

        int[] imgArray;
        String[] txtName;
        String[] txtDept;

        public CustomAdapter(Context context, String[] facName, String[] facDept, int[] facPic){
            super(context, R.layout.listview_faculty, R.id.facultyyName, facName);
            this.imgArray = facPic;
            this.txtName = facName;
            this.txtDept = facDept;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listview_faculty, parent, false);
                ImageView imgv =  (ImageView) convertView.findViewById(R.id.facultyyPic);
                TextView txtv = (TextView) convertView.findViewById(R.id.facultyyName);
                TextView txtv2 = (TextView) convertView.findViewById(R.id.facultyyDesc);

                imgv.setImageResource(facultyPic[position]);
                txtv.setText(facultyName[position]);
                txtv2.setText(facultyDept[position]);
            }
            return convertView;
        }

    }




}
