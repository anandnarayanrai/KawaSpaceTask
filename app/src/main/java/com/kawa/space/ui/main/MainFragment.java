package com.kawa.space.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.kawa.space.databinding.MainFragmentBinding;
import com.kawa.space.retrofit.responce.ResultsItem;

import java.util.ArrayList;

public class MainFragment extends Fragment implements RecyclerViewAdapter.onCallBack {

    private MainViewModel mViewModel;

    private MainFragmentBinding mBinding;
    ViewPagerAdapter customPagerAdapter;
    RecyclerViewAdapter recyclerViewAdapter;

    ArrayList<ResultsItem> userArrayList = new ArrayList<>();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = MainFragmentBinding.inflate(getLayoutInflater());
        mBinding.setLifecycleOwner(getViewLifecycleOwner());

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        mBinding.recyclerView.setAdapter(recyclerViewAdapter);

        customPagerAdapter = new ViewPagerAdapter(requireActivity());
        mBinding.viewpager.setAdapter(customPagerAdapter);

        mBinding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                recyclerViewAdapter.setSelectedPosition(position);
            }
        });

        mBinding.leftNav.setOnClickListener(v -> {
            int tab = mBinding.viewpager.getCurrentItem();
            if (tab > 0) {
                tab--;
                mBinding.viewpager.setCurrentItem(tab, true);
            } else if (tab == 0) {
                mBinding.viewpager.setCurrentItem(tab, true);
            }
        });

        mBinding.rightNav.setOnClickListener(v -> {
            int tab = mBinding.viewpager.getCurrentItem();
            tab++;
            mBinding.viewpager.setCurrentItem(tab, true);
        });

        listenToViewModel();
        mViewModel.onGetListResources();

    }

    private void listenToViewModel() {
        mViewModel.getVolumesResponseLive().observe(getViewLifecycleOwner(), itemList -> {
            mBinding.layoutMainView.setVisibility(View.VISIBLE);
            mBinding.layoutProgressBar.setVisibility(View.GONE);
            userArrayList.addAll(itemList);
            recyclerViewAdapter.updateUserList(itemList);
            customPagerAdapter.updateUserList(itemList);
            recyclerViewAdapter.setSelectedPosition(0);
        });
    }

    @Override
    public void onClick(int position) {
        mBinding.viewpager.setCurrentItem(position, true);
    }

}