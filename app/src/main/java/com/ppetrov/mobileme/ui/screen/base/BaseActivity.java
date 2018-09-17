package com.ppetrov.mobileme.ui.screen.base;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.ppetrov.mobileme.R;
import com.ppetrov.mobileme.ui.fragment.MotivationFragment;
import com.ppetrov.mobileme.ui.fragment.PresentationFragment;
import com.ppetrov.mobileme.ui.fragment.WelcomeFragment;

public class BaseActivity extends AppCompatActivity {

    public void replaceFragment(int fragmentContainer, String fragmentTag){
        Fragment f = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        if (f == null){
            f = initFragment(fragmentTag);
        }
        getSupportFragmentManager().beginTransaction().replace(fragmentContainer, f)
                .addToBackStack(fragmentTag)
                .commit();
    }

    private Fragment initFragment(String fragmentTag){
        if (WelcomeFragment.FRAGMENT_TAG.equals(fragmentTag)){
            return new WelcomeFragment();
        } else if (PresentationFragment.FRAGMENT_TAG.equals(fragmentTag)){
            return new PresentationFragment();
        } else if (MotivationFragment.FRAGMENT_TAG.equals(fragmentTag)){
            return new MotivationFragment();
        }
        throw new IllegalArgumentException("Unhandled fragmentTag");
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            getSupportFragmentManager().popBackStack();
            return;
        } else if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            showAppDialog(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == DialogInterface.BUTTON_POSITIVE){
                        finish();
                    } else {
                        dialog.dismiss();
                    }
                }
            }, R.string.leave_app_dialog_message, R.string.yes, R.string.no);
        }        else {
            super.onBackPressed();
        }
    }

    public void showAppDialog(DialogInterface.OnClickListener onClickListener, int message,
                              int positiveText, int negativeText){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setNegativeButton(negativeText, onClickListener)
                .setPositiveButton(positiveText, onClickListener);
        builder.create().show();
    }
}
