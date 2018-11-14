package com.example.administrator.nationaldrugs.Myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.nationaldrugs.Model.DRUG;
import com.example.administrator.nationaldrugs.R;

import java.util.List;



/**
 * Created by Administrator on 2016/11/3.
 */

public  class Adapter extends BaseAdapter {
    private List<DRUG> list;
    Context context;
    private LayoutInflater listContainer;
    public Adapter(Context c,List<DRUG> list) {
        this.context = c;
        listContainer=LayoutInflater.from(c);
        this.list = list;
    }

    @Override
    public View getView( int position, View convertView,
                        ViewGroup parent){
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView =listContainer.inflate(R.layout.items, null);
            holder.drugid = (TextView) convertView
                    .findViewById(R.id.drugid);
            holder.nationName = (TextView) convertView
                    .findViewById(R.id.nationName);
            holder.transltName = (TextView) convertView
                    .findViewById(R.id.transltName);
            holder.name = (TextView) convertView
                    .findViewById(R.id.name);
            holder.position = (TextView) convertView
                    .findViewById(R.id.position);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        DRUG drug = (DRUG) getItem(position);
        holder.drugid.setText(drug.getdrugid());
        holder.nationName.setText(drug.getnationName());
        holder.transltName.setText(drug.gettransltName());
        holder.name.setText(drug.getname());
        holder.position.setText(drug.getposition());
        return convertView;

    }
    private class ViewHolder {
        TextView drugid;
        TextView nationName;
        TextView transltName;
        TextView name;
        TextView position;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        //return this.list!=null? this.list.size(): 0 ;
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }



}
