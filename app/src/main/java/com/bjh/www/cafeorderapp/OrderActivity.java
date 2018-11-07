package com.bjh.www.cafeorderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvPrice1, tvPrice2, tvPrice3, tvPrice4, tvPrice5, tvPrice6, tvSum;
    TextView tvNum1, tvNum2, tvNum3, tvNum4, tvNum5, tvNum6;
    Button btnOK, btnX, btnSum;
    Button num1Plus, num2Plus, num3Plus, num4Plus, num5Plus, num6Plus;
    Button num1Minus, num2Minus, num3Minus, num4Minus, num5Minus, num6Minus;

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

        num1Plus = (Button)findViewById(R.id.button1Plus);          num1Plus.setOnClickListener(this);
        num2Plus = (Button)findViewById(R.id.button2Plus);          num2Plus.setOnClickListener(this);
        num3Plus = (Button)findViewById(R.id.button3Plus);          num3Plus.setOnClickListener(this);
        num4Plus = (Button)findViewById(R.id.button4Plus);          num4Plus.setOnClickListener(this);
        num5Plus = (Button)findViewById(R.id.button5Plus);          num5Plus.setOnClickListener(this);
        num6Plus = (Button)findViewById(R.id.button6Plus);          num6Plus.setOnClickListener(this);

        num1Minus = (Button)findViewById(R.id.button1Minus);        num1Minus.setOnClickListener(this);
        num2Minus = (Button)findViewById(R.id.button2Minus);        num2Minus.setOnClickListener(this);
        num3Minus = (Button)findViewById(R.id.button3Minus);        num3Minus.setOnClickListener(this);
        num4Minus = (Button)findViewById(R.id.button4Minus);        num4Minus.setOnClickListener(this);
        num5Minus = (Button)findViewById(R.id.button5Minus);        num5Minus.setOnClickListener(this);
        num6Minus = (Button)findViewById(R.id.button6Minus);        num6Minus.setOnClickListener(this);

        btnOK = (Button)findViewById(R.id.buttonOK);        btnOK.setOnClickListener(this);
        btnX = (Button)findViewById(R.id.buttonCancel);     btnX.setOnClickListener(this);
        btnSum = (Button)findViewById(R.id.buttonSum);      btnSum.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch(id) {
            case R.id.button1Plus:
                num1++;
                tvNum1.setText(Integer.toString(num1));
                break;
            case R.id.button1Minus:
                num1--;
                if(num1<0)  num1 = 0;
                tvNum1.setText(Integer.toString(num1));
                break;
            case R.id.button2Plus:
                num2++;
                tvNum2.setText(Integer.toString(num2));
                break;
            case R.id.button2Minus:
                num2--;
                if(num2<0)  num2 = 0;
                tvNum2.setText(Integer.toString(num2)); /////////////
                break;
            case R.id.button3Plus:
                num3++;
                tvNum3.setText(Integer.toString(num3));
                break;
            case R.id.button3Minus:
                num3--;
                if(num3<0)  num3 = 0;
                tvNum3.setText(Integer.toString(num3));
                break;
            case R.id.button4Plus:
                num4++;
                tvNum4.setText(Integer.toString(num4));
                break;
            case R.id.button4Minus:
                num4--;
                if(num4<0)  num4 = 0;
                tvNum4.setText(Integer.toString(num4));
                break;
            case R.id.button5Plus:
                num5++;
                tvNum5.setText(Integer.toString(num5));
                break;
            case R.id.button5Minus:
                num5--;
                if(num5<0)  num5 = 0;
                tvNum5.setText(Integer.toString(num5));
                break;
            case R.id.button6Plus:
                num6++;
                tvNum6.setText(Integer.toString(num6));
                break;
            case R.id.button6Minus:
                num6--;
                if(num6<0)  num6 = 0;
                tvNum6.setText(Integer.toString(num6));
                break;
            case R.id.buttonSum:
                sum = num1*price1 + num2*price2 + num3*price3 + num4*price4 + num5*price5 + num6*price6;
                tvSum.setText(Integer.toString(sum));
                break;
            case R.id.buttonOK:
                Intent intent = new Intent(this, MainActivity.class);   // 이렇게 하면 화면 쌓임..... 흠.
                startActivityForResult(intent, 100);
                break;
            case R.id.buttonCancel:
                finish();   // MainActivity로 돌아가기
                break;
            default:
                break;
        }
    }
}
