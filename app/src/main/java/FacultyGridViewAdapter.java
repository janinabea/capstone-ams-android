import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hernandez.com.iics.materializedattendance.Faculty;
import hernandez.com.iics.materializedattendance.R;

/**
 * Created by Biancake on 4/9/2018.
 */

public class FacultyGridViewAdapter extends ArrayAdapter<Faculty> {

    public FacultyGridViewAdapter(Context context, int resource, List<Faculty> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;

        if(null == v){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.gridview_faculty,null); //layout
        }
        Faculty f = getItem(position);
//        ImageView facImg = (ImageView) v.findViewById(R.id.);
//        TextView facName = (TextView) v.findViewById(R.id.);
//        TextView facDept = (TextView) v.findViewById(R.id.);

//        facImg.setImageResource(f.getFacultyId());
//        facName.setText(f.getFacultyName());
//        facDept.setText(f.getFacultyDept());
        return v;
    }
}
