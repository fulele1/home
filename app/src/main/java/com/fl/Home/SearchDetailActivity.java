package com.fl.Home;


import android.view.View;
import android.widget.ImageView;

public class SearchDetailActivity extends BaseActivity {

    private SearchDetailActivity instance;
    private ImageView mIvBack;

    @Override
    public void initTitle() {
        setTitleVisibleB(View.GONE);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_search_detail);
        instance = this;
        setStatusColorB(instance.getResources().getColor(R.color.main_color),View.VISIBLE,true);
        mIvBack = (ImageView) findViewById(R.id.iv_back_search_del);
    }

    @Override
    public void initAvailable() {
    }

    @Override
    public void initData() {
    }

    @Override
    public void addEvent() {
        mIvBack.setOnClickListener(instance);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_search_del://back button
                finish();
                break;
        }
    }
}
