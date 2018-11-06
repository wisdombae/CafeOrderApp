package com.bjh.www.cafeorderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderListActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        Button btnOrderListBack = findViewById(R.id.btnOrderListBack);
        btnOrderListBack.setOnClickListener(this);
        TextView textViewOrderListDate = findViewById(R.id.textViewOrderListDate);

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String datetime = format.format(new Date());

        textViewOrderListDate.setText(datetime);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 1000);
    }
}
