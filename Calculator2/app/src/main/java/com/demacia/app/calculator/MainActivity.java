package com.demacia.app.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Button button[] = new Button[18];
    private TextView textViewTop;
    private TextView textViewMid;
    private TextView textViewBottom;
    private TextView signtop;
    private TextView signbottom;
    private TextView signmid;
    private String prev = "";
    private String next = "";
    private String sign = "";
    private String result = "";
    private boolean dotFlag = true;
    private boolean numFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signtop = (TextView) findViewById(R.id.signtop);
        signmid = (TextView) findViewById(R.id.signmid);
        signbottom = (TextView) findViewById(R.id.signbottom);
        textViewTop = (TextView) findViewById(R.id.textviewtop);
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
                        // [] ********
                        // [] ********      ---->
                        // =  ********                      0  hint
                        //it mean that it has done some calculating before, so when numFlag = false set all to begin
                        textViewBottom.setText("");
                        textViewBottom.setHint("0");
                        textViewTop.setText("");
                        textViewMid.setText("");
                        signtop.setText("");
                        signmid.setText("");
                        signbottom.setText("");
                        numFlag = true;
                        prev = "";
                        next = "";
                        dotFlag = true;
                    }
                    //if numFlag = true bottom set text
                    textViewBottom.append(((Button) findViewById(v.getId())).getText());
                }
            });
        }

        //use DEL to backspace when input ******, or to clear all when get result,
        button[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //it cannot use when there is nothing input
                //                                  //
                //                  cannot use      //              cannot use
                //           0                      //= *********
                String input = textViewBottom.getText().toString();
                String sign = signbottom.getText().toString();
                if (!(input.equals(""))&&!sign.equals("=")) {
                    //
                    //                  --->
                    // *********                ******
                        textViewBottom.setText(stringCut(input));
                }
            }
        });


        //when use C to reset all to begin
        button[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //reset all textview and sign textview,flag
                textViewTop.setText("");
                textViewMid.setText("");
                textViewBottom.setText("");
                textViewBottom.setHint("0");
                signtop.setText("");
                signmid.setText("");
                signbottom.setText("");
                numFlag = true;
                prev = "";
                next = "";
                dotFlag = true;
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

        //when use + - * / to set bottom String to mid String and use sign , open new String in next line
        for (int index = 12; index < 16; ++index) {
            button[index].setOnClickListener(new View.OnClickListener() {
                @Override

                //when input nothing we cannot use sign
                public void onClick(View v) {
                    //
                    //                 --->     ********    prev
                    //    ********           []
                    if (!(textViewBottom.getText().toString().equals(""))) {
                        //input != ""
                        numFlag = true;
                        if (signbottom.getText().toString().equals("")) {
                            //has finished all calculating before
                            signbottom.setText(((Button) findViewById(v.getId())).getText().toString());
                            prev = textViewBottom.getText().toString();
                            textViewMid.setText(prev);
                        } else if (!signmid.getText().toString().equals("=") && (signbottom.getText().toString().equals("="))) {
                            //      *********   |          [] *********
                            //  []  *********   |  ------> =  *********
                            //  =   *********   |          []
                            //after = ******** it should allow to input number so need to set numFlag false!!
                            signtop.setText(signmid.getText().toString());
                            signmid.setText("=");
                            signbottom.setText(((Button) findViewById(v.getId())).getText().toString());
                            textViewTop.setText(textViewMid.getText().toString());
                            textViewMid.setText(textViewBottom.getText().toString());
                        } else if (!signbottom.getText().toString().equals("=") && !(signmid.getText().toString().equals("="))) {
                            //                   |          []  *********
                            //       *********   |  ------> =  *********
                            //  []   *********   |          []
                            signtop.setText(signbottom.getText().toString());
                            signmid.setText("=");
                            signbottom.setText(((Button) findViewById(v.getId())).getText().toString());
                            next = textViewBottom.getText().toString();
                            String mid = calculator(signtop.getText().toString(), Double.parseDouble(prev), Double.parseDouble(next)) + "";
                            textViewTop.setText(textViewBottom.getText().toString());
                            textViewMid.setText(mid);
                        } else if ((!signbottom.getText().toString().equals("=")) && (signmid.getText().toString().equals("="))) {
                            //  [] *********                 []  *********
                            //  =  *********     ------>      =  *********
                            //  [] *********                 []
                            signtop.setText(signbottom.getText().toString());
                            signmid.setText("=");
                            signbottom.setText(((Button) findViewById(v.getId())).getText().toString());
                            prev = textViewMid.getText().toString();
                            textViewTop.setText(textViewBottom.getText().toString());
                            next = textViewBottom.getText().toString();
                            textViewMid.setText(calculator(signtop.getText().toString(), Double.parseDouble(prev), Double.parseDouble(next)) + "");
                        } else {
                            signtop.setText("=");
                            signmid.setText("=");
                            signbottom.setText(((Button) findViewById(v.getId())).getText().toString());
                            textViewTop.setText(textViewMid.getText().toString());
                            textViewMid.setText(textViewBottom.getText().toString());
                        }
                        textViewBottom.setText("");
                        textViewBottom.setHint("0");
                        prev = textViewMid.getText().toString();
                        next = "";
                        dotFlag = true;
                    }
                }
            });
        }

        //when use = to get result
        button[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //it cannot be
                //  ********
                //[]
                //use =,so textViewBottom cannot be ""


                if (!(textViewBottom.getText().toString().equals(""))) {
                /*if we use = as this situation

                                   ------>    *********
                  **********               =  *********          */
                    if (prev.equals("")) {
                        prev = textViewBottom.getText().toString();
                        signbottom.setText("=");
                        textViewMid.setText(prev);
                        numFlag = false;
                    } else if (signbottom.getText().toString().equals("=")) {
                        //                                  *********       //  *********                 + *********
                        //      *********       ----->   =  *********       //+ *********           -->   = *********
                        //  =   *********                =  *********       //= *********                 = *********
                        prev = textViewBottom.getText().toString();
                        textViewTop.setText(textViewMid.getText().toString());
                        textViewMid.setText(prev);
                        textViewBottom.setText(prev);
                        signtop.setText(signmid.getText().toString());
                        signmid.setText("=");
                        signbottom.setText("=");
                        numFlag = false;
                    } else if (!(signbottom.getText().toString().equals("")) && !prev.equals("")) {
                        //what about if we use = to continue? we need to judge signbottom != "=".it must be + - * /
                        //when you use = to get result ,u can only use + - * / to continue calculating or use number to reset all to begin
                        // getText!=""  && signbottom !=""|"="
                        //                                                *********
                        //    *********            ------->            +  *********
                        //  + *********                                =  *********
                        signtop.setText(signmid.getText().toString());
                        signmid.setText(signbottom.getText().toString());
                        signbottom.setText("=");
                        next = textViewBottom.getText().toString();
                        textViewTop.setText(prev);
                        textViewMid.setText(next);
                        textViewBottom.setText(calculator(signmid.getText().toString(), Double.parseDouble(prev), Double.parseDouble(next)) + "");
                        numFlag = false;
                    }

                }
            }
        });


    }

    static double calculator(String sign, double num1, double num2) {
        if (sign.equals("+"))
            return plus(num1, num2);
        if (sign.equals("-"))
            return minus(num1, num2);
        if (sign.equals("*"))
            return multiply(num1, num2);
        if (sign.equals("/"))
            return divide(num1, num2);
        return Double.MAX_VALUE;
    }

    static String stringCut(String string) {
        char[] temp = new char[string.length() - 1];
        string.getChars(0, string.length() - 1, temp, 0);
        String s = new String(temp);
        return s;
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
