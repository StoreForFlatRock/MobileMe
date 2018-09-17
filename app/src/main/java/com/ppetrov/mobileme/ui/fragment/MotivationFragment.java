package com.ppetrov.mobileme.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ppetrov.mobileme.R;
import com.ppetrov.mobileme.ui.screen.MainActivity;

public class MotivationFragment extends Fragment {

    public static final String FRAGMENT_TAG = MotivationFragment.class.getSimpleName();
    private TextView mTvMotivationText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motivation, container, false);
        ((MainActivity)getActivity()).setToolbarTitle(FRAGMENT_TAG);
        mTvMotivationText = view.findViewById(R.id.tv_motivation_text);
        mTvMotivationText.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }
}
