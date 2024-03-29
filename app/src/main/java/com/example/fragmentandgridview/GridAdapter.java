package com.example.fragmentandgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] wifeName;
    int[] image;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] wifeName, int[] image) {
        this.context = context;
        this.wifeName = wifeName;
        this.image = image;
    }

    @Override
    public int getCount() {
        return wifeName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null){
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.item_name);

        imageView.setImageResource(image[position]);
        textView.setText(wifeName[position]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan pesan Toast saat item di klik
                Toast.makeText(context, "You Clicked on " + wifeName[position], Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
