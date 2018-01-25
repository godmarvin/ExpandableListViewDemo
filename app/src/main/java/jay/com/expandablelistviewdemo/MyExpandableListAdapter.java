/*
package jay.com.expandablelistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

*/
/**
 * Created by godmarvin on 18-1-25.
 *//*


public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    //Variables
// Sample data set.  children[i] contains the children (String[]) for groups[i].
    private String[] groups = {"People Names", "Dog Names", "Cat Names", "Fish Names"}; //headers
    private String[][] children = {
            {"Arnold", "Barry", "Chuck", "David"},
            {"Ace", "Bandit", "Cha-Cha", "Deuce"},
            {"Fluffy", "Snuggles"},
            {"Goldy", "Bubbles"}
    };
    private String[] group_vaues = {"PN", "DN", "CN", "FN"};
    private String[][] children_values = {
            {"Ar", "Ba", "Ch", "Da"},
            {"Ace", "Ban", "Cha", "Deu"},
            {"Flu", "Snu"},
            {"Gol", "Bub"}
    };
    ArrayList<ArrayList<Integer>> check_states = new ArrayList<ArrayList<Integer>>();

    private Context context;

    //Constructors
    public MyExpandableListAdapter() {

    }

    public MyExpandableListAdapter(Context c) {
        this.context = c;
    }

    //Set Methods
    public void setGroupsAndValues(String[] g, String[] v) {
        this.groups = g;
        this.group_vaues = v;
    }

    public void setChildrenAndValues(String[][] c, String[][] v) {
        this.children = c;
        this.children_values = v;
        //initialize the states to all 0;
        for (int i = 0; i < c.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < c[i].length; j++) {
                tmp.add(0);
            }
            check_states.add(tmp);
        }
    }

    //Get Methods
    public Object getChild(int groupPosition, int childPosition) {
        return children[groupPosition][childPosition];
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
        return children[groupPosition].length;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        View grid;


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        grid = inflater.inflate(R.layout.specialty_list_item, parent, false);

        final int grpPos = groupPosition;
        final int childPos = childPosition;

        TextView header = (TextView) grid.findViewById(R.id.title);
        header.setText(getChild(groupPosition, childPosition).toString());
        final View tick = grid.findViewById(R.id.image);
        if (check_states.get(grpPos).get(childPos) == 1)
            tick.setVisibility(View.VISIBLE);
        else
            tick.setVisibility(View.GONE);

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_states.get(grpPos).set(childPos, 1);
                tick.setVisibility(View.VISIBLE);
            }
        });

        return grid;
    }

    public Object getGroup(int groupPosition) {
        return groups[groupPosition];
    }

    public int getGroupCount() {
        return groups.length;
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        View grid;

        if (convertView == null) {
            grid = new View(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.specialty_header, parent, false);
        } else {
            grid = (View) convertView;
        }

        TextView header = (TextView) grid.findViewById(R.id.specialty_header);
        header.setText(getGroup(groupPosition).toString());


        return grid;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public boolean hasStableIds() {
        return true;
    }

}*/
