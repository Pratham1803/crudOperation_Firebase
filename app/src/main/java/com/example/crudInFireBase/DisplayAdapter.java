package com.example.crudInFireBase;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
    int pos;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblName;
        private final TextView lblEmailId;
        private final TextView lblId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lblName = itemView.findViewById(R.id.lblName);
            lblEmailId = itemView.findViewById(R.id.lblEmailId);
            lblId = itemView.findViewById(R.id.lblId);
        }

        public TextView getLblName() {
            return lblName;
        }

        public TextView getLblEmailId() {
            return lblEmailId;
        }
        public TextView getLblId() {
            return lblId;
        }
    }

    public DisplayAdapter(Context context, List<UserData> localUserDataset) {
        this.localUserDataset = localUserDataset;
        this.context = context;
    }

    @NonNull
    @Override
    public DisplayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getLblName().setText(localUserDataset.get(position).getUserName());
        holder.getLblEmailId().setText(localUserDataset.get(position).getUserEmailId());
        holder.getLblId().setText(localUserDataset.get(position).getUserId());

        holder.getLblName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = localUserDataset.get(position).getUserName();
                String EmailId = localUserDataset.get(position).getUserEmailId();
                String id = localUserDataset.get(position).getUserId();
                Intent intent = new Intent(context, activityAddRecord.class);
                String[] data = new String[]{Name, EmailId, id};

                intent.putExtra("DataTransfer", data);

                startActivity(context, intent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localUserDataset.size();
    }
}
