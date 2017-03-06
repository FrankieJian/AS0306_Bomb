package com.example.g572_528r.as0306_bomb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {
    private Button btn_insert;
    private TextView txt_con;
    private RecyclerView mRecyclerView;
    private List<Person> mPersonList = new ArrayList<>();
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this, "17edadaf31b491c9074b7a27c30ecc86");

        initViews();
        queryAll();
    }

    private void queryAll() {
        BmobQuery<Person> personBmobQuery = new BmobQuery<>();
        personBmobQuery.findObjects(new FindListener<Person>() {
            @Override
            public void done(List<Person> list, BmobException e) {
                if(e==null) {
                    mPersonList = list;
                    mMyAdapter = new MyAdapter(mPersonList);
                    LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                    mRecyclerView.setLayoutManager(manager);
                    mRecyclerView.setAdapter(mMyAdapter);
                    mMyAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void initViews() {
        btn_insert = (Button) findViewById(R.id.insert_btn);
        txt_con = (TextView) findViewById(R.id.con_txt);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p1 = new Person();
                p1.setName("GGG");
                p1.setAge(20);
                p1.setAddress("体育西路");
                p1.setScore(100);
                p1.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        txt_con.setText(s);
                    }
                });
            }
        });
    }
}
