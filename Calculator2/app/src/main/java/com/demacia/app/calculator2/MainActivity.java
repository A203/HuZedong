package com.demacia.app.calculator2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Button button[] = new Button[18];
    //    private static final String[] buttonLabels = {"0","1","2","3","4","5","6","7","8","9","C","D","/","*","-","+","=","."};
    private TextView textviewTop;
    private TextView textViewMid;
    private TextView textViewBottom;
    private TextView signtop;
    private TextView signbottom;
    private String prev = null;
    private String next = null;
    private String sign = null;
    private String result = null;
    private static byte operator = -1;
    private int signcount = 0;
    private boolean dotFlag = true;
    private boolean numFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signtop = (TextView) findViewById(R.id.signtop);
        signbottom = (TextView) findViewById(R.id.signbottom);
        textviewTop = (TextView) findViewById(R.id.textviewtop);
        textViewMid = (TextView) findViewById(R.id.textviewmid);
        textViewBottom = (TextView) findViewById(R.id.textviewbottom);
        button[0] = (Button) findViewById(R.id.button0);
        button[1] = (Button) findViewById(R.id.button1);
        button[2] = (Button) findViewById(R.id.button2);
        button[3] = (Button) findViewById(R.id.button3);
        button[4] = (Button) findViewById(R.id.button4);
        button[5] = (Button) findViewById(R.id.button5);
        button[6] = (Button) findViewById(R.id.button6);
        button[7] = (Button) findViewById(R.id.button7);
        button[8] = (Button) findViewById(R.id.button8);
        button[9] = (Button) findViewById(R.id.button9);
        button[10] = (Button) findViewById(R.id.buttonc);
        button[11] = (Button) findViewById(R.id.buttondel);
        button[12] = (Button) findViewById(R.id.buttond);
        button[13] = (Button) findViewById(R.id.buttonmp);
        button[14] = (Button) findViewById(R.id.buttonm);
        button[15] = (Button) findViewById(R.id.buttonplus);
        button[16] = (Button) findViewById(R.id.buttonequal);
        button[17] = (Button) findViewById(R.id.buttondot);

        //number button 0-9 after input number wo can input + - * / = .
        for (int index = 0; index < 10; ++index) {
            button[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!numFlag) {
                        //if numFlag = false set all to begin
                        textViewBottom.setText("");
                        textViewBottom.setHint("0");
                        textviewTop.setText("");
                        textViewMid.setText("");
                        signbottom.setText("");
                        numFlag = true;
                    }
                    //if numFlag = true bottom set text
                    textViewBottom.append(((Button) findViewById(v.getId())).getText());
                }
            });
        }

        //when use C to reset all to begin
        button[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textviewTop.setText("");
                textViewMid.setText("");
                textViewBottom.setText("");
                signtop.setText("");
                signbottom.setText("");
                dotFlag = true;
                signcount = 0;
                operator = -1;
            }
        });

        //only one dot in a line

        button[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dotFlag) {
                    textViewBottom.append(((Button) findViewById(v.getId())).getText());
                    dotFlag = false;
                }
            }
        });
//
//
//        //when use + - * / next line
//        for (int index = 12; index < 16; ++index) {
//            button[index].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    /*if (!textView.getText().toString().equals("") || textView.getText().toString() == null) {
//                        if (signcount < 2) {
//                            prev = textView.getText().toString();
//                            textView.append("\n");
//                            String mark = ((Button) findViewById(v.getId())).getText().toString();
//                            sign.setText(mark);
//                            operator = operatorNum(mark);
//                            signcount++;
//                            dotFlag = true;
//                        } else {
//                            sign.setText("=");
//                            signcount = 0;
//                            if (prev != null) {
//                                next = cutPrev(prev, textView.getText().toString());
//                                textView.setText(calculator(operator, Double.parseDouble(prev), Double.parseDouble(next)) + "");
//                                numFlag = false;
//                                dotFlag = true;
//                            } else {
//                                prev = textView.getText().toString();
//                                textView.setText(prev);
//                            }
//                            sign.append("");
//                        }
//                    }*/
//                    //if prev == null or prev ==""  do nothing
//
//                    //if we have done something before,we need to give result
//                    if (signcount > 0) {
//                        next = cutPrev(prev, textView.getText().toString());
//                        textView.setText(calculator(operator, Double.parseDouble(prev), Double.parseDouble(next))+"");
//                        prev = textView.getText().toString();
//                        textView.append("\n");
//                        next = null;
//                        numFlag = false;
//                        dotFlag = true;
//                        signcount = 0;
//                    }else {
//                        //if there is no input do nothing,if have we input sign and get prev ,signcount++ and textView input nextline
//                        if (!(prev == null) && !(prev.equals(""))) {
//                            //have done + - * / before we need to get result now then go on
//                            //just do = before + - * /
////                        prev = textView.getText().toString();
//                            textView.append("\n");
//                            String mark = ((Button) findViewById(v.getId())).getText().toString();
//                            sign.setText(mark);
//                            operator = operatorNum(mark);
//                            signcount++;
//                            dotFlag = true;
//                        }
//                    }
//                }
//            });
//        }
//
        //when use + - * / to set bottom String to mid String and use sign , open new String in next line
        for (int index = 12; index < 16; ++index) {
            button[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sign = ((Button) findViewById(v.getId())).getText().toString();
                    signbottom.setText(sign);
                    operator = operatorNum(sign);
                    prev = textViewBottom.getText().toString();
                    textViewMid.setText(prev);
                    signbottom.setText("");
                    dotFlag=true;
                }
            });
        }


//
//        //when use = to get result
//        button[16].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//      /*          sign.setText("=");
//                signcount++;
//                if (prev != null) {
//                    next = cutPrev(prev, textView.getText().toString());
//                    textView.setText(calculator(operator, Double.parseDouble(prev), Double.parseDouble(next)) + "");
//
//                    numFlag = false;
//                    dotFlag = true;
//                } else {
//                    prev = textView.getText().toString();
//                    textView.setText(prev);
//                }*/
//                //if have no input do nothing
//                if (!(prev == null) && !(prev.equals(""))) {
//                    sign.setText("=");
//                    next = cutPrev(prev, textView.getText().toString());
//                    textView.setText(calculator(operator, Double.parseDouble(prev), Double.parseDouble(next)) + "");
//                    numFlag = false;
//                    dotFlag = true;
//                    signcount = 0;
//                    prev = textView.getText().toString();
//                    next = null;
//                }
//
//
//            }
//        });

        //when use = to get result
        button[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textviewTop.setText(textViewMid.getText().toString());
                next = textViewBottom.getText().toString();
                textViewMid.setText(next);
                signtop.setText(signbottom.getText().toString());
                signbottom.setText("=");
                textViewBottom.setText(calculator(sign, Double.parseDouble(prev), Double.parseDouble(next)) + "");
            }
        });

    }

    static byte operatorNum(String mark) {
        if (mark.equals("+")) {
            return 1;
        } else if (mark.equals("-")) {
            return 2;
        } else if (mark.equals("*")) {
            return 3;
        } else if (mark.equals("/")) {
            return 4;
        }
        return -1;
    }

    static double calculator(String sign, double num1, double num2) {
  /*      switch (operator) {
            case 1:
                return plus(num1, num2);
            case 2:
                return minus(num1, num2);
            case 3:
                return multiply(num1, num2);
            case 4:
                return divide(num1, num2);
            default:
                return -99999999;
        }*/
        if (sign == "+")
            return plus(num1, num2);
        if (sign == "-")
            return minus(num1, num2);
        if (sign == "*")
            return multiply(num1, num2);
        if (sign == "/")
            return divide(num1, num2);
        return Double.MAX_VALUE;
    }

    static double plus(double num1, double num2) {
        return num1 + num2;
    }

    static double minus(double num1, double num2) {
        return num1 - num2;
    }

    static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    static double divide(double num1, double num2) {
        return num1 / num2;
    }


    static String cutPrev(String prev, String next) {
        int length = prev.length();
        char[] temp = new char[next.length() - prev.length() - 1];
        next.getChars(prev.length() + 1, next.length(), temp, 0);
        String s = new String(temp);
        return s;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
