package com.example.fragmentscommunitytest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentRight extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragmentright,null);
        view.findViewById(R.id.button_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
                Date date = new Date();// 获取当前时间
                //方法二
                Bundle bundle=new Bundle();
                bundle.putString("message",sdf.format(date));
                if(mMessageInterface!=null){
                    mMessageInterface.sendMessage(bundle);
                }
                //结束
            }
        });
        return view;
    }
    //方法一接口(方法二中也需要)
    public void setData(Bundle bundle) {
        String message=bundle.getString("message");
        Toast.makeText(getActivity(),"我（FragmentRight）接受到来自FragmentLeft的消息："+message,Toast.LENGTH_LONG).show();
    }
    //结束
    //方法二
    public interface MessageInterface {
        void sendMessage(Bundle data);
    }
    private MessageInterface mMessageInterface;
    public void setMessageInterface(MessageInterface mMessageInterface){
        this.mMessageInterface=mMessageInterface;
    }
    //结束
}
