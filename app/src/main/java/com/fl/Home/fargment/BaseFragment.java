package com.fl.Home.fargment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fl.Home.R;

/**
 * Created by fl on 2017/6/12.
 */

public class BaseFragment  extends Fragment implements View.OnClickListener{
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_base,null);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
