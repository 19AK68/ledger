package com.example.ak.user.ledger.ExpandableListview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.ak.user.ledger.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpandableListview_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpandableListview_Fragment extends Fragment
{

    private LinkedHashMap<String,CostItemsInfo> costIntemList = new LinkedHashMap<String, CostItemsInfo>();
    private DataAdapter listadapter;
    private ArrayList<CostItemsInfo> deptlist = new ArrayList<CostItemsInfo>();
    private ExpandableListView expandableListView;






    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ExpandableListview_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpandableListview_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpandableListview_Fragment newInstance(String param1, String param2) {
        ExpandableListview_Fragment fragment = new ExpandableListview_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootview = inflater.inflate(R.layout.fragment_expandable_listview_, container, false);
        // Inflate the layout for this fragment

        LoadData();

        expandableListView = (ExpandableListView) rootview.findViewById(R.id.expListView);
        listadapter = new DataAdapter(ExpandableListview_Fragment.this.getContext(),deptlist);
        expandableListView.setAdapter(listadapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
        {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l)
            {

                CostItemsInfo headerinfo = deptlist.get(i);

                //display

                Toast.makeText(getContext(),"Header is: " + headerinfo.getName(),Toast.LENGTH_SHORT).show();

                return false;
            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
        {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPos, int childPos, long l)
            {
                CostItemsInfo headerinfo = deptlist.get(groupPos);

                //child
                Cost_SubItems_Info detalinfo = headerinfo.getList().get(childPos);

                //display
                Toast.makeText(getContext(),"Clicked on:   " + headerinfo.getName()+ "/" + detalinfo.getName(),Toast.LENGTH_SHORT).show();

                return false;
            }
        });


        return rootview;
    }



    // method expand_all

    private  void expand_all()
    {
        int count = listadapter.getGroupCount();

        for(int i=0; i<count;i++ )
        {

            expandableListView.expandGroup(i);
        }

    }

    // method collapse_all

    private  void collapse_all()
    {
        int count = listadapter.getGroupCount();

        for(int i=0; i<count;i++ )
        {

            expandableListView.collapseGroup(i);
        }

    }

    private void LoadData()
    {



    }


    // add to list

    private  int addProduct (String cost, String subcost)
    {
         int gpoupPosition;

         ArrayList<CostItemsInfo> arrayList;
         CostItemsInfo headerinfo = costIntemList.get(cost);

         if(headerinfo==null)
         {
            headerinfo =new CostItemsInfo();
            headerinfo.setName(cost);
            costIntemList.put(cost,headerinfo);
            deptlist.add(headerinfo);

         }

         ArrayList<Cost_SubItems_Info> sublist = headerinfo.getList();

         int listsize = sublist.size();
         listsize++;
         Cost_SubItems_Info detailinfo = new Cost_SubItems_Info();

         detailinfo.setName(subcost);
         detailinfo.setSequence(String.valueOf(listsize));
         sublist.add(detailinfo);

         headerinfo.setList(sublist);

        // gpoupPosition

        gpoupPosition = deptlist.indexOf(headerinfo);

        return  gpoupPosition;
    }


}
