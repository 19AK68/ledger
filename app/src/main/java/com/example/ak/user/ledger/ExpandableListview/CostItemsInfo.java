package com.example.ak.user.ledger.ExpandableListview;

import java.util.ArrayList;

public class CostItemsInfo {

    private String Name;
    private ArrayList<Cost_SubItems_Info> list = new ArrayList<Cost_SubItems_Info>();

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Cost_SubItems_Info> getList() {
        return list;
    }

    public void setList(ArrayList<Cost_SubItems_Info> list) {
        this.list = list;
    }








}
