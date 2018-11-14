package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.Heredity;
import com.example.administrator.nationaldrugs.Model.Reference;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class heredity extends AppCompatActivity {
    private List<Map<String,String>> list=new ArrayList<>();
    private List<Heredity> List=new ArrayList<>();
    private ListView lv;
    int[]id={R.id.hdt41,R.id.hdt42,R.id.hdt43,R.id.hdt44,R.id.hdt45,
            R.id.hdt46,R.id.hdt47,R.id.hdt48,R.id.hdt49,R.id.hdt50,
            R.id.hdt51,R.id.hdt52,R.id.hdt53,R.id.hdt54,R.id.hdt55,
            R.id.hdt56,R.id.hdt57,R.id.hdt58,R.id.hdt59,R.id.hdt60,
            R.id.hdt61,R.id.hdt62,R.id.hdt63,R.id.hdt64,R.id.hdt65,R.id.hdt66,R.id.hdt67};
    String[]res={"hdt41","hdt42","hdt43","hdt44","hdt45","hdt46","hdt47",
            "hdt48","hdt49","hdt50","hdt51","hdt52","hdt53","hdt54",
            "hdt55","hdt56","hdt57","hdt58","hdt59","hdt60","hdt61","hdt62",
            "hdt63","hdt64","hdt65","hdt66","hdt67"};
    String MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heredity);
        lv=(ListView)findViewById(R.id.here);
        MM=getIntent().getStringExtra("drugid");
        List= WebserviceTest.getHeredity(MM);
        for (int i=0;i<List.size();i++)
        {
            Heredity drug= List.get(i);
            Map<String,String>map=new HashMap<>();
            map.put("hdt41",drug.getHdt41());
            map.put("hdt42",drug.getHdt42());
            map.put("hdt43",drug.getHdt43());
            map.put("hdt44",drug.getHdt44());
            map.put("hdt45",drug.getHdt45());
            map.put("hdt46",drug.getHdt46());
            map.put("hdt47",drug.getHdt47());
            map.put("hdt48",drug.getHdt48());
            map.put("hdt49",drug.getHdt49());
            map.put("hdt50",drug.getHdt50());
            map.put("hdt51",drug.getHdt51());
            map.put("hdt52",drug.getHdt52());
            map.put("hdt53",drug.getHdt53());
            map.put("hdt54",drug.getHdt54());
            map.put("hdt55",drug.getHdt55());
            map.put("hdt56",drug.getHdt56());
            map.put("hdt57",drug.getHdt57());
            map.put("hdt58",drug.getHdt58());
            map.put("hdt59",drug.getHdt59());
            map.put("hdt60",drug.getHdt60());
            map.put("hdt61",drug.getHdt61());
            map.put("hdt62",drug.getHdt62());
            map.put("hdt63",drug.getHdt63());
            map.put("hdt64",drug.getHdt64());
            map.put("hdt65",drug.getHdt65());
            map.put("hdt66",drug.getHdt66());
            map.put("hdt67",drug.getHdt67());
            list.add(map);
        }
        lv.setAdapter(new SimpleAdapter(this,list,R.layout.hereitems, res, id));
        Toast.makeText(heredity.this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
    }
    public void herenext(View view)
    {
        Intent intent=new Intent(heredity.this,image.class);
        intent.putExtra("drugid",MM);
        startActivity(intent);
    }
}
