package com.fl.Home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{


    private Context mContext;
    private BaseActivity instance;
    private LinearLayout mLyTitle;//标题布局
    private LinearLayout mLyStatus;//状态栏
    private FrameLayout mLyContent;//内容布局
    private TextView mTvBack;//返回键
    private TextView mTvTitle;//标题内容
    private Toast mToast;//吐司
    private AlertDialog.Builder mDialog;//对话框
    private Intent mIntent;
    private Boolean iskitkat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setUpViewsB();
        initTitle();
        initView();
        initAvailable();
        initData();
        addEvent();
    }

    /**
     * 初始化标题栏
     */
    public abstract void initTitle();

    /**
     * 初始化view
     */
    public abstract void initView();

    /**
     * 初始化携带跳转的数据
     */
    public abstract void initAvailable();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 添加事件
     */
    public abstract void addEvent();

    /**
     * 初始化标题栏和内容界面
     */
    public void setUpViewsB() {
        super.setContentView(R.layout.activity_base);//大的布局
        instance = this;
        mLyTitle = (LinearLayout) findViewById(R.id.ly_title_bar);//标题栏
        mLyStatus = (LinearLayout) findViewById(R.id.status_bar);//状态栏
        mLyContent = (FrameLayout) findViewById(R.id.ly_content_base);//内容界面
        mTvBack = (TextView) findViewById(R.id.tv_back_title);//返回按钮
        mTvTitle = (TextView) findViewById(R.id.tv_title_tilte);//标题栏文字
    }


    /**
     * 重新渲染
     *
     * @param layoutResID
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mLyContent.removeAllViews();
        View.inflate(this, layoutResID, mLyContent);
        onContentChanged();
    }

    @Override
    public void setContentView(View view) {
        mLyContent.removeAllViews();
        mLyContent.addView(view);
        onContentChanged();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mLyContent.removeAllViews();
        mLyContent.addView(view, params);
        onContentChanged();
    }


    /**
     * 设置标题栏内容
     *
     * @param title
     */
    public void setTitleB(String title) {
        mTvTitle.setText(title);
    }

    /**
     * 设置返回按钮不可见
     *
     * @param invisible
     */
    public void setBackVisibleB(int invisible) {
        mTvBack.setVisibility(invisible);
    }

    /**
     * 设置标题栏隐藏
     *
     * @param invisible
     */
    public void setTitleVisibleB(int invisible) {
        mLyTitle.setVisibility(invisible);
    }

    /**
     * 点击返回按钮
     *
     * @param view
     */
    public void onBack(View view) {
        finish();
    }


    /**
     * 设置透明状态栏以及状态栏的颜色
     * @param color
     * @param visible
     */
    public void setStatusColorB(int color,int visible,boolean kitkat){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // Translucent navigation bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            iskitkat = kitkat;
        }
        if (iskitkat){
            mLyStatus.setVisibility(visible);
            mLyStatus.setBackgroundColor(color);
        }
    }



    /**
     * 普通的界面的跳转
     *
     * @param context
     * @param cla
     */
    public void intentB(Context context, Class<?> cla) {
        mIntent = new Intent(context, cla);
        context.startActivity(mIntent);
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
    }

    /**
     * 弹出对话框
     */
    public void showToastB(String str) {
        if (null == mToast) {
            mToast = Toast.makeText(mContext, str, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(str);
        }
        mToast.show();
    }
}
