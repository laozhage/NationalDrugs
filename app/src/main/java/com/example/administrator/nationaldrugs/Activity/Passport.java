package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.passport;
import com.example.administrator.nationaldrugs.Myadapter.PassportAdapter;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.List;

public class Passport extends AppCompatActivity {
    ListView lv;
    List<passport> list = new ArrayList<>();
    String MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);
        lv = (ListView) findViewById(R.id.pass);
        MM=getIntent().getStringExtra("drugid");
        list=WebserviceTest.getPassport(MM);
        lv.setAdapter(new PassportAdapter(this,list));
        Toast.makeText(this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
    }
    public void passnext(View view)
    {
        Intent intent=new Intent(Passport.this,Preparation.class);
        intent.putExtra("drugid",MM);
        startActivity(intent);
    }
}
