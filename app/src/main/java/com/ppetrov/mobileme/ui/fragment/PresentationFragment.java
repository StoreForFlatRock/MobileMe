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

public class PresentationFragment extends Fragment {

    public static final String FRAGMENT_TAG = PresentationFragment.class.getSimpleName();
    private Button mBtnToMotivation;
    private TextView mTvPresentationText;

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_to_motivation){
                ((BaseActivity)getActivity()).replaceFragment(R.id.fragment_container, MotivationFragment.FRAGMENT_TAG);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_presentation, container, false);
        mTvPresentationText = view.findViewById(R.id.tv_presentation_text);
        mTvPresentationText.setMovementMethod(new ScrollingMovementMethod());
        mBtnToMotivation = view.findViewById(R.id.btn_to_motivation);
        mBtnToMotivation.setOnClickListener(mClickListener);
        ((MainActivity)getActivity()).setToolbarTitle(FRAGMENT_TAG);
        return view;
    }
}
