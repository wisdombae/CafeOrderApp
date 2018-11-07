package com.bjh.www.cafeorderapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderListActivity extends AppCompatActivity implements View.OnClickListener {


    SQLiteDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        Button btnOrderListBack = findViewById(R.id.btnOrderListBack);
        btnOrderListBack.setOnClickListener(this);
        Button btnOrderListDate = findViewById(R.id.btnOrderListDate);
        btnOrderListDate.setOnClickListener(this);



        TextView textViewOrderListDate = findViewById(R.id.textViewOrderListDate);


        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String date= format.format(new Date());

        textViewOrderListDate.setText(date);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOrderListBack:
                Intent intent = new Intent(this, MainActivity.class);
                startActivityForResult(intent, 1000);
                break;

//            case R.id.btnOrderListDate:
//                TextView textViewOrderList = findViewById(R.id.textViewOrderList);
//                String query = "SELECT * FROM menu";
//
//                Cursor cursor = mdb.rawQuery(query,null);
//                String str ="";
//                while (cursor.moveToNext()){
//                    String pkid = "x";
//                    String name = cursor.getString(cursor.getColumnIndex("menu_name"));
//                    int cost = cursor.getInt(cursor.getColumnIndex("cost"));
//                    str+=(pkid+":"+name+"-"+Integer.toString(cost)+"\n");
//                }
//                textViewOrderList.setText(str);
                

        }

    }
}
