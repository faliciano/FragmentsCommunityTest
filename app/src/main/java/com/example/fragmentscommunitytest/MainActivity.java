package com.example.fragmentscommunitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public FragmentLeft fleft;
    public FragmentRight fright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        //方法二
        fright.setMessageInterface(new FragmentRight.MessageInterface() {
            @Override
            public void sendMessage(Bundle data) {
                //与方法一方法一致
                fleft.setData(data);
            }
        });
        //结束
    }
    private void initData(){
        fleft=new FragmentLeft();
        fright=new FragmentRight();
        getSupportFragmentManager().beginTransaction().replace(R.id.fm_1,fleft,"fLeft").commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fm_2,fright,"fRight").commit();
    }
}
