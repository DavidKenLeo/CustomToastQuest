package com.example.auser.customtoastquest;

import android.app.Activity;
import android.content.res.Resources;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class customtoastquest extends Activity {

    EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customtoastquest);
        findView();
        setOnKeyListener();
    }

    void findView(){
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editText3);
    }

    void setOnKeyListener(){
        et1.setOnKeyListener(onKeyListener);
        et2.setOnKeyListener(onKeyListener);
        et3.setOnKeyListener(onKeyListener);
    }

    OnKeyListener onKeyListener = new OnKeyListener(){

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event)
        {
            //判斷使用者是否有按下的動作以及按下的是否為Enter鍵
            try {
                if(event.getAction()==KeyEvent.ACTION_DOWN & keyCode == KeyEvent.KEYCODE_ENTER){

                    //取得使用者輸入的選項，並轉成數值，以便於switch-case的比對
                    int choice = Integer.parseInt(((EditText)v).getText().toString());

                    if(((EditText)v)==et3){
                        //當使用者互動的是EditText3時，根據使用者的選擇，來顯示特定文字
                        switch(choice){
                            case 1:
                                customtoastquest1(R.string.choice1,R.drawable.crispy); break;
                            case 2:
                                customtoastquest1(R.string.choice2,R.drawable.big_mac); break;
                            case 3:
                                customtoastquest1(R.string.choice3,R.drawable.chicken_mc_nuggets_4pcs); break;
                            case 4:
                                customtoastquest1(R.string.choice4,R.drawable.spicy_chicken_filet_burger); break;
                            default:
                                Toast.makeText(customtoastquest.this, R.string.choice5, Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        //當使用者互動的是EditText1與EditText2時，就顯示使用者所輸入的資料
                        Toast.makeText(customtoastquest.this, ((EditText)v).getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }catch (NumberFormatException e){
                e.printStackTrace();

            }catch (Resources.NotFoundException e){
                e.printStackTrace();

            }


            // TODO Auto-generated method stub
            return false;
        }
    };
    void customtoastquest1(int textID,int drawableID){
        Toast toast = Toast.makeText(customtoastquest.this,textID, Toast.LENGTH_SHORT);
        View original = toast.getView();
        LinearLayout linearLayout = new LinearLayout(customtoastquest.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ImageView img = new ImageView(this);
        img.setImageResource(drawableID);
        linearLayout.addView(img);
        linearLayout.addView(original);
        toast.setView(linearLayout);
        toast.show();

    }
}