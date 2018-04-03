package nuro.nuro.storemanagemnet.userPackage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import nuro.nuro.storemanagemnet.R;
/**
 * 用户登陆页面
 * @time 180328
 * @author wwx
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText name_et;
    private EditText passwd_et;
    private Button login;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        name_et = (EditText) findViewById(R.id.name_et);
        passwd_et = (EditText) findViewById(R.id.passwd_et);
        login = (Button) findViewById(R.id.login_bt);
        register = (Button) findViewById(R.id.register_bt);

        name_et.setOnClickListener(this);
        passwd_et.setOnClickListener(this);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_bt:
                Intent intent1 = new Intent();
                intent1.setClass(this,MainMenuActivity.class);
                startActivity(intent1);
                break;
            case R.id.register_bt:
                Intent intent = new Intent();
                intent.setClass(this,UserRegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


}
