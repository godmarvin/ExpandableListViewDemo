package jay.com.expandablelistviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Group> gData = null;
    private ArrayList<ArrayList<Item>> iData = null;
    private ArrayList<Item> lData = null;
    private Context mContext;
    private ExpandableListView exlist_lol;
    private CheckBox checkBoxAll;
    private MyBaseExpandableListAdapter myAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        exlist_lol = (ExpandableListView) findViewById(R.id.exlist_lol);
        checkBoxAll = (CheckBox) findViewById(R.id.select_item);


        checkBoxAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                for(int i=0;i<gData.size();i++){

                    gData.get(i).setChecked(isChecked);
                    for(Item item:iData.get(i)){
                        item.setChecked(isChecked);
                    }
                }
                myAdapter.notifyDataSetChanged();
            }
        });

        //数据准备
        gData = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<Item>>();
        gData.add(new Group("AD",false));
        gData.add(new Group("AP",false));
        gData.add(new Group("TANK",false));

        lData = new ArrayList<Item>();

        //AD组
        lData.add(new Item(R.mipmap.iv_lol_icon3,"剑圣",false));
        lData.add(new Item(R.mipmap.iv_lol_icon4,"德莱文",false));
        lData.add(new Item(R.mipmap.iv_lol_icon13,"男枪",false));
        lData.add(new Item(R.mipmap.iv_lol_icon14,"韦鲁斯",false));
        iData.add(lData);
        //AP组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.iv_lol_icon1, "提莫",false));
        lData.add(new Item(R.mipmap.iv_lol_icon7, "安妮",false));
        lData.add(new Item(R.mipmap.iv_lol_icon8, "天使",false));
        lData.add(new Item(R.mipmap.iv_lol_icon9, "泽拉斯",false));
        lData.add(new Item(R.mipmap.iv_lol_icon11, "狐狸",false));
        iData.add(lData);
        //TANK组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.iv_lol_icon2, "诺手",false));
        lData.add(new Item(R.mipmap.iv_lol_icon5, "德邦",false));
        lData.add(new Item(R.mipmap.iv_lol_icon6, "奥拉夫",false));
        lData.add(new Item(R.mipmap.iv_lol_icon10, "龙女",false));
        lData.add(new Item(R.mipmap.iv_lol_icon12, "狗熊",false));
        iData.add(lData);

        myAdapter = new MyBaseExpandableListAdapter(gData,iData,mContext);
        exlist_lol.setAdapter(myAdapter);


        //为列表设置点击事件
        exlist_lol.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                Toast.makeText(mContext, "你点击了：" + iData.get(groupPosition).get(childPosition).getiName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }
}
