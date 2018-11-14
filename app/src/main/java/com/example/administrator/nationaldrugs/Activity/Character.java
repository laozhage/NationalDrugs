package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.character;
import com.example.administrator.nationaldrugs.Model.preparation;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Character extends AppCompatActivity {
    private java.util.List<Map<String,String>> list=new ArrayList<>();
    private List<character>List=new ArrayList<>();
    private ListView lv;
    int[]id={R.id.cc14,R.id.cc15,R.id.cc16,R.id.cc17,R.id.cc18,R.id.cc19,R.id.cc20};
    String[]res={"cc14","cc15","cc16","cc17","cc18","cc19","cc20"};
    String MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        lv=(ListView)findViewById(R.id.cha);
        MM=getIntent().getStringExtra("drugid");
        List= WebserviceTest.getcharacter(MM);
        for (int i=0;i<List.size();i++)
        {
            character drug= List.get(i);
            Map<String,String>map=new HashMap<>();
            map.put("cc14",drug.getCc14());
            map.put("cc15",drug.getCc15());
            map.put("cc16",drug.getCc16());
            map.put("cc17",drug.getCc17());
            map.put("cc18",drug.getCc18());
            map.put("cc19",drug.getCc19());
            map.put("cc20",drug.getCc20());
            list.add(map);
        }
        lv.setAdapter(new SimpleAdapter(this,list,R.layout.chaitems, res, id));
        Toast.makeText(Character.this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
    }
    public void chanext(View view)
    {
        Intent intent=new Intent(Character.this,research.class);
        intent.putExtra("drugid",MM);
        startActivity(intent);
    }
}
