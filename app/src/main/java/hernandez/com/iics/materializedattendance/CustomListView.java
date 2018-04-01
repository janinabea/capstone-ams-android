package hernandez.com.iics.materializedattendance;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Biancake on 3/30/2018.
 */

public class CustomListView extends ArrayAdapter<String> {

    private String[] facultyName;
    private String[] facultyDept;
    private Integer[] facultyPic;
    private Activity context;


    public CustomListView(Activity context, String[] facultyName, String[] facultyDept, Integer[] facultyPic ){
        super(context, R.layout.listview_faculty, facultyName);
        this.context = context;
        this.facultyDept = facultyDept;
        this.facultyName = facultyName;
        this.facultyPic = facultyPic;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_faculty, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.c.setImageResource(facultyPic[position]);
        viewHolder.a.setText(facultyName[position]);
        viewHolder.b.setText(facultyDept[position]);
        return r;
    }

    class ViewHolder{
        TextView a;
        TextView b;
        ImageView c;
        ViewHolder(View v){
            a = (TextView) v.findViewById(R.id.facultyName);
            b = (TextView) v.findViewById(R.id.facultyDesc);
            c = (ImageView) v.findViewById(R.id.facultyPic);
        }
    }

}
