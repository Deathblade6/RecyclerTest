package com.example.jyothisp.recyclertest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FlagshipAdapter extends RecyclerView.Adapter<FlagshipAdapter.FlagshipHolder> {

    private ArrayList<Event> eventArrayList;

    String LOG_TAG = "Flagship Adapter";
    private ArrayList<FlagshipHolder> viewHolderList;

    public ArrayList<FlagshipHolder> getViewHolderList() {
        return viewHolderList;
    }

    public FlagshipAdapter(ArrayList<Event> eventArrayList) {
        this.eventArrayList = eventArrayList;
        viewHolderList = new ArrayList<>();
    }

    public FlagshipAdapter(){}


    public class FlagshipHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;

        public View getItemView(){
            return itemView;
        }

        public FlagshipHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO: open up descriptions.
                }
            });
        }
    }
    @NonNull
    @Override
    public FlagshipHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.flagship_list_item, viewGroup, false);
        FlagshipHolder holder = new FlagshipHolder(view);
        Log.d(LOG_TAG, "View holder created" + viewHolderList.size());
        return holder;
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull FlagshipHolder holder) {
        super.onViewDetachedFromWindow(holder);
        viewHolderList.remove(holder);
        Log.d(LOG_TAG, "View holder detached" + viewHolderList.size());
    }

    @Override
    public void onBindViewHolder(@NonNull FlagshipHolder flagshipHolder, int i) {
        Event event = eventArrayList.get(i);
        flagshipHolder.titleTextView.setText(event.getmTitle());
        flagshipHolder.titleTextView.setTag(i);
        Log.d(LOG_TAG, "View holder bound" + viewHolderList.size());
    }

    @Override
    public void onViewAttachedToWindow(@NonNull FlagshipHolder holder) {
        super.onViewAttachedToWindow(holder);
        viewHolderList.add(holder);
        Log.d(LOG_TAG, "View holder attached" + viewHolderList.size());
    }

    @Override
    public int getItemCount() {
        return eventArrayList.size();
    }

}
