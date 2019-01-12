package com.example.jyothisp.recyclertest;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EventDetailsFragment extends android.support.v4.app.Fragment{

    public EventDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.shared));

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.event_details_layout, container, false);


        animateViews(view);


        MainActivity activity = (MainActivity) getActivity();

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeButtonEnabled(true);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        setHasOptionsMenu(true);
//        activity.getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout toolbarLayout = view.findViewById(R.id.collapsing);
        toolbarLayout.setTitle("Event Name");
//        toolbarLayout.setCollapsedTitleTextColor(getColor(R.color.titleTextColor));


        final LinearLayout registration = view.findViewById(R.id.event_registration_layout);
        final LinearLayout description = view.findViewById(R.id.event_description_layout);

        TabLayout tabLayout = view.findViewById(R.id.tab);
        final TabLayout.Tab regTab = tabLayout.newTab().setIcon(R.drawable.reg_icon);
        final TabLayout.Tab detailsTab = tabLayout.newTab().setIcon(R.drawable.details_icon);
        tabLayout.addTab(regTab);
        tabLayout.addTab(detailsTab);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.equals(regTab)){
                    registration.setVisibility(View.VISIBLE);
                    description.setVisibility(View.GONE);
                } else if (tab.equals(detailsTab)){
                    registration.setVisibility(View.GONE);
                    description.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }

    private void animateViews(View view){

        final View content = view.findViewById(R.id.scroll);
        View tab = view.findViewById(R.id.tab);


        content.animate()
                .alpha(1)
                .setDuration(300)
                .setStartDelay(300)
                .setListener(null)
                .start();
        tab.animate()
                .alpha(1)
                .setDuration(300)
                .setStartDelay(300)
                .setListener(null)
                .start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Toast.makeText(getContext(), "Pressed", Toast.LENGTH_SHORT).show();
            getFragmentManager().popBackStack();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
