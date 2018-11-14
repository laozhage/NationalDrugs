package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.Research;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class research extends AppCompatActivity {
    private List<Map<String,String>> list=new ArrayList<>();
    private List<Research> List=new ArrayList<>();
    private ListView lv;
    int[]id={R.id.rsh21,R.id.rsh22,R.id.rsh23,R.id.rsh24,R.id.rsh25,R.id.rsh26,
            R.id.rsh27,R.id.rsh28,R.id.rsh29,R.id.rsh30,R.id.rsh31};
    String[]res={"rsh21","rsh22","rsh23","rsh24","rsh25","rsh26","rsh27","rsh28","rsh29","rsh30","rsh31"};
    String MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
        lv=(ListView)findViewById(R.id.res);
        MM=getIntent().getStringExtra("drugid");
        List= WebserviceTest.getResearch(MM);
        for (int i=0;i<List.size();i++)
        {
            Research drug= List.get(i);
            Map<String,String>map=new HashMap<>();
            map.put("rsh21",drug.getRsh21());
            map.put("rsh22",drug.getRsh22());
            map.put("rsh23",drug.getRsh23());
            map.put("rsh24",drug.getRsh24());
            map.put("rsh25",drug.getRsh25());
            map.put("rsh26",drug.getRsh26());
            map.put("rsh27",drug.getRsh27());
            map.put("rsh28",drug.getRsh28());
            map.put("rsh29",drug.getRsh29());
            map.put("rsh30",drug.getRsh30());
            map.put("rsh31",drug.getRsh31());
            list.add(map);
        }
        lv.setAdapter(new SimpleAdapter(this,list,R.layout.resitems, res, id));
        Toast.makeText(research.this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
    }
    public void resnext(View view)
    {
        Intent intent=new Intent(research.this,Chemistry.class);
        intent.putExtra("drugid",MM);
        startActivity(intent);
    }
}
