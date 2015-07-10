package com.demacia.app.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by HZD-PC on 2015/7/10 0010.
 */
public class Telephone extends ActionBarActivity {
   private Button button;
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.telephone);
      button = (Button)findViewById(R.id.button);

      button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
         }
      });
   }
}
