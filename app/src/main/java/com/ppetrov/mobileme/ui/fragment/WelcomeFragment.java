package com.ppetrov.mobileme.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ppetrov.mobileme.R;
import com.ppetrov.mobileme.ui.screen.MainActivity;
import com.ppetrov.mobileme.ui.screen.base.BaseActivity;

public class WelcomeFragment extends Fragment {

    public static final String FRAGMENT_TAG = WelcomeFragment.class.getSimpleName();

    private Button mBtnToPresentation;
    private TextView mTvWelcome;


    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_to_presentation){
                ((BaseActivity)getActivity()).replaceFragment(R.id.fragment_container, PresentationFragment.FRAGMENT_TAG);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        mBtnToPresentation = view.findViewById(R.id.btn_to_presentation);
        mBtnToPresentation.setOnClickListener(mClickListener);
        mTvWelcome = view.findViewById(R.id.tv_welcome_text);
        mTvWelcome.setSingleLine(false);
        mTvWelcome.setMovementMethod(new ScrollingMovementMethod());
        ((MainActivity)getActivity()).setToolbarTitle(FRAGMENT_TAG);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((BaseActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void onStop() {
        super.onStop();
        ((BaseActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
