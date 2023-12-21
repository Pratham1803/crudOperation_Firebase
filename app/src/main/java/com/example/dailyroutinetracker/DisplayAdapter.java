package com.example.dailyroutinetracker;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder> {
    private List<UserData> localUserDataset;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblName;
        private final TextView lblEmailId;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lblName = itemView.findViewById(R.id.lblName);
            lblEmailId = itemView.findViewById(R.id.lblEmailId);
        }

        public TextView getLblName() {
            return lblName;
        }

        public TextView getLblEmailId() {
            return lblEmailId;
        }
    }

    public DisplayAdapter(Context context,List<UserData> localUserDataset) {
        this.localUserDataset = localUserDataset;
        this.context = context;
    }

    @NonNull
    @Override
    public DisplayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_list,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayAdapter.ViewHolder holder = new ViewHolder(v);

                Intent intent = new Intent(context, activityAddRecord.class);

                String[] data = {holder.getLblName().getText().toString(),holder.getLblEmailId().getText().toString()};
                intent.putExtra("DataTransfer",data);

                startActivity(context,intent,null);
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayAdapter.ViewHolder holder, int position) {
        holder.getLblName().setText(localUserDataset.get(position).getUserName());
        holder.getLblEmailId().setText(localUserDataset.get(position).getUserEmailId());
    }

    @Override
    public int getItemCount() {
        return localUserDataset.size();
    }


}
