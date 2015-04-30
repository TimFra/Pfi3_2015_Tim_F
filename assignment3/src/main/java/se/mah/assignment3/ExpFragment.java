package se.mah.assignment3;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;

import se.mah.assignment3.control.Constants;
import se.mah.assignment3.dummy.DummyContent;
import se.mah.assignment3.model.Journey;
import se.mah.assignment3.model.Journeys;
import se.mah.assignment3.xmlparser.Parser;



public class ExpFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private ArrayList<Journey> journeyList = new ArrayList<Journey>();
    private Adapter adapter;
    public ExpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_layout, container, false);
        /* /Do whatever */

        ExpandableListView ev = (ExpandableListView) v.findViewById(R.id.expandableListView);
        adapter = new Adapter(getActivity(),journeyList);
        ev.setAdapter(adapter);

        //MyAsyncTask myAsyncTask = new MyAsyncTask();
        //myAsyncTask.execute("KD323B-20151-K3522");
        Spinner sp = (Spinner)v.findViewById(R.id.spinner);
        Spinner sp2 = (Spinner)v.findViewById(R.id.spinner2);
        sp.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);
        return v;
    }

    ///Listens to meny selection.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.i("ExpFragment", "MenuSelection. " + id);
        if (id == R.id.refresh) {
            Spinner sp = (Spinner)getView().findViewById(R.id.spinner);
            Spinner sp2 = (Spinner)getView().findViewById(R.id.spinner2);
            int i = sp.getSelectedItemPosition();
            int x = sp2.getSelectedItemPosition();
            String[] sa = getActivity().getResources().getStringArray(R.array.courses);
            String course = sa[i];
            String toSpinner = sa[x];
            String searchURL ="";

            if(course.equals("Malmö")) {
                if(toSpinner.equals("Malmö")){ searchURL = Constants.getURL("80000", "80000", 10); }
                if(toSpinner.equals("Köpenhamn")){ searchURL = Constants.getURL("80000", "45007", 10);}
                if(toSpinner.equals("Hässleholm")){searchURL = Constants.getURL("80000", "93070", 10);}
                if(toSpinner.equals("Halmstad")){searchURL = Constants.getURL("80000", "13003", 10);}
            }
            if(course.equals("Köpenhamn")) {
                if(toSpinner.equals("Malmö")){ searchURL = Constants.getURL("45007", "80000", 10); }
                if(toSpinner.equals("Köpenhamn")){searchURL = Constants.getURL("45007", "45007", 10);}
                if(toSpinner.equals("Hässleholm")){searchURL = Constants.getURL("45007", "93070", 10);}
                if(toSpinner.equals("Halmstad")){ searchURL = Constants.getURL("45007", "13003", 10);}
            }
            if(course.equals("Hässleholm")) {
                if(toSpinner.equals("Malmö")){ searchURL = Constants.getURL("93070", "80000", 10);}
                if(toSpinner.equals("Köpenhamn")){searchURL = Constants.getURL("93070", "45007", 10);}
                if(toSpinner.equals("Hässleholm")){ searchURL = Constants.getURL("93070", "93070", 10);}
                if(toSpinner.equals("Halmstad")){ searchURL = Constants.getURL("93070", "13003", 10);}
            }
            if(course.equals("Halmstad")) {
                if(toSpinner.equals("Malmö")){searchURL = Constants.getURL("13003", "80000", 10);}
                if(toSpinner.equals("Köpenhamn")){searchURL = Constants.getURL("13003", "45007", 10);}
                if(toSpinner.equals("Hässleholm")){ searchURL = Constants.getURL("13003", "93070", 10);}
                if(toSpinner.equals("Halmstad")){searchURL = Constants.getURL("13003", "13003", 10);}
            }
            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(searchURL);
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    //Listens to the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] courses = getActivity().getResources().getStringArray(R.array.courses);
        String[] toSpinner = getActivity().getResources().getStringArray(R.array.toSpinner);
        String course = courses[position];
        String toSpin = toSpinner[position];

        String searchURL ="";

        if(course.equals("Malmö")) {
            if(toSpinner.equals("Malmö")){ searchURL = Constants.getURL("80000", "80000", 10); }
            if(toSpinner.equals("Köpenhamn")){ searchURL = Constants.getURL("80000", "45007", 10);}
            if(toSpinner.equals("Hässleholm")){searchURL = Constants.getURL("80000", "93070", 10);}
            if(toSpinner.equals("Halmstad")){searchURL = Constants.getURL("80000", "13003", 10);}
        }
        if(course.equals("Köpenhamn")) {
            if(toSpinner.equals("Malmö")){ searchURL = Constants.getURL("45007", "80000", 10); }
            if(toSpinner.equals("Köpenhamn")){searchURL = Constants.getURL("45007", "45007", 10);}
            if(toSpinner.equals("Hässleholm")){searchURL = Constants.getURL("45007", "93070", 10);}
            if(toSpinner.equals("Halmstad")){ searchURL = Constants.getURL("45007", "13003", 10);}
        }
        if(course.equals("Hässleholm")) {
            if(toSpinner.equals("Malmö")){ searchURL = Constants.getURL("93070", "80000", 10);}
            if(toSpinner.equals("Köpenhamn")){searchURL = Constants.getURL("93070", "45007", 10);}
            if(toSpinner.equals("Hässleholm")){ searchURL = Constants.getURL("93070", "93070", 10);}
            if(toSpinner.equals("Halmstad")){ searchURL = Constants.getURL("93070", "13003", 10);}
        }
        if(course.equals("Halmstad")) {
            if(toSpinner.equals("Malmö")){searchURL = Constants.getURL("13003", "80000", 10);}
            if(toSpinner.equals("Köpenhamn")){searchURL = Constants.getURL("13003", "45007", 10);}
            if(toSpinner.equals("Hässleholm")){ searchURL = Constants.getURL("13003", "93070", 10);}
            if(toSpinner.equals("Halmstad")){searchURL = Constants.getURL("13003", "13003", 10);}
        }



        Log.i("ExpFragment", "Item. " + course + searchURL);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(searchURL);

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    //And the thread
    private class MyAsyncTask extends AsyncTask<String,Void,Long> {

        @Override
        protected Long doInBackground(String... params) {
            Journeys journeys = Parser.getJourneys(params[0]);
            String param1 =  params[0];
            journeyList.clear();
            journeyList.addAll(journeys.getJourneys());
            return null;
        }

        @Override
        protected void onPostExecute(Long result) { //Called when the AsyncTask is all done
            super.onPostExecute(result);
            adapter.notifyDataSetChanged();
        }
    }
    }
