package com.example.administrator.nationaldrugs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.Image;
import com.example.administrator.nationaldrugs.Myadapter.ImageAdapter;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class image extends AppCompatActivity {

    private List<Image> list=new ArrayList<>();
    private ListView lv;
    String MM;
    private Spinner spinner;
    private String[]type={"药材图像", "原植物图像", "种质资源图像 ","标本图像"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        lv=(ListView)findViewById(R.id.ige);
        spinner=(Spinner)findViewById(R.id.imagetype);
        spinner.setAdapter(new ArrayAdapter<>(image.this, R.layout.support_simple_spinner_dropdown_item, type));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MM=getIntent().getStringExtra("drugid");
                    list = WebserviceTest.getImagetype(MM, position);
                    lv.setAdapter(new ImageAdapter(image.this, list));
                    Toast.makeText(image.this, "共查询到" + list.size() + "张" + type[position] + "图片",
                            Toast.LENGTH_SHORT).show();
                return;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void igenext(View view)
    {
        Intent intent=new Intent(image.this,share.class);
        intent.putExtra("drugid",MM);
        startActivity(intent);
    }
}
