package com.example.panguangyi.diyview0401;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private HorizontalScrollViewEx mHorizontalScrollViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_horizontal_scrollview_ex);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = getLayoutInflater();
        mHorizontalScrollViewEx = (HorizontalScrollViewEx) findViewById(R.id.container);
        final int screenWidth = MyUtils.getScreenMetrics(this).widthPixels;
        final int screenHeight = MyUtils.getScreenMetrics(this).heightPixels;
        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.content_layout,mHorizontalScrollViewEx,false);
            TextView tv = layout.findViewById(R.id.tvTitle);
            tv.setText("page" + (i + 1));
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1),0));
            createList(layout);
            mHorizontalScrollViewEx.addView(layout);
        }
    }

    private void createList(ViewGroup layout) {
        ListView lv = layout.findViewById(R.id.lvList);
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("name" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.content_list_item,R.id.tvName,datas);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "click item" + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
