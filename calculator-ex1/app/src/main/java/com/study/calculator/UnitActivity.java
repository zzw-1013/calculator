package com.study.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class UnitActivity extends AppCompatActivity {

    double mm=0,cm=0,dm=0,m=0,km=0,sec=0,min=0,hour=0,mm3=0,cm3=0,dm3=0,m3=0;
    String strMm="",strCm="",strDm="",strM="",strKm="",strSec="",strMin="",strHour="",
            strMm3="",strCm3="",strDm3="",strM3="";
    boolean isMmTouch=true,isCmTouch=false,isDmTouch=false,isMTouch=false,isKmTouch=false,
            isSecTouch=false,isMinTouch=false,isHourTouch=false;

    int EditTextTouchState=1;//1代表mm3被点击，2代表cm3被点击，3代表dm3被点击，4代表m3被点击

    EditText etMm;
    EditText etDm;
    EditText etCm;
    EditText etM;
    EditText etKm;
    EditText etSec;
    EditText etMin;
    EditText etHour;

    EditText etMm3;
    EditText etCm3;
    EditText etDm3;
    EditText etM3;


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
            case R.id.item_exit:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        etMm=findViewById(R.id.et_mm);
        etDm=findViewById(R.id.et_dm);
        etCm=findViewById(R.id.et_cm);
        etM=findViewById(R.id.et_m);
        etKm=findViewById(R.id.et_km);
        etSec=findViewById(R.id.et_sec);
        etMin=findViewById(R.id.et_min);
        etHour=findViewById(R.id.et_hour);
        etMm3=findViewById(R.id.et_mm3);
        etCm3=findViewById(R.id.et_cm3);
        etDm3=findViewById(R.id.et_dm3);
        etM3=findViewById(R.id.et_m3);


        if(isLand()){
            etMm3.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    EditTextTouchState=1;
                    return false;
                }
            });

            etCm3.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    EditTextTouchState=2;
                    return false;
                }
            });

            etDm3.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    EditTextTouchState=3;
                    return false;
                }
            });

            etM3.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    EditTextTouchState=4;
                    return false;
                }
            });

            etMm3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(EditTextTouchState==1){
                        strMm3=editable.toString();
                        if(strMm3.length()==0) strMm3="0";
                        mm3=Double.parseDouble(strMm3);
                        cm3=mm3/1000;
                        dm3=cm3/1000;
                        m3=dm3/1000;
                        etCm3.setText(cm3+"");
                        etDm3.setText(dm3+"");
                        etM3.setText(m3+"");
                    }
                }
            });

            etCm3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(EditTextTouchState==2){
                        strCm3=editable.toString();
                        if(strCm3.length()==0) strCm3="0";
                        cm3=Double.parseDouble(strCm3);
                        mm3=cm3*1000;
                        dm3=cm3/1000;
                        m3=dm3/1000;
                        etMm3.setText(mm3+"");
                        etDm3.setText(dm3+"");
                        etM3.setText(m3+"");
                    }
                }
            });

            etDm3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(EditTextTouchState==3){
                        strDm3=editable.toString();
                        if(strDm3.length()==0) strDm3="0";
                        dm3=Double.parseDouble(strDm3);
                        cm3=dm3*1000;
                        mm3=cm3*1000;
                        m3=dm3/1000;
                        etMm3.setText(mm3+"");
                        etCm3.setText(cm3+"");
                        etM3.setText(m3+"");
                    }
                }
            });

            etM3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(EditTextTouchState==4){
                        strM3=editable.toString();
                        if(strM3.length()==0) strM3="0";
                        m3=Double.parseDouble(strM3);
                        dm3=m3*1000;
                        cm3=dm3*1000;
                        mm3=cm3*1000;
                        etMm3.setText(mm3+"");
                        etCm3.setText(cm3+"");
                        etDm3.setText(dm3+"");
                    }
                }
            });

        }
        else {
            etMm.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    isMmTouch=true;
                    isCmTouch=false;
                    isDmTouch=false;
                    isMTouch=false;
                    isKmTouch=false;
                    return false;
                }
            });

            etCm.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    isMmTouch=false;
                    isCmTouch=true;
                    isDmTouch=false;
                    isMTouch=false;
                    isKmTouch=false;
                    return false;
                }
            });

            etDm.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    isMmTouch=false;
                    isCmTouch=false;
                    isDmTouch=true;
                    isMTouch=false;
                    isKmTouch=false;
                    return false;
                }
            });

            etM.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    isMmTouch=false;
                    isCmTouch=false;
                    isDmTouch=false;
                    isMTouch=true;
                    isKmTouch=false;
                    return false;
                }
            });

            etKm.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    isMmTouch=false;
                    isCmTouch=false;
                    isDmTouch=false;
                    isMTouch=false;
                    isKmTouch=true;
                    return false;
                }
            });

            etSec.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    isSecTouch=true;
                    isMinTouch=false;
                    isHourTouch=false;
                    return false;
                }
            });

            etMin.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    isSecTouch=false;
                    isMinTouch=true;
                    isHourTouch=false;
                    return false;
                }
            });

            etHour.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    isSecTouch=false;
                    isMinTouch=false;
                    isHourTouch=true;
                    return false;
                }
            });

            etMm.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(isMmTouch){
                        strMm=editable.toString();
                        if(strMm.length()==0) strMm="0";
                        mm=Double.parseDouble(strMm);
                        cm=mm/10;
                        dm=cm/10;
                        m=dm/10;
                        km=m/1000;
                        etCm.setText(cm+"");
                        etDm.setText(dm+"");
                        etM.setText(m+"");
                        etKm.setText(km+"");
                    }
                }
            });

            etCm.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(isCmTouch){
                        strCm=editable.toString();
                        if(strCm.length()==0) strCm="0";
                        cm=Double.parseDouble(strCm);
                        mm=cm*10;
                        dm=cm/10;
                        m=dm/10;
                        km=m/1000;
                        etMm.setText(mm+"");
                        etDm.setText(dm+"");
                        etM.setText(m+"");
                        etKm.setText(km+"");
                    }
                }
            });

            etDm.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(isDmTouch){
                        strDm=editable.toString();
                        if(strDm.length()==0) strDm="0";
                        dm=Double.parseDouble(strDm);
                        cm=dm*10;
                        mm=cm*10;
                        m=dm/10;
                        km=m/1000;
                        etMm.setText(mm+"");
                        etCm.setText(cm+"");
                        etM.setText(m+"");
                        etKm.setText(km+"");
                    }
                }
            });

            etM.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(isMTouch){
                        strM=editable.toString();
                        if(strM.length()==0) strM="0";
                        m=Double.parseDouble(strM);
                        dm=m*10;
                        cm=dm*10;
                        mm=cm*10;
                        km=m/1000;
                        etMm.setText(mm+"");
                        etCm.setText(cm+"");
                        etDm.setText(dm+"");
                        etKm.setText(km+"");
                    }
                }
            });

            etKm.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(isKmTouch){
                        strKm=editable.toString();
                        if(strKm.length()==0) strKm="0";
                        km=Double.parseDouble(strKm);
                        m=km*1000;
                        dm=m*10;
                        cm=dm*10;
                        mm=cm*10;
                        etMm.setText(mm+"");
                        etCm.setText(cm+"");
                        etDm.setText(dm+"");
                        etM.setText(m+"");
                    }
                }
            });

            etSec.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(isSecTouch){
                        strSec=editable.toString();
                        if(strSec.length()==0) strSec="0";
                        sec=Double.parseDouble(strSec);
                        min=sec/60;
                        hour=min/60;
                        etMin.setText(min+"");
                        etHour.setText(hour+"");
                    }
                }
            });

            etMin.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(isMinTouch){
                        strMin=editable.toString();
                        if(strMin.length()==0) strMin="0";
                        min=Double.parseDouble(strMin);
                        sec=min*60;
                        hour=min/60;
                        etSec.setText(sec+"");
                        etHour.setText(hour+"");
                    }
                }
            });

            etHour.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }
                @Override
                public void afterTextChanged(Editable editable) {
                    if(isHourTouch){
                        strHour=editable.toString();
                        if(strHour.length()==0) strHour="0";
                        hour=Double.parseDouble(strHour);
                        min=hour*60;
                        sec=min*60;
                        etMin.setText(min+"");
                        etSec.setText(sec+"");
                    }
                }
            });
        }

    }

    //判断当前是否为横屏
    private boolean isLand() {
        Configuration mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
        int ori = mConfiguration.orientation; //获取屏幕方向
        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
            //横屏
            return true;
        } else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {
            //竖屏
            return false;
        }
        return false;
    }

}
