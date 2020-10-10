package com.study.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class BinaryActivity extends AppCompatActivity {

    int two,eight,ten;
    String strTwo,strEight,strTen,strSixteen,strThirtyTwo;
    boolean isTwoTouch=true,isEightTouch=false,isTenTouch=false,isSixteenTouch=false,isThirdtyTwoTouch=false;

    EditText etTwo;
    EditText etEight;
    EditText etTen;
    EditText etSixteen;
    EditText etThirtyTwo;
    Button clear;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        Intent intent=new Intent();
        switch (id){
            case R.id.item_cal:
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.item_unit:
                intent.setClass(this,UnitActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.item_binary:
                intent.setClass(this,BinaryActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.item_help:
                intent.setClass(this,HelpActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_binary);

        clear=findViewById(R.id.et_clear);

        etTwo=findViewById(R.id.et_two);
        etEight=findViewById(R.id.et_eight);
        etTen=findViewById(R.id.et_ten);
        etSixteen=findViewById(R.id.et_sixteen);
        etThirtyTwo=findViewById(R.id.et_thirtytwo);

        etTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTwoTouch=true;
                isEightTouch=false;
                isTenTouch=false;
                isSixteenTouch=false;
                isThirdtyTwoTouch=false;
                return false;
            }
        });

        etEight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTwoTouch=false;
                isEightTouch=true;
                isTenTouch=false;
                isSixteenTouch=false;
                isThirdtyTwoTouch=false;
                return false;
            }
        });

        etTen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTwoTouch=false;
                isEightTouch=false;
                isTenTouch=true;
                isSixteenTouch=false;
                isThirdtyTwoTouch=false;
                return false;
            }
        });

        etSixteen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTwoTouch=false;
                isEightTouch=false;
                isTenTouch=false;
                isSixteenTouch=true;
                isThirdtyTwoTouch=false;
                return false;
            }
        });

        etThirtyTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTwoTouch=false;
                isEightTouch=false;
                isTenTouch=false;
                isSixteenTouch=false;
                isThirdtyTwoTouch=true;
                return false;
            }
        });

        etTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(isTwoTouch){
                    strTwo=editable.toString();
                    if(strTwo.length()==0) strTwo="0";
                    try {
                        ten=Integer.valueOf(strTwo,2);
                        strEight=Integer.toOctalString(ten);
                        strSixteen=Integer.toHexString(ten);
                        strThirtyTwo=Integer.toString(ten,32);
                        etEight.setText(strEight);
                        etTen.setText(ten+"");
                        etSixteen.setText(strSixteen);
                        etThirtyTwo.setText(strThirtyTwo);
                    } catch (Exception e) {
                        Toast toast=Toast.makeText(BinaryActivity.this, "不是二进制，转换失败！", Toast.LENGTH_LONG);
                        changeToastTime(toast,1000);
                    }
                }
            }
        });

        etEight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(isEightTouch){
                    strEight=editable.toString();
                    if(strEight.length()==0) strEight="0";
                    try {
                        ten=Integer.valueOf(strEight,8);
                        strTwo=Integer.toBinaryString(ten);
                        strSixteen=Integer.toHexString(ten);
                        strThirtyTwo=Integer.toString(ten,32);
                        etTwo.setText(strTwo);
                        etTen.setText(ten+"");
                        etSixteen.setText(strSixteen);
                        etThirtyTwo.setText(strThirtyTwo);
                    } catch (Exception e) {
                        Toast toast=Toast.makeText(BinaryActivity.this, "不是八进制，转换失败！", Toast.LENGTH_LONG);
                        changeToastTime(toast,1000);
                    }
                }
            }
        });

        etTen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(isTenTouch){
                    strTen=editable.toString();
                    if(strTen.length()==0) strTen="0";
                    try {
                        ten=Integer.valueOf(strTen);
                        strTwo=Integer.toBinaryString(ten);
                        strEight=Integer.toOctalString(ten);
                        strSixteen=Integer.toHexString(ten);
                        strThirtyTwo=Integer.toString(ten,32);
                        etTwo.setText(strTwo);
                        etEight.setText(strEight);
                        etSixteen.setText(strSixteen);
                        etThirtyTwo.setText(strThirtyTwo);
                    } catch (Exception e) {
                        Toast toast=Toast.makeText(BinaryActivity.this, "不是十进制，转换失败！", Toast.LENGTH_LONG);
                        changeToastTime(toast,1000);
                    }
                }
            }
        });

        etSixteen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(isSixteenTouch){
                    strSixteen=editable.toString();
                    if(strSixteen.length()==0) strSixteen="0";
                    try {
                        ten=Integer.valueOf(strSixteen,16);
                        strTwo=Integer.toBinaryString(ten);
                        strEight=Integer.toOctalString(ten);
                        strThirtyTwo=Integer.toString(ten,32);
                        etTwo.setText(strTwo);
                        etEight.setText(strEight);
                        etTen.setText(ten+"");
                        etThirtyTwo.setText(strThirtyTwo);
                    } catch (Exception e) {
                        Toast toast=Toast.makeText(BinaryActivity.this, "不是十六进制，转换失败！", Toast.LENGTH_LONG);
                        changeToastTime(toast,1000);
                    }
                }
            }
        });

        etThirtyTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(isThirdtyTwoTouch){
                    strThirtyTwo=editable.toString();
                    if(strThirtyTwo.length()==0) strThirtyTwo="0";
                    try {
                        ten=Integer.valueOf(strThirtyTwo,32);
                        strTwo=Integer.toBinaryString(ten);
                        strEight=Integer.toOctalString(ten);
                        strSixteen=Integer.toHexString(ten);
                        etTwo.setText(strTwo);
                        etEight.setText(strEight);
                        etTen.setText(ten+"");
                        etSixteen.setText(strSixteen);
                    } catch (Exception e) {
                        Toast toast=Toast.makeText(BinaryActivity.this, "不是三十二进制，转换失败！", Toast.LENGTH_LONG);
                        changeToastTime(toast,1000);
                    }
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etTwo.setText("");
                etTen.setText("");
                etEight.setText("");
                etSixteen.setText("");
                etThirtyTwo.setText("");
            }
        });

    }


    //注意:该方法创建Toast对象的时候时长因该设置为 Toast.LENGTH_LONG,因为该他的时长就是3秒,与下面的延时时间对应
    //cnt:需要显示的时长,毫秒
    private void changeToastTime(final Toast toast, final int cnt) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3000);//每隔三秒调用一次show方法;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt );//经过多长时间关闭该任务
    }

}


