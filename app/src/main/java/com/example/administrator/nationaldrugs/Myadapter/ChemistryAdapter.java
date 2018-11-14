package com.example.administrator.nationaldrugs.Myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.nationaldrugs.Model.chemistry;
import com.example.administrator.nationaldrugs.R;

import java.util.List;

import static com.example.administrator.nationaldrugs.Webservice.Const.url;

/**
 * Created by Administrator on 2016/11/23.
 */

public class ChemistryAdapter extends BaseAdapter {
    private List<chemistry> list;
    Context context;
    String path;
    public ChemistryAdapter(Context context, List<chemistry> list){
        this.context = context;
        this.list=list;
    }
    @Override
    public View getView(final int position, View convertView,
                        ViewGroup parent) {
       ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.cheitems, null);
            holder = new ViewHolder();
            holder.cmformula = (TextView) convertView
                    .findViewById(R.id.cmformula);
            holder.cmname = (TextView) convertView
                    .findViewById(R.id.cmname);
            holder.cmpic = (ImageView) convertView
                    .findViewById(R.id.cmpic);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        chemistry drug = (chemistry) getItem(position);
        holder.cmformula.setText(drug.getCmformula());
        holder.cmname.setText(drug.getCmname());
        path=url+drug.getPath().replace("~","");
        Glide.with(context).load(path).
                asBitmap(). //强制处理为bitmap
                into(holder.cmpic);//显示到目标View中
        return convertView;
    }
    class ViewHolder {
        TextView  cmname;
        TextView  cmformula;
        ImageView cmpic;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
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
