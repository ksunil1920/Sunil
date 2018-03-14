package com.basaila.sunil.skychalisaAndaarti;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Sunil on 12/16/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    @Override
    public void finish() {
        super.finish();
        hideSoftKeyboard();
    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void showSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(getCurrentFocus(), InputMethodManager.SHOW_IMPLICIT);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                hideSoftKeyboard();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setToolbar(@StringRes int title) {
        setToolbar(getString(title));
    }

    protected void setToolbar(@NonNull String title) {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        setTitle(title);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(Boolean.TRUE);
    }

    protected void setToolbar(@StringRes int title, @NonNull String subTitle) {
        setToolbar(getString(title));
        if (subTitle != null) {
            getSupportActionBar().setSubtitle(subTitle);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(Boolean.FALSE);
    }
    protected void setToolbar(@NonNull String title, @NonNull String subTitle) {
        setToolbar(title);
        if (subTitle != null) {
            getSupportActionBar().setSubtitle(subTitle);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(Boolean.TRUE);
    }

}
