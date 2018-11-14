package com.example.administrator.nationaldrugs.Myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.nationaldrugs.Model.passport;
import com.example.administrator.nationaldrugs.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

public class PassportAdapter extends BaseAdapter {
    private List<passport> list;
    Context context;
    private LayoutInflater listContainer;
    public PassportAdapter(Context c,List<passport> list) {
        this.context = c;
        listContainer=LayoutInflater.from(c);
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder holder ;
        if (convertView == null) {
            convertView = listContainer.inflate(R.layout.passitems, null);
            holder = new ViewHolder();
            holder.NationName = (TextView) convertView
                    .findViewById(R.id.nationName);
            holder.TransltName = (TextView) convertView
                    .findViewById(R.id.transltName);
            holder.Name = (TextView) convertView
                    .findViewById(R.id.name);
            holder.Position = (TextView) convertView
                    .findViewById(R.id.position);
            holder.channel = (TextView) convertView
                    .findViewById(R.id.channel);
            holder.effect = (TextView) convertView
                    .findViewById(R.id.effect);
            holder.func = (TextView) convertView
                    .findViewById(R.id.func);
            holder.usef = (TextView) convertView
                    .findViewById(R.id.usef);
            holder.Observe = (TextView) convertView
                    .findViewById(R.id.Observe);
            holder.standard = (TextView) convertView
                    .findViewById(R.id.standard);
            holder.useGUID = (TextView) convertView
                    .findViewById(R.id.useGUID);
            holder.classify = (TextView) convertView
                    .findViewById(R.id.classify);
            holder.subjectno = (TextView) convertView
                    .findViewById(R.id.subjectno);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        passport drug = (passport) getItem(position);
        holder.NationName.setText(drug.getNationName());
        holder.TransltName.setText(drug.getTransltName());
        holder.Name.setText(drug.getName());
        holder.Position.setText(drug.getPosition());
        holder.channel.setText(drug.getChannel());
        holder.effect.setText(drug.getEffect());
        holder.func.setText(drug.getFunc());
        holder.usef.setText(drug.getUsef());
        holder.Observe.setText(drug.getObserve());
        holder.standard.setText(drug.getStandard());
        holder.useGUID.setText(drug.getUseGUID());
        holder.classify.setText(drug.getClassify());
        holder.subjectno.setText(drug.getSubjectno());
        return convertView;
    }
    class ViewHolder {
        TextView Drugid;
        TextView NationName;
        TextView TransltName;
        TextView Name;
        TextView Position;
        TextView channel;
        TextView effect;
        TextView func;
        TextView usef;
        TextView Observe;
        TextView standard;
        TextView useGUID;
        TextView classify;
        TextView subjectno;
    }
}
