package hernandez.com.iics.materializedattendance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CalendarView;
import android.widget.Toast;

public class AdminMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //CalendarView calendarView;
    FloatingActionButton fab_add, fab_addEvent, fab_addFaculty;
    Animation fabOpen, fabClose, fabRotateClockwise, fabRotateCounter;
    boolean isOpen= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        fab_add = (FloatingActionButton) findViewById(R.id.fab_add);
        fab_addEvent = (FloatingActionButton) findViewById(R.id.fab_addEvent);
        fab_addFaculty = (FloatingActionButton) findViewById(R.id.fab_addFaculty);
        fabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fabRotateClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fabRotateCounter = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_counterclockwise);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    fab_addEvent.startAnimation(fabClose);
                    fab_addFaculty.startAnimation(fabClose);
                    fab_add.startAnimation(fabRotateCounter);
                    fab_addFaculty.setClickable(false);
                    fab_addEvent.setClickable(false);
                    isOpen = false;
                }else{
                    fab_addEvent.startAnimation(fabOpen);
                    fab_addFaculty.startAnimation(fabOpen);
                    fab_add.startAnimation(fabRotateClockwise);
                    fab_addFaculty.setClickable(true);
                    fab_addEvent.setClickable(true);
                    isOpen = true;
                }
            }
        });
        fab_addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminMainActivity.this, addEventActivity.class);
                startActivity(i);

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       /* calendarView =  (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Intent intent = new Intent(AdminMainActivity.this, EventActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), ""+month+ " "+dayOfMonth +", "+year, 0).show();// TODO Auto-generated method stub

            }
        });*/
        //defaultFragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutContainer, new EventFragment());
        ft.commit();
        navigationView.setCheckedItem(R.id.nav_event);

    }

    public void setActionBarTitle(String titlee){
        getSupportActionBar().setTitle(titlee);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        if (id == R.id.action_addEvent) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Class fragmentClass = null;

         switch (id) {

            case R.id.nav_event:
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayoutContainer, new EventFragment());
                ft.commit();
                break;
            case R.id.nav_faculty:
                FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.frameLayoutContainer, new FacultyFragment());
                ft1.commit();
                break;
            case R.id.nav_settings:
                Intent g = new Intent(AdminMainActivity.this, SettingsActivity.class);
                startActivity(g);
                break;
           /* case R.id.nav_sync:
                Intent s= new Intent(this,SyncActivity.class);
                startActivity(s);
                break;*/
           //progress bar should  be attached for sync

        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
