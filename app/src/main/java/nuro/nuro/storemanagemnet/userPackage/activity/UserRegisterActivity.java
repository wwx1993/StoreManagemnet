package nuro.nuro.storemanagemnet.userPackage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nuro.nuro.storemanagemnet.R;
import nuro.nuro.storemanagemnet.SqlHelpdemo.SqlHelpdemo;

/**
 * 用户注册页面
 * @time 180328
 * @author wwx
 */
public class UserRegisterActivity extends Activity implements View.OnClickListener{
    private EditText register_name_et;//用户名
    private EditText register_number_et;//职工号
    private EditText register_phone_et;//手机号
    private EditText register_passwd_et;//密码
    private EditText register_surepasswd_et;//确认密码
    private EditText repair_shopname_et;//汽修厂名称
    private EditText repair_shoparea_et;//汽修厂区域选择
    private EditText address_scope_et;//汽修厂地址
    private EditText repair_scope_et;//所属区域
    private EditText repair_shopaddress_et;//经营类型
    private Button submit;
    private final static int REQUEST_CODE=1;
    private String TAG = "UserRegisterActivity";

    SqlHelpdemo db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {
        register_name_et = (EditText) findViewById(R.id.register_name_et);
        register_phone_et = (EditText) findViewById(R.id.register_phone_et);
        register_passwd_et = (EditText) findViewById(R.id.register_passwd_et);
        register_surepasswd_et = (EditText) findViewById(R.id.register_surepasswd_et);
        repair_shopname_et = (EditText) findViewById(R.id.repair_shopname_et);
        repair_shoparea_et = (EditText) findViewById(R.id.repair_shoparea_et);
        repair_shopaddress_et = (EditText) findViewById(R.id.repair_shopaddress_et);
        repair_scope_et = (EditText) findViewById(R.id.repair_scope_et);
        submit = (Button) findViewById(R.id.submit);

        repair_shoparea_et.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.repair_shoparea_et:
                showCityPickerView();
                break;
            default:
                break;
        }

    }

    private void showCityPickerView() {
        Intent intent = new Intent();
        intent.setClass(this,CityPickerActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE)
        {
            if (resultCode==CityPickerActivity.RESULT_CODE)
            {
                Bundle bundle=data.getExtras();
                String str=bundle.getString("back");
                repair_shoparea_et.setText(str);
                Log.i(TAG,"str:"+str);
                Toast.makeText(UserRegisterActivity.this, str, Toast.LENGTH_LONG).show();
            }
        }
    }
}
