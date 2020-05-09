package com.example.myfirstapplication.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfirstapplication.R;

import org.w3c.dom.Text;

public class ContainerActivity extends AppCompatActivity implements Fragment_1.onMessageReader{


    public static FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment_1 fragment_1;
    private TextView mTvmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if(findViewById(R.id.fl_Container1) != null){ //确认有一个Fragment容器

            if(savedInstanceState != null){ //如果activity是resumed，再生成一个Fragment会覆盖原来的Fragment
                return;
            }

            fragment_1 = new Fragment_1();
            //实例化一个自定义Fragment类的对象，并将此对象添加到容器Activity中
            fragmentTransaction.add(R.id.fl_Container1,fragment_1).commitAllowingStateLoss();
            //调用commit方法后才会生效，commitAllowingStateLoss宽容显示，允许一些横竖屏幕切换等情况下会出现的错误。
        }
    }


    @Override
    public void onMessageReade(String message) {
        mTvmessage = findViewById(R.id.tv_message);
        mTvmessage.setText(message);

        Fragment_2 fragment_2 = new Fragment_2();
        fragmentManager.beginTransaction().add(R.id.fl_Container3,fragment_2).commit();
        Bundle bundle =  new Bundle();
        bundle.putString("Title",message);
        fragment_2.setArguments(bundle);
    }


}
