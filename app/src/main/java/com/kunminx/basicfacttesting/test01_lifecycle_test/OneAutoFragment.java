package com.kunminx.basicfacttesting.test01_lifecycle_test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/18
 */
public class OneAutoFragment extends BaseLifeCycleFragment {

    private IOneAutoFragment mIOneAutoFragment;
    private long startTime;
    private final static String TAG_TIME = "";
    private TextView mTextView;

    public void setIOneAutoFragment(IOneAutoFragment IOneAutoFragment) {
        mIOneAutoFragment = IOneAutoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lifecycler_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_jump_frag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIOneAutoFragment != null) {
                    mIOneAutoFragment.onJumpToSecondFragment();
                }

               /* getFragmentManager().beginTransaction()
                        .replace(R.id.frg_container_1, new SecondFragment())
//                .add(R.id.frg_container_1, mAutoFragment = new SecondFragment())
//                .hide(mAutoFragment)
                        .addToBackStack(null)
                        .commitAllowingStateLoss();*/
            }
        });
        mTextView = ((TextView) view.findViewById(R.id.tv_num));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(TAG_TIME, startTime);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            startTime = savedInstanceState.getLong(TAG_TIME);
        } else {
            startTime = System.currentTimeMillis();
        }
        mTextView.setText(String.valueOf(startTime));
    }

}
