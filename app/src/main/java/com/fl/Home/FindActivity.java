package com.fl.Home;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class FindActivity extends BaseActivity {

    private EditText mEtPhone;
    private EditText mEtCode;
    private EditText mEtPsw;
    private EditText mEtConPsw;
    private ImageView mIvCode;
    private Button mBtFinished;
    private String mPhone;
    private String mCode;
    private String mPsw;
    private String mConPsw;
    private String mCodeKey;
    private FindActivity.TimeCount mTime;
    private TextView mTvAgain;
    private boolean canClick;
    private FindActivity instance;

    @Override
    public void initTitle() {
        setTitleB("找回密码");
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_find);
        instance = this;
        setStatusColorB(instance.getResources().getColor(R.color.main_color),View.VISIBLE,true);
        mEtPhone = (EditText) findViewById(R.id.et_phone_find);
        mEtCode = (EditText) findViewById(R.id.et_code_find);
        mEtPsw = (EditText) findViewById(R.id.et_psw_find);
        mEtConPsw = (EditText) findViewById(R.id.et_con_psw_find);
        mIvCode = (ImageView) findViewById(R.id.iv_code_find);
        mBtFinished = (Button) findViewById(R.id.bt_finished_find);
        mTvAgain = (TextView) findViewById(R.id.tv_again_find);
        mTime = new TimeCount(60000,1000);
    }

    @Override
    public void initAvailable() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void addEvent() {
        mIvCode.setOnClickListener(instance);
        mBtFinished.setOnClickListener(instance);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_code_find://手机验证码
                if (!canClick){
                    getCode();
                }
                break;
            case R.id.bt_finished_find://完成
                finished();
                break;
        }
    }


    /**
     * 获取手机验证码
     */
    public void getCode(){
        mPhone = mEtPhone.getText().toString().trim();
        if (mPhone.equals("")){
            showToastB("请输入手机号码");
            return;
        }

    }


    public void finished(){
        mPhone = mEtPhone.getText().toString().trim();
        mCode = mEtCode.getText().toString().trim();
        mPsw = mEtPsw.getText().toString().trim();
        mConPsw = mEtConPsw.getText().toString().trim();
        if (mPhone.equals("")){
            showToastB("请输入手机号码");
            return;
        }else if (mCode.equals("")){
            showToastB("请输入手机验证码");
            return;
        }else if (mPsw.equals("")){
            showToastB("请输入密码");
            return;
        }else if (mConPsw.equals("")){
            showToastB("请输入确认密码");
            return;
        }else if (!mPsw.equals(mConPsw)){
            showToastB("两次输入密码不一致");
            return;
        }


    }

    /**
     * 倒计时计时器
     */
    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mTvAgain.setText(millisUntilFinished/1000+"s后重新获取");
            canClick = true;
        }

        @Override
        public void onFinish() {
            mIvCode.setImageResource(R.mipmap.ic_launcher);
            mTvAgain.setText("重新发送");
            canClick = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStatusColorB(instance.getResources().getColor(R.color.main_color),View.VISIBLE,true);
    }
}
