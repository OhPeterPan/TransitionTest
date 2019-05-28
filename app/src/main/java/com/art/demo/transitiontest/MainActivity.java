package com.art.demo.transitiontest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.art.demo.transitiontest.custom.CustomColorTransition;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout root;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private CustomColorTransition transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        root = findViewById(R.id.root);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
    }

    private void initListener() {
        root.setOnClickListener(this);
        transition = new CustomColorTransition();
        transition.setDuration(2000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.root:
                TransitionManager.beginDelayedTransition(root, transition);
                textView1.setBackgroundColor(Color.RED);
                textView2.setBackgroundColor(Color.WHITE);
                textView3.setBackgroundColor(Color.GREEN);
                break;
            case R.id.textView1:

                break;
        }
    }
}
