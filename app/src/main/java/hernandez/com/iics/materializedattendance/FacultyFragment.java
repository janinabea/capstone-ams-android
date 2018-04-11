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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FacultyFragment extends Fragment {

        ListView list;
        String[] facultyName = {"Jonatahan Cabero","Eugenia Ramirez","Divinagracia Mariano", "Mike Victorio", "Mylene Domingo"};
        String[] facultyDept = {"CS Dept","IT Dept","IS Dept/SWDB Coordinator", "IT Chair","Institute Secretary"};
        int[] facultyPic = {R.drawable.cabero, R.drawable.zhuo,R.drawable.mariano, R.drawable.victorio, R.drawable.domingo};


    public FacultyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      //  ((AdminMainActivity)getActivity()).setActionBarTitle("Home"); //use this to change title. add onCreate
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_faculty, container, false);


        list = (ListView) v.findViewById(R.id.facultyListView);
        CustomAdapter cs  = new CustomAdapter(getActivity(), facultyName, facultyDept,facultyPic);
        list.setAdapter(cs);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Intent intent = new Intent(getActivity(), FacultyDetailsActivity.class );
                intent.putExtra("names", facultyName[i]);
                intent.putExtra("pics", facultyPic[i]);
            }

        });

        return v;
    }

    public class CustomAdapter extends ArrayAdapter<String> {

        int[] imgArray;
        String[] txtName;
        String[] txtDept;

        public CustomAdapter(Context context, String[] facName, String[] facDept, int[] facPic){
            super(context, R.layout.listview_faculty, R.id.listFacDept, facName);
            this.imgArray = facPic;
            this.txtName = facName;
            this.txtDept = facDept;
        }
        @Override
        public int getCount(){
            return facultyName.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = new ViewHolder();
            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_faculty, parent, false);

                viewHolder.pic = (ImageView) convertView.findViewById(R.id.listFacPic);
                viewHolder.name = (TextView) convertView.findViewById(R.id.listFacName);
                viewHolder.dept = (TextView) convertView.findViewById(R.id.listFacDept);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder)convertView.getTag();
            }
                viewHolder.pic.setImageResource(facultyPic[position]);
                viewHolder.name.setText(facultyName[position]);
                viewHolder.dept.setText(facultyDept[position]);

            return convertView;
        }

    }

    static class ViewHolder{
        ImageView pic;
        TextView name, dept;
    }




}
