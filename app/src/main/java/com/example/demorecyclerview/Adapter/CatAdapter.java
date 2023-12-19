package com.example.demorecyclerview.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demorecyclerview.DAO.CatDAO;
import com.example.demorecyclerview.DTO.CatDTO;
import com.example.demorecyclerview.R;

import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter <CatAdapter.ViewHolder>{
    ArrayList<CatDTO> listCat;
    Context context;

    public CatAdapter(ArrayList<CatDTO> listCat, Context context) {
        this.listCat = listCat;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View v = inflater.inflate(R.layout.row_cat, parent, false);

        return new CatAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gắn dữ liệu lên giao diện
        CatDTO objCat = listCat.get(position);
        holder.tv_id.setText(objCat.getId() + ""); // không quên chuyển kiểu số về chuỗi
        holder.tv_name.setText(objCat.getName());

        // Sau này muốn tương tác với view nào thì viết ở đây

        // Bấm vào tên thì toast thông báo
        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Tên thể loại: " + objCat.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listCat.size();  // không được quên
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_id, tv_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
