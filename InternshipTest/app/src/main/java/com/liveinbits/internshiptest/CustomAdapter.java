package com.liveinbits.internshiptest;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liveinbits.internshiptest.models.Items;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<Items> items;
    private Context context;

    private MyItemListener listener;

    public CustomAdapter() {
    }

    public CustomAdapter(List<Items> listItems, Context context) {
        this.items = listItems;
        this.context = context;
    }

    public void setMyListener(MyItemListener listener) {
        this.listener = listener;
    }

    public interface MyItemListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
        final MyViewHolder holder = holders;
        Items model = items.get(position);
        holder.reponame.setText(context.getResources().getString(R.string.reponame) + " : " + model.getName());
        holder.forks.setText(context.getResources().getString(R.string.forks) + " : " + String.valueOf(model.getForks()));
        holder.watchers.setText(context.getResources().getString(R.string.watchers) + " : " + String.valueOf(model.getWatchers()));
        holder.openissue.setText(context.getResources().getString(R.string.openissue) + " : " + String.valueOf(model.getOpen_issues()));
        holder.score.setText(context.getResources().getString(R.string.score) + " : " + String.valueOf(model.getScore()));
        holder.language.setText(context.getResources().getString(R.string.language) + " : " + model.getLanguage());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView reponame, forks, watchers, openissue, score, language;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            reponame = itemView.findViewById(R.id.reponame);
            forks = itemView.findViewById(R.id.forks);
            watchers = itemView.findViewById(R.id.watchers);
            openissue = itemView.findViewById(R.id.openissue);
            score = itemView.findViewById(R.id.score);
            language = itemView.findViewById(R.id.language);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition());
        }
    }
}
