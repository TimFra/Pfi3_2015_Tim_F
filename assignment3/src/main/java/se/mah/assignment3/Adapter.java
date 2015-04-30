package se.mah.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import se.mah.assignment3.model.Journey;


/**
 * Created by Tim on 2015-04-29.
 */
public class Adapter extends BaseExpandableListAdapter{
    private ArrayList<Journey> journeyItems;
    private Context c;

    public Adapter(Context c,ArrayList<Journey> journeyItems){

        this.c=c;
        this.journeyItems = journeyItems;
    }

    @Override
    public int getGroupCount() {
        return journeyItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.group_exp_layout,null);
        TextView tvCourse = (TextView) convertView.findViewById(R.id.tv_course);
        String course = "Till avgång: " + journeyItems.get(groupPosition).getTimeToDeparture() + "min";
        tvCourse.setText(course);
        TextView tvDate =(TextView) convertView.findViewById(R.id.tv_date);
        String date = "Resetid: " + journeyItems.get(groupPosition).getTravelMinutes() + "min";
        tvDate.setText(date);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.group_child_layout,null);
        TextView tvMoment = (TextView) convertView.findViewById(R.id.tv_moment);
        String moment = "Startstation:" + journeyItems.get(groupPosition).getStartStation().getStationName();
        tvMoment.setText(moment);
        TextView tvRoom = (TextView) convertView.findViewById(R.id.tv_room);
        String room = "Restyp: " + journeyItems.get(groupPosition).getLineTypeName();
        tvRoom.setText(room);
        TextView tvStart = (TextView) convertView.findViewById(R.id.tv_start);
        String start = "Antal byte: " + journeyItems.get(groupPosition).getNoOfChanges();
        tvStart.setText(start);
        TextView tvEnd = (TextView) convertView.findViewById(R.id.tv_end);
        String end = "Slutstation: " + journeyItems.get(groupPosition).getEndStation().getStationName();
        tvEnd.setText(end);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imageView1);

        if(Integer.parseInt(journeyItems.get(groupPosition).getTimeToDeparture()) > 200) {
            imgView.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }



    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
