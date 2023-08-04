package com.mastercoding.recyclerview_vaccineapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// we will extends (means inherit this child MyAdapter class) our MyAdapter class ----->  RecyclerView.Adapter class (Parent Class)
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {  //this MyAdapter class is acting as an adapter from the recycler view
    // <> this is a type parameter

    // alt+enter to implement the methods nd cut and paste them in below 3rd step of implementation

    //---------------------> 4- Handling the click events

    private ItemClickListener clickListener;
    // for this we will create new class named as ItemClickListener



    //---------------------> 1- Data Source

    private VaccineModel[] listData;  // yaha per humne ek puri ki puri class ko he ek type ka ya to datastructure(Array) bana dia
                                        //kyoki data hume vahi sai milaga
    // creating constructor
    public MyAdapter(VaccineModel[] listData) {
        // it will contain a list of data as a parameter

        this.listData = listData;
    }


    //----------------------> 2- View Holder Class:

    // whenever we use custom adapter class we will use view holder class
    // this class describe an item, view and metadata about its place within the recycler view or the advanced view


    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }  //initializing the click listener

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //MyViewHolder = view holder class
        //this means we are using this class as a View holder from the recycler view

        public ImageView imageView;
        public TextView textView;

        // creating construstor of class before initializing the widgets
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView = itemView.findViewById(R.id.imageView);  // this is from the item of the recycler
            this.textView = itemView.findViewById(R.id.textView);
            // whenever we are using the view holder don't miss the "itemView" before findViewById
            //  ---> because our view holder will go and search for the views / UI views

            itemView.setOnClickListener(this);  //  ye subse last step hai
        }
        // as we have create our view holder class so we need to pass in the above <> type parmeter


        // this is for on click events
        @Override
        public void onClick(View view) {
            if (clickListener != null){
                clickListener.onClick(view, getAdapterPosition());
            }
        }
    }



    // -------------------------> 3- Implementing the methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this inCreateViewHolder is called when we need a new view
        // create a new view

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recyclerview_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // there is an available recycler view that can be provided and bound with the new data then onBindViewHolder is called
        // this will display the new data

        final VaccineModel myListData = listData[position];
        holder.textView.setText(listData[position].getTitle());
        holder.imageView.setImageResource(listData[position].getImage());

    }

    @Override
    public int getItemCount() {
        return listData.length;
    }


}
