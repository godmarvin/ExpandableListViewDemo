package jay.com.expandablelistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jay on 2015/9/25 0025.
 */
public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

    private ArrayList<Group> gData;
    private ArrayList<ArrayList<Item>> iData;
    private Context mContext;
    ExpandableListView exlist_lol;

    public MyBaseExpandableListAdapter(ArrayList<Group> gData,ArrayList<ArrayList<Item>> iData,
                                       Context mContext,ExpandableListView exlist_lol) {
        this.gData = gData;
        this.iData = iData;
        this.mContext = mContext;
        this.exlist_lol = exlist_lol;
    }

    public void setCollectedInfo(CollectedInfo collectedInfo){

        this.collectedInfo = collectedInfo;
    }

    @Override
    public int getGroupCount() {
        return gData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return iData.get(groupPosition).size();
    }

    @Override
    public Group getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }

    @Override
    public Item getChild(int groupPosition, int childPosition) {
        return iData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //取得用于显示给定分组的视图. 这个方法仅返回分组的视图对象
    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        final ViewHolderGroup groupHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_exlist_group, parent, false);
            groupHolder = new ViewHolderGroup();
            groupHolder.tv_group_name = (TextView) convertView.findViewById(R.id.tv_group_name);
            groupHolder.checkBoxgroup = (CheckBox) convertView.findViewById(R.id.select_item_all);
            convertView.setTag(groupHolder);
        }else{
            groupHolder = (ViewHolderGroup) convertView.getTag();
        }
        groupHolder.checkBoxgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gData.get(groupPosition).setChecked(groupHolder.checkBoxgroup.isChecked());
                for(Item item :iData.get(groupPosition)){
                    item.setChecked(groupHolder.checkBoxgroup.isChecked());
                }
                notifyDataSetChanged();
                collectedInfo.collected();//方法回调
            }
        });
        groupHolder.tv_group_name.setText(gData.get(groupPosition).getgName());
        groupHolder.checkBoxgroup.setChecked(gData.get(groupPosition).isChecked());
        return convertView;
    }

    //取得显示给定分组给定子位置的数据用的视图
    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ViewHolderItem itemHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_exlist_item, parent, false);
            itemHolder = new ViewHolderItem();
            itemHolder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            itemHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            itemHolder.checkBoxItem = (CheckBox) convertView.findViewById(R.id.select_item);
            convertView.setTag(itemHolder);
        }else{
            itemHolder = (ViewHolderItem) convertView.getTag();
        }
        itemHolder.img_icon.setImageResource(iData.get(groupPosition).get(childPosition).getiId());
        itemHolder.tv_name.setText(iData.get(groupPosition).get(childPosition).getiName());
        itemHolder.checkBoxItem.setChecked(iData.get(groupPosition).get(childPosition).isChecked());
        itemHolder.checkBoxItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iData.get(groupPosition).get(childPosition).setChecked(itemHolder.checkBoxItem.isChecked());
                if(gData.get(groupPosition).isChecked()!=itemHolder.checkBoxItem.isChecked()){
                    if(itemHolder.checkBoxItem.isChecked()==false){
                        gData.get(groupPosition).setChecked(false);
                        notifyDataSetChanged();
                    }
                }
                //判断是否全选
                if(valiItemChecked(groupPosition)){
                    exlist_lol.collapseGroup(groupPosition);
                    gData.get(groupPosition).setChecked(true);
                    notifyDataSetChanged();
                }
                collectedInfo.collected();//方法回调
            }
        });
        return convertView;
    }

    public boolean valiItemChecked(final int groupPosition){

        for (Item item:iData.get(groupPosition)){
            if(!item.isChecked()){
            return false;
            }
        }
        return true;
    }

    //设置子列表是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    private static class ViewHolderGroup{
        private TextView tv_group_name;
        private CheckBox checkBoxgroup;
    }

    private static class ViewHolderItem{
        private ImageView img_icon;
        private TextView tv_name;
        private CheckBox checkBoxItem;
    }


    public CollectedInfo collectedInfo;

    public interface CollectedInfo{
        public void collected();
    }
}
