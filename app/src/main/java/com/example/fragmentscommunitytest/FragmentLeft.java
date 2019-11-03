package com.example.fragmentscommunitytest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentLeft extends Fragment {
    //https://blog.csdn.net/luweicheng24/article/details/53738772
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragmentleft,null);
        view.findViewById(R.id.button_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
                Date date = new Date();// 获取当前时间
                Bundle bundle=new Bundle();
                bundle.putString("message",sdf.format(date));
                FragmentRight fright=(FragmentRight) getActivity().getSupportFragmentManager().findFragmentByTag("fRight");
                fright.setData(bundle);
            }
        });
        return view;
    }
}
