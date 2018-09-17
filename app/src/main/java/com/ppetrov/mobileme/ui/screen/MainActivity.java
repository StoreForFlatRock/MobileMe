package com.ppetrov.mobileme.ui.screen;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.ppetrov.mobileme.R;
import com.ppetrov.mobileme.ui.fragment.MotivationFragment;
import com.ppetrov.mobileme.ui.fragment.PresentationFragment;
import com.ppetrov.mobileme.ui.fragment.WelcomeFragment;
import com.ppetrov.mobileme.ui.screen.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private TextView mTvToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar_layout);
        if (mToolbar != null){
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        replaceFragment(R.id.fragment_container, WelcomeFragment.FRAGMENT_TAG);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return true;
    }

    public void setToolbarTitle(String fragmentTag){
        mTvToolbarTitle = findViewById(R.id.tv_toolbar_title);
        if (fragmentTag.equals(WelcomeFragment.FRAGMENT_TAG)){
            mTvToolbarTitle.setText(R.string.welcome_fragment_title);
        } else if (fragmentTag.equals(PresentationFragment.FRAGMENT_TAG)){
            mTvToolbarTitle.setText(R.string.presentation_fragment_title);
        } else if (fragmentTag.equals(MotivationFragment.FRAGMENT_TAG)){
            mTvToolbarTitle.setText(R.string.motivation_fragment_title);
        }
    }
}
