package hernandez.com.iics.materializedattendance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FacultyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView list;
    String[] facultyName = {"Eugenia Ramirez", "Mike Victorio", "Mylene Domingo"};
    String[] facultyDept = {"IT Dept", "IT Chair","Institute Secretary"};
    int[] facultyPic = {R.drawable.zhuo, R.drawable.victorio, R.drawable.domingo_background};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        //list
        list = (ListView) findViewById(R.id.facultyListView);
        //CustomListView customListView = new CustomListView(FacultyActivity.this, facultyName, facultyDept, facultyPic);
        CustomAdapter cs  = new CustomAdapter(FacultyActivity.this, facultyName, facultyDept,facultyPic);
        list.setAdapter(cs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

            case R.id.nav_event:
                Intent h = new Intent(FacultyActivity.this, EventActivity.class);
                startActivity(h);
                break;
            case R.id.nav_faculty:
                Intent intent = new Intent(FacultyActivity.this, FacultyActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_settings:
                Intent g = new Intent(FacultyActivity.this, SettingsActivity.class);
                startActivity(g);
                break;
            /*case R.id.nav_sync:
                Intent s= new Intent(FacultyActivity.this,SyncActivity.class);
                startActivity(s);
                break;*/
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.listview_faculty, parent, false);

            ImageView imgv =  (ImageView) view.findViewById(R.id.facultyyPic);
            TextView txtv = (TextView) view.findViewById(R.id.facultyyName);
            TextView txtv2 = (TextView) view.findViewById(R.id.facultyyDesc);

            imgv.setImageResource(facultyPic[position]);
            txtv.setText(facultyName[position]);
            txtv2.setText(facultyDept[position]);
            return view;
        }

    }


}

