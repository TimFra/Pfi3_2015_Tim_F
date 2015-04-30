package se.mah.assignment4;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageAdapter extends ArrayAdapter<Planet> {
    ArrayList<Planet> planetList;
    private Context mContext;

    public ImageAdapter(Context c, ArrayList<Planet> planetList) {
        super(c,0,planetList);
        mContext = c;
        this.planetList = planetList;
    }


    @Override
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ImageButton imageView;
        Log.i("MyListAdapter", "Called for position: " + position);
        Planet p = planetList.get(position);

        convertView = inflater.inflate(R.layout.fragment_image_adapter,null);
        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_planet);

        TextView tv = (TextView) convertView.findViewById(R.id.iv_text);

        tv.setText(p.getName());
        iv.setImageDrawable(p.getImage());
        return convertView;
    }


}
