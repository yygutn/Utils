package com.utils.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.utils.R;
import com.utils.annotations.ViewUtils;
import com.utils.annotations.framework.ContentView;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.init(this);
    }

    public native String getName();

    static {
        System.loadLibrary("JniTest");
    }
}
