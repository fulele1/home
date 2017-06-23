package com.fl.Home;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fl.Home.util.IntentUtil;

public class SearchActivity extends BaseActivity {

    private SearchActivity instance;
    private TextView mTvGo;
    private ImageView mTvBack;

    @Override
    public void initTitle() {
        setTitleVisibleB(View.GONE);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_search);
        instance = this;
        setStatusColorB(instance.getResources().getColor(R.color.main_color),View.VISIBLE,true);
        mTvGo = (TextView) findViewById(R.id.tv_go_search);
        mTvBack = (ImageView) findViewById(R.id.iv_back_search);
    }

    @Override
    public void initAvailable() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void addEvent() {
        mTvGo.setOnClickListener(instance);
        mTvBack.setOnClickListener(instance);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_search://search
                IntentUtil.start(instance,SearchDetailActivity.class);
                break;
            case R.id.iv_back_search://back
                finish();
                break;
        }
    }
}
