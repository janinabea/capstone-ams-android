package hernandez.com.iics.materializedattendance;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FacultyDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // ImageView imageV = (ImageView)findViewById(R.id.imageViewIcon);
       // TextView txtV = (TextView) findViewById(R.id.textViewName);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            toolbar.setTitle(bundle.getString("names"));
            //imageV.setImageResource(bundle.getInt("pics"));
            //txtV.setText(bundle.getString("names"));
        }

    }

}
