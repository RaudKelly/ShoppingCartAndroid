package Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.robertwais.shoppingcart.R;

import java.util.List;

import Model.Item;

public class ItemCartAdapter extends RecyclerView.Adapter<ItemCartAdapter.ViewHolder> {

    private  Context context;
    private List<Item> itemList;


    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        public TextView name, price,quantity,total;
        public ImageView imageView;

        public ViewHolder(View view){
            super(view);

            view.setOnClickListener(this);
            name = (TextView) view.findViewById(R.id.itemCartName);
            price = (TextView) view.findViewById(R.id.priceCartLbl);
            quantity = (TextView) view.findViewById(R.id.quantityCartLbl);
            total = (TextView) view.findViewById(R.id.itemCartTotalLbl);
            imageView = (ImageView) view.findViewById(R.id.itemCartImageView);

            //SET VARIABLES
            //title = (TextView) view.findViewById(R.id.title);
        }

        @Override
        public void onClick(View view) {
            //Maybe Change Later but nothing for now..
        }
    }

    public ItemCartAdapter(Context context, List<Item> list){
        this.context = context;
        this.itemList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        //Change
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.purchaseditem_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemCartAdapter.ViewHolder holder, int position){
        Item item = itemList.get(position);
        holder.name.setText(item.getName());
        holder.price.setText("Price: " +String.valueOf(item.getPrice()));
        holder.quantity.setText("Quantity: "+String.valueOf(item.getQuantity()));

        //Must Change Later for total for each item
        holder.total.setText(String.valueOf("Total: " +item.getQuantity() * 2));
        switch (position){
            case 0:
                holder.imageView.setImageResource(R.drawable.android0);
                break;
            case 1:
                holder.imageView.setImageResource(R.drawable.android1);
                break;
            case 2:
                holder.imageView.setImageResource(R.drawable.android2);
                break;
            case 3:
                holder.imageView.setImageResource(R.drawable.android3);
                break;
            case 4:
                holder.imageView.setImageResource(R.drawable.android4);
                break;
            case 5:
                holder.imageView.setImageResource(R.drawable.android5);
                break;
        }
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

}

