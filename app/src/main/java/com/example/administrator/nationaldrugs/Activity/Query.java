package com.example.administrator.nationaldrugs.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.nationaldrugs.Model.DRUG;
import com.example.administrator.nationaldrugs.Myadapter.Adapter;
import com.example.administrator.nationaldrugs.R;
import com.example.administrator.nationaldrugs.Webservice.WebserviceTest;
import com.example.administrator.nationaldrugs.Webservice.network;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Query extends AppCompatActivity  {

    EditText st;
    ListView lv;
    List<DRUG> list = new ArrayList<>();
    Button btn;
    Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]+");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        initView();
        if (network.isNetworkAvailable(Query.this))
        {
            new Thread(networkTask).start();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "当前没有可用网络！", Toast.LENGTH_LONG).show();
        }

    }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(Query.this, "无法访问服务器", Toast.LENGTH_LONG).show();
                case 1:
                    Toast.makeText(Query.this, "成功连接服务器", Toast.LENGTH_LONG).show();
                default:
                    break;
            }
        }
    };
    private void initView() {
        st = (EditText) findViewById(R.id.EditText1);
        lv = (ListView) findViewById(R.id.info);
        btn=(Button)findViewById(R.id.query);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = st.getText().toString().trim();
                Matcher m = p.matcher(s);
                if(m.find()&&m.group(0).equals(s)||s.isEmpty()) {
                    list = WebserviceTest.getDrug(s);
                    if (list.isEmpty()) {
                        Toast.makeText(Query

                                .this, "没有匹配的信息，请重新输入", Toast.LENGTH_SHORT).show();
                    } else {
                        lv.setAdapter(new Adapter(Query.this, list));
                        Toast.makeText(Query.this, "共查询到" + list.size() + "条数据", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Query.this, "请输入有效的关键字！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=(TextView) view.findViewById(R.id.drugid);
                String text=tv.getText().toString();
                Intent intent=new Intent(Query.this,Passport.class);
                intent.putExtra("drugid",text);
                startActivity(intent);
            }
        });
    }
    Runnable networkTask = new Runnable() {

        @Override
        public void run() {
            // TODO
            // 在这里进行 http request.网络请求相关操作
           if (network.isConnByHttp())
           {
               Message msg = new Message();
               msg.what = 1;
               handler.sendMessage(msg);
           }
            else {
               Message msg = new Message();
               msg.what = 0;
               handler.sendMessage(msg);
           }
        }
    };
}






