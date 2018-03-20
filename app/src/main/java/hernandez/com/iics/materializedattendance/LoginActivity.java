package hernandez.com.iics.materializedattendance;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;*/

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;



public class LoginActivity extends AppCompatActivity  {
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
//    LoginHelper lHelper = new LoginHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button btnLogin = (Button) findViewById(R.id.email_sign_in_button);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean isExist= lHelper.userExist(mEmailView.getText().toString(), mPasswordView.getText().toString());
//                if(isExist){
//                    Intent intent = new Intent(LoginActivity.this, AdminMainActivity.class);
//                }else{
//                    mPasswordView.setText(null);
//                    Toast.makeText(LoginActivity.this, "Login failed. Invalid username or password", Toast.LENGTH_SHORT).show();
//                }w
            }
        });
    }


}

