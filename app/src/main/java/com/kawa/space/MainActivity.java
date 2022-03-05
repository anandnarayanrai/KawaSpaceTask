package com.kawa.space;

import android.os.Bundle;

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
    }
}