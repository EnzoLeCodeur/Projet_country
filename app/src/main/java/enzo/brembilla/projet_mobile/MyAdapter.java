package enzo.brembilla.projet_mobile;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import enzo.brembilla.projet_mobile.Model.Pays;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> {
    private List<Pays> listValues;
    private Context cntxt;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class CelluleJava extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        //Constructeur
        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Pays> listValues, Context c) {
        cntxt = c; this.listValues = listValues;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent,
                                          int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Pays currentPays = listValues.get(position);
        final String name = currentPays.getName();
        final String alpha2Code = currentPays.getAlphaCode();
        final String capital = currentPays.getCapital();
        final String region = currentPays.getRegion();
        final String subregion = currentPays.getSubregion();
        final int population = currentPays.getPopulation();
        final String flag = currentPays.getFlag();
        Glide.with(cntxt).load(currentPays.getFlag()).into(holder.image);
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cntxt, PaysActivity.class);
                intent.putExtra("paysName", name);
                intent.putExtra("paysAlphaCode", alpha2Code);
                intent.putExtra("paysCapital", capital);
                intent.putExtra("paysRegion", region);
                intent.putExtra("paysSubregion", subregion);
                intent.putExtra("paysPopulation", population);
                intent.putExtra("paysFlag", flag);
                cntxt.startActivity(intent);
            }
        });

        holder.txtFooter.setText(region);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listValues.size();
    }

}
