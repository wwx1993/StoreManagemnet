package nuro.nuro.storemanagemnet.userPackage.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import nuro.nuro.storemanagemnet.R;
import nuro.nuro.storemanagemnet.userPackage.fragment.FirstFragment;

/**
 * Created by wwx on 2018/4/3 0003.
 */

public class MainMenuActivity extends Activity implements View.OnClickListener{
    private TextView topBar;
    private TextView tabDeal;
    private TextView tabPoi;
    private TextView tabUser;
    private TextView tabMore;
    private FrameLayout ly_content;
    private Fragment f1,f2,f3,f4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        bindView();
    }

    //UI组件初始化与事件绑定
    private void bindView() {
        topBar = (TextView)this.findViewById(R.id.txt_top);
        tabDeal = (TextView)this.findViewById(R.id.txt_deal);
        tabPoi = (TextView)this.findViewById(R.id.txt_poi);
        tabUser = (TextView)this.findViewById(R.id.txt_user);
        tabMore = (TextView)this.findViewById(R.id.txt_more);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tabDeal.setOnClickListener(this);
        tabMore.setOnClickListener(this);
        tabUser.setOnClickListener(this);
        tabPoi.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch(view.getId()){
            case R.id.txt_deal:
                selected();
                tabDeal.setSelected(true);
                if(f1==null){
                    f1 = new FirstFragment("第一个Fragment");
                    transaction.add(R.id.fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;

            case R.id.txt_more:
                selected();
                tabMore.setSelected(true);
                if(f2==null){
                    f2 = new FirstFragment("第二个Fragment");
                    transaction.add(R.id.fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;

            case R.id.txt_poi:
                selected();
                tabPoi.setSelected(true);
                if(f3==null){
                    f3 = new FirstFragment("第三个Fragment");
                    transaction.add(R.id.fragment_container,f3);
                }else{
                    transaction.show(f3);
                }
                break;

            case R.id.txt_user:
                selected();
                tabUser.setSelected(true);
                if(f4==null){
                    f4 = new FirstFragment("第四个Fragment");
                    transaction.add(R.id.fragment_container,f4);
                }else{
                    transaction.show(f4);
                }
                break;
        }

        transaction.commit();
    }

    //重置所有文本的选中状态
    public void selected(){
        tabDeal.setSelected(false);
        tabMore.setSelected(false);
        tabPoi.setSelected(false);
        tabUser.setSelected(false);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(f1!=null){
            transaction.hide(f1);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
        if(f3!=null){
            transaction.hide(f3);
        }
        if(f4!=null){
            transaction.hide(f4);
        }
    }
}

