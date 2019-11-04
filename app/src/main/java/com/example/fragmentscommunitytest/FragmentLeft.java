package com.example.fragmentscommunitytest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
                //方法一
                Bundle bundle=new Bundle();
                bundle.putString("message",sdf.format(date));
                FragmentRight fright=(FragmentRight) getActivity().getSupportFragmentManager().findFragmentByTag("fRight");
                fright.setData(bundle);
                //结束
            }
        });
        return view;
    }
    //方法一接口(方法二中也需要)
    public void setData(Bundle bundle) {
        String message=bundle.getString("message");
        Toast.makeText(getActivity(),"我（FragmentLeft）接受到来自FragmentRight的消息："+message,Toast.LENGTH_LONG).show();
    }
    //结束
}
