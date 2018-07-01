package com.literature.android.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetBehavior bottomSheet;
    private ImageView action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        action = (ImageView) findViewById(R.id.imgview_action);
        action.setOnClickListener(this);
        View view = findViewById(R.id.bottom_sheet);
        bottomSheet = BottomSheetBehavior.from(view);
        bottomSheet.setPeekHeight(220);
        bottomSheet.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.v("test", "state is changed");
                switch (newState) {

                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        Log.v("test", "collapsed");
                    }
                    case BottomSheetBehavior.STATE_SETTLING: {

                        Log.v("test", "settling");
                    }
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        Log.v("test", "expanded");
                    }
                    case BottomSheetBehavior.STATE_HIDDEN: {

                        Log.v("test", "hidden");
                    }
                    case BottomSheetBehavior.STATE_DRAGGING: {

                        Log.v("test", "dragging");
                    }
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.v("test", "onSlide");
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.imgview_action:
                if (bottomSheet == null) {
                    return;
                }

                if (bottomSheet.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    setBottomSheetState(BottomSheetBehavior.STATE_EXPANDED);
                    action.setImageResource(android.R.drawable.arrow_down_float);

                } else {
                    setBottomSheetState(BottomSheetBehavior.STATE_COLLAPSED);
                    action.setImageResource(android.R.drawable.arrow_up_float);
                }
                break;
        }
    }

    private void setBottomSheetState(int state) {
        bottomSheet.setState(state);
    }
}
