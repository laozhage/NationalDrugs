package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.Reference;
import com.example.administrator.nationaldrugs.Model.Share;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class share extends AppCompatActivity {
    private List<Map<String,String>> list=new ArrayList<>();
    private List<Share> List=new ArrayList<>();
    private ListView lv;
    int[]id={R.id.ishareway,R.id.iobtainway,R.id.man,R.id.depart,
            R.id.mcode,R.id.tel,R.id.email,};
    String[]res={"ishareway","iobtainway","man","depart","mcode","tel","email"};
    String MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        lv=(ListView)findViewById(R.id.share);
        MM=getIntent().getStringExtra("drugid");
        List= WebserviceTest.getShare(MM);
        for (int i=0;i<List.size();i++)
        {
            Share drug= List.get(i);
            Map<String,String>map=new HashMap<>();
            map.put("ishareway",drug.getIshareway());
            map.put("iobtainway",drug.getIobtainway());
            map.put("man",drug.getMan());
            map.put("depart",drug.getDepart());
            map.put("mcode",drug.getMcode());
            map.put("tel",drug.getTel());
            map.put("email",drug.getEmail());
            list.add(map);
        }
        lv.setAdapter(new SimpleAdapter(this,list,R.layout.shareitems, res, id));
        Toast.makeText(share.this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
        Toast.makeText(share.this, "已经到最后一页了", Toast.LENGTH_SHORT).show();
    }
    public void getback(View view)
    {
        Intent intent=new Intent(share.this,Query.class);
        startActivity(intent);
    }
}
