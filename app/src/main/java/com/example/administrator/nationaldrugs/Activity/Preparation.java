package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.preparation;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Preparation extends AppCompatActivity {
    private List<Map<String,String>> list=new ArrayList<>();
    private List<preparation>List=new ArrayList<>();
    private ListView lv;
    String MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation);
        lv=(ListView)findViewById(R.id.pre);
        MM=getIntent().getStringExtra("drugid");
        List= WebserviceTest.getpreparation(MM);
        for (int i=0;i<List.size();i++)
        {
            preparation drug= List.get(i);
            Map<String,String>map=new HashMap<>();
            map.put("pName",drug.getpName());
            map.put("about",drug.getAbout());
            list.add(map);
        }
        lv.setAdapter(new SimpleAdapter(this,list,R.layout.preitems,
                new String[]{"pName","about"}, new int[]{R.id.pName,R.id.about}));
        Toast.makeText(Preparation.this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
    }
    public void prenext(View view)
    {
        Intent intent=new Intent(Preparation.this,Character.class);
        intent.putExtra("drugid",MM);
        startActivity(intent);
    }
}
