package com.fl.Home;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.fl.Home.adapter.FragmentAdapter;
import com.fl.Home.fargment.CommendFragment;
import com.fl.Home.fargment.MainFragment;
import com.fl.Home.fargment.MineFragment;
import com.fl.Home.util.SPUtil;
import com.fl.Home.util.SystemUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private MainActivity instance;
    private ViewPager mVpg;
    private RadioGroup mRgp;
    private RadioButton mRbMain;
    private RadioButton mRbConmmend;
    private RadioButton mRbMine;
    private List<Fragment> mFrags;
    private FragmentManager mFragmentManager;
    private ImageView mIv;
    private DrawerLayout mDraLayout;
    private Button mBtFinished;
    private RelativeLayout mLayTitle;
    private LinearLayout.LayoutParams lp;
    @Override
    public void initTitle() {
        setTitleVisibleB(View.GONE);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_total);
        instance = this;
        setStatusColorB(instance.getResources().getColor(R.color.main_color),View.VISIBLE,true);
        mFragmentManager = this.getSupportFragmentManager();
        mVpg = (ViewPager) findViewById(R.id.vpg_main);
        mRgp = (RadioGroup) findViewById(R.id.rgp_main);
        mRbMain = (RadioButton) findViewById(R.id.rbt_main_main);
        mRbConmmend = (RadioButton) findViewById(R.id.rbt_commend_main);
        mRbMine = (RadioButton) findViewById(R.id.rbt_mine_main);
        mIv = (ImageView) findViewById(R.id.iv_user_main);
        mDraLayout = (DrawerLayout) findViewById(R.id.activity_drag);
        mBtFinished = (Button) findViewById(R.id.bt_finish_drag);
        mLayTitle = (RelativeLayout) findViewById(R.id.lay_title_main);
        setParams();
    }

    public void setParams(){
        lp= (LinearLayout.LayoutParams) mLayTitle.getLayoutParams();
        lp.width=SystemUtil.getSystemWidth(instance);
        lp.height=SystemUtil.getSystemHeight(instance)/20;
        mLayTitle.setLayoutParams(lp);

    }

    @Override
    public void initAvailable() {

    }

    @Override
    public void initData() {
        mFrags = new ArrayList<>();
        mFrags.add(new MainFragment());
        mFrags.add(new CommendFragment());
        mFrags.add(new MineFragment());
    }

    @Override
    public void addEvent() {
        mVpg.setAdapter(new FragmentAdapter(mFragmentManager,mFrags));
        mRgp.setOnCheckedChangeListener(new CheckedChange());
        mVpg.setOnPageChangeListener(new pageChange());
        mIv.setOnClickListener(instance);
        mBtFinished.setOnClickListener(instance);
    }


    /**
     * 页面滑动后设置当前为点击
     */
    class pageChange implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    mRbMain.setChecked(true);
                    mRbMain.setTextColor(instance.getResources().getColor(R.color.main_color));
                    mRbConmmend.setTextColor(Color.BLACK);
                    mRbMine.setTextColor(Color.BLACK);
                    break;
                case 1:
                    mRbConmmend.setChecked(true);
                    mRbConmmend.setTextColor(instance.getResources().getColor(R.color.main_color));
                    mRbMain.setTextColor(Color.BLACK);
                    mRbMine.setTextColor(Color.BLACK);
                    break;
                case 2:
                    mRbMine.setChecked(true);
                    mRbMine.setTextColor(instance.getResources().getColor(R.color.main_color));
                    mRbMain.setTextColor(Color.BLACK);
                    mRbConmmend.setTextColor(Color.BLACK);
                    break;
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }


    /**
     * 点击改变页面的监听事件
     */
    class CheckedChange implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rbt_main_main:
                    mVpg.setCurrentItem(0);
                    break;
                case R.id.rbt_commend_main:
                    mVpg.setCurrentItem(1);
                    break;
                case R.id.rbt_mine_main:
                    mVpg.setCurrentItem(2);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_user_main:
                mDraLayout.openDrawer(Gravity.LEFT);//打开抽屉
                break;
            case R.id.bt_finish_drag://退出
                SPUtil.put(instance,"password","");//清除偏好设置中的密码
                SPUtil.put(instance,"FirstIn",true);
                intentB(instance, LoginActivity.class);
                finish();
                break;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStatusColorB(instance.getResources().getColor(R.color.main_color ),View.VISIBLE,true);
    }
}