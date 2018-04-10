package hernandez.com.iics.materializedattendance;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {
    GridView gv;
    int[] facultyImg = {R.drawable.acula, R.drawable.alberto, R.drawable.ballon, R.drawable.barcelo,
            R.drawable.cabero, R.drawable.delfinado};
    //R.drawable.estabillo, R.drawable.ladao, R.drawable.mariano,
    //R.drawable.marollano, R.drawable.padua, R.drawable.ponay, R.drawable.sanidad, R.drawable.tupaz
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gv = (GridView)findViewById(R.id.gridViewFaculty);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("details");
        spec.setContent(R.id.details);
        spec.setIndicator("Details");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Attendance");
        spec.setContent(R.id.attendance);
        spec.setIndicator("Attendance");
        host.addTab(spec);

        FacultyGridViewAdapter fd = new FacultyGridViewAdapter(this, facultyImg );
        gv.setAdapter(fd);

    }





}
