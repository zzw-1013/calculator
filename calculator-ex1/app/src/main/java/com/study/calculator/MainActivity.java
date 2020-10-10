package com.study.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




public class MainActivity extends AppCompatActivity {

    private BaseCalculator baseCalculator = new BaseCalculator();
    private  ScienceCalculator scienceCalculator=new ScienceCalculator();
    EditText etCurrent;
    EditText etPast;
    String mathCurrent = "";
    String mathPast = "";
    int precision = 6;
    int equal_flag = 0;

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
//             case R.id.item_exit:
//                finish();
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etCurrent = findViewById(R.id.et_current);
        etPast = findViewById(R.id.et_past);
        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);
        Button btnDot = findViewById(R.id.btn_dot);
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSub = findViewById(R.id.btn_sub);
        Button btnMul = findViewById(R.id.btn_mul);
        Button btnDiv = findViewById(R.id.btn_div);
        Button btnAC = findViewById(R.id.btn_clc);
        Button btnDel = findViewById(R.id.btn_del);
        Button btnEqual = findViewById(R.id.btn_equal);

        Button btnBracket = findViewById(R.id.btn_bracket);
        Button btnSin=findViewById(R.id.btn_sin);
        Button btnCos=findViewById(R.id.btn_cos);
        Button btnTan=findViewById(R.id.btn_tan);
        Button btnXsquare=findViewById(R.id.btn_square);
        Button btnXy=findViewById(R.id.btn_cube);
        Button btnSqrt=findViewById(R.id.btn_sqrt);
        Button btnPi=findViewById(R.id.btn_pi);
        Button btnE=findViewById(R.id.btn_e);



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() == 0) {                    //1.表达式为空，+0
                    mathCurrent += "0";
                } else if (mathCurrent.length() == 1) {             //2.表达式长度为1

                    if (mathCurrent.charAt(0) == '0') {                 //2.1 如果该字符为0，不加
                        mathCurrent += "";
                    } else if (isNum(mathCurrent.charAt(0))) {          //2.2 如果该字符为1-9，+0
                        mathCurrent += "0";
                    } else if (mathCurrent.charAt(0) == '-') {
                        mathCurrent += "0";                             //2.3 如果该字符为-，+0
                    }

                } else if (!isNum(mathCurrent.charAt(mathCurrent.length() - 2)) && mathCurrent.charAt(mathCurrent.length() - 1) == '0'&& mathCurrent.charAt(mathCurrent.length() - 2)!='.') {
                    mathCurrent += "";                              //3.属于2.1的一般情况，在式子中间出现 比如：*0 +0
                } else {                                        //4.除此之外，+0
                    mathCurrent += "0";
                }
                etCurrent.setText(mathCurrent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() >= 0) {
                    mathCurrent += "1";
                }

                etCurrent.setText(mathCurrent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() >= 0) {
                    mathCurrent += "2";
                }

                etCurrent.setText(mathCurrent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() >= 0) {
                    mathCurrent += "3";
                }

                etCurrent.setText(mathCurrent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() >= 0) {
                    mathCurrent += "4";
                }

                etCurrent.setText(mathCurrent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() >= 0) {
                    mathCurrent += "5";
                }

                etCurrent.setText(mathCurrent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() >= 0) {
                    mathCurrent += "6";
                }

                etCurrent.setText(mathCurrent);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() >= 0) {
                    mathCurrent += "7";
                }

                etCurrent.setText(mathCurrent);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() >= 0) {
                    mathCurrent += "8";
                }

                etCurrent.setText(mathCurrent);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }

                if (mathCurrent.length() >= 0) {
                    mathCurrent += "9";
                }

                etCurrent.setText(mathCurrent);
            }
        });

        //island是否横屏
        if (isLand()) {//横屏
            btnBracket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (equal_flag == 1) {//判断当前是否计算完成
                        mathCurrent = "";//输入框等于0
                        equal_flag = 0;
                    }
                    if (mathCurrent.length() == 0) {
                        mathCurrent += "(";
                    } else if (baseCalculator.isOper(mathCurrent.charAt(mathCurrent.length() - 1)) && mathCurrent.charAt(mathCurrent.length() - 1) != ')') {  //2.math最后一个字符是oper，+(
                        mathCurrent += "(";
                    } else if (isNum(mathCurrent.charAt(mathCurrent.length() - 1))
                            || mathCurrent.charAt(mathCurrent.length() - 1) == 'π'
                            || mathCurrent.charAt(mathCurrent.length() - 1) == 'e') {
                        if (!hasStartBracket(mathCurrent))
                            mathCurrent += "*(";
                        else
                            mathCurrent += ")";
                    } else if (mathCurrent.charAt(mathCurrent.length() - 1) == ')') {
                        mathCurrent += ")";
                    }
                    etCurrent.setText(mathCurrent);
                }
            });


            btnSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (equal_flag == 1) {
                        mathCurrent = "";
                        equal_flag = 0;
                    }
                    if (mathCurrent.length() == 0) {
                        mathCurrent += "sin(";
                    } else {
                        //oper, (, 加 sin(
                        char ch = mathCurrent.charAt(mathCurrent.length() - 1);
                        if (baseCalculator.isOper(ch) || ch == '(')
                            mathCurrent += "sin(";
                    }
                    etCurrent.setText(mathCurrent);
                }
            });

            btnCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (equal_flag == 1) {
                        mathCurrent = "";
                        equal_flag = 0;
                    }
                    if (mathCurrent.length() == 0) {
                        mathCurrent += "cos(";
                    } else {
                        char ch = mathCurrent.charAt(mathCurrent.length() - 1);
                        if (baseCalculator.isOper(ch) || ch == '(')
                            mathCurrent += "cos(";
                    }
                    etCurrent.setText(mathCurrent);
                }
            });

            btnTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (equal_flag == 1) {
                        mathCurrent = "";
                        equal_flag = 0;
                    }
                    if (mathCurrent.length() == 0) {
                        mathCurrent += "tan(";
                    } else {
                        char ch = mathCurrent.charAt(mathCurrent.length() - 1);
                        if (baseCalculator.isOper(ch) || ch == '(')
                            mathCurrent += "tan(";
                    }
                    etCurrent.setText(mathCurrent);
                }
            });

            btnXsquare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (equal_flag == 1) {
                        mathCurrent = "";
                        equal_flag = 0;
                    }
                    //要求math不为空并且最后一个字符：num, ), e, π
                    if (mathCurrent.length() > 0) {
                        char ch = mathCurrent.charAt(mathCurrent.length() - 1);
                        if (isNum(ch) || ch == ')' || ch == 'e' || ch == 'π')
                            mathCurrent += "^(2)";
                    }
                    etCurrent.setText(mathCurrent);
                }
            });

            btnXy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (equal_flag == 1) {
                        mathCurrent = "";
                        equal_flag = 0;
                    }
                    if (mathCurrent.length() > 0) {
                        char ch = mathCurrent.charAt(mathCurrent.length() - 1);
                        if (isNum(ch) || ch == ')' || ch == 'e' || ch == 'π')
                            mathCurrent += "^(";
                    }
                    etCurrent.setText(mathCurrent);
                }
            });

            btnSqrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (equal_flag == 1) {
                        mathCurrent = "";
                        equal_flag = 0;
                    }
                    if (mathCurrent.length() == 0) {
                        mathCurrent += "√(";
                    } else {

                        char ch = mathCurrent.charAt(mathCurrent.length() - 1);
                        if (baseCalculator.isOper(ch) || ch == '(')
                            mathCurrent += "√(";
                    }
                    etCurrent.setText(mathCurrent);
                }
            });


            btnPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (equal_flag == 1) {
                        mathCurrent = "";
                        equal_flag = 0;
                    }
                    if (mathCurrent.length() == 0) {
                        mathCurrent += "π";
                    } else {
                        //oper, (, 加 π
                        char ch = mathCurrent.charAt(mathCurrent.length() - 1);
                        if (baseCalculator.isOper(ch) || ch == '(')
                            mathCurrent += "π";
                    }
                    etCurrent.setText(mathCurrent);

                }
            });

            btnE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (equal_flag == 1) {
                        mathCurrent = "";
                        equal_flag = 0;
                    }
                    if (mathCurrent.length() == 0) {
                        mathCurrent += "e";
                    } else {
                        //oper, (, 加 e
                        char ch = mathCurrent.charAt(mathCurrent.length() - 1);
                        if (baseCalculator.isOper(ch) || ch == '(')
                            mathCurrent += "e";
                    }
                    etCurrent.setText(mathCurrent);

                }
            });

        }

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "";
                    equal_flag = 0;
                }
                if (mathCurrent.length() == 0) {                                //1.mathNow为空，+0.
                    mathCurrent += "0.";
                } else if (baseCalculator.isOper(mathCurrent.charAt(mathCurrent.length() - 1))) {  //2.mathNow的最后一个字符为oper，+0.
                    mathCurrent += "0.";
                } else if (isNum(mathCurrent.charAt(mathCurrent.length() - 1))) {   //3.mathNow的最后一个字符为num，+.
                    mathCurrent += ".";
                } else {                                                    //4.除此之外，不加
                    mathCurrent += "";
                }
                etCurrent.setText(mathCurrent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag != 1) {
                    if (mathCurrent.length() != 0) {
                        if (!baseCalculator.isOper(mathCurrent.charAt(mathCurrent.length() - 1))) {
                            mathCurrent += "+";
                            etCurrent.setText(mathCurrent);
                        } else {
                            if (isNum(mathCurrent.charAt(mathCurrent.length() - 1))
                                    || mathCurrent.charAt(mathCurrent.length() - 1) == ')'
                                    || mathCurrent.charAt(mathCurrent.length() - 1) == 'π'
                                    || mathCurrent.charAt(mathCurrent.length() - 1) == 'e')
                                mathCurrent += "+";
                            etCurrent.setText(mathCurrent);
                        }
                    }
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag == 1) {
                    mathCurrent = "-";
                    equal_flag = 0;
                }
                if (mathCurrent.length() == 0) {
                    mathCurrent += "-";
                } else {
                    if (isNum(mathCurrent.charAt(mathCurrent.length() - 1))
                            || mathCurrent.charAt(mathCurrent.length() - 1) == ')'
                            || mathCurrent.charAt(mathCurrent.length() - 1) == '('
                            || mathCurrent.charAt(mathCurrent.length() - 1) == 'π'
                            || mathCurrent.charAt(mathCurrent.length() - 1) == 'e')
                        mathCurrent += "-";
                }
                etCurrent.setText(mathCurrent);

            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag != 1) {
                    if (mathCurrent.length() != 0) {
                        if (!baseCalculator.isOper(mathCurrent.charAt(mathCurrent.length() - 1))) {
                            mathCurrent += "*";
                            etCurrent.setText(mathCurrent);
                        } else {
                            if (isNum(mathCurrent.charAt(mathCurrent.length() - 1))
                                    || mathCurrent.charAt(mathCurrent.length() - 1) == ')'
                                    || mathCurrent.charAt(mathCurrent.length() - 1) == 'π'
                                    || mathCurrent.charAt(mathCurrent.length() - 1) == 'e')
                                mathCurrent += "*";
                            etCurrent.setText(mathCurrent);
                        }
                    }
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag != 1) {
                    if (mathCurrent.length() != 0) {
                        if (!baseCalculator.isOper(mathCurrent.charAt(mathCurrent.length() - 1))) {
                            mathCurrent += "/";
                            etCurrent.setText(mathCurrent);
                        } else {
                            if (isNum(mathCurrent.charAt(mathCurrent.length() - 1))
                                    || mathCurrent.charAt(mathCurrent.length() - 1) == ')'
                                    || mathCurrent.charAt(mathCurrent.length() - 1) == 'π'
                                    || mathCurrent.charAt(mathCurrent.length() - 1) == 'e')
                                mathCurrent += "*";
                            etCurrent.setText(mathCurrent);
                        }
                    }
                }
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathCurrent = "";
                equal_flag = 1;
                etCurrent.setText(mathCurrent);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mathCurrent.length() != 0 && equal_flag != 1) {
                    mathCurrent = mathCurrent.substring(0, mathCurrent.length() - 1);
                    etCurrent.setText(mathCurrent);
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equal_flag != 1) {
                    if (mathCurrent.length() != 0) {
                        double result = scienceCalculator.cal(mathCurrent,precision,1);
                        String strResult = String.valueOf(result);
                        String errorMath = mathCurrent;
                        mathPast = mathCurrent + "=";
                        if (mathCurrent.charAt(mathCurrent.length() - 1) == ')' || !baseCalculator.isOper(mathCurrent.charAt(mathCurrent.length() - 1))) {


                            mathCurrent += "=" + strResult;

                        }
                        if (result == Double.MAX_VALUE) {
                            mathCurrent = errorMath + "=";
                            strResult = "错误！请检查输入的表达式";
                        }
                        equal_flag = 1;
                        //etCurrent.setText(mathCurrent);//输出整个表达式
                        etCurrent.setText(strResult);//只输出结果

                        etPast.setText(mathPast);
                    }
                }
            }
        });
    }


    //判断当前字符是否为数字
    private boolean isNum(char c) {
        char num[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i = 0;
        for (; i < num.length; i++) {
            if (num[i] == c)
                break;
        }
        return i != num.length;
    }

    //判断当前math是否有'('
    private boolean hasStartBracket(String s) {
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                break;
        }
        return i != s.length();
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
