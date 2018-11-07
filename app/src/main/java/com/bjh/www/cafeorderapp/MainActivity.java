package com.bjh.www.cafeorderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{//adsfsdfadsfadfadfadfsdf

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOrder = findViewById(R.id.buttonOrder);
        buttonOrder.setOnClickListener(this);
        TextView textViewDate = findViewById(R.id.textViewDate);
        TextView textViewCount = findViewById(R.id.textViewCount);

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String datetime = format.format(new Date());

        textViewDate.setText(datetime);
        textViewCount.setText("오늘 주문건수: ");




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemOrder:
                Intent intent = new Intent(this, OrderListActivity.class);
                startActivityForResult(intent, 1000);
                return true;
            case R.id.itemMenu:
                Intent intent1 = new Intent(this, EditMenuActivity.class);
                startActivityForResult(intent1, 1000);

                return true;
            case R.id.itemTable:
                Intent intent2 = new Intent(this, EditTableActivity.class);
                startActivityForResult(intent2, 1000);

                return true;

        }
        return false;
    }

    @Override
    public void onClick(View v) {



        Intent intent = new Intent(this, OrderActivity.class);
        startActivityForResult(intent, 100);




    }
}
