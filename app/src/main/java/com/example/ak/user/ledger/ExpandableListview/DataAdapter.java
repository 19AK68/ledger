package com.example.ak.user.ledger.ExpandableListview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import com.example.ak.user.ledger.R;
import android.widget.TextView;

import java.util.ArrayList;


public class DataAdapter extends BaseExpandableListAdapter
{

    private Context context;
    private ArrayList<CostItemsInfo> deplist;


    //constructor

    public DataAdapter(Context context, ArrayList<CostItemsInfo> deplist)
    {
        this.context = context;
        this.deplist = deplist;
    }


    @Override
    public int getGroupCount() {
        return deplist.size();
    }

    @Override
    public int getChildrenCount(int i ) {

        ArrayList<Cost_SubItems_Info> subitemlist= deplist.get(i).getList();

        return subitemlist.size();
    }

    @Override
    public Object getGroup(int i){
        return deplist.get(i);
    }

    @Override
    public Object getChild(int groupPos, int childPos)
    {
        ArrayList<Cost_SubItems_Info> subitemlist= deplist.get(groupPos).getList();
        return subitemlist.get(childPos);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View convertView, ViewGroup viewGroup)
    {
        CostItemsInfo headerinfo = (CostItemsInfo)getGroup(i);

        if (convertView==null)
        {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.cost_items,null);

        }

        TextView heading = (TextView) convertView.findViewById(R.id.heading);
        heading.setText(headerinfo.getName().trim());


        return convertView;
    }

    @Override
    public View getChildView(int groupPos, int childPos, boolean isLastChild, View convertView, ViewGroup viewGroup)
    {

        Cost_SubItems_Info detailinfo = (Cost_SubItems_Info) getChild(groupPos, childPos);

        if (convertView==null)
        {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.cost_subitems,null);

        }

        TextView sequence = (TextView) convertView.findViewById(R.id.tv_cost_items);
        sequence.setText(detailinfo.getSequence().trim()+".");

        TextView childitem = (TextView) convertView.findViewById(R.id.tv_child_items);
        childitem.setText(detailinfo.getName().trim());


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
