package com.example.jyothisp.recyclertest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.DepartmentsHolder> {

    private ArrayList<Department> departmentsList;


    public DepartmentsAdapter(ArrayList<Department> departments){
        departmentsList = departments;
    }


    public void setData(ArrayList<Department> data){
        departmentsList = data;
        notifyDataSetChanged();
    }

    public class DepartmentsHolder extends RecyclerView.ViewHolder{

        private TextView deptNameTextView;
        private RecyclerView horizonthalRecyclerView;
        private EventsAdapter eventsAdapter;

        public DepartmentsHolder(@NonNull View itemView) {
            super(itemView);
            Context context = itemView.getContext();
            deptNameTextView = (TextView) itemView.findViewById(R.id.departments_name_view);
            horizonthalRecyclerView = (RecyclerView) itemView.findViewById(R.id.departments_recycler_view);
            horizonthalRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            eventsAdapter = new EventsAdapter();
            horizonthalRecyclerView.setItemAnimator(new DefaultItemAnimator());
            horizonthalRecyclerView.setAdapter(eventsAdapter);
        }
    }

    @NonNull
    @Override
    public DepartmentsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.department_list_item, viewGroup, false);
        DepartmentsHolder holder = new DepartmentsHolder(view);
        return holder;
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull DepartmentsHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentsHolder departmentsHolder, int i) {
        DepartmentsHolder holder = departmentsHolder;
        holder.deptNameTextView.setText(departmentsList.get(i).getmDepartmentName());
        holder.eventsAdapter.setData(departmentsList.get(i).getmDepartmentEvents());
        //TODO row index
    }

    @Override
    public int getItemCount() {
        return departmentsList.size();
    }


}
