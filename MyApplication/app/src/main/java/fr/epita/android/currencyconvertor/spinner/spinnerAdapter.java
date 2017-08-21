package fr.epita.android.currencyconvertor.spinner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import fr.epita.android.currencyconvertor.R;

/**
 * Created by valentin on 8/21/17.
 */

public class spinnerAdapter extends ArrayAdapter<String> {

    Context c;
    String[] kind;
    String[] images;

    public spinnerAdapter(Context c, String[] kind, String[] images)
    {
        super(c, R.layout.model, kind);
        this.c = c;
        this.kind = kind;
        this.images = images;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null)
       {
           LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.model, null);
       }

        TextView nameMonney = (TextView) convertView.findViewById(R.id.name_monney);
        TextView imgMonney = (TextView) convertView.findViewById(R.id.img_monney);

        nameMonney.setText(kind[position]);
        imgMonney.setText(images[position]);

        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model, null);
        }

        TextView nameMonney = (TextView) convertView.findViewById(R.id.name_monney);
        TextView imgMonney = (TextView) convertView.findViewById(R.id.img_monney);

        nameMonney.setText(kind[position]);
        imgMonney.setText(images[position]);

        return convertView;

    }
}
