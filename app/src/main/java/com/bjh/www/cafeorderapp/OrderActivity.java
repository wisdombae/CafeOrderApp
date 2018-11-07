package com.bjh.www.cafeorderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvPrice1, tvPrice2, tvPrice3, tvPrice4, tvPrice5, tvPrice6, tvSum;
    TextView tvNum1, tvNum2, tvNum3, tvNum4, tvNum5, tvNum6;
    Button btnOK, btnX, btnSum;

    int price1, price2, price3, price4, price5, price6, sum;
    int num1, num2, num3, num4, num5, num6;
    String str1, str2, str3, str4, str5, str6;
    String strnum1, strnum2, strnum3, strnum4, strnum5, strnum6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvSum = (TextView)findViewById(R.id.textViewSum);

        tvPrice1 = (TextView)findViewById(R.id.textViewPrice1);
        tvPrice2 = (TextView)findViewById(R.id.textViewPrice2);
        tvPrice3 = (TextView)findViewById(R.id.textViewPrice3);
        tvPrice4 = (TextView)findViewById(R.id.textViewPrice4);
        tvPrice5 = (TextView)findViewById(R.id.textViewPrice5);
        tvPrice6 = (TextView)findViewById(R.id.textViewPrice6);

        str1 = tvPrice1.getText().toString();
        price1 = Integer.parseInt(str1);
        str2 = tvPrice2.getText().toString();
        price2 = Integer.parseInt(str2);
        str3 = tvPrice3.getText().toString();
        price3 = Integer.parseInt(str3);
        str4 = tvPrice4.getText().toString();
        price4 = Integer.parseInt(str4);
        str5 = tvPrice5.getText().toString();
        price5 = Integer.parseInt(str5);
        str6 = tvPrice6.getText().toString();
        price6 = Integer.parseInt(str6);

        tvNum1 = (TextView)findViewById(R.id.textViewNum1);
        tvNum2 = (TextView)findViewById(R.id.textViewNum2);
        tvNum3 = (TextView)findViewById(R.id.textViewNum3);
        tvNum4 = (TextView)findViewById(R.id.textViewNum4);
        tvNum5 = (TextView)findViewById(R.id.textViewNum5);
        tvNum6 = (TextView)findViewById(R.id.textViewNum6);

        strnum1 = tvNum1.getText().toString();
        num1 = Integer.parseInt(strnum1);
        strnum2 = tvNum2.getText().toString();
        num2 = Integer.parseInt(strnum2);
        strnum3 = tvNum3.getText().toString();
        num3 = Integer.parseInt(strnum3);
        strnum4 = tvNum4.getText().toString();
        num4 = Integer.parseInt(strnum4);
        strnum5 = tvNum5.getText().toString();
        num5 = Integer.parseInt(strnum5);
        strnum6 = tvNum6.getText().toString();
        num6 = Integer.parseInt(strnum6);

        btnOK = (Button)findViewById(R.id.buttonOK);
        btnOK.setOnClickListener(this);
        btnX = (Button)findViewById(R.id.buttonCancel);
        btnX.setOnClickListener(this);
        btnSum = (Button)findViewById(R.id.buttonSum);
        btnSum.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch(id) {
            case R.id.buttonSum:
                sum = num1*price1 + num2*price2 + num3*price3 + num4*price4 + num5*price5 + num6*price6;
                tvSum.setText("" + sum);
                break;
            case R.id.buttonOK:

                break;
            case R.id.buttonCancel:
                break;

            default:
                break;
        }
    }
}
