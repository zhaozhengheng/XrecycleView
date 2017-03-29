package com.bawei.xrecycleView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView xx;
    private Apdte aa;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xx = (XRecyclerView) findViewById(R.id.XRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xx.setLayoutManager(layoutManager);


        list = new ArrayList<>();

        for(int i=0;i<20;i++)
        {
            list.add("第"+i+"条数据");
        }
        aa = new Apdte(MainActivity.this, list);
        xx.setAdapter(aa);
        xx.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh()
            {
                list.clear();
                for(int i=0;i<20;i++)
                {
                    list.add("第"+i+"条数据");
                }
                aa = new Apdte(MainActivity.this, list);
                aa.notifyDataSetChanged();
                xx.refreshComplete();
            }

            @Override
            public void onLoadMore()
            {
               list.add("新家的");
                aa.notifyDataSetChanged();
              xx.loadMoreComplete();
            }
        });
    }
}
