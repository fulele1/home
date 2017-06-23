package com.fl.Home;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fl.Home.util.IntentUtil;
import com.fl.Home.util.SPUtil;


public class LoginActivity extends BaseActivity {


    private Button mBtLogin;
    private TextView mTvNew;
    private TextView mTvFind;
    private LoginActivity instance;
    private EditText mEtPhone;
    private EditText mEtPsw;
    private String mPhone;
    private String mPsw;
    @Override
    public void initTitle() {
        setTitleB("登录");
        setBackVisibleB(View.INVISIBLE);

    }
    @Override
    public void initView() {
        setContentView(R.layout.activity_login);
        instance = this;
        setStatusColorB(instance.getResources().getColor(R.color.main_color),View.VISIBLE,true);
        if ((Boolean) SPUtil.get(this,"FirstIn",true)==true){
            SPUtil.put(this,"FirstIn",false);
            setContentView(R.layout.activity_login);
            instance = this;
        }else{
            instance = this;
            setContentView(R.layout.activity_login);
            intentB(instance,MainActivity.class);
            finish();
        }
        mBtLogin = (Button) findViewById(R.id.bt_login_login);
        mTvNew = (TextView) findViewById(R.id.tv_new_login);
        mTvFind = (TextView) findViewById(R.id.tv_find_login);
        mEtPsw = (EditText) findViewById(R.id.et_psw_login);
        mEtPhone = (EditText) findViewById(R.id.et_phone_login);
    }

    @Override
    public void initAvailable() {}

    @Override
    public void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!SPUtil.get(instance,"password","").toString().equals("")){
            mEtPhone.setText(SPUtil.get(instance,"loginNum","").toString());
            mEtPsw.setText(SPUtil.get(instance,"password","").toString());
        }else if (SPUtil.get(instance,"password","").toString().equals("")){//找回密码或者新注册时
            mEtPhone.setText(SPUtil.get(instance,"loginNum","").toString());
            mEtPsw.setText("");
        }
        setStatusColorB(instance.getResources().getColor(R.color.main_color),View.VISIBLE,true);
    }

    @Override
    public void addEvent() {
        mBtLogin.setOnClickListener(instance);
        mTvNew.setOnClickListener(instance);
        mTvFind.setOnClickListener(instance);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login_login://登录按钮
                login();
                break;
            case R.id.tv_new_login://注册
                IntentUtil.start(instance,RegisterActivity.class);
                break;
            case R.id.tv_find_login://找回密码
                intentB(instance,FindActivity.class);
                break;
        }
    }

    /**
     * 登录
     */
    public void login(){
        mPhone = mEtPhone.getText().toString().trim();
        mPsw = mEtPsw.getText().toString().trim();
        if (mPhone.equals("")){
            showToastB("请输入账号");
            return;
        }else if (mPsw.equals("")){
            showToastB("请输入密码");
            return;
        }
    IntentUtil.start(instance,MainActivity.class);
    }

}
