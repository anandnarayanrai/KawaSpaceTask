package com.kawa.space.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.kawa.space.R;
import com.kawa.space.retrofit.responce.ResultsItem;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final onCallBack mCallBack;
    ArrayList<ResultsItem> userArrayList = new ArrayList<>();

    public RecyclerViewAdapter(onCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public void updateUserList(final List<ResultsItem> userArrayList) {
        this.userArrayList.clear();
        this.userArrayList.addAll(userArrayList);
        notifyDataSetChanged();
    }

    public void setSelectedPosition(Integer position) {
        for (int i = 0; i <= userArrayList.size() - 1; i++) {
            ResultsItem resultsItem = userArrayList.get(i);
            resultsItem.setSelected(i == position);
            userArrayList.set(i, resultsItem);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_view_item, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ResultsItem resultsItem = userArrayList.get(position);
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;

        viewHolder.tvGender.setText(resultsItem.getGender());
        viewHolder.tvFullName.setText(resultsItem.getName().getFullName());
        viewHolder.tvEmail.setText(resultsItem.getEmail());

        if (resultsItem.getSelected()) {
            viewHolder.cardView.setCardBackgroundColor(viewHolder.cardView.getContext().getResources().getColor(R.color.purple));
            viewHolder.tvGender.setTextColor(viewHolder.tvGender.getContext().getResources().getColor(R.color.white));
            viewHolder.tvFullName.setTextColor(viewHolder.tvFullName.getContext().getResources().getColor(R.color.white));
            viewHolder.tvEmail.setTextColor(viewHolder.tvEmail.getContext().getResources().getColor(R.color.white));
        } else {
            viewHolder.cardView.setCardBackgroundColor(viewHolder.cardView.getContext().getResources().getColor(R.color.white));
            viewHolder.tvGender.setTextColor(viewHolder.tvGender.getContext().getResources().getColor(R.color.black));
            viewHolder.tvFullName.setTextColor(viewHolder.tvFullName.getContext().getResources().getColor(R.color.black));
            viewHolder.tvEmail.setTextColor(viewHolder.tvEmail.getContext().getResources().getColor(R.color.colorSecondaryVariant));

        }

        viewHolder.itemView.setOnClickListener(v -> {
            mCallBack.onClick(position);
        });

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    interface onCallBack {
        void onClick(int position);
    }

    static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView tvGender;
        AppCompatTextView tvFullName;
        AppCompatTextView tvEmail;
        MaterialCardView cardView;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
