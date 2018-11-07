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
        String ordered_list_seq= textViewOrderNum1.getText().toString();

        int ordered_count=1;

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss");
        String ordered_date = format.format(new Date());

        String tableseat_seq="aa";

        TextView textViewTableNum1 =(TextView)findViewById(R.id.textViewTableNum1);
        String tableseat_name = textViewTableNum1.getText().toString();

        String menu_seq="bb";

        TextView textViewOrderList1 =(TextView)findViewById(R.id.textViewOrderList1);
        String  menu_name = textViewOrderList1.getText().toString();

        TextView textViewOrderSum1 = (TextView) findViewById(R.id.textViewOrderSum1);
        int cost = Integer.parseInt(textViewOrderSum1.getText().toString());



        switch (v.getId()){
            case R.id.buttonOrder:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivityForResult(intent, 100);
                break;
            case R.id.btnCal1:
                mdb.execSQL("INSERT INTO ordered_list Values('"+ordered_list_seq+"','"+ordered_count+"','"+ordered_date+"'"+",'"+tableseat_seq+"','"+tableseat_name+"','"+menu_seq+"','"+menu_name+"','"+cost+"');");
                textViewOrderNum1.setText("NO.");
                textViewOrderList1.setText("");
                
            case R.id.btnCancel1:
                textViewOrderNum1.setText("NO.");
                textViewOrderList1.setText("");
                textViewOrderSum1.setText("");




        }






    }
}
