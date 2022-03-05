package com.kawa.space.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.kawa.space.R;
import com.kawa.space.retrofit.responce.ResultsItem;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private final Context mContext;
    ArrayList<ResultsItem> userArrayList = new ArrayList<>();

    public ViewPagerAdapter(Context context) {
        mContext = context;
    }

    public void updateUserList(final List<ResultsItem> userArrayList) {
        this.userArrayList.clear();
        this.userArrayList.addAll(userArrayList);
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        ViewGroup layout = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.layout_view_pager_item, collection, false);
        ResultsItem resultsItem = userArrayList.get(position);

        TextView textView = layout.findViewById(R.id.textView);
        textView.setText(HtmlCompat.fromHtml("<u>" + resultsItem.getName().getFullName() + "</u>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        TextView tvAddress = layout.findViewById(R.id.tvAddress);
        tvAddress.setText(HtmlCompat.fromHtml(resultsItem.getLocation().getFullAddress(), HtmlCompat.FROM_HTML_MODE_LEGACY));

        TextView tvTimeZone = layout.findViewById(R.id.tvTimeZone);
        tvTimeZone.setText(HtmlCompat.fromHtml(resultsItem.getLocation().getTimezone().getTimeZone(), HtmlCompat.FROM_HTML_MODE_LEGACY));

        TextView tvGender = layout.findViewById(R.id.tvGender);
        tvGender.setText(resultsItem.getGender());

        ImageView ivProfile = layout.findViewById(R.id.ivProfile);
        Glide.with(ivProfile).load(resultsItem.getPicture().getLarge()).fitCenter().into(ivProfile);

        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ResultsItem resultsItem = userArrayList.get(position);
        return resultsItem.getName().getFirst();
    }

}