package com.fl.Home.fargment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.fl.Home.AgencyActivity;
import com.fl.Home.BuyActivity;
import com.fl.Home.R;
import com.fl.Home.RentActivity;
import com.fl.Home.SearchActivity;
import com.fl.Home.util.IntentUtil;
import com.fl.Home.util.SystemUtil;

import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSetEvent;

/**
 * Created by fl on 2017/6/12.
 */

public class MainFragment extends BaseFragment{
    private Context instance;
    private View view;
    private ConvenientBanner mConvenientBanner;
    private LinearLayout mLayOne;
    private LinearLayout mLayTwo;
    private LinearLayout mLayThree;
    private LinearLayout mLayFour;
    private TextView mTvSearch;
    private TextView mTvBuy;
    private TextView mTvRent;
    private TextView mTvAgency;
    private TextView mTvOne;
    private TextView mTvTwo;
    private TextView mTvThree;
    private TextView mTvS;
    private TextView mTvM;
    private TextView mTvN;
    private TextView mTvB;
    private TextView mTvMM;
    private TextView mTvT;
    private List<Integer> mImageList;
    private LinearLayout.LayoutParams lpOne;
    private LinearLayout.LayoutParams lpTwo;
    private LinearLayout.LayoutParams lpThree;
    private LinearLayout.LayoutParams lpFour;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main,null);
        instance  = this.getActivity();
        mConvenientBanner = (ConvenientBanner) view.findViewById(R.id.cb_main_frg);
        mLayOne = (LinearLayout) view.findViewById(R.id.layout_one_frag_main);
        mLayTwo = (LinearLayout) view.findViewById(R.id.layout_two_frag_main);
        mLayThree = (LinearLayout) view.findViewById(R.id.layout_three_frag_main);
        mLayFour = (LinearLayout) view.findViewById(R.id.layout_four_frag_main);
        mTvSearch = (TextView) view.findViewById(R.id.tv_search_main_frag);
        mTvBuy = (TextView) view.findViewById(R.id.tv_buy_frag_main);
        mTvRent = (TextView) view.findViewById(R.id.tv_rent_frag_main);
        mTvAgency = (TextView) view.findViewById(R.id.tv_agency_frag_main);
        mTvOne = (TextView) view.findViewById(R.id.tv_one_frag_main);
        mTvTwo = (TextView) view.findViewById(R.id.tv_two_frag_main);
        mTvThree = (TextView) view.findViewById(R.id.tv_three_frag_main);
        mTvS = (TextView) view.findViewById(R.id.tv_s_frag_main);
        mTvM = (TextView) view.findViewById(R.id.tv_m_frag_main);
        mTvN = (TextView) view.findViewById(R.id.tv_n_frag_main);
        mTvB = (TextView) view.findViewById(R.id.tv_b_frag_main);
        mTvMM = (TextView) view.findViewById(R.id.tv_mm_frag_main);
        mTvT = (TextView) view.findViewById(R.id.tv_t_frag_main);
        setParams();
        mImageList = new ArrayList();
        mImageList.add(R.mipmap.pic1);
        mImageList.add(R.mipmap.pic2);
        mImageList.add(R.mipmap.pic3);
        mImageList.add(R.mipmap.pic4);
        cbSetPage();
        mConvenientBanner.startTurning(2000);
        cbItemEvent();
        setEvent();
        return view;
    }

    private void setEvent() {
        mTvSearch.setOnClickListener(this);
        mTvBuy.setOnClickListener(this);
        mTvRent.setOnClickListener(this);
        mTvAgency.setOnClickListener(this);
        mTvOne.setOnClickListener(this);
        mTvTwo.setOnClickListener(this);
        mTvThree.setOnClickListener(this);
        mTvS.setOnClickListener(this);
        mTvM.setOnClickListener(this);
        mTvN.setOnClickListener(this);
        mTvB.setOnClickListener(this);
        mTvMM.setOnClickListener(this);
        mTvT.setOnClickListener(this);
    }


    /**
     * set layouts's size
     */
    public void setParams(){
        lpOne= (LinearLayout.LayoutParams) mLayOne.getLayoutParams();
        lpOne.width= SystemUtil.getSystemWidth(instance);
        lpOne.height=SystemUtil.getSystemHeight(instance)/3;
        mLayOne.setLayoutParams(lpOne);

        lpTwo= (LinearLayout.LayoutParams) mLayTwo.getLayoutParams();
        lpTwo.width= SystemUtil.getSystemWidth(instance);
        lpTwo.height=SystemUtil.getSystemHeight(instance)/20*3;
        mLayTwo.setLayoutParams(lpTwo);

        lpThree= (LinearLayout.LayoutParams) mLayThree.getLayoutParams();
        lpThree.width= SystemUtil.getSystemWidth(instance);
        lpThree.height=SystemUtil.getSystemHeight(instance)/60*13;
        mLayThree.setLayoutParams(lpThree);

        lpFour= (LinearLayout.LayoutParams) mLayFour.getLayoutParams();
        lpFour.width= SystemUtil.getSystemWidth(instance);
        lpFour.height=SystemUtil.getSystemHeight(instance)/60*13;
        mLayFour.setLayoutParams(lpFour);
    }


    /**
     * Set the picture for the convenientbanner
     */
    public void cbSetPage() {
        mConvenientBanner.setPages(new CBViewHolderCreator<CbHolder>() {
            @Override
            public CbHolder createHolder() {
                return new CbHolder();
            }
        }, mImageList)
                .setPageIndicator(new int[]{R.mipmap.pointn, R.mipmap.pointc})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_LEFT);
    }

    /**
     * 轮播图子条目的点击事件
     * Click about convenient banner
     */
    public void cbItemEvent(){
        mConvenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
    }

    /**
     * convenient banner's holder
     */
    public class CbHolder implements Holder<Integer> {

        private ImageView pImg;
        @Override
        public View createView(Context context) {
            pImg = new ImageView(context);
            pImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return pImg;
        }

        @Override
        public void UpdateUI(Context context, int position, Integer data) {
            pImg.setImageResource(data);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_search_main_frag://search
                IntentUtil.start(instance, SearchActivity.class);
                break;
            case R.id.tv_buy_frag_main://buy house
                IntentUtil.start(instance, BuyActivity.class);
                break;
            case R.id.tv_rent_frag_main://rent house
                IntentUtil.start(instance, RentActivity.class);
                break;
            case R.id.tv_agency_frag_main://agency
                IntentUtil.start(instance, AgencyActivity.class);
                break;
            case R.id.tv_one_frag_main://一居室
                IntentUtil.start(instance, BuyActivity.class);
                break;
            case R.id.tv_two_frag_main://两居室
                IntentUtil.start(instance, BuyActivity.class);
                break;
            case R.id.tv_three_frag_main://三居室
                IntentUtil.start(instance, BuyActivity.class);
                break;
            case R.id.tv_s_frag_main://城南
                IntentUtil.start(instance, BuyActivity.class);
                break;
            case R.id.tv_m_frag_main://城中
                IntentUtil.start(instance, BuyActivity.class);
                break;
            case R.id.tv_n_frag_main://城北
                IntentUtil.start(instance, BuyActivity.class);
                break;
            case R.id.tv_b_frag_main://70以下
                IntentUtil.start(instance, BuyActivity.class);
                break;
            case R.id.tv_mm_frag_main://70-100
                IntentUtil.start(instance, BuyActivity.class);
                break;
            case R.id.tv_t_frag_main://100以上
                IntentUtil.start(instance, BuyActivity.class);
                break;
        }
    }
}