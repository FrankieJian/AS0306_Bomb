package com.example.g572_528r.as0306_bomb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by g572-528r on 2017/3/6.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Person> mPersons;

    public MyAdapter(List<Person> mPersons) {
        this.mPersons = mPersons;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_age;
        private TextView tv_address;
        private TextView tv_score;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_age = (TextView) itemView.findViewById(R.id.tv_age);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            tv_score = (TextView) itemView.findViewById(R.id.tv_score);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_main, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person p = mPersons.get(position);
        holder.tv_name.setText(p.getName());
        holder.tv_address.setText(p.getAddress());
        holder.tv_age.setText(String.valueOf(p.getAge()));
        holder.tv_score.setText(String.valueOf(p.getScore()));
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }
}
