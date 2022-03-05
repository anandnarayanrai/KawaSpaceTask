package com.kawa.space;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.kawa.space.databinding.MainActivityBinding;
import com.kawa.space.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding mBinding = MainActivityBinding.inflate(getLayoutInflater());
        mBinding.setLifecycleOwner(this);
        setContentView(mBinding.getRoot());
        setSupportActionBar(mBinding.toolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        mBinding.menuButton.setOnClickListener(this::displayPopupWindow);
    }

    private void displayPopupWindow(View anchorView) {
        PopupWindow popup = new PopupWindow(MainActivity.this);
        View layout = getLayoutInflater().inflate(R.layout.menus_layout, null);
        popup.setContentView(layout);
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(anchorView);
    }
}