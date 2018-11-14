package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.Reference;
import com.example.administrator.nationaldrugs.Model.right;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class reference extends AppCompatActivity {
    private List<Map<String,String>> list=new ArrayList<>();
    private List<Reference> List=new ArrayList<>();
    private ListView lv;
    int[]id={R.id.title,R.id.magazine,R.id.author,R.id.gov,R.id.province,
            R.id.year,R.id.vol,R.id.page,R.id.abs};
    String[]res={"title","magazine","author","gov","province","year","vol","page","abs"};
    String MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);
        lv=(ListView)findViewById(R.id.refer);
        MM=getIntent().getStringExtra("drugid");
        List= WebserviceTest.getReference(MM);
        for (int i=0;i<List.size();i++)
        {
            Reference drug= List.get(i);
            Map<String,String>map=new HashMap<>();
            map.put("title",drug.getTitle());
            map.put("magazine",drug.getMagazine());
            map.put("author",drug.getAuthor());
            map.put("gov",drug.getGov());
            map.put("province",drug.getProvince());
            map.put("year",drug.getYear());
            map.put("vol",drug.getVol());
            map.put("page",drug.getPage());
            map.put("abs",drug.getAbs());
            list.add(map);
        }
        lv.setAdapter(new SimpleAdapter(this,list,R.layout.referitems, res, id));
        Toast.makeText(reference.this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
    }
    public void refernext(View view)
    {
        Intent intent=new Intent(reference.this,heredity.class);
        intent.putExtra("drugid",MM);
        startActivity(intent);
    }
}
