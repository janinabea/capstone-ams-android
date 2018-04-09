package hernandez.com.iics.materializedattendance;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FacultyFragment extends Fragment {

    ListView list;
    String[] facultyName = {"Eugenia Ramirez", "Mike Victorio", "Mylene Domingo"};
    String[] facultyDept = {"IT Dept", "IT Chair","Institute Secretary"};
    int[] facultyPic = {R.drawable.zhuo, R.drawable.victorio, R.drawable.domingo};


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
        return v;


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
