package com.yeyu.openbookview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Copyright © 2013-2020 Yeyu. All Rights Reserved.
 * Author: hasee
 * Email: 879689064@qq.com
 * Date: 2020/3/14
 * Time: 20:00
 * Desc:
 */
public class BrowserBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_FIRST_USER);
        super.onBackPressed();
    }
}
