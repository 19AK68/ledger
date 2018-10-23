package com.example.ak.user.ledger.ExpandableListview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
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
    public Object getGroup(int i) {
        return deplist.get(i);
    }

    @Override
    public Object getChild(int groupPos, int childPos)
    {
        ArrayList<Cost_SubItems_Info> subitemlist= deplist.get(groupPos).getList();
        return subitemlist.get(childPos);
    }

    @Override
    public long getGroupId(int groupPos) {
        return groupPos;
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
    public View getGroupView(int grouPos, boolean isExpanded, View convertView, ViewGroup parent)
    {
        CostItemsInfo hederinfo = (CostItemsInfo)getGroup(grouPos);

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cost_items,null);

        }

        TextView  heading = (TextView) convertView.findViewById(R.id.heading);

        return null;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup)
    {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
