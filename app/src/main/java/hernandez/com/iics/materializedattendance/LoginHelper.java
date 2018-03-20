package hernandez.com.iics.materializedattendance;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.ScriptGroup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Biancake on 2/28/2018.
 */

public class LoginHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;
    private static final String DATABASE_NAME =  "mobile.db";
    private static final String TABLE_NAME = "login";
    private final String USER_TABLE = "login";
    private static final String COLUMN_USERNAME = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String DATABASE_PATH = "/data/data/hernandez.com.iics.materializedattendance/databases/";
    private final Context context;

    public LoginHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        createdb();
    }
    public void createdb(){
        if (!checkdb()){
            this.getReadableDatabase();
            copyDatabase();
            close();
        }
        else{

        }
    }

    private void copyDatabase() {
        try {
            InputStream inputStream = context.getAssets().open(DATABASE_NAME);

            String outFileName = DATABASE_PATH + DATABASE_NAME;

            OutputStream outputStream = new FileOutputStream(outFileName);

            byte[] b = new byte[1024];
            int length;

            while((length = inputStream.read(b)) > 0){
                outputStream.write(b, 0, length);

            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean checkdb(){
        SQLiteDatabase sqLiteDatabase = null;

        String path = DATABASE_PATH + DATABASE_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

        if (sqLiteDatabase != null){
            sqLiteDatabase.close();
            return true;
        }else{

            return false;
        }
    }

    private SQLiteDatabase openDatabase(){
        String path = DATABASE_PATH + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);
        return db;
    }

    public void close(){
        if(db !=null) {
            db.close();
        }
    }

    public boolean userExist(String username, String password){
        db = openDatabase();
        String[] columns = {"username"};
        String selection = "username = ? and password = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(USER_TABLE, columns, selection, selectionArgs, null, null, null);
        int count = 0;
        count = cursor.getCount();
        cursor.close();
        close();
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

   /* public String searchPass(String mEmail) {

        db = this.getReadableDatabase();
        String cEmail, cPass;
        String query = "SELECT email, password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        cPass = "not found";
        if (cursor.moveToFirst()){
            do{
                cEmail = cursor.getString(0);
                if (cEmail.equals(mEmail)){
                    cPass = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        db.close();
        return cPass;
    }*/
}
