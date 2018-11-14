package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.chemistry;
import com.example.administrator.nationaldrugs.Model.right;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Right extends AppCompatActivity {
    private List<Map<String,String>> list=new ArrayList<>();
    private List<right> List=new ArrayList<>();
    private ListView lv;
    int[]id={R.id.rttype,R.id.rtname,R.id.rtcontent,};
    String[]res={"rttype","rtname","rtcontent",};
    String MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right);
        lv=(ListView)findViewById(R.id.rig);
        MM=getIntent().getStringExtra("drugid");
        List= WebserviceTest.getright(MM);
        for (int i=0;i<List.size();i++)
        {
            right drug= List.get(i);
            Map<String,String>map=new HashMap<>();
            map.put("rttype",drug.getRttype());
            map.put("rtname",drug.getRtname());
            map.put("rtcontent",drug.getRtcontent());
            list.add(map);
        }
        lv.setAdapter(new SimpleAdapter(this,list,R.layout.rigitems, res, id));
        Toast.makeText(Right.this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
    }
    public void rignext(View view)
    {
        Intent intent=new Intent(Right.this,reference.class);
        intent.putExtra("drugid",MM);
        startActivity(intent);
    }
}
