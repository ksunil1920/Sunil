package com.basaila.sunil.skychalisaAndaarti;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Sunil on 11/22/2017.
 */

public class ShowBook extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_book);
        String book = getIntent().getStringExtra("BookName");
        initViews(book);

    }

    private void initViews(String book) {
        TextView tvBookHeader = findViewById(R.id.tvBook);
        TextView tvBookDetail = findViewById(R.id.tvBookDetails);
        String text = getStringResourceByName(book);
        tvBookDetail.setText(text);
        String mType = book.split("_")[1].trim();
        String header = getBaseContext().getString(R.string.shri) + " " + book.substring(0, book.indexOf("_")).trim() + " " + mType;
        tvBookHeader.setText(header);
      /*  Toolbar myToolBar =  findViewById(R.id.my_toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            myToolBar.setTitle(mType);
        }*/
     // setToolbar(mType);

    }

    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
