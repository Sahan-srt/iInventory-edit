package ithub.iinventory;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by DulanjayaSamarajeewa on 2/3/2018.
 */

public class items extends RecyclerView.Adapter<items.SearchViewHolder>{

    ArrayList<String> itemnamelist;
    ArrayList<String> itempricelist;
    Context context;
    ArrayList<All_ItemsActivity> itemDetails=new ArrayList<All_ItemsActivity>();

    public items(Context context, ArrayList<String> itemnamelist, ArrayList<String> itempricelist) {
        this.context = context;
        this.itemnamelist = itemnamelist;
        this.itempricelist = itempricelist;
    }


    class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView item_name,item_price;

        Context ctx;
        ArrayList<String> itemnamelist;
        ArrayList<String> itempricelist;

        public SearchViewHolder(View itemView, Context ctx,ArrayList<String> itemnamelist, ArrayList<String> itempricelist) {
            super(itemView);
            this.ctx=ctx;
            this.itemnamelist=itemnamelist;
            this.itempricelist=itempricelist;

            itemView.setOnClickListener(this);
            item_name =(TextView)itemView.findViewById(R.id.itemName);
            item_price=(TextView)itemView.findViewById(R.id.itemPrice);
        }


        @Override
        public void onClick(View v) {
                int position = getAdapterPosition();

                String name=itemnamelist.get(position);
                String price=itempricelist.get(position);




           Intent update=new Intent(context,Update.class);
            update.putExtra("Name",name);
           update.putExtra("Price",price);

            context.startActivity(update);



         //  Toast.makeText(context,String.valueOf(position)+name,Toast.LENGTH_SHORT).show();
        }
    }







    @Override
    public items.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bill_items, parent,false);
        return new items.SearchViewHolder(view,context,itemnamelist,itempricelist);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.item_name.setText(itemnamelist.get(position));
        holder.item_price.setText(itempricelist.get(position));


    }



    @Override
    public int getItemCount() {
        return itemnamelist.size();
    }
}
