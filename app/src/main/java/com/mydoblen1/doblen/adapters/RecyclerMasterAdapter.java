package com.mydoblen1.doblen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mydoblen1.doblen.R;
import com.mydoblen1.doblen.classes.ListMasterRecycle;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerMasterAdapter extends RecyclerView.Adapter<RecyclerMasterAdapter.RecyclerMasterViewHolder> {

    private List<ListMasterRecycle> listMasterRecycles;
    private Context context;

    public RecyclerMasterAdapter(List<ListMasterRecycle> listMasterRecycles, Context context) {
        this.listMasterRecycles = listMasterRecycles;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerMasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.custom_layout_recycle,parent,false);
        return new RecyclerMasterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMasterViewHolder holder, int position) {

        ListMasterRecycle listMasterRecycle=listMasterRecycles.get(position);

        holder.name_master.setText(listMasterRecycle.getName());
        holder.work_master.setText(listMasterRecycle.getWork());
        holder.location_master.setText(listMasterRecycle.getLoc());
        holder.call_master.setText(listMasterRecycle.getPhone());
       // holder.profile_master.setImageResource(listMasterRecycle.getPic());

        switch (listMasterRecycle.getStar()){

            case 1:
                holder.star1.setVisibility(View.VISIBLE);
                break;
            case 2:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                break;
            case 3:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                holder.star3.setVisibility(View.VISIBLE);
                break;
            case 4:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                holder.star3.setVisibility(View.VISIBLE);
                holder.star4.setVisibility(View.VISIBLE);
                break;
            case 5:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                holder.star3.setVisibility(View.VISIBLE);
                holder.star4.setVisibility(View.VISIBLE);
                holder.star5.setVisibility(View.VISIBLE);
                break;
            case 6:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                holder.star3.setVisibility(View.VISIBLE);
                holder.star4.setVisibility(View.VISIBLE);
                holder.star5.setVisibility(View.VISIBLE);
                holder.star6.setVisibility(View.VISIBLE);
                break;
            case 7:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                holder.star3.setVisibility(View.VISIBLE);
                holder.star4.setVisibility(View.VISIBLE);
                holder.star5.setVisibility(View.VISIBLE);
                holder.star6.setVisibility(View.VISIBLE);
                holder.star7.setVisibility(View.VISIBLE);
                break;
            default:
                holder.star1.setVisibility(View.VISIBLE);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return listMasterRecycles.size();
    }

    public class RecyclerMasterViewHolder extends RecyclerView.ViewHolder{

        public TextView name_master;
        public TextView work_master;
        public TextView location_master;
        public TextView call_master;
        public CircleImageView profile_master;
        public ImageView instagram_master;
        public ImageView whatsapp_master;
        public ImageView message_master;
        public ImageView star1;
        public ImageView star2;
        public ImageView star3;
        public ImageView star4;
        public ImageView star5;
        public ImageView star6;
        public ImageView star7;



        public RecyclerMasterViewHolder(@NonNull View itemView) {
            super(itemView);

            name_master =(TextView)itemView.findViewById(R.id.name_master);
            work_master =(TextView)itemView.findViewById(R.id.work_master);
            location_master =(TextView)itemView.findViewById(R.id.location_master);
            call_master =(TextView)itemView.findViewById(R.id.call_master);

            profile_master =(CircleImageView) itemView.findViewById(R.id.profile_master);

            instagram_master=(ImageView)itemView.findViewById(R.id.instagram_master);
            whatsapp_master =(ImageView)itemView.findViewById(R.id.whatsapp_master);
            message_master=(ImageView)itemView.findViewById(R.id.message_master);
            star1=(ImageView)itemView.findViewById(R.id.star1);
            star2=(ImageView)itemView.findViewById(R.id.star2);
            star3=(ImageView)itemView.findViewById(R.id.star3);
            star4=(ImageView)itemView.findViewById(R.id.star4);
            star5=(ImageView)itemView.findViewById(R.id.star5);
            star6=(ImageView)itemView.findViewById(R.id.star6);
            star7=(ImageView)itemView.findViewById(R.id.star7);

            call_master.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "call_master", Toast.LENGTH_SHORT).show();
                }
            });

            profile_master.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "profile_master", Toast.LENGTH_SHORT).show();
                }
            });

            instagram_master.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "instagram_master", Toast.LENGTH_SHORT).show();
                }
            });

            whatsapp_master.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "whatsapp_master", Toast.LENGTH_SHORT).show();
                }
            });

            message_master.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "message_master", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
