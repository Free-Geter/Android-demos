package com.example.ui_platformapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class fruit_Adapter extends RecyclerView.Adapter<fruit_Adapter.FruitViewHolder> {  //修改Adapter的Holder类型

    private List<String> list;

    public fruit_Adapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {   //修改Holder类型后一定要修改onCreate方法的返回值类型

        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        return new FruitViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder fruitViewHolder, int position) {   //一定要修改BindView的参数类型

        String name = list.get(position);
        fruitViewHolder.fruit_item.setText(name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder{

        private TextView fruit_item;

        public FruitViewHolder(@NonNull TextView itemView) {
            super(itemView);
            fruit_item = itemView;
        }
    }
}
