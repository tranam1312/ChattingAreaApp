package com.example.chattingarea.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chattingarea.R;
import com.example.chattingarea.model.MessageDetailDto;
import com.example.chattingarea.model.UserChatOverview;
import com.example.chattingarea.model.UserDto;
import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int TYPE_HEADER = 1;
    private final static int TYPE_USER = 2;
    private ArrayList<UserDto> listData;
    private String title= null;
    private Context context;

    public UserAdapter(Context context,ArrayList<UserDto> listData) {
        this.context = context;
        this.listData = listData;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (listData.size()> 0 ){
            return  listData.size()+ 1;
        }else {
            return 0;
        }
    }

    public  void  updateData(ArrayList<UserDto> listData){
        this.listData = listData;
        notifyDataSetChanged();
    }
    static class UserViewHolder extends RecyclerView.ViewHolder {

        CircularImageView ciAva;
        TextView tvName;
        ImageView imageView;

        public UserViewHolder(View itemView) {
            super(itemView);
            ciAva = itemView.findViewById(R.id.avatar_img);
            tvName = itemView.findViewById(R.id.nam_tv);
            itemView = itemView.findViewById(R.id.add_user_btn);

        }


        public void bind(UserDto userDto, Context context) {
            Glide.with(context)
                    .load(userDto.getUrlAva()) // image url
                    .placeholder(R.drawable.img) // any placeholder to load at start
                    .error(R.drawable.img)  // any image in case of error
                    .override(200, 200) // resizing
                    .centerCrop()
                    .into(ciAva);
            tvName.setText(userDto.getName());
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.title_header);
        }

        public void bind(String title) {

        }
    }

}
