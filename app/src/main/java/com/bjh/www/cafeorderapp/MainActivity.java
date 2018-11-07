package com.bjh.www.cafeorderapp;

import android.database.sqlite.SQLiteDatabase;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDBOpenHelper(this, "order.db", null, 1);
        mdb = dbHelper.getWritableDatabase();

        Button buttonOrder = findViewById(R.id.buttonOrder);
        buttonOrder.setOnClickListener(this);
        TextView textViewDate = findViewById(R.id.textViewDate);
        TextView textViewCount = findViewById(R.id.textViewCount);

        Button btnCal1, btnCal2, btnCal3, btnCal4,
                btnCancel1, btnCancel2, btnCancel3, btnCancel4;

        btnCal1 = findViewById(R.id.btnCal1);
        btnCal1.setOnClickListener(this);
        btnCal2 = findViewById(R.id.btnCal2);
        btnCal2.setOnClickListener(this);
        btnCal3 = findViewById(R.id.btnCal3);
        btnCal3.setOnClickListener(this);
        btnCal4 = findViewById(R.id.btnCal4);
        btnCal4.setOnClickListener(this);

        btnCancel1 = findViewById(R.id.btnCancel1);
        btnCancel1.setOnClickListener(this);
        btnCancel2 = findViewById(R.id.btnCancel2);
        btnCancel2.setOnClickListener(this);
        btnCancel3 = findViewById(R.id.btnCancel3);
        btnCancel3.setOnClickListener(this);
        btnCancel4 = findViewById(R.id.btnCancel4);
        btnCancel4.setOnClickListener(this);



        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String date = format.format(new Date());

        textViewDate.setText(date);
        textViewCount.setText("오늘 주문건수: ");


    }



    //option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    //option menu
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

        TextView textViewOrderNum1 = (TextView)findViewById(R.id.textViewOrderNum1);
        String orderNum1 = textViewOrderNum1.getText().toString();

        TextView textViewTableNum1 =(TextView)findViewById(R.id.textViewTableNum1);

        TextView textViewOrderList1 =(TextView)findViewById(R.id.textViewOrderList1);
        String orderList1 = textViewOrderList1.getText().toString();

        TextView textViewOrderSum1 = (TextView) findViewById(R.id.textViewOrderSum1);
        int orderSum1 = 12000;

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String datetime = format.format(new Date());

        switch (v.getId()){
            case R.id.buttonOrder:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivityForResult(intent, 100);
                break;
            case R.id.btnCal1:
                mdb.execSQL("INSERT INTO menu Values('"+orderNum1+"','"+orderList1+"','"+orderSum1+"');");
                break;

            case R.id.btnCancel1:
                textViewOrderNum1.setText("NO.");
                textViewOrderList1.setText("");
                textViewOrderSum1.setText("합계: ");

                break;


        }






    }
}
