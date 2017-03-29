package com.bawei.xrecycleView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 1 on 2017/3/29.
 */
public class Apdte extends RecyclerView.Adapter<MyApdate>
{
    private Context context;
    private List<String> list;

    public Apdte(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public Apdte() {
        super();
    }

    public MyApdate onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_header, parent, false);
        MyApdate myApdate = new MyApdate(view);
        return myApdate;
    }


    @Override
    public void onBindViewHolder(MyApdate holder, int position)
    {
        holder.tt.setText(list.get(position));
    }


    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
class MyApdate extends RecyclerView.ViewHolder{
    TextView tt;
    public MyApdate(View itemView)
    {
        super(itemView);
        tt = (TextView) itemView.findViewById(R.id.TextView);
    }
}
