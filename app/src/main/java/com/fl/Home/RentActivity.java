package com.fl.Home;


import android.view.View;
import android.widget.ImageView;

public class RentActivity extends BaseActivity {

    private RentActivity instance;
    private ImageView mIvBack;

    @Override
    public void initTitle() {
        setTitleVisibleB(View.GONE);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_rent);
        instance = this;
        setStatusColorB(instance.getResources().getColor(R.color.main_color),View.VISIBLE,true);
        mIvBack = (ImageView) findViewById(R.id.iv_back_rent);
    }

    @Override
    public void initAvailable() {

    }

    @Override
    public void initData() {
        mIvBack.setOnClickListener(instance);
    }

    @Override
    public void addEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_rent://back
                finish();
                break;
        }
    }

}
