package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.Research;
import com.example.administrator.nationaldrugs.Model.chemistry;
import com.example.administrator.nationaldrugs.Myadapter.ChemistryAdapter;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chemistry extends AppCompatActivity {
    private List<chemistry> list=new ArrayList<>();
    private ListView lv;
    String MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);
        lv=(ListView)findViewById(R.id.che);
        MM=getIntent().getStringExtra("drugid");
        list= WebserviceTest.getchemistry(MM);
        lv.setAdapter(new ChemistryAdapter(this,list));
        Toast.makeText(Chemistry.this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
    }
    public void chenext(View view)
    {
        Intent intent=new Intent(Chemistry.this,Right.class);
        intent.putExtra("drugid",MM);
        startActivity(intent);
    }
}
