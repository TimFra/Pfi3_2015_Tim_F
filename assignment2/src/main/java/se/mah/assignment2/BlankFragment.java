package se.mah.assignment2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener{


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        View myButtonView = v.findViewById(R.id.btn_ok);
        //Button myButton = (Button) myButtonView;
        myButtonView.setOnClickListener(this);
        return v;
    }


    public void onClick(View v) {
        MainActivity a = (MainActivity) getActivity();
        Toast t = Toast.makeText(getActivity(),"Laddar reseplaneraren",Toast.LENGTH_SHORT);
        t.show();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment2 bf = new Fragment2();
        ft.replace(R.id.main_layout,bf);
        ft.commit();

        //getFragmentManager().beginTransaction().replace(R.id.main_layout,new ListFragment()).commit();

    }
}



